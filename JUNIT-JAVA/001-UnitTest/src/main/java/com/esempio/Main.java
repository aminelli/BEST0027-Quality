package com.esempio;

import java.util.Scanner;

/**
 * Classe principale dell'applicazione console
 */
public class Main {
    
    public static void main(String[] args) {
        Calcolatrice calc = new Calcolatrice();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== CALCOLATRICE ===");
        System.out.println("1. Somma");
        System.out.println("2. Sottrazione");
        System.out.println("3. Moltiplicazione");
        System.out.println("4. Divisione");
        System.out.println("5. Verifica numero pari");
        System.out.println("6. Massimo tra due numeri");
        System.out.println("7. Fattoriale");
        System.out.println("0. Esci");
        
        while (true) {
            System.out.print("\nScegli un'operazione: ");
            int scelta = scanner.nextInt();
            
            if (scelta == 0) {
                System.out.println("Arrivederci!");
                break;
            }
            
            try {
                switch (scelta) {
                    case 1, 2, 3, 4, 6 -> {
                        System.out.print("Inserisci primo numero: ");
                        int a = scanner.nextInt();
                        System.out.print("Inserisci secondo numero: ");
                        int b = scanner.nextInt();
                        
                        switch (scelta) {
                            case 1 -> System.out.println("Risultato: " + calc.somma(a, b));
                            case 2 -> System.out.println("Risultato: " + calc.sottrazione(a, b));
                            case 3 -> System.out.println("Risultato: " + calc.moltiplicazione(a, b));
                            case 4 -> System.out.println("Risultato: " + calc.divisione(a, b));
                            case 6 -> System.out.println("Massimo: " + calc.massimo(a, b));
                        }
                    }
                    case 5 -> {
                        System.out.print("Inserisci numero: ");
                        int num = scanner.nextInt();
                        System.out.println(num + " è " + (calc.isPari(num) ? "pari" : "dispari"));
                    }
                    case 7 -> {
                        System.out.print("Inserisci numero: ");
                        int n = scanner.nextInt();
                        System.out.println("Fattoriale: " + calc.fattoriale(n));
                    }
                    default -> System.out.println("Operazione non valida!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
}