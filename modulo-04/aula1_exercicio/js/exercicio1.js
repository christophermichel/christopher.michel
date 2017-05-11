console.log("Carregou!");
//alert("Hey ho, let's go");
if (typeof pi !== "undefined") {
  console.log(pi)
}

function soma (a, b) { return a+b}
var somar = (a, b) => a+b

var somar = function() {
  var a = arguments[0], b = arguments[1]
  return a + b
}

console.log("soma " + soma(1,5))
console.log("somar " + somar(1,5))
