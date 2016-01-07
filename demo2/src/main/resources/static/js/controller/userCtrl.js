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
.controller('userWriteCtrl', function($scope, $state, $http, toastr) {

	// 회사
	$scope.company = {
			
		companies : [{ name : '' , salary : '' }],
		// 추가
		add : function() {
			if (this.companies.length == 5) {
				return;
			}
			this.companies.push({ name : '' , salary : '' });
		},
		// 삭제
		minus : function() {
			if (this.companies.length == 1) {
				return;
			}
			this.companies.pop();
		}
	}

	// 학교
	$scope.school = {
		
		schools : [{ name : '', schoolKind : ''	}],
		// 추가
		add : function() {
			if (this.schools.length == 5) {
				return;
			}
			this.schools.push({ name : '', schoolKind : ''	});
		},
		// 삭제
		minus : function() {
			if (this.schools.length == 1) {
				return;
			}
			this.schools.pop();
		},
		user : {}
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
		// 회사		
		// $scope.user.companies =	angular.copy($scope.company.companies);
		// 학교
		// $scope.user.schools   =	$scope.school.schools;
		
		// 파라미터
		var params = angular.copy($scope.user);
		
		console.log(params);

		$http.post('/rest/users',params).success(function(data){
			alert('등록되었습니다');
			$scope.userInfo = $scope.user;
			
			console.log(data);
			
			$state.go('userView',{id : data.userId});
		});				  
	}

})
.controller('userViewCtrl', function($http, $state, $stateParams, $scope) {
	
	$scope.init = function() {
		
		console.log($stateParams);
		
		
		$http.get('/rest/user/' + $stateParams.id).success(function(data) {
			
			$scope.userInfo = data;
			
			console.log(data);
			
		})
		
		
	}
	
	$scope.init();
	
})
;
