
var obj ;

myApp
.controller(
		'userListCtrl',
		function($scope, $http, $stateParams, $location, $state, $rootScope) {
			
			// 사용자
			$scope.user = {
					// 검색
					search : function() 
					{
						var params = angular.copy(this.pagingInfo);
						console.log(params);
						for (param in params) {
							if (param == 'page') {
								params[param]--;
								// 2015.12.03 추가
								if (!params[param] || params[param] < 1)
									params[param] = 0;
							}
						}

						$http.get('/rest/users', {
							params : params
						}).success(	function(dataList) {
									console.log('success');

									$scope.currentPage = params.page;
									$scope.pagePerCnt = params.pagePerCnt;
									$scope.totalCnt = dataList.length;
									$scope.offset = ($scope.currentPage - 1) * $scope.pagePerCnt;
									$scope.data = dataList;
									$location.search(params);
						})
					},
					
					// 페이징 객체
					pagingInfo : {
						page : 1,
						pagePerCnt : 10
					},
					
					// 초기화
					init : function() {
							// url 파라미터에 있는 내용에 따른 검색 파라미터 설정
							var obj = $location.search();
							if (obj.page != undefined) {
								this.pagingInfo.page = obj.page;
							}
							this.search();
					},
					
					// 페이지 변경
					pageChanged : function() {
						// console.log('query ' + $scope.query);
						$scope.pagingInfo.page = $scope.currentPage;
						this.search();						
					}
			};
			
			// 초기화
			$scope.user.init();
		})
// 작성 페이지
.controller('userWriteCtrl', function($scope, $state, $http, toastr, user) {
 
	
	// 등록
	$scope.submitForm = function (form) {
		if(form.$valid == false){
			//alert('입력 오류');
			 toastr.error('입력값이 올바르지 않습니다.', '입력오류');
			return ;
		}
		// 회사		
		// $scope.user.companies =	angular.copy($scope.company.companies);
		// 학교
		// $scope.user.schools   =	$scope.school.schools;
		
		// 파라미터
		var params = angular.copy($scope.user);
		console.log(params);
		// 변경한 서비스 사용
		$scope.user = new user();
		console.log('$scope.user', $scope.user);
		console.log('user' , user);
		$scope.user.save(params, function () {
			// 상세 페이지로 이동
			$state.go('userView',{userId : $scope.user.userId});
		});
		
	}

})
// 상세 컨트롤러
.controller('userViewCtrl', function($http, $state, $stateParams, $scope, user) {
	
	console.log($stateParams);
	
	$scope.user = new user();
	
	$scope.user.load($stateParams.userId);
	
	
	// 회사
	$scope.company = {
			
		// 추가
		add : function() {
			if ($scope.user.companies.length == 5) {
				return;
			}
			$scope.user.companies == null ? [] : $scope.user.companies;
			
			$scope.user.companies.push($scope.company);
			/**/
			var params = angular.copy($scope.user);
			$scope.user.update($scope.user.userId, params);
			/**/
		},
		// TODO 삭제
		minus : function() {
			if (companies.length == 1) {
				return;
			}
			$scope.user.companies.pop();
		}
	}

	// 학교
	$scope.school = {
		
		// 추가
		add : function() {
			if ($scope.user.schools.length == 5) {
				return;
			}
			//$scope.user.schools.push({ name : '', schoolKind : ''	});
			var params = angular.copy($scope.user);
			$scope.user.update($scope.user.userId, params);
		},
		// TODO 삭제
		minus : function() {
			if ($scope.user.schools.length == 1) {
				return;
			}
			$scope.user.schools.pop();
		}
	}

	
	$scope.friend = {
		friends : [{}]
	}	
	
	// 등록
	$scope.submitForm = function (form) {
		
		if(form.$valid == false){
			//alert('입력 오류');
			 toastr.error('입력값이 올바르지 않습니다.', '입력오류');
			return ;
		}
		
		// 파라미터
		var params = angular.copy($scope.user);
		console.log(params);
		// 변경한 서비스 사용
		$scope.user = new user();
		console.log('$scope.user', $scope.user);
		console.log('user' , user);
		
		$scope.user.update($scope.user.userId, params, function () {
			// 상세 페이지로 이동
			$state.go('userView',{userId : $scope.user.userId});
		});
		
	}	
	
})

;
