package org.example.functionalProgramming.dayTwo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("src/main/resources/Personensatz.txt");


        ArrayList<String> list = Hilfsklasse.readTXT(file);

        // c) list.stream().limit(15).forEach(System.out::println);

        // d) list.stream().skip(2).limit(5).forEach(System.out::println);

        // e + f)
        LinkedList<Person> realList = list.stream().skip(1).map(Hilfsklasse::ausString).collect(Collectors.toCollection(LinkedList::new));

        // g) realList.stream().filter(s -> Objects.equals(s.bundesland, "Rheinland-Pfalz")).forEach(System.out::println);

        // h)

        //double count = realList.stream().filter(s -> s.alter > 50).count();
        //System.out.println("Count für Jacky <3: " + count);

        // i)
        //realList.stream().sorted((a,b) -> a.alter.compareTo(b.alter)).forEach(s -> System.out.println(s.alter));

        // j)
        // realList.stream().filter(s -> s.name.contains("nn")).distinct().forEach(System.out::println);

        // k)
        // Double durchschnitt = realList.stream().mapToInt(s -> s.name.length()).average().getAsDouble();
        // System.out.println(durchschnitt);

        // l)
        // realList.forEach(s -> s.bundesland = s.bundesland.substring(0, 3));
        // realList.stream().limit(20).forEach(System.out::println);

        // m)
        // boolean check = realList.stream().anyMatch(s -> s.vorname.contains("aa"));
        // System.out.print(check);

        // n)
        /*
        float countWith = realList.stream().filter(s -> Objects.equals(s.anrede, "k.A.")).count();
        float AllCount = realList.size();
        System.out.println(countWith / AllCount * 100);
        */

        // o)
        /*
        float countWith = realList.stream().filter(s -> s.alter >= 18).count();
        String s = "volljährig";
        if (countWith < 2500) {
            s = "nicht " + s;
        }
        System.out.println(s);
        */

        // p)



    }
}
