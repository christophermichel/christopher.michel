angular.module('app').controller('feedController', function ($scope, feedService, $location, toastr) {

getPosts()

    function getPosts() {
      feedService.getPosts().then(function (response) {
        console.log(response);
        $scope.posts = response.data;
      });
    }

});
