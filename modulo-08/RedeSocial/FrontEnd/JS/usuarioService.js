angular.module('app').factory('usuarioService', function ($http) {
    var urlBase = 'http://localhost:9090/usuario';

    function postUsuario(usuario) {
        return $http.post(urlBase, usuario);
    };

    function putUsuario(usuario){
        return $http.put(urlBase, usuario);
    };

    return {
        novoUsuario: postUsuario,
        putUsuario: putUsuario
    };

})
