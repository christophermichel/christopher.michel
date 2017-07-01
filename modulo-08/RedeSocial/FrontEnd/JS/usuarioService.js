angular.module('app').factory('usuarioService', function ($http) {
    var urlBase = 'http://localhost:8080/usuario';

    function postUsuario(usuario) {
        return $http.post(urlBase, usuario);
    };

    return {
        novoUsuario: postUsuario
    };

})
