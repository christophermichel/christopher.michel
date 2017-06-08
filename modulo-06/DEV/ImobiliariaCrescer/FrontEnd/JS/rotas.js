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

            .when('/cadastro', {
                controller: 'pedidoController',
                templateUrl: './cadastro.html'
            })

            .otherwise({redirectTo:'/login'});
    });
