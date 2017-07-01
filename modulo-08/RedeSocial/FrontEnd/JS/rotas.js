app.config(function ($routeProvider) {
        $routeProvider

            .when('/login', {
                controller: 'loginController',
                templateUrl: '/login.html'
            })

            .when('/cadastro', {
                controller: 'cadastroController',
                templateUrl: '/cadastro.html'
            })

            .when('/feed', {
                controller: 'feedController',
                templateUrl: '/feed.html'
            })

            .when('/amigos', {
                controller: 'loginController',
                templateUrl: '/amigos.html'
            })

            .when('/perfil', {
                controller: 'loginController',
                templateUrl: '/perfil.html'
            })

            .when('/perfilamigo/:idamigo',
            {
                controller: 'perfilAmigoController',
                templateUrl: '/perfilAmigo.html'
            })

            .when("/logout", {
                templateUrl: "logout.html",
                resolve: {
                    removerAuth: function  (authService)  {
                        return authService.logout();
                    }
                }
            })

            .otherwise({redirectTo:'/login'});
    });
