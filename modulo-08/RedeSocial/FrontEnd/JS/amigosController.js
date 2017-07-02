angular.module('app').controller('amigosController', function ($scope, amigosService, authService, $routeParams, $location, toastr) {

getAmigos()

    function getAmigosUsuario() {
      amigosService.getAmigosUsuario().then(function (response) {
        console.log(response);
        $scope.amigosUsuario = response.data;
      });
    }

});
