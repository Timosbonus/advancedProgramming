package org.example.Tag2;

import java.util.Date;
import java.util.Scanner;

public class Aufgabe16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Drücke Enter, um die Stoppuhr zu starten. Drücke erneut Enter, um sie zu stoppen.");

        ClockThread ct = new ClockThread(); // Erstelle den Thread
        scanner.nextLine(); // Warte auf erste Enter-Eingabe
        ct.start(); // Starte den Thread

        scanner.nextLine(); // Warte auf zweite Enter-Eingabe
        ct.stopClock(); // Beende den Thread

        scanner.close();
        System.out.println("Programm beendet.");
    }
}

class ClockThread extends Thread {
    private final Date startTime;
    private volatile boolean running = true; // Flag für Steuerung

    public ClockThread() {
        this.startTime = new Date();
    }

    @Override
    public void run() {
        System.out.println("Stoppuhr gestartet um: " + startTime);

        while (running) {
            try {
                Thread.sleep(1000);
                long time = (new Date().getHours());
                System.out.println(time);
            } catch (InterruptedException e) {
                Date stop;
                System.out.println("Thread wurde unterbrochen!");
                return;
            }
        }

        System.out.println("Stoppuhr gestoppt nach: " + (new Date().getTime() - startTime.getTime()) / 1000 + " Sekunden");
    }

    public void stopClock() {
        running = false; // Stoppe die Schleife
        this.interrupt(); // Falls der Thread gerade schläft, wecke ihn auf
    }
}
