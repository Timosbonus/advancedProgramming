package org.example.Tag1;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Zeitangabe extends JFrame{

    Container c;

    JComboBox cb;
    JLabel datum;
    JLabel displayFormat;
    JButton b;

    final SimpleDateFormat kurz = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    final SimpleDateFormat mittel = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    final SimpleDateFormat lang = new SimpleDateFormat("EEEE, dd. MMMM yyyy HH:mm:ss");

    public Zeitangabe() {
        c = getContentPane();
        c.setLayout(new BorderLayout());

        // Dropdown menu
        String[] choices = {"Tag, Datum und Uhrzeit", "Datum und Uhrzeit mit Sekunden", "Datum mit Jahr und Uhrzeit"};
        cb = new JComboBox<>(choices);
        c.add(cb, BorderLayout.NORTH);

        // Create Panel for Datum: + formatted date
        JPanel panel = new JPanel();

        // Date show area
        datum = new JLabel("Datum und Uhrzeit:");
        panel.add(datum);

        // formatted date area


        displayFormat = new JLabel();
        getCurrentDateAsString(cb.getSelectedItem().toString());
        panel.add(displayFormat);

        c.add(panel, BorderLayout.CENTER);

        // change format button
        b = new JButton("Anzeige aktualisieren");
        b.addActionListener(new ButtonListener());
        c.add(b, BorderLayout.SOUTH);

    }
    class ButtonListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             String selectedItem = (String) cb.getSelectedItem();
             getCurrentDateAsString(selectedItem);
         }

    }

    private void getCurrentDateAsString(String selectedItem) {
        Date now = new Date();
        if (selectedItem.equals("Tag, Datum und Uhrzeit")) {
            displayFormat.setText(kurz.format(now));
        } else if (selectedItem.equals("Datum und Uhrzeit mit Sekunden")) {
            displayFormat.setText(mittel.format(now));
        } else if (selectedItem.equals("Datum mit Jahr und Uhrzeit")) {
            displayFormat.setText(lang.format(now));
        }

    }

    public static void main(String[] args) {
        Zeitangabe z = new Zeitangabe();
        z.setTitle("Zeitangabe");
        z.setSize(330, 120);
        z.setVisible(true);
        z.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
