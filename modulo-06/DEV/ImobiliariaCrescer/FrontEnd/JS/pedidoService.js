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

return {
    ObterClientes: getClientes,
    ObterCombos: getCombos,
    ObterAdicionais: getAdicionais
  /*  NovoCliente: post */
};

});
