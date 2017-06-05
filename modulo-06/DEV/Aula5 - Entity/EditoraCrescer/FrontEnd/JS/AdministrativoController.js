editora.controller('AdministrativoController', function ($scope, $routeParams, AdministrativoService, authService){

function salvar(livro)
{
    if (typeof livro.Isbn === 'number')
    {
        alterar(livro);
    }
    else
    {
        criar(livro);
    }
}

});
