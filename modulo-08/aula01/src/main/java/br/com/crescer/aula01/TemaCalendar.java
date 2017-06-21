package br.com.crescer.aula01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author chris
 */

public class TemaCalendar implements CalendarUtils{
    
    public SimpleDateFormat formatoData () {
        //para poder instancia na hora de testar
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        return formatoData;
    }
    Calendar calendar = Calendar.getInstance();
    
    public static void main (String[] args) throws ParseException {
        TemaCalendar testa = new TemaCalendar();
        System.out.println(testa.diaSemana(new SimpleDateFormat("dd/MM/yyyy").parse("19/06/2015")));
        System.out.println(testa.diaSemana(new SimpleDateFormat("dd/MM/yyyy").parse("21/06/2017")));
    }
    
    @Override
    public DiaSemana diaSemana(Date date) {
        calendar.setTime(date);
        DiaSemana dia = DiaSemana.values()[calendar.get(Calendar.DAY_OF_WEEK) -1];
        return dia;
    }

    @Override
    public String tempoDecorrido(Date date) {
        Calendar dataAtual = Calendar.getInstance();
        Calendar dataInformada = Calendar.getInstance();
        
        dataAtual.setTime(new Date());
        dataInformada.setTime(date);
        
        
        return "falta implementar";
    }
}
