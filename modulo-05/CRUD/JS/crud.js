var modulo = angular.module(`modulo`,[]);

modulo.controller('aulas', function($scope){
  $scope.aulas = aulas;
  $scope.instrutores = instrutores;



//incluir novo instrutor
  $scope.incluirInstrutor = function (){
      if($scope.novoInstrutorForm.$valid){
        let jaCadastrado = false;
        let emailInvalido = false;
        for(cadaUm of instrutores){
          if(cadaUm.nome === $scope.novoInstrutor.nome &&
             cadaUm.sobrenome === $scope.novoInstrutor.sobrenome)
            jaCadastrado = true;
          if(cadaUm.email === $scope.novoInstrutor.email &&
             $scope.novoInstrutor.email != null )
             emailInvalido = true;
          else {
          $scope.novoInstrutor.id = instrutores.length;
          var arrayDeAulas = [];
          if($scope.novoInstrutor.aula != null)
            for(a of aulas)
              for(cadaUm of $scope.novoInstrutor.aula){
                if(a.nome === cadaUm){
                  arrayDeAulas.push(a);
              }
          }
          $scope.novoInstrutor.aula = arrayDeAulas;
          instrutores.push($scope.novoInstrutor);
          $scope.novoInstrutor = {};
          
        }
        }
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
    $scope.deletarInstrutor = function (){
      let dandoAula = false;
      if($scope.deletarInstrutorForm.$valid){
        for (cadaUm of instrutores){
          let indexAtual = instrutores.indexOf(cadaUm);
          if(cadaUm.nome === $scope.instrutorDeletar){
                instrutores.splice(indexAtual, 1);
                alert("Instrutor deletado com sucesso!");
          }
        }
      }
    }

//Incluir nova aula
  $scope.incluirAula = function ()
  {
    if($scope.aulasForm.$valid)
    {
      var aulaExiste = true;
      for(a of aulas)
      {
        if(a.nome === $scope.novaAula.nome)
          aulaExiste = false;
      }
      if(aulaExiste)
      {
        $scope.novaAula.id = aulas.length;
        aulas.push($scope.novaAula);
        $scope.novaAula = {};
        alert("Aula incluida com sucesso!");
      }
    } else
    {
      alert("Não foi possível incluir a aula")
    }
  }


//alterar aula já existente
  $scope.alterarAula = function(){
    aulas[$scope.selecionarAula.id].nome = $scope.alterarAula.nome;
    alert("Aula modificada com sucesso!");
  }

// deletar aula
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
