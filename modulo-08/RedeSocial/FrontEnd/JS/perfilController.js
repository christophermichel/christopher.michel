angular.module('app').controller('perfilController', function ($scope, usuarioService, $http, feedService, $routeParams, $location, toastr) {

getUsuarioAtual()
getPostsUsuarioLogado()

  function getUsuarioAtual() {
    feedService.getUsuarioAtual().then(function (response) {
      console.log(response);
      $scope.usuarioLogado = response.data;
    });
  }

$scope.alterarUsuario = function(usuario){
  if ($scope.formAlterarUsuario.$valid) {
    usuario.senha =   $scope.usuarioLogado.senha;
    usuario.id =   $scope.usuarioLogado.id;
    usuarioService.putUsuario(usuario).then(function (){
      toastr.success('Dados alterados com sucesso!');
  })};
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
