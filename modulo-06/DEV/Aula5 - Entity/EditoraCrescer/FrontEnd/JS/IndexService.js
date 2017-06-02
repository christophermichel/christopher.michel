editora.factory('IndexService', function ($http) {

    function getLivrosLancamentos() {
    return $http.get('http://localhost:60047/api/Livros/Lancamentos');
};

    function getLivros() {
    return $http.get('http://localhost:60047/api/Livros');
};

return {
    ObterLancamentos: getLivrosLancamentos,
    ObterLivros: getLivros
      };

});
