editora.factory('IndexService', function ($http, $routeParams) {

  function getLivrosLancamentos() {
    return $http.get('http://localhost:60047/api/Livros/Lancamentos');
};

  function getLivros() {
    return $http.get('http://localhost:60047/api/Livros?pegar=9&pular=0');
};

return {
    ObterLancamentos: getLivrosLancamentos,
    ObterLivros: getLivros
};

});
