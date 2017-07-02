angular.module('app').factory('amigosService', function ($http, $routeParams) {
    var urlBase = 'http://localhost:9090/usuario/amigos';

    function getAmigosUsuario() {
    return $http.get(urlBase);
    };

    return {
        getAmigosUsuario:getAmigosUsuario
    };

});
