package br.com.crescer.aula01;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chris
 */
public class TemaStringTest {
    
    public TemaStringTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    /**
     * Test of isEmpty method, of class TemaString.
     */
    @org.junit.Test
    public void testIsEmptyFalse() {
        System.out.println("IsEmpty");
        String string = "allkas";
        TemaString instance = new TemaString();
        boolean expResult = false;
        boolean result = instance.isEmpty(string);
        
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testIsEmptyTrue() {
        System.out.println("IsEmpty");
        String string = "";
        TemaString instance = new TemaString();
        boolean expResult = true;
        boolean result = instance.isEmpty(string);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of inverter method, of class TemaString.
     */
    @org.junit.Test
    public void testInverter() {
        System.out.println("inverter");
        String string = "chris";
        TemaString instance = new TemaString();
        String expResult = "sirhc";
        String result = instance.inverter(string);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of contaVogais method, of class TemaString.
     */
    @org.junit.Test
    public void testContaVogais() {
        System.out.println("contaVogais");
        String string = "adaga";
        TemaString instance = new TemaString();
        int expResult = 3;
        int result = instance.contaVogais(string);
        assertEquals(expResult, result);
    }

    /**
     * Test of isPalindromo method, of class TemaString.
     */
    @org.junit.Test
    public void testIsPalindromo() {
        System.out.println("isPalindromo");
        String string = "amad d a m a";
        TemaString instance = new TemaString();
        boolean expResult = true;
        boolean result = instance.isPalindromo(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @org.junit.Test
    public void testIsPalindromoFalso() {
        System.out.println("isPalindromo");
        String string = "amads a m a";
        TemaString instance = new TemaString();
        boolean expResult = false;
        boolean result = instance.isPalindromo(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    } 
    
    @Test
    public void testIsEmpty() {
        TemaString instance = new TemaString();
        assertTrue(instance.isEmpty(null));
        assertTrue(instance.isEmpty(""));
        assertTrue(instance.isEmpty(" "));
        assertFalse(instance.isEmpty("a"));
        assertFalse(instance.isEmpty(" a "));
    }

    /**
     * Test of inverter method, of class StringUtils.
     */
    @Test
    public void testInverter2() {
        TemaString instance = new TemaString();
        assertEquals("solrac", instance.inverter("carlos"));
    }

    /**
     * Test of contaVogais method, of class StringUtils.
     */
    @Test
    public void testContaVogais2() {
        TemaString instance = new TemaString();
        assertEquals(2, instance.contaVogais("carlos"));
    }

    /**
     * Test of isPalindromo method, of class StringUtils.
     */
    @Test
    public void testIsPalindromo2() {
        TemaString instance = new TemaString();
        assertTrue(instance.isPalindromo("ovo"));
        assertTrue(instance.isPalindromo("Ame a Ema"));
        assertTrue(instance.isPalindromo("A sogra má e amargosa"));
        assertFalse(instance.isPalindromo("uva"));
        assertFalse(instance.isPalindromo("Ame a Emo"));
    }
    
}
