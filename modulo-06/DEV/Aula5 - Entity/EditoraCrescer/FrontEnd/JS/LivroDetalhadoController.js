editora.controller('LivroDetalhadoController', function ($scope, $routeParams, LivroDetalhadoService){

ObterPorId($routeParams.isbn);


  function buscarPorId ($routeParams.isbn){
      LivroDetalhadoService.ObterPorId(isbn).then(function (response){
        $scope.livroDetalhado = response.data;
  })};

});
