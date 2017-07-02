angular.module('app').factory('feedService', function ($http) {
    var urlBase = 'http://localhost:9090/post';

    function getPosts() {
    return $http.get(urlBase);
    };

    function getUsuarioAtual() {
    return $http.get('http://localhost:9090/usuario/atual');
    };

    function novoPost(post) {
        return $http.post(urlBase, post);
    };

    return {
        getPosts: getPosts,
        novoPost: novoPost,
        getUsuarioAtual: getUsuarioAtual
    };

});
