 var modulo = angular.module(`modulo`,['ngRoute']);


 modulo.config(function ($routeProvider) {

  $routeProvider
    .when('/aulas', {
      controller: 'aulas',
      templateUrl: 'aulas.html'
    })
    .when('/instrutores', {
      controller: 'instrutores',
      templateUrl: 'instrutores.html'
    })
    .otherwise({redirectTo: '/aulas'});
});

modulo.controller('instrutores', function($scope, $http){
$scope.instrutores = instrutores;
  $scope.incluirInstrutor = function (){
      if($scope.novoInstrutorForm.$valid){
        var naoCadastrado = true;
        var emailValido = true;
        for(cadaUm of instrutores){
          if(cadaUm.email === $scope.novoInstrutor.email &&
             $scope.novoInstrutor.email != null )
             emailValido = false;
          if(cadaUm.nome === $scope.novoInstrutor.nome &&
            cadaUm.sobrenome === $scope.novoInstrutor.sobrenome)
            naoCadastrado = false;
        }
        if(naoCadastrado && emailValido)
        {
          $scope.novoInstrutor.id = instrutores.length;
          let aulasInstrutor = [];
          if($scope.novoInstrutor.aula != null)
          for(a of aulas)
              for(cadaUm of $scope.novoInstrutor.aula)
            {
              if(a.nome === cadaUm)
              {
                aulasInstrutor.push(a);
              }
          }
          $scope.novoInstrutor.aula = aulasInstrutor;
          instrutores.push($scope.novoInstrutor);
          $scope.novoInstrutor = {};
          alert("Instrutor inserido com sucesso!")
        }
        else jaCadastrado ? alert("Instrutor já cadastrado.") : alert("Email já está sendo utilizado.")

      }
    }





//alterar instrutor já existente
  $scope.alterarInstrutor = function (){
      if($scope.alterarInstrutorExistente != undefined){
        var indexAtual;
        for (cadaUm of instrutores){
          if(cadaUm.nome === $scope.selectAltera)
            indexAtual = instrutores.indexOf(cadaUm);
          }
            instrutores[indexAtual].nome = $scope.alterarInstrutorExistente.nome;
            instrutores[indexAtual].sobrenome = $scope.alterarInstrutorExistente.sobrenome;
            instrutores[indexAtual].idade = $scope.alterarInstrutorExistente.idade;
            instrutores[indexAtual].email = $scope.alterarInstrutorExistente.email;
            instrutores[indexAtual].dandoAula = $scope.alterarInstrutorExistente.dandoAula;
            instrutores[indexAtual].aula = $scope.alterarInstrutorExistente.aula;
            instrutores[indexAtual].urlFoto = $scope.alterarInstrutorExistente.urlFoto;
          $scope.alterarInstrutorExistente = {};
          alert("Alterações realizadas com sucesso!");
    }
  }

//deletar instrutor
function deletarInstrutor(instrutor){
    aulaService.deletarInstrutor(instrutor)
    };

});

modulo.controller('aulas', function($scope, $http){
  $scope.aulas = aulas;



//Incluir nova aula
function incluirAula(aula) {
  aulaService.incluirAula(aula);
}
//alterar aula já existente
function alterarAula(aula){
    aulaService.alterarAula(aula);
  }
// deletar aula
function deletarAula(aula) {
      aulaService.deletarAula(aula);
  }
});



modulo.filter('ordenarPorAula', function(){
  return function(){
    return aulas.sort(function(a, b) {
          if (a.nome.toUpperCase() < b.nome.toUpperCase()) {
            return -1;
          }
          if (a.nome.toUpperCase() > b.nome.toUpperCase()) {
            return 1;
          }
          return 0;
        });
  }
})
modulo.filter('ordenarPorInstrutor', function(){
  return function(){
    return instrutores.sort(function(a, b) {
          if (a.nome.toUpperCase() < b.nome.toUpperCase()) {
            return -1;
          }
          if (a.nome.toUpperCase() > b.nome.toUpperCase()) {
            return 1;
          }
          return 0;
        });
  }
})
//aula para exemplo
let aulas = [
  { id: 0,
    nome:'Orientacao a Objetos'
  },
  {
    id: 1,
    nome:'Banco de Dados'
  }
];
// Instrutor para exemplo
let instrutores = [
  { id: 0,
    nome: 'Bernardo',
    sobrenome: 'Rezende',
    idade: 30,
    email: 'bernardo@cwi.com.br',
    jaDeuAula: true,
    aula: [aulas[0], aulas[1]],
    urlFoto: 'xxx'
  }
];
