// 사용자
myApp.service('user', ['$http', function($http) {
	function user(userData) {
		if(userData) {
			this.setData(userData);
		}
	}

	User.prototype = {
			setData : function (userData) {
				angular.extend(this, userData);
			},
			load : function (userId) {
				var scope = this;
				$http.get('/rest/user/' + userId).success(function(data) {
					scope.setData(userData);
				})
			},
			delete : function (userId) {
				$http.delete('/rest/user/' + userId).success(function(data) {
					
				})
			},
			update : function (userId) {
				$http.put('/rest/user/' + userId).success(function(data) {
					
				})
			},
			save : function () {
				$http.post('/rest/user/', this).success(function(data) {
					
				})
			}
	}
}]

// 회사
myApp.service('company', ['$http', function($http) {

	Company.prototype = {
			setData : function (companyData) {
				angular.extend(this, companyData);
			},
			save : function (userId) {
				$http.post('/rest/company/' + userId, this).success(function(data) {
					
				})
			},
			delete : function (companyId) {
				$http.delete('/rest/company/' + companyId).success(function(data) {
					
				})
			},
			update : function (userId) {
				$http.put('/rest/company/' + companyId, this).sucess(function(data) {
					
				})
			}
	}

}])
