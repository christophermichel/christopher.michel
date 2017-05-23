modulo.factory('aulaService', function ($http) {

function deletarInstrutor(instrutor){
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



function incluirAula(aula)
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

function alterarAula(aula) {
  aulas[$scope.selecionarAula.id].nome = $scope.alterarAula.nome;
  alert("Aula modificada com sucesso!");
}

function deletarAula(aula) {
  if($scope.deletarAulaForm.$invalid){
     return;
  }
  for (var cadaUm = 0; cadaUm < $scope.aulas.length; cadaUm++)
  {
    if ($scope.aulas[cadaUm].id === id)
    {
      for (cadaUm of instrutores)
      {
        for(var i = 0; i < cadaUm.aula.length; i++)
        {
          if(cadaUm.aula[i] === id)
          {
            window.alert('Não é possível excluir esta aula. Está sendo utilizada.');
            $scope.idAula = "";
            return;
          }
        }
      }
      $scope.aulas.splice(cadaUm, 1);
      window.alert('Aula excluída com sucesso.');
      $scope.idAula = "";
      return;
    }
  }
   window.alert('Aula não cadastrada.');
   $scope.idAula="";
  return;
}



});
