var modulo = angular.module('modulo', []);

modulo.controller('aulas', function($scope) {
    $scope.aulas = [];
    var id = 0;

//adicionar aula no array aulas, porém o primeiro ele não
//aceita as condições dadas para ser uma aula válida
    $scope.adicionar = function(nome)
    {
        var nomes = $scope.aulas.map(aula => aula.nome);
        if (nomes.some(i => i === nome))
        {
            console.log('Já existe uma aula com o nome digitado');
            return;
        }
        if ($scope.AulasForm.$valid)
        {
            $scope.aulas.push({id, nome});
            $scope.novaAula = { };
            id++;
        }
    }
//Alterar aula já existente
    $scope.alterar = function(id, novoNome)
    {
        $scope.aulas[id].nome = novoNome;
        $scope.novoNome = '';
    }

//Excluir aula
    $scope.excluir = function(id)
    {
        console.log(id);
        $scope.aulas.splice(id, 1);
    }
});
