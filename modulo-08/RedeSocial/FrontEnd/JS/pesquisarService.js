angular.module('app').factory('pesquisarService', function ($http, $routeParams) {
    var urlBase = 'http://localhost:9090/usuario';

    function getUsuarios() {
    return $http.get(urlBase + '/todos');
    };

    return {
        getUsuarios:getUsuarios,
    };

});
