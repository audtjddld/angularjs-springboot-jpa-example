myApp
.controller(
		'userListCtrl',
		function($scope, $http, $stateParams, $location, $state, $rootScope) {
			// 리스트 검색
			$scope.search = function() {
				// 객체 복사
				var params = angular.copy($scope.pagingInfo);
				console.log(params);
				for(param in params) {
					if (param == 'page') {
						params[param]--;
						// 2015.12.03 추가
						if(!params[param]) params[param] = 0;	
					}
				}
				
				/**/
				$http.get('/rest/users',{params:params}).success(
						function(dataList) {
							console.log('success');
							console.log($scope.pagingInfo);
							console.log(dataList);
							// console.log('reload ' + $scope.pagingInfo.page);
							$scope.currentPage = $scope.pagingInfo.page;
							$scope.pagePerCnt = $scope.pagingInfo.pagePerCnt;
							$scope.totalCnt = dataList.length;
							$scope.offset = ($scope.currentPage -1)	* $scope.pagePerCnt;
							// console.log($scope.pagingInfo);
							// 로컬스토리지에 저장
							$scope.data = dataList;
							$location.search($scope.pagingInfo);
						})
				/**/

			}

			// 페이지 인포 객체가 없으면 한번 초기화
			if ($scope.pagingInfo == undefined) {
				$scope.pagingInfo = {
					page : 1,
					pagePerCnt : 10
				};
				// url 파라미터에 있는 내용에 따른 검색 파라미터 설정
				var obj = $location.search();
				if(obj.page != undefined){
					$scope.pagingInfo.page = obj.page;
				}
				$scope.search();
			}


			// 페이징 버튼 클릭시 이벤트
			$scope.pageChanged = function() {
				// console.log('query ' + $scope.query);
				$scope.pagingInfo.page = $scope.currentPage;
				$scope.search();
			};
		})
		
		;
	