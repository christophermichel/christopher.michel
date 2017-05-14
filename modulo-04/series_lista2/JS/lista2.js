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

function MascadaEmSerie(serie) {
	var pagamentoFinal;
	for(atores of serie.eleco){
		pagamentoFinal += 40000;
	}
	for(atores of serie.diretor){
		pagamentoFinal += 100000;
	}
	return pagamentoFinal;
}
