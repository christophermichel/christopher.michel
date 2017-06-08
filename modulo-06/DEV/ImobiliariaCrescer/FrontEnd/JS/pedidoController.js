imobiliaria.controller('pedidoController', function ($scope, $routeParams, pedidoService){
ObterClientes()
ObterCombos()
ObterAdicionais()

function ObterClientes() {
      pedidoService.ObterClientes().then(function (response) {
      $scope.clientes = response.data;
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


$scope.NovoCliente = NovoCliente;

function NovoCliente (cliente){
      pedidoService.NovoCliente(cliente).then(function (response){
      })};

});
