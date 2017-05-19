var aula3 = angular.module('aula3',[]);

aula3.controller('a', function($scope) {
  $scope.instrutor = [$scope.nomes, $scope.sobrenomes, $scope.idades, $scope.emails ];
  $scope.nomes = [];
  $scope.sobrenomes = [];
  $scope.idades = [];
  $scope.emails = [];

  $scope.instrutores = function (novoInstrutor) {
    if ($scope.meuForm.$invalid) {
      return;
    }
    $scope.nomes.push(novoNome);
    $scope.sobrenomes.push(novoSobrenome);
    $scope.idades.push(novaIdade);
    $scope.emails.push(novoEmail);
  }

});
