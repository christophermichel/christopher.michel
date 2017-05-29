controller.factory('UsuarioService', function ($http) {

  let urlBase = 'http://localhost:50704/api';

  function postUsuario(usuario) {
      return $http.post(urlBase + '/Usuarios', usuario);
  };

  function getUsuario() {
      return $http.get(urlBase + '/Usuarios');
  };

  return {
        listarUsuarios: getUsuario,
        criarUsuario: postUsuario,
  };
  
});