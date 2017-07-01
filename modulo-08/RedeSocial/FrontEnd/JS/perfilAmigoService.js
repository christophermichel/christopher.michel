angular.module('app').factory('perfilAmigoService', function ($http, $routeParams) {
    var urlBase = 'http://localhost:9090/usuario/' + $routeParams.idamigo;

    function getPerfil() {
    return $http.get(urlBase);
    };

    return {
        getPerfil: getPerfil
    };

});
