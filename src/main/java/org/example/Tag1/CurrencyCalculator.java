package org.example.Tag1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyCalculator extends JFrame {
    Container c;
    JLabel euroLabel;
    JTextField euroTextField, currencyTextField;
    JComboBox<String> currencyComboBox;

    public CurrencyCalculator() {
        c = getContentPane();
        c.setLayout(new GridLayout(4, 1));

        euroLabel = new JLabel("Euro");
        c.add(euroLabel);

        euroTextField = new JTextField();
        c.add(euroTextField);

        String[] currencies = {"Yen", "USD"};
        currencyComboBox = new JComboBox<>(currencies);
        c.add(currencyComboBox);

        currencyTextField = new JTextField();
        c.add(currencyTextField);

        euroTextField.addActionListener(new CurrencyChangeListener());
        euroTextField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                convertCurrency();
            }
        });
        currencyComboBox.addActionListener(new CurrencyChangeListener());
        currencyTextField.addActionListener(new ReverseCurrencyChangeListener());
    }

    class CurrencyChangeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            convertCurrency();
        }
    }

    class ReverseCurrencyChangeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            convertToEuro();
        }
    }

    private void convertCurrency() {
        try {
            double euro = Double.parseDouble(euroTextField.getText());
            double rate = currencyComboBox.getSelectedItem().equals("Yen") ? 130.0 : 1.1;
            currencyTextField.setText(String.format("%.2f", euro * rate));
        } catch (NumberFormatException ex) {
            currencyTextField.setText("");
        }
    }

    private void convertToEuro() {
        try {
            double value = Double.parseDouble(currencyTextField.getText());
            double rate = currencyComboBox.getSelectedItem().equals("Yen") ? 130.0 : 1.1;
            euroTextField.setText(String.format("%.2f", value / rate));
        } catch (NumberFormatException ex) {
            euroTextField.setText("");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new CurrencyCalculator();
        frame.setTitle("Euro Umrechner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 200);
        frame.setVisible(true);
    }
}
