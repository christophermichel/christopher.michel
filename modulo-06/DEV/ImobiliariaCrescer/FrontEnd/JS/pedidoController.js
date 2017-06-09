imobiliaria.controller('pedidoController', function ($scope, $routeParams, pedidoService){
ObterClientes()
ObterCombos()
ObterAdicionais()
ObterPedidos()

function ObterClientes() {
      pedidoService.ObterClientes().then(function (response) {
      $scope.clientes = response.data;console.log($scope.clientes);
      });
    }

function ObterCombos() {
      pedidoService.ObterCombos().then(function (response) {
      $scope.combos = response.data;
      });
    }

function ObterAdicionais() {
      pedidoService.ObterAdicionais().then(function (response) {
      $scope.adicionais = response.data;
      });
    }

function ObterPedidos() {
      pedidoService.ObterPedidos().then(function (response) {
      $scope.pedidos = response.data;console.log($scope.pedidos);
      });
    }


});
