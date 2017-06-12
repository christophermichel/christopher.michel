imobiliaria.controller('pedidoController', function ($scope, $routeParams, pedidoService){
ObterClientes()
ObterCombos()
ObterAdicionais()
ObterPedidos()
ObterAlugados()
ObterRelatorioMensal()

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

function ObterRelatorioMensal() {
      pedidoService.ObterRelatorioMensal().then(function (response) {
      $scope.RelatorioMensal = response.data;
      console.log($scope.RelatorioMensal);
      });
}

function ObterAtrasados() {
      pedidoService.ObterAtrasados().then(function (response) {
      $scope.RelatorioAtrasados = response.data;
      console.log($scope.RelatorioAtrasados);
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
    $scope.clienteSelecionado = cliente;
    console.log($scope.clienteSelecionado);
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
  var objetoPedido = {Cliente : $scope.clienteSelecionado, Itens : itensPedido, DataVencimento: $scope.data};
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
