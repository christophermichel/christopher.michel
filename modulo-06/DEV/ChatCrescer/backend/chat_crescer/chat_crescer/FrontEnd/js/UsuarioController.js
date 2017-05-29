controller.controller('UsuarioController', function ($scope, $localStorage, $routeParams, UsuarioService){

       $scope.addUsuario = function (usuario){
            UsuarioService.criarUsuario(usuario).then(function (response){
                localStorage.setItem('nome', usuario.Nome,toString());
                localStorage.setItem('foto', usuario.UrlFoto,toString());
                location.href = '#!/chat';
                listaTodosUsuarios();
            });
        }
    });