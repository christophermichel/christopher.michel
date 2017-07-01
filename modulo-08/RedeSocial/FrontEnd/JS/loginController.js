angular.module('app').controller('loginController', function ($scope, authService, $location, toastr) {

  $scope.login = function (usuario) {

    if ($scope.formLogin.$valid) {
    authService.login(usuario)
      .then(function (response) {
            toastr.success('Login realizado com sucesso');
            $location.path('/feed');

        },
        function (response) {
          toastr.error('Credenciais inválidas!');
        });
    } else {
        toastr.error('Confira os dados preenchidos!');
    }
  };
});
