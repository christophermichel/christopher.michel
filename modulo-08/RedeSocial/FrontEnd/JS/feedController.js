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
        console.log(post);
        post.idUsuario = $scope.usuarioAtual;
        console.log(post);
        feedService.novoPost(post).then( function (){
            toastr.success('Todo dia é um bom dia para falar sobre música!');
        });
      } else {
        toastr.warning('Poxa, assim não podemos publicar!');
      }
    };

});
