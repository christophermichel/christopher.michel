angular.module('app').controller('perfilController', function ($scope, usuarioService, $http, usuarioService, feedService, $routeParams, $location, toastr) {

getUsuarioAtual()
getPostsUsuarioLogado()

  function getUsuarioAtual() {
    feedService.getUsuarioAtual().then(function (response) {
      console.log(response);
      $scope.usuarioLogado = response.data;
    });
  }

  $scope.alterarUsuario = function(usuarioLogado, usuario){
    if ($scope.formAlterarUsuario.$valid) {
      usuarioLogado.id =   $scope.usuarioLogado.id;
      if (usuario.senha == usuario.senha2) {
        usuarioLogado.senha = usuario.senha;
        var ano = usuarioLogado.dataNascimento.slice(2,4);
        var mes = usuarioLogado.dataNascimento.slice(5,7);
        var dia = usuarioLogado.dataNascimento.slice(8,10);
        usuarioLogado.dataNascimento = dia+"/"+mes+"/"+ano;
        usuarioService.novoUsuario(usuarioLogado).then(function (){
        toastr.success('Dados alterados com sucesso!');
        })
      } else {toastr.error('As senhas digitadas devem ser iguais!')}
    };
  };


//não é boa prática
  function getPostsUsuarioLogado() {
      feedService.getUsuarioAtual().then(function (response) {
      $scope.usuarioLogado = response.data;
      $http.get('http://localhost:9090/post/usuario/' + $scope.usuarioLogado.id).then(function (response){
        console.log(response);
      $scope.postsUsuarioLogado = response.data;
    });

    });
  };




});
