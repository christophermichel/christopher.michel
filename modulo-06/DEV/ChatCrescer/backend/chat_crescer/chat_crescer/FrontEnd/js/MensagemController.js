    controller.controller('MensagemController', function ($scope, $routeParams, $localStorage, MensagemService){

        function todasMensagens() {
            MensagemService.listarMensagens().then(function (response) {
            $scope.mensagens = response.data;
            });
        }

        $scope.usuario = {nome:localStorage.getItem('nome'), UrlFoto:localStorage.getItem('foto')};

        $scope.addMensagem = function (mensagem){
            mensagem.usuario = $scope.usuario;
            MensagemService.criarMensagens(mensagem).then(function (response){
                    todasMensagens();
                });
            delete $scope.mensagem;
        }

        var setInterval = function () {
                todasMensagens()
            setTimeout(setInterval, 1000);
        }

        setInterval();
        
    });