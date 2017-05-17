var aula1 = angular.module('aula1',[]);

aula1.controller('a', function($scope) {
  $scope.pokemon = {nome: "Default", tipo: "Default"};
});

aula1.controller('b', function($scope) {
  $scope.pokemons = [{nome: "Default", tipo: "Default"}, {nome: "Default", tipo: "Default"}, {nome: "Default", tipo: "Default"}];
});