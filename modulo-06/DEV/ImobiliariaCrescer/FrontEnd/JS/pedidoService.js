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

function postPedido(objetoPedido){
    return $http.post('http://localhost:57197/api/pedidos', objetoPedido);
};

function getPedidos() {
    return $http.get('http://localhost:57197/api/pedidos');
};

function getAlugados() {
    return $http.get('http://localhost:57197/api/pedidos/alugados');
};

return {
    ObterClientes: getClientes,
    ObterCombos: getCombos,
    ObterAdicionais: getAdicionais,
    ObterPedidos: getPedidos,
    NovoCliente: post,
    novoPedido: postPedido,
    ObterAlugados: getAlugados
};

});
