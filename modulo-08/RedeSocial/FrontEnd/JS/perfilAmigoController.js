angular.module('app').controller('perfilAmigoController', function ($scope, perfilAmigoService, $routeParams, $location, toastr) {

getPerfil()
getPostsAmigo()

    function getPostsAmigo() {
      perfilAmigoService.getPostsAmigo().then(function (response) {
        console.log(response);
        $scope.postsAmigo = response.data;
      });
    }

    function getPerfil() {
      perfilAmigoService.getPerfil().then(function (response) {
        console.log(response);
        $scope.perfil = response.data;
      });
    }

    $scope.solicitarAmizade = function () {
      if ($scope.formSolicitacao.$valid) {
          console.log();
          perfilAmigoService.solicitarAmizade().then(function (){
              toastr.success('Boa! Network é vida!');
          });
      } else {
          toastr.warning('Poxa, vocês não podem ser amigos!');

        }
      };

});
