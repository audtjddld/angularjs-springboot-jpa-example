// 사용자
myApp.factory('user', function($http, toastr) {
	
	function user(userData) {
		if(userData) {
			this.setData(userData);
		}
	}
	// Value Object 정의
	user.prototype = {
			// 사용자 정보 객체 셋팅
			setData : function (userData) {
				angular.extend(this, userData);
			},
			// 사용자 정보 불러오기
			load : function (userId, callback) {
				var scope = this;
				$http.get('/rest/user/' + userId).success(function(data) {
					scope.setData(data);
					if ( typeof(callback) == 'Function') {
						callback();
					};	
				});
				
			},
			// 사용자 정보 삭제
			delete : function (userId) {
				var scope = this;
				$http.delete('/rest/user/' + userId).success(function(data) {
					//alert('삭제되었습니다.');
					toastr.success("삭제되었습니다.");
					this.load(userId);
				});
			},
			// 사용자 정보 수정
			update : function (userId, data, callback) {
				company.userId = userId;
				var scope = this;
				$http.put('/rest/users', data)
				.then(function(data) {
						toastr.success("등록되었습니다.");
						scope.load(userId);
						callback.success();
					},
					function errorCallback(response) {
						toastr.error("에러가 발생되었습니다.");
						callback.error();
					}
				);
			},
			// 사용자 정보 저장
			save : function (userData, callback) {
				var scope = this;
				$http.post('/rest/users', userData).success(function(data) {
					//alert('등록되었습니다.');
					toastr.success("등록되었습니다.");
					scope.setData(data);
					callback();
				});
			},
			// 회사 등록
			companyUpdate : function(userId, company, successCallback, errorCallback) {
				var scope = this;
				$http.put('/rest/companies', company)
				.then(function(data) {
						toastr.success("등록되었습니다.");
						scope.load(userId);
						successCallback();
					},
					function errorCallback(response) {
						toastr.error("에러가 발생되었습니다.");
						errorCallback();
					}
				);
			},
			// 회사 삭제
			companyDelete : function(userId, company, successCallback) {
				company.userId = userId;
				
				$http.delete('/rest/companies', company)
					.then(function(data) {
							toastr.success("삭제되었습니다.");
							scope.load(userId);
							successCallback();
						},
						function errorCallback(response) {
							toastr.error("에러가 발생되었습니다.");
						}
					)
			}
	}

	return user;
});

