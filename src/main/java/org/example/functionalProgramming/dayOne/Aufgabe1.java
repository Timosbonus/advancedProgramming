package org.example.functionalProgramming.dayOne;

import java.util.function.Function; // Importieren des funktionalen Interfaces Function
import java.util.function.Predicate; // Importieren des funktionalen Interfaces Function
import java.util.function.Consumer; // Importieren des funktionalen Interfaces Function



public class Aufgabe1 {

    // Eigenes Interface Addition, das Function erweitert
    interface Addition extends Function<Double, Double> {
        // Keine Notwendigkeit, apply() neu zu deklarieren, weil Function es bereits hat
    }

    interface Abfrage extends Predicate<Integer> {}

    public static void main(String[] args) {
        Consumer<String> newLine = s -> {
            System.out.println("");
            System.out.println(s);
            System.out.println();

        };


        // Aufgabe 1 a
        newLine.accept("1 a");
        Addition add = (a) -> (a * a * a + 2 * a + 100 / a);

        System.out.println("f(25) = " + add.apply(25.0));
        System.out.println("f(-25) = " + add.apply(-25.0));

        // Aufgabe 1 b
        newLine.accept("1 b");

        Abfrage abf = (a) -> {
            return a + 2 > 0;
        };

        System.out.println(abf.test(5));
        System.out.println(abf.test(-3));


        // Aufgabe 2 a
        newLine.accept("2 a");







    }
}
