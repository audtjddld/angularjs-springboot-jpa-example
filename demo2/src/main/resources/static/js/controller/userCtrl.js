
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
		$scope.user.save(params, function () {
			// 상세 페이지로 이동
			$state.go('userView',{userId : $scope.user.userId});
		});
		
	}

})
// 상세 컨트롤러
.controller('userViewCtrl', function($http, $state, $stateParams, $scope, user, toastr) {
	
	$scope.user = new user();
	
	$scope.user.load($stateParams.userId, function (){
		// 데이터가 없으면 작성 페이지로 보내버린다. TODO 아니면 에러페이지로 이동
		if($scope.user.userId == null){
			$state.go('userWrite');
		}
	});
	
	
	// view단 회사 객체
	$scope.company = {
			
		// 추가
		add : function() {
			if ($scope.user.companies.length == 5) {
				toastr.warning('5개 이상 추가하실 수 없습니다.');
				return;
			}
			
			$scope.user.companies.push($scope.company);
			
			var params = angular.copy($scope.company);
			
			$scope.user.companyUpdate($scope.user.userId,
										params, function() {
					$scope.company.name='';
					$scope.company.salary='';
				}, function() {
					// 오류면 삭제
					$scope.user.companies.pop();
				});
			},
		minus : function (companyId) {
			$scope.user.companyDelete($scope.user.userId,
									  companyId, 
					function() {
						$scope.user.load($scope.user.userId);
					}
			)
		}
	}

	// view단 학교 객체
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

	// view단 친구 객체
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
		// 변경한 서비스 사용
		$scope.user = new user();
		console.log('$scope.user', $scope.user);
		console.log('user' , user);
		
		$scope.user.update($scope.user.userId, params, function() {
			
		});

	}	
	
})

;
