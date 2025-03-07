package org.example.Tag1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColourChanger extends JFrame {
    Container c;

    JRadioButton redButton, greenButton, yellowButton;
    JPanel redPanel, greenPanel, yellowPanel;

    ButtonGroup bg;


    public ColourChanger() {
        c = getContentPane();
        c.setLayout(new GridLayout(3, 2));


        redButton = new JRadioButton("rot");
        redButton.addActionListener(new ColourChangerListener());
        redButton.setSelected(true);
        c.add(redButton);

        redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        c.add(redPanel);

        yellowButton = new JRadioButton("yellow");
        yellowButton.addActionListener(new ColourChangerListener());
        c.add(yellowButton);

        yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.black);
        c.add(yellowPanel);

        greenButton = new JRadioButton("green");
        greenButton.addActionListener(new ColourChangerListener());
        c.add(greenButton);

        greenPanel = new JPanel();
        greenPanel.setBackground(Color.black);
        c.add(greenPanel);

        bg = new ButtonGroup();
        bg.add(redButton);
        bg.add(greenButton);
        bg.add(yellowButton);

    }

    class ColourChangerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setAllBlack();
            if (redButton.isSelected()) {
                redPanel.setBackground(Color.red);
            } else if (yellowButton.isSelected()) {
                yellowPanel.setBackground(Color.yellow);
            } else if (greenButton.isSelected()) {
                greenPanel.setBackground(Color.green);
            }

        }

        private void setAllBlack() {
            redPanel.setBackground(Color.black);
            yellowPanel.setBackground(Color.black);
            greenPanel.setBackground(Color.black);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new ColourChanger();
        frame.setTitle("A");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(330, 130);
        frame.setVisible(true);
    }
}
