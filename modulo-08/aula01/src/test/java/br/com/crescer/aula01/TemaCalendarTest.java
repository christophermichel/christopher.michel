/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula01;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author carloshenrique
 */
public class TemaCalendarTest {

    private final TemaCalendar calendarUtils = new TemaCalendar();
    private static final Calendar CALENDAR = Calendar.getInstance();

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_Domingo() {
        CALENDAR.set(2017, 5, 18, 0, 0, 0); // 2017-06-18 00:00:00

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(diaSemana.DOMINGO, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_SegundaFeira() {
        CALENDAR.set(2017, 5, 19, 0, 0, 0); // 2017-06-19 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(diaSemana.SEGUNDA_FEIRA, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_TercaFeira() {
        CALENDAR.set(2017, 5, 20, 0, 0, 0); // 2017-06-20 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(diaSemana.TERCA_FEIRA, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_QuartaFeira() {
        CALENDAR.set(2017, 5, 21, 0, 0, 0); // 2017-06-21 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(diaSemana.QUARTA_FEIRA, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_QuintaFeira() {
        CALENDAR.set(2017, 5, 22, 0, 0, 0); // 2017-06-22 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(diaSemana.QUINTA_FEIRA, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_SextaFeira() {
        CALENDAR.set(2017, 5, 23, 0, 0, 0); // 2017-06-23 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(diaSemana.SEXTA_FEIRA, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_Sabado() {
        CALENDAR.set(2017, 5, 24, 0, 0, 0); // 2017-06-24 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(diaSemana.SABADO, diaSemana);
    }

    /**
     * Test of tempoDecorrido method, of class CalendarUtils.
     */
    @Test
    public void testTempoDecorrido() {
        final Period between = Period.between(LocalDate.of(1985, Month.JANUARY, 29), LocalDate.now());

        CALENDAR.set(1985, 0, 29, 0, 0, 0); // 1985-01-29 00:00:00    

        final String tempo = calendarUtils.tempoDecorrido(CALENDAR.getTime());
        final String format = String.format("%s ano(s), %s messe(s) e %s dia(s)", 
                between.getYears(), 
                between.getMonths(), 
                between.getDays());

        assertEquals(format, tempo);
    }

}
