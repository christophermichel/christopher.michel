imobiliaria.controller('pedidoController', function ($scope, $routeParams, pedidoService){
ObterClientes()

function ObterClientes() {
      pedidoService.ObterClientes().then(function (response) {
      $scope.clientes = response.data;
      });
    }

$scope.NovoCliente = NovoCliente;

function NovoCliente (cliente){
      pedidoService.NovoCliente(cliente).then(function (response){
      })};

});
