angular.module('app').controller('feedController', function ($scope, feedService, $http, $localStorage, $sessionStorage, $location, toastr) {

getPosts()
getUsuarioAtual()
getSolicitacoes();
$scope.postOrdenado;
    function getPosts() {
      feedService.getPosts().then(function (response) {
        console.log(response);
        $scope.posts = response.data;
//        function ordemDecrescente(a, b) {
//            return a.dataPublicacao < b.dataPublicacao;
//        }
//        $scope.posts.sort(ordemDecrescente);
//        console.log($scope.posts);
      });
    }

    function getSolicitacoes() {
      feedService.getSolicitacoes().then(function (response) {
        console.log(response);
        $scope.solicitacoes = response.data;
      });
    }

    $scope.aceitarAmizade = function (id) {
          console.log(id);
          $http.post('http://localhost:9090/usuario/aceitar/' + id).then(function (){
              toastr.success('Boa! Network é vida!');
              getSolicitacoes();
        });
      };

    function getUsuarioAtual() {
      feedService.getUsuarioAtual().then(function (response) {
        console.log(response);
        $scope.usuarioAtual = response.data;
      });
    }

    $scope.rejeitarAmizade = function (id) {
          $http.post('http://localhost:9090/usuario/rejeitar/' + id).then(function (){
              toastr.success('Solicitação de amizade rejeitada');
              getSolicitacoes();
        });
      };

    function getUsuarioAtual() {
      feedService.getUsuarioAtual().then(function (response) {
        console.log(response);
        $scope.usuarioAtual = response.data;
      });
    }

    $scope.novoPost = function (post) {
      if ($scope.formPost.$valid) {
        post.idUsuario = {id:$scope.usuarioAtual.id};
        feedService.novoPost(post).then( function (){
            toastr.success('Todo dia é um bom dia para falar sobre música!');
            getPosts();
        });
      } else {
        toastr.warning('Poxa, assim não podemos publicar!');
      }
    };

    $scope.curtir = function (post) {
      var objeto = {};
      if($scope.verificarSePostJaFoiCurtido(post)){
        "Deveria descurtir, mas por enquanto, só aviso que não se pode curtir de novo!"
      } else {
      feedService.curtir(post.id, objeto).then( function (){
          toastr.success('Você curtiu a publicação de ' + post.idUsuario.nome);
          getPosts()
      })};
    }

    $scope.verificarSePostJaFoiCurtido = function(post) {
        return post.curtir.some(x => x.usuarioCurtir.id == $scope.usuarioAtual.id);
    }

});
