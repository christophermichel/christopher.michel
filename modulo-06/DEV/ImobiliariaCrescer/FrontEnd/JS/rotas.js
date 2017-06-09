imobiliaria.config(function ($routeProvider) {
        $routeProvider
            .when('/login', {
                controller: 'loginController',
                templateUrl: './login.html'

            })
            .when('/cliente', {
                controller: 'pedidoController',
                templateUrl: './cliente.html'
            })

            .when('/cadastro', {
                controller: 'pedidoController',
                templateUrl: './cadastro.html'
            })

            .when('/pedido', {
                controller: 'pedidoController',
                templateUrl: './pedido.html'
            })

            .when('/relatorio', {
                controller: 'pedidoController',
                templateUrl: './relatorio.html'
            })

            .otherwise({redirectTo:'/login'});
    });
