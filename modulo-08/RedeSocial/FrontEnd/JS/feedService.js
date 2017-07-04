angular.module('app').factory('feedService', function ($http) {
    var urlBase = 'http://localhost:9090/post';

    function getPosts() {
    return $http.get(urlBase);
    };

    function getSolicitacoes() {
    return $http.get('http://localhost:9090/usuario/solicitacoes');
    };

    function getUsuarioAtual() {
    return $http.get('http://localhost:9090/usuario/atual');
    };

    function novoPost(post) {
        return $http.post(urlBase, post);
    };

    function curtir(id, objeto) {
        return $http.post('http://localhost:9090/curtir/' + id, objeto);
    };

    return {
        curtir:curtir,
        getPosts: getPosts,
        novoPost: novoPost,
        getUsuarioAtual: getUsuarioAtual,
        getSolicitacoes: getSolicitacoes
    };

});
