imobiliaria.controller('pedidoController', function ($scope, $routeParams, pedidoService){
ObterClientes()
ObterCombos()
ObterAdicionais()
ObterPedidos()
ObterAlugados()

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

function ObterAlugados() {
      pedidoService.ObterAlugados().then(function (response) {
      $scope.alugados = response.data;console.log($scope.alugados);
      });
    }
$scope.clienteGuardado = clienteGuardado;
function clienteGuardado(cliente) {
  $scope.clienteLegal = cliente;
  console.log(cliente);
}
$scope.NovoCliente = NovoCliente;

function NovoCliente (cliente){
      pedidoService.NovoCliente(cliente).then(function (response){
      $scope.cliente = {};
      })};

});
