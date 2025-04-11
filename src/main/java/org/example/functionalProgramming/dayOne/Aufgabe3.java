package org.example.functionalProgramming.dayOne;

public class Aufgabe3 {

    interface Bedingung<String> {
        boolean trifftZuAuf(String s);
    }

    public static String erstesWort (String[] str, Bedingung<String> bedingung) {

        for (String s : str) {
            if (bedingung.trifftZuAuf(s)) {
                return s;
            }
        }
        return "";
    }
    

    public static void main(String[] args) {
        String [] woerter = {
                "Alle", "lieben", "den", "Kuchen", "der", "Oma", "Hilde", "und", "auch", "die",
                "Linsensuppe", "von", "Opa", "Hans"};

        System.out.println("1. Wort mit Anfangsbuchstabe A:");
        System.out.println(erstesWort(woerter, s -> s.startsWith("A")));

        System.out.println("1. Wort, das 'au' enthält:");
        System.out.println(erstesWort(woerter, s -> s.contains("au")));

        System.out.println("1. Wort, das auf 'suppe' endet:");
        System.out.println(erstesWort(woerter, s -> s.endsWith("suppe")));

        System.out.println("1. Wort, das aus 5 Zeichen besteht:");
        System.out.println(erstesWort(woerter, s -> s.length() == 5));



    }

}

