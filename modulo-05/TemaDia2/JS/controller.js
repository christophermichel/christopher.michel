var modulo = angular.module('modulo', []);

modulo.controller('tema2', function($scope){
  $scope.instrutores = instrutores;
  $scope.arrayInterno = arrayInterno();
});


var instrutores = [{
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

function arrayInterno() {
  var interno = [];
    instrutores.forEach(function(instrutor){
      for(aula of instrutor.aula) {
        interno.push({aula: aula, instrutor: instrutor })
      }
    }
  )
  return interno
}

modulo.filter('mascada', () => nome => nome.replace(/(nunes)/gi, '$ $1 $'));
modulo.filter('upperCase', () => nome => nome.toString().toUpperCase());
modulo.filter('completarComZero', () => numero => numero.toString().padStart(3, '0'));
