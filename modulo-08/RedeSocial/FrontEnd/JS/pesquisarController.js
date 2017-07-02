angular.module('app').controller('pesquisarController', function ($scope, pesquisarService, $routeParams, $location, toastr) {

getUsuarios()

    function getUsuarios() {
      pesquisarService.getUsuarios().then(function (response) {
        console.log(response);
        $scope.usuarios = response.data;
      });
    }

});
