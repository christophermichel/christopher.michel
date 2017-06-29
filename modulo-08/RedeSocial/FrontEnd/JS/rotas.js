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

            .when('/feed', {
                controller: 'loginController',
                templateUrl: '/feed.html'
            })

            .otherwise({redirectTo:'/login'});
    });
