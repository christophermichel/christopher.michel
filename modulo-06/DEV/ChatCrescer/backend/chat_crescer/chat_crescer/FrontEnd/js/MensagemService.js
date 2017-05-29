controller.factory('MensagemService', function ($http) {

  let urlBase = 'http://localhost:50704/api';

  function getMensagens() {
      return $http.get(urlBase + '/Mensagens');
  };

  function postMensagem(mensagem) {
      return $http.post(urlBase + '/Mensagens', mensagem);
  };

  return {
    listarMensagens: getMensagens,
    criarMensagens: postMensagem,
  };
});