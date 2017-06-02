editora.controller('IndexController', function ($scope, $routeParams, IndexService){
ObterLancamentos()
ObterLivros()

function ObterLancamentos() {
      IndexService.ObterLancamentos().then(function (response) {
      $scope.lancamentos = response.data;
      });
    }
function ObterLivros() {
      IndexService.ObterLivros().then(function (response) {
      $scope.livros = response.data;
      });
    }

});
