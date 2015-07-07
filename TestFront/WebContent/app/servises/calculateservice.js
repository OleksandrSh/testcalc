
(function() {

	var injectParams = ['$filter','$http' ];
  
	var calculateService = function($filter, $http) {
		var calculateUrl=undefined;
		return {
			getCalculate : function(dataRequest) {
				var ajaxUrl = this.calculateUrl + dataRequest.serviceAddress;

				return $http.post(ajaxUrl, dataRequest).then(function(result) {
                    var rr=result;
					return result.data;
				});
			},
			getCalculateUrl : function() {
				return this.calculateUrl;
			},
			setCalculateUrl : function(calculateurl) {
				this.calculateUrl=calculateurl;
			}
		}
	};
	calculateService.$inject = injectParams;

	angular.module('Testfront').service('calculateService', calculateService);

}());