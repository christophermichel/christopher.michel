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
  console.log($scope.clienteLegal);
}

$scope.dataGuardada = dataGuardada;
function dataGuardada(data) {
  $scope.dataLegal = data;
  console.log($scope.dataLegal);
}

$scope.NovoCliente = NovoCliente;
$scope.itensPedido = [];
$scope.adicionarNovoItemNoPedido = adicionarNovoItemNoPedido;
$scope.novoPedido = novoPedido;
function adicionarNovoItemNoPedido (combo){
  $scope.itensPedido.push({Produto:combo});
  console.log($scope.itensPedido);
}

function NovoCliente (cliente){
      pedidoService.NovoCliente(cliente).then(function (response){
      $scope.cliente = {};
      })};
});
function novoPedido(){
  var objetoPedido = {Cliente:$scope.clienteLegal, Itens: $scope.itensPedido};
  console.log(objetoPedido);
  pedidoService.novoPedido(objetoPedido).then(function (response){
  $scope.objetoPedido = response.data.dados;
})};
