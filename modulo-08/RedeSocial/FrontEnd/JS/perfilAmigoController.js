angular.module('app').controller('perfilAmigoController', function ($scope, perfilAmigoService, $routeParams, $location, toastr) {

getPerfil()

    $scope.parametro = {
      message: "Olá" + $routeParams.idamigo + "querido amigo"
    }

    function getPerfil() {
      perfilAmigoService.getPerfil().then(function (response) {
        console.log(response);
        $scope.perfil = response.data;
      });
    }
});
