var aula1 = angular.module('aula1',[]);

aula1.controller('a', function($scope) {
  $scope.pokemon = {nome: "Default", tipo: "Default"};
});