imobiliaria.config(function ($routeProvider) {
        $routeProvider
            .when('/login', {
                controller: 'loginController',
                templateUrl: './login.html'

            })
            .when('/pedido', {
                controller: 'pedidoController',
                templateUrl: './pedido.html'

            })
            .otherwise({redirectTo:'/login'});
    });
