imobiliaria.factory('pedidoService', function ($http, $routeParams) {

function getClientes() {
    return $http.get('http://localhost:57197/api/clientes');
};

function getCombos() {
    return $http.get('http://localhost:57197/api/produtos/combos');
};

function getAdicionais() {
    return $http.get('http://localhost:57197/api/produtos/adicionais');
};

function post(cliente){
    return $http.post('http://localhost:57197/api/clientes', cliente);
};

function getPedidos() {
    return $http.get('http://localhost:57197/api/pedidos');
};

function getAlugados() {
    return $http.get('http://localhost:57197/api/pedidos/alugados');
};

function getRelatorioMensal() {
    return $http.get('http://localhost:57197/api/pedidos/relatorio/mensal');
};

function getRelatorioAtrasados() {
    return $http.get('http://localhost:57197/api/pedidos/relatorio/atrasados');
};

function postPedido(objetoPedido){
    return $http.post('http://localhost:57197/api/pedidos', objetoPedido);
};

function putPedido(pedido){
  return $http.put('http://localhost:57197/api/pedidos/devolver/'+ pedido.Id, pedido);
};

return {
    ObterClientes: getClientes,
    ObterCombos: getCombos,
    ObterAdicionais: getAdicionais,
    ObterPedidos: getPedidos,
    ObterRelatorioMensal: getRelatorioMensal,
    NovoCliente: post,
    novoPedido: postPedido,
    devolver: putPedido,
    ObterAtrasados: getRelatorioAtrasados,
    ObterAlugados: getAlugados
};

});
