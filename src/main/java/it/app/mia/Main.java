package it.app.mia;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        try {



            JFrame frame = new JFrame("Codifica il messaggio Base64");
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setLayout(null);


            JTextField Messaggio = new JTextField();
            Messaggio.setBounds(10, 10, 280, 20);


            Messaggio.setColumns(10);
            JButton Codifica = new JButton("Codifica");
            Codifica.setBounds(10, 40, 89, 23);
            frame.add(Codifica);
            frame.add(Messaggio);

            JLabel label = new JLabel(Messaggio.getText());
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            label.setFont(new java.awt.Font("Arial", 0, 14));
            label.setForeground(new java.awt.Color(0, 0, 0));
            label.setOpaque(true);


            label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            label.setBounds(10, 70, 280, 20);

            label.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    super.mouseClicked(evt);
                    StringSelection stringSelection = new StringSelection(label.getText());
                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
                    JOptionPane.showMessageDialog(null, "Messaggio copiato");
                }
            });

            frame.add(label);

            Codifica.addActionListener(e -> {
                String messaggio = Messaggio.getText();
                String encoded = Base64.getEncoder().encodeToString(messaggio.getBytes(StandardCharsets.UTF_8));
                label.setText(encoded);
            });


            frame.setVisible(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
