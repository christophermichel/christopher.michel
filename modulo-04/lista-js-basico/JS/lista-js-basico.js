console.log("Carregou!");

//Exercício 1
function daisyGame(a) {
  if (a%2 === 0) {
    console.log("Love me not")
  }
  else {
    console.log("Love me")
  }
}

console.log(daisyGame(0))
console.log(daisyGame(1))
console.log(daisyGame(2))

//Exercício 2
function maiorTexto(a) {
    var maior = "";
    for(var i = 0; i < a.length; i++) {
        if(a[i].length > maior.length)
            maior = a[i];
    }
    return maior;
}

console.log(maiorTexto(["ie aihf aoefh oa","odhif aiofh", "aehioaehfioaehfiaohfiohioahfiohfiehieoh"]))
console.log(maiorTexto(["","ja"]))

//Exercício 3
function imprime(arrayDeStrings, funcao) {
    if(typeof funcao !== "function")
      return console.log("Isso não é uma função");
    for(var i = 0; i < arrayDeStrings.length; i++)
        funcao(arrayDeStrings[i]);
}

//Exercício 4
function somaDiferentona(a) {
    return function(b) {
        return parseInt(a) + parseInt(b);
    };
}

console.log("Soma Diferentona de (3)(4) é: ",somaDiferentona(3)(4));
console.log("Soma Diferentona de (5642)(8749) é: ",somaDiferentona(5642)(8749));

//Exercício 5

function fibonacci(a){
    if(a<0){
      console.log("Número inválido")
    }
    if(a === 2 || a === 1) {
      return 1
    }
    else {
      return (fibonacci(a-1) + fibonacci(a-2))
    }
}

/*function fiboSum(numeroDeTermos){
  var soma = 0;
  for(var i = 1, i<numeroDeTermos, i++) {
    soma = soma + fibonacci(i);
  }
  return soma
}*/

//Exercício 6

function bubbleSort(a) {
    var trocarposicoes;
    var a = a;
    do {
        trocarposicoes = false;
        for (var i=0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) {
                var temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                trocarposicoes = true;
            }
        }
    } while (trocarposicoes);
}

function queroCafe (mascada, precos)
  var precos = precos;
  for(i=0, i<precos.length, i++) {
    if(precos[i] <= mascada)
        possiveis.push(precos[i]);
  }
  return bubbleSort(possiveis).toString();
}
