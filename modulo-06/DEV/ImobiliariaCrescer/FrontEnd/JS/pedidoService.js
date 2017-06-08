imobiliaria.factory('pedidoService', function ($http, $routeParams) {

  function getClientes() {
    return $http.get('http://localhost:57197/api/clientes');
};

return {
    ObterClientes: getClientes,
};

});
