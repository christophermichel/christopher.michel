var modulo = angular.module('diaUm',[]);

modulo.controller('listaPokemon', function($scope){
    $scope.topoDaPagina = "Busca Pokémon"
    $scope.procurarPokemon = "";
    $scope.procurarTipo = "";
    $scope.pokemons = [
      {nome:'Bulbasaur', tipo:'grama'},
      {nome:'Charmander', tipo:'fogo'},
      {nome:'Wartortle', tipo:'agua'},
      {nome:'Charizard', tipo:'fogo'},
      {nome:'Abra', tipo:'psiquico'},
      {nome:'Vulpix', tipo:'fogo'},
      {nome:'Gengar', tipo:'fantasma'},
      {nome:'Squirtle', tipo:'agua'},
      {nome:'Lapras', tipo:'agua'},
      {nome:'Caterpie', tipo:'venenoso'}
    ];
})
