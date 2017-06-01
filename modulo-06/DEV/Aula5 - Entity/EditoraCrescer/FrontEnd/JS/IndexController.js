editora.controller('IndexController', function ($scope, $routeParams, IndexService){
ObterLivros()
function ObterLivros() {
      IndexService.ObterLivros().then(function (response) {
      $scope.livros = response.data;
      });
    }

});
