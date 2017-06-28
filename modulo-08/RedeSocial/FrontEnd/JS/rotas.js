app.config(function ($routeProvider) {
        $routeProvider
            .when('/login', {
                controller: 'loginController',
                templateUrl: '/login.html'
            })

            .when('/cadastro', {
                controller: 'loginController',
                templateUrl: '/cadastro.html'
            })

            .otherwise({redirectTo:'/login'});
    });
