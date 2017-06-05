editora.controller('LivroDetalhadoController', function ($scope, $routeParams, LivroDetalhadoService){

ObterPorId($routeParams.isbn);

var a = $routeParams.isbn;
  function buscarPorId (a){
      LivroDetalhadoService.ObterPorId(isbn).then(function (response){
        $scope.livroDetalhado = response.data;
  })};

});
