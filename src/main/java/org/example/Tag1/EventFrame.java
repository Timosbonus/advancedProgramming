package org.example.Tag1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EventFrame extends JFrame {
    Container c;
    JButton b;
    public EventFrame() {
        c = getContentPane();
        c.setLayout(new FlowLayout());
        b = new JButton("Drueck mich!");
        b.addActionListener(new ButtonBearbeiter());
        c.add(b);
        c.addMouseListener(new MausBearbeiter());
    }
    class ButtonBearbeiter implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            c.setBackground(Color.black);
        }
    }
    class MausBearbeiter implements MouseListener {
        public void mousePressed(MouseEvent e) {
            c.setBackground(Color.white);
        }
        public void mouseClicked(MouseEvent e) { }
        public void mouseReleased(MouseEvent e) { }
        public void mouseEntered(MouseEvent e) { }
        public void mouseExited(MouseEvent e) { }
    }
    public static void main(String[] args) {
        EventFrame fenster = new EventFrame();
        fenster.setTitle("Black and White");
        fenster.setSize(300,130);
        fenster.setVisible(true);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
