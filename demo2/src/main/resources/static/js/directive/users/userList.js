myApp
.drective('userPopup',function() {
	return {
		restrict: 'E',
		scope: {
			companyId: '='
		},
		templateUrl: '/js/directive/user/userList.html', 
		controller: 'userPopupCtrl'
	}	
})
.controller('userPopupCtrl' , function($scope){
	$scope.user = {
			// 검색
			search : function (){
				$http.get('/rest/users').success(function() {
					
				})
			}
			
	}
})