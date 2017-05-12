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
