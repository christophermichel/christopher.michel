angular.module('app').controller('perfilAmigoController', function ($scope, perfilAmigoService, $routeParams, $location, toastr) {

getPerfil()
getPosts()

    $scope.postsAmigo = [];

    function getPosts() {
      perfilAmigoService.getPosts().then(function (response) {
        console.log(response);
        $scope.posts = response.data;
      });
    }

    function getPerfil() {
      perfilAmigoService.getPerfil().then(function (response) {
        console.log(response);
        $scope.perfil = response.data;
      });
    }

});
