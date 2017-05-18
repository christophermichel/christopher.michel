var aula2 = angular.module('aula2',[]);

aula2.controller('buscarPorData', function($scope, $filter) {
  $scope.dataRecebida = "";
  $scope.funcaoData = funcaoData;
  $scope.data = data;

  var stringData = function (dataRecebida) {
    var dia = stringData.slice(0,2);
    var mes = stringData.slice(3,5);
    var ano = stringData.slice(6,10);
    funcaoData(mes, dia, ano)
  }

  var funcaoData = function(a, b, c) {
    var array = [b, a, c];
    var stringDaData = a.split(.);
    $scope.data = new Date(stringDaData);
});
