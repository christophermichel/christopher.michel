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

cliente = $scope.cliente;
$scope.NovoCliente = NovoCliente;
$scope.itensPedido = [];
var itensPedido = $scope.itensPedido;
$scope.adicionarNovoItemNoPedido = adicionarNovoItemNoPedido;
$scope.novoPedido = novoPedido;
$scope.clienteGuardado = clienteGuardado;
$scope.devolver = devolver;
function clienteGuardado(cliente) {
    $scope.clienteLegal = cliente;
    console.log($scope.clienteLegal);
    }

function adicionarNovoItemNoPedido (combo){
  itensPedido.push({Produto:combo});
  console.log($scope.itensPedido);
}

function NovoCliente (cliente){
      pedidoService.NovoCliente(cliente).then(function (response){
      $scope.cliente = {};
      })};

function novoPedido(){
  var objetoPedido = {Cliente : $scope.clienteLegal, Itens : itensPedido};
  console.log(JSON.stringify(objetoPedido));
  pedidoService.novoPedido(objetoPedido).then(function (response){
  $scope.objetoPedido = response.data.dados;
})};

function devolver(pedido){
  console.log(JSON.stringify(pedido));
  pedidoService.devolver(pedido).then(function (response){
  ObterAlugados();
})};

});
