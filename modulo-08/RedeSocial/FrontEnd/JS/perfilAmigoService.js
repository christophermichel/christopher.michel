angular.module('app').factory('perfilAmigoService', function ($http, $routeParams) {
    var urlBase = 'http://localhost:9090/usuario/' + $routeParams.idamigo;

    function getPerfil() {
    return $http.get(urlBase);
    };

    function getPosts() {
    return $http.get('http://localhost:9090/post');
    };

    function solicitarAmizade() {
        return $http.post('http://localhost:9090/usuario/solicitacao/' + $routeParams.idamigo);
    };

    return {
        getPerfil: getPerfil,
        getPosts: getPosts,
        solicitarAmizade: solicitarAmizade
    };

});
