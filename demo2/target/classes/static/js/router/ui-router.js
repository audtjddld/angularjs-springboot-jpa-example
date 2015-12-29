myApp.config(function($locationProvider, $stateProvider, $urlRouterProvider) {

	// html5 모드
	$locationProvider.html5Mode(true).hashPrefix('!');
	$urlRouterProvider.otherwise("/");

	$stateProvider

	// 사용자
	.state('userList', {
		url : "/users",
		templateUrl : '/js/user/list.html',
		controller : 'userListCtrl'

	})
	.state('userWrite',{
		url : "^/users/write",
		templateUrl : '/js/user/write.html',
		controller : 'userWriteCtrl'
	})
	.state('main', {
		url : "/",
		templateUrl : '/main'
	})
});
