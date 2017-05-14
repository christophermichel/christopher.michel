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
function seriesPorAno(serie,ano) {
	return series.filter(series => (series.anoEstreia > ano))
}

console.log('exercicio 02 ');
console.log(seriesPorAno(series,2015));

//Exercício 3

function mediaDeEpisodios(series) {
	var somaDeEpisodios = 0;
	var media = 0;
	series.forEach(function(serie){
		somaDeEpisodios += (serie.numeroEpisodios)
	})
	return media = somaDeEpisodios/series.length
}
console.log(mediaDeEpisodios(series))
