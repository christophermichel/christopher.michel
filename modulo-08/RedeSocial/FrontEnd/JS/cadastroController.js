angular.module('app').controller('cadastroController', function ($scope, $location, toastr, usuarioService) {

  $scope.novoUsuario = function (usuario) {
    if ($scope.formCadastro.$valid) {

      usuarioService.novoUsuario(usuario).then( function (){
          toastr.success('Mais um pra banda! Agora é só fazer login!');
          $location.path('/login.html');
      });
    } else {
      toastr.warning('Preencha todos os dados corretamente.', 'Dados inválidos!');
    }
  };
});
