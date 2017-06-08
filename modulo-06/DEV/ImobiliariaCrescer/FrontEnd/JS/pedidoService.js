imobiliaria.factory('pedidoService', function ($http, $routeParams) {

function getClientes() {
    return $http.get('http://localhost:57197/api/clientes');
};

function post(cliente){
    return $http.post('http://localhost:57197/api/clientes', cliente);
};

return {
    ObterClientes: getClientes,
    NovoCliente: post
};

});
