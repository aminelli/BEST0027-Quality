package com.esempio;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Classe di test per la Calcolatrice
 */
@DisplayName("Test della Calcolatrice")
class CalcolatriceTest {
    
    private Calcolatrice calc;
    
    @BeforeEach
    void setUp() {
        calc = new Calcolatrice();
        System.out.println("Inizializzazione test...");
    }
    
    @AfterEach
    void tearDown() {
        System.out.println("Test completato.\n");
    }
    
    @Test
    @DisplayName("Test somma di due numeri positivi")
    void testSommaPositivi() {
        assertEquals(5, calc.somma(2, 3));
        assertEquals(100, calc.somma(50, 50));        
    }
    
    @Test
    @DisplayName("Test somma con numeri negativi")
    void testSommaNegativi() {
        assertEquals(-5, calc.somma(-2, -3));
        assertEquals(0, calc.somma(-5, 5));
    }
    
    @Test
    @DisplayName("Test sottrazione")
    void testSottrazione() {
        assertEquals(2, calc.sottrazione(5, 3));
        assertEquals(-2, calc.sottrazione(3, 5));
        assertEquals(0, calc.sottrazione(5, 5));
        
    }
    
    @Test
    @DisplayName("Test moltiplicazione")
    void testMoltiplicazione() {
        assertEquals(6, calc.moltiplicazione(2, 3));
        assertEquals(0, calc.moltiplicazione(5, 0));
        assertEquals(-15, calc.moltiplicazione(3, -5));
    }
    
    @Test
    @DisplayName("Test divisione normale")
    void testDivisione() {
        assertEquals(2.0, calc.divisione(6, 3));
        assertEquals(2.5, calc.divisione(5, 2));
        assertEquals(-2.0, calc.divisione(6, -3));
    }
    
    @Test
    @DisplayName("Test divisione per zero - deve lanciare eccezione")
    void testDivisionePerZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.divisione(10, 0);
        });
        assertEquals("Divisione per zero non permessa", exception.getMessage());
    }
    
    @ParameterizedTest
    @DisplayName("Test numeri pari")
    @ValueSource(ints = {2, 4, 6, 8, 0, -2, -4})
    void testNumeriPari(int numero) {
        assertTrue(calc.isPari(numero));
    }
    
    @ParameterizedTest
    @DisplayName("Test numeri dispari")
    @ValueSource(ints = {1, 3, 5, 7, -1, -3})
    void testNumeriDispari(int numero) {
        assertFalse(calc.isPari(numero));
    }
    
    @ParameterizedTest
    @DisplayName("Test massimo tra due numeri")
    @CsvSource({
        "5, 3, 5",
        "3, 5, 5",
        "-1, -5, -1",
        "0, 0, 0",
        "100, 99, 100"
    })
    void testMassimo(int a, int b, int atteso) {
        assertEquals(atteso, calc.massimo(a, b));
    }
    
    @Test
    @DisplayName("Test fattoriale di 0")
    void testFattorialeZero() {
        assertEquals(1, calc.fattoriale(0));
    }
    
    @Test
    @DisplayName("Test fattoriale di numeri positivi")
    void testFattorialePositivi() {
        assertEquals(1, calc.fattoriale(1));
        assertEquals(2, calc.fattoriale(2));
        assertEquals(6, calc.fattoriale(3));
        assertEquals(24, calc.fattoriale(4));
        assertEquals(120, calc.fattoriale(5));
    }
    
    @Test
    @DisplayName("Test fattoriale di numero negativo - deve lanciare eccezione")
    void testFattorialeNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.fattoriale(-1);
        });
    }
    
    @Nested
    @DisplayName("Test suite per operazioni avanzate")
    class OperazioniAvanzate {
        
        @Test
        @DisplayName("Test combinazione di operazioni")
        void testCombinazioneOperazioni() {
            int risultato = calc.somma(calc.moltiplicazione(2, 3), calc.sottrazione(10, 5));
            assertEquals(11, risultato);
        }
        
        @Test
        @DisplayName("Test con valori estremi")
        void testValoriEstremi() {
            assertEquals(Integer.MAX_VALUE, calc.massimo(Integer.MAX_VALUE, 100));
            assertEquals(Integer.MIN_VALUE, calc.massimo(Integer.MIN_VALUE, Integer.MIN_VALUE));
        }
    }
}