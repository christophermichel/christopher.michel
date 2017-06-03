editora.config(function ($routeProvider) {
        $routeProvider
            .when('/home', {
                controller: 'IndexController',
                templateUrl: './home.html'
            })
            .when('/login', {
                controller: 'LoginController',
                templateUrl: './login.html'
            })
            .when('/administrativo', {
                controller: 'AdministrativoController',
                templateUrl: './administrativo.html'
            })
            .otherwise({redirectTo:'/home'});
    });
