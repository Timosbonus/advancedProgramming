package org.example.Tag1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    Container c;

    JButton addition, subtraction, multiplication, division, deletion;
    JTextField first, second;
    JLabel operand, equalSign, result;

    public Calculator() {
        c = getContentPane();
        c.setLayout(new GridLayout(2, 5));

        first = new JTextField("");
        c.add(first);

        operand = new JLabel("+");
        operand.setHorizontalAlignment(SwingConstants.CENTER);
        operand.setHorizontalTextPosition(SwingConstants.CENTER);
        operand.setFont(new Font("Arial", Font.PLAIN, 20));
        c.add(operand);

        second = new JTextField("");
        c.add(second);

        equalSign = new JLabel("=");
        equalSign.setHorizontalAlignment(SwingConstants.CENTER);
        equalSign.setHorizontalTextPosition(SwingConstants.CENTER);
        equalSign.setFont(new Font("Arial", Font.PLAIN, 20));
        c.add(equalSign);

        result = new JLabel("");
        c.add(result);

        addition = new JButton("Addiere");
        addition.addActionListener(new CalculationListener());
        c.add(addition);

        subtraction = new JButton("Subtrahiere");
        subtraction.addActionListener(new CalculationListener());
        c.add(subtraction);

        multiplication = new JButton("Multiplikation");
        multiplication.addActionListener(new CalculationListener());
        c.add(multiplication);

        division = new JButton("Division");
        division.addActionListener(new CalculationListener());
        c.add(division);

        deletion = new JButton("Löschen");
        deletion.addActionListener(new CalculationListener());
        c.add(deletion);
    }

    class CalculationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double a = Double.parseDouble(first.getText());
            double b = Double.parseDouble(second.getText());
            if (e.getSource() == addition) {
                double res = a + b;
                result.setText("" + res);
                operand.setText("+");
            } else if (e.getSource() == subtraction) {
                double res = a - b;
                result.setText("" + res);
                operand.setText("-");
            } else if (e.getSource() == multiplication) {
                double res = a * b;
                result.setText("" + res);
                operand.setText("*");
            } else if (e.getSource() == division) {
                double res = a / b;
                result.setText("" + res);
                operand.setText("/");
            } else if (e.getSource() == deletion) {
                operand.setText("+");
                first.setText("");
                second.setText("");
                result.setText("");
            }
        }

    }

    public static void main(String[] args) {
        JFrame frame = new Calculator();
        frame.setTitle("Rechner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 130);
        frame.setVisible(true);
    }

}
