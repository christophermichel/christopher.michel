angular.module('app').controller('perfilController', function ($scope, usuarioService, feedService, $routeParams, $location, toastr) {

getUsuarioAtual()

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





});
