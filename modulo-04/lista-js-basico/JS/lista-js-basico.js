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
