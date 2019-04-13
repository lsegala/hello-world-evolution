'use strict';

angular.module('hello.main', ['ngRoute'])

.config(['$routeProvider', function(routeProvider) {
  routeProvider.when('/main', {
    templateUrl: 'main/main.html',
    controller: 'MainCtrl'
  })
  .when('/main/:name', {
      templateUrl: 'main/main.html',
      controller: 'MainCtrl'
    });
}])


.service('HelloService', ['$http', function(http){
    return {
        sayHello: function(callback){
            return http.get('/rest/api/hello', {headers: {'Content-type': 'application/json'}})
                .then(callback);
        }
    }
}])

.controller('MainCtrl', ['$scope', 'HelloService', function($scope, HelloService) {
    $scope.init = function(){
        HelloService.sayHello(function(response){
            $scope.message = response.data.message;
        });
    }
}]);