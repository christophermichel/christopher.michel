app.controller('loginController', function ($scope, $routeParams, authService){

  $scope.login = function (usuario)
  {
     authService.login($scope.usuario)
       .then(
         function (response) {
           console.log(response);
         },
         function (response) {
           console.log(response);
         });
   };
});
