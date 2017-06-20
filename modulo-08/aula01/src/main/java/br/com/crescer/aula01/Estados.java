package br.com.crescer.aula01;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum Estados {
    AC("Acre"), AL("Alagoas"), ES("EspíritoSanto"), AP("Amapá"),
    BA("Bahia"), CE("Ceará"), DF("DistritoFederal"), GO("Goiás"),
    MA("Maranhão"), SC("SantaCatarina"), MG("MinasGerais"),
    MT("MatoGrosso"), MS("MatoGrossodoSul"), PA("Pará"),
    RS("RioGrandedoSul"), PE("Pernambuco"), PI("Piauí"),
    AM("Amazonas"), PR("Paraná"), RJ("RiodeJaneiro"),
    RN("RioGrandedoNorte"), PB("Paraíba"), RO("Rondônia"),
    RR("Roraima"), SE("Sergipe"), SP("SãoPaulo"), TO("Tocantins");

    private String nome;

    private Estados(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
 
    public static void main(String[] args) {
        
    List<Estados> listaEstados = Arrays.asList(Estados.values());
    Collections.sort(listaEstados);
    
    StringBuilder stringB = new StringBuilder();
    for (Estados estado : listaEstados) {
        stringB.append(estado.getNome().toString());
        stringB.append(", ");
    }
    System.out.println(stringB);
    }

}
