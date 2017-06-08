imobiliaria.controller('pedidoController', function ($scope, $routeParams, pedidoService){
ObterClientes()

function ObterClientes() {
      pedidoService.ObterClientes().then(function (response) {
      $scope.clientes = response.data;
      });
    }

});
