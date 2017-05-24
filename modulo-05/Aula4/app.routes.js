angular.module('app').config(function ($routeProvider) {

  $routeProvider
    .when('/home', {

      templateUrl: 'home/home.html'
    })
    .when('/aula', {
      controller: 'AulaController',
      templateUrl: 'aula/aula.html'
    })
    .when('/instrutor', {
      controller: 'InstrutorController',
      templateUrl: 'instrutor/instrutor.html'
    })
    .otherwise({
      redirectTo: '/home'
    });
});
