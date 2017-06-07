imobiliaria.config(function ($routeProvider) {
        $routeProvider
            .when('/login', {
                controller: 'loginController',
                templateUrl: './login.html'

            })
            .otherwise({redirectTo:'/login'});
    });
