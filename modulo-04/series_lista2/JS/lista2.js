//Exercício 1
function seriesInvalidas(series) {
  var seriesQueNaoDevemAparecer = new Array;
  series
  .forEach(i => {
     if(i.anoEstreia > new Date().getFullYear()) {
       seriesQueNaoDevemAparecer.push(i.titulo)
      }
    });
  return "Séries Inválidas: " + seriesQueNaoDevemAparecer.join(" - ");
}
console.log("Exercicio 1: " + seriesInvalidas(series));



//Exercício 2
function seriesPorAno(series,ano) {
	var seriesSelecionadas = Array();
  for(serie of series) {
		if(serie.anoEstreia >= ano) {
			seriesSelecionadas.push(serie)
		}
	}
	return seriesSelecionadas;
}
console.log("Exercício 2" + seriesPorAno(series,2015));

//Exercício 3

function mediaDeEpisodios(series) {
  var somaDeEpisodios = 0;
  var media = 0;
  series.forEach(function(serie){
    somaDeEpisodios += (serie.numeroEpisodios)
  })
  return media = somaDeEpisodios/series.length
}
console.log("Exercício 3: " + mediaDeEpisodios(series))

//Exercício 4

function procurarPorNome(series,nome){
		var nomeEncontrado = false;
		for(serie of series){
				for(atores of serie.elenco){
						if(nome === atores){
								nomeEncontrado = true;
								break;
						}
				}
		}
		return nomeEncontrado;
}
console.log("Exercício 4: Teste true - " + procurarPorNome(series,"Christopher Michel"))
console.log("Exercício 4: Teste false - " + procurarPorNome(series,"Christopher"))

//Exercício 5

function mascadaEmSerie(serie) {
	var pagamentoFinal = 0;
	for(atores of serie.elenco){
		pagamentoFinal += 40000;
	}
	for(atores of serie.diretor){
		pagamentoFinal += 100000;
	}
	return pagamentoFinal;
}
console.log(("Exercício 5: " + mascadaEmSerie(series[5])));
console.log(("Exercício 5: " + mascadaEmSerie(series[7])));

//Exercício 6 A

function queroGenero(genero) {
	var seriesPorGenero = Array();
		for(serie of series) {
			for(a of series.genero){
				if(genero === generos) {
					seriesPorGenero.push(serie.titulo);
				}
			}
		}
	return seriesPorGenero;
}

//Exercício 6 B

function queroTitulo(titulo) {
    var filtro = function(serie) {
        return (serie.titulo.toLowerCase()).includes(titulo.toLowerCase());
    };
    return series.filter(filtro);
}
console.log("Exercício 6B: ", queroTitulo("of"));
console.log("Exercício 6B: ", queroTitulo("The"));

//Exercício 8

function atoresIlluminati(series){
	var atores = Array();
  for(serie of series){
    var nomesAbreviados = 0;
    for(ator of serie.elenco){
      if(ator.includes(".")) {
        nomesAbreviados++;
      	if(nomesAbreviados === serie.elenco.length) {
					for(ator of serie.elenco){
						atores.push(ator)
					}
        }
      }
    }
  }
  return atores;
}

function fraseIlluminati(atores) {
	var stringFinal = "#"
	for(ator of atores) {
		var letra = ator.charAt(ator.indexOf(".")-1);
		stringFinal = stringFinal + letra;
	}
	return stringFinal;
}
