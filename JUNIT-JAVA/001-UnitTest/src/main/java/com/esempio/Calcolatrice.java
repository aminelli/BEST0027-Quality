package com.esempio;

/**
 * Classe che implementa operazioni matematiche di base
 */
public class Calcolatrice {
    
    public int somma(int a, int b) {
        return a + b;
    }
    
    public int sottrazione(int a, int b) {
        return a - b;
    }
    
    public int moltiplicazione(int a, int b) {
        return a * b;
    }
    
    public double divisione(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisione per zero non permessa");
        }        
        return (double) a / b;
    }
    
    public boolean isPari(int numero) {
        return numero % 2 == 0;
    }
    
    public int massimo(int a, int b) {
        return Math.max(a, b);
    }
    
    public int fattoriale(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Il fattoriale non è definito per numeri negativi");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        int risultato = 1;
        for (int i = 2; i <= n; i++) {
            risultato *= i;
        }
        return risultato;
    }
}