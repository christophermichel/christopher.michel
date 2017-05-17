function buscarPokemon() {
    var form = document.forms.pokemonASerBuscado;
    var botaoDesativado = form.submitBt.disabled;
    botaoDesativado = true;
    var id = form.id.value;
    fetch("https://pokeapi.co/api/v2/pokemon/"+id)
        .then(response => response.json())
        .then(json => {
            console.log(json);
            var imagem = document.createElement("img");
            imagem.src = json.sprites.front_default;
            var p = document.createElement("p");
            p.innerText = (json.name).toUpperCase()
            var divResult = document.getElementById("resultado");

            divResult.appendChild(imagem);
            divResult.appendChild(p);
            divResult.appendChild(id);
            submitBtDisabled = false;
        })
}
