editora.factory('LivroDetalhadoService', function ($http, $routeParams) {

  function getLivrosPorId(isbn){
    return $http.get('http://localhost:60047/api/Livros/' + isbn);
};

return {
    ObterPorId : getLivrosPorId
};

});
