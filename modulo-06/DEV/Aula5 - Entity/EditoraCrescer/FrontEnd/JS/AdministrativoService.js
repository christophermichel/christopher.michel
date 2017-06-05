editora.factory('AdministrativoService', function ($http, $routeParams) {

function criar(livro)
{
    return $http.post('http://localhost:60047/api/Livros/', livro);
};

function alterar(livro){
    return $http.put('http://localhost:60047/api/Livros/' + livro.Isbn, livro);
}

return {
  criar: criar,
  alterar: alterar
};

});
