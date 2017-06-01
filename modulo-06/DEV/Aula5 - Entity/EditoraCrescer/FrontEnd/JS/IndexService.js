editora.factory('IndexService', function ($http) {

    function getLivros() {
    return $http.get('http://localhost:60047/api/Livros');
};

return {
    ObterLivros: getLivros,
      };

});
