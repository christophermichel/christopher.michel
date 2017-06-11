imobiliaria.config(function ($routeProvider) {
        $routeProvider
            .when('/login', {
                controller: 'loginController',
                templateUrl: './login.html'

            })
            .when('/devolucao', {
                controller: 'pedidoController',
                templateUrl: './devolucao.html'
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
