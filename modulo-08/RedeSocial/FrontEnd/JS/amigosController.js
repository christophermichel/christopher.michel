angular.module('app').controller('amigosController', function ($scope, amigosService, authService, $routeParams, $location, toastr) {

getAmigosUsuario();

   function getAmigosUsuario() {
   console.log("hello");
      amigosService.getAmigosUsuario().then(function (response) {
        console.log(response);
        $scope.amigosUsuario = response.data;
      });
    }

});
