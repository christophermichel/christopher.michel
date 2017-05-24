angular.module('app').factory('instrutorService', function ($http) { 
  let urlBase = 'http://localhost:3000/instrutor';

  function getTodosOsInstrutores() {
    return $http.get(urlBase);
  };

 function editar(instrutor) {
    return $http.put(urlBase + '/' + instrutor.id, instrutor);
  };

  function incluir(instrutor){
    return $http.post(urlBase, instrutor);
  }

  function excluir(instrutor) {
    return $http.delete(urlBase + '/' + instrutor.id);
  }

    return {
    list: getTodosOsInstrutores,
    editar: editar,
    incluir: incluir,
    excluir: excluir
  };
});
