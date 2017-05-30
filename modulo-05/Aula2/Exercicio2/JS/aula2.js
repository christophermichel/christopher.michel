var aula2 = angular.module('aula2',[]);

aula2.controller('a', function($scope) {
  $scope.instrutores = [{
    nome: 'Bernardo',
    aula: [{
        numero: 1,
        nome: 'OO'
      },
      {
        numero: 4,
        nome: 'Javascript'
      }
    ]
  },
  {
    nome: 'Nunes',
    aula: [{
      numero: 2,
      nome: 'Banco de Dados I'
    }]
  },
  {
    nome: 'Pedro (PHP)',
    aula: [{
      numero: 3,
      nome: 'HTML e CSS'
    }]
  },
  {
    nome: 'Zanatta',
    aula: [{
      numero: 5,
      nome: 'AngularJS'
    }]
  }
];
});

aula2.filter('mascada',function(){
    return function(nome){
      return nome.replace(/nunes/gi,'$' + nome + '$');
}});
