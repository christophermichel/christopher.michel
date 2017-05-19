var modulo = angular.module("modulo",[]);

modulo.controller ("aula2", function ($scope) {
    $scope.convert = function () {
        $scope.dataSaida = new Date ($scope.dataEntrada);
    }
})
