package org.example.functionalProgramming.dayOne;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Aufgabe2 {

    interface Funktion<VON,ZU> {
        ZU apply(VON s);
    }

    public static void main(String[] args) {
        // 1
        class Mensch {
            String vorname = "Timo";
            String nachname = "Sutter";
        }

        Funktion<String, Integer> f = new Funktion<>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };


        // 2
        Funktion<String,Integer> lam = (s) -> s.length();

        // 3
        Consumer<Double> print = d -> System.out.println(d);
        print.accept(Math.random());

        Consumer<Double> printDotDot = System.out::println;

        // 4
        List<String> freunde = new ArrayList<>(Arrays.asList("Timo","Brian", "Nate","Neal","Raju","Lea","Sara","Scotty"));
        freunde.replaceAll(cur -> cur.toUpperCase());








    }
}
