// 사용자
myApp.factory('user', function($http) {
	
	function user(userData) {
		if(userData) {
			this.setData(userData);
		}
	}

	user.prototype = {
			setData : function (userData) {
				angular.extend(this, userData);
			},
			
			load : function (userId) {
				var scope = this;
				$http.get('/rest/user/' + userId).success(function(data) {
					scope.setData(data);
					
				});
			},
			delete : function (userId) {
				var scope = this;
				$http.delete('/rest/user/' + userId).success(function(data) {
					alert('삭제되었습니다.');
					this.load(userId);
				});
			},
			update : function (userId, data) {
				
				console.log(data);
				
				var scope = this;
				$http.put('/rest/user/' + userId).success(function(data) {
					alert('수정되었습니다.');
					scope.setData(data);

				});
				
			},
			save : function (userData, callback) {
				var scope = this;
				$http.post('/rest/users', userData).success(function(data) {
					alert('등록되었습니다.');
					scope.setData(data);
					callback();
				});
			}
	}

	return user;
});

