(function() {

	var injectParams = [ '$scope', '$http', '$controller', '$element',
			'$interval', '$filter', '$compile', 'calculateService' ];

	var CalcFrontController = function($scope, $http, $controller, $element,
			$interval, $filter, $compile, calculateService) {
		'use strict'
		calculateService
				.setCalculateUrl('http://localhost:8080/CalculateApi/services/');
		$scope.calcUrl = calculateService.getCalculateUrl();
		$scope.calcNumbers = 5;
		$scope.datan = [];
		$scope.curop = [];
		$scope.onlyNumbers = /^\d+$/;
		$scope.operators = [ '*', '-', '/', '+' ];
		$scope.expressions;
		$scope.getNumber = function(num) {
			if (num) {
				return new Array(parseInt(num));
			} else
				return new Array(0);
		}
		var data = {
			serviceAddress : "calculate/all",
			expressionsForCalculate:"2*2",
			parametrs : {
				numbers : [ 23, 11, 44, 55 ],
				actions : [ '+', '-', '-', '+' ]
			}
		};
		var buildexpressionsForCalculate = function() {
			var expressions=$scope.datan[0];
			for(var i=1;i<$scope.calcNumbers;i++)
				{
				expressions+=$scope.curop[i-1]+$scope.datan[i];
				}
			return expressions;
		}
		$scope.getCalc = function() {
			console.log("postDataToServer");
			console.log($scope.datan.length);
			$scope.expressions=buildexpressionsForCalculate();
			//console.log($scope.expressions)
			if($scope.expressions.includes('undefined'))
			{
				$scope.result="Sorry wrong expressions, check please e "+$scope.expressions+"and try again";
			}else{
			$scope.result=undefined;
			data.parametrs.numbers = $scope.datan;
			data.parametrs.actions = $scope.curop;
			data.expressionsForCalculate=$scope.expressions;
			//console.log(data.expressionsForCalculate)
			calculateService.getCalculate(data).then(function(result) {
				var data = result;
				$scope.result=data.result;
                 console.log(data);
			});
			}
		}

	};

	CalcFrontController.$inject = injectParams;

	angular.module('Testfront').controller('CalcFrontController',
			CalcFrontController);

}());
