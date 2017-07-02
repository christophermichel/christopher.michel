angular.module('app').controller('feedController', function ($scope, feedService, $localStorage, $sessionStorage, $location, toastr) {

getPosts()
getUsuarioAtual()

    function getPosts() {
      feedService.getPosts().then(function (response) {
        console.log(response);
        $scope.posts = response.data;
      });
    }

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
            $location.path('/feed.html');
        });
      } else {
        toastr.warning('Poxa, assim não podemos publicar!');
      }
    };

});
