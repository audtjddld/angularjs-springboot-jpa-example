myApp
.controller('systemLogCtrl', syslogListCtrl)
		
		
	function syslogListCtrl ($scope, $http) {
		console.log('systemLogCtrl');
		var searchInfo = {
			sort : 'logId,desc'
		}
		
		$scope.domains;
		$scope.load = function() {
			var params = angular.copy(searchInfo);
			
			$http.get('/rest/systemLogs',{params: params})
				.success(function(result) {
					console.log(result);
					
					$scope.domains = result;
					
				})
		}
		$scope.load();
	};
