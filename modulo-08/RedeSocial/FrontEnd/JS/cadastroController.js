angular.module('app').controller('cadastroController', function ($scope, $location, toastr, usuarioService) {

  $scope.novoUsuario = function (usuario) {
    if ($scope.formCadastro.$valid) {
      console.log(usuario);
      var dia = usuario.dataNascimento.getDate();
      if (dia.toString().length == 1)
      dia = "0"+dia;
      var mes = usuario.dataNascimento.getMonth()+1;
      if (mes.toString().length == 1)
      mes = "0"+mes;
      var ano = usuario.dataNascimento.getFullYear();
      usuario.dataNascimento = dia+"/"+mes+"/"+ano;
      usuarioService.novoUsuario(usuario).then( function (){
          toastr.success('Mais um pra banda! Agora é só fazer login!');
          $location.path('/login.html');
      });
    } else {
      toastr.warning('Preencha todos os dados corretamente.', 'Dados inválidos!');
    }
  };
});
