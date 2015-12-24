myApp.filter('offset', function() {
	return function(input, start) {
		//console.log(input instanceof String);
		if (!(input instanceof Array) && !(input instanceof String)){
			return input;
		}
			
		
		start = parseInt(start, 10);
		if (start == 0) {
			return input.slice();
		}
		return input.slice(start);
	};
});