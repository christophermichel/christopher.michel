imobiliaria.config(function ($routeProvider) {
        $routeProvider
            .when('/home', {
                controller: 'IndexController',
                templateUrl: './home.html'
                
            })
            .otherwise({redirectTo:'/home'});
    });
