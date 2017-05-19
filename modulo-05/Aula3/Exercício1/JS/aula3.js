var aula3 = angular.module('aula3',[]);

aula3.controller('a', function($scope) {
  $scope.nomes = ['Bernardo', 'Nunes'];
  $scope.incluir = function (novoNome) {
    if ($scope.meuForm.$invalid) {
      return;
    }
    $scope.nomes.push(novoNome);
  }
});
