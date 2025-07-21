package it.app.mia;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Codifica il messaggio Base64");
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setLayout(null);

            JTextField messaggioField = new JTextField();
            messaggioField.setBounds(10, 10, 280, 20);
            frame.add(messaggioField);

            JButton codificaButton = new JButton("Codifica");
            codificaButton.setBounds(10, 40, 89, 23);
            frame.add(codificaButton);

            JLabel label = new JLabel("");
            label.setBounds(10, 70, 280, 20);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 14));
            label.setOpaque(true);
            label.setBackground(Color.WHITE);
            label.setForeground(Color.BLACK);
            label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            label.setCursor(new Cursor(Cursor.HAND_CURSOR));
            frame.add(label);

            // Listener per copiare il testo dal JLabel
            label.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    String testo = label.getText();
                    if (!testo.isEmpty()) {
                        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(testo), null);
                        JOptionPane.showMessageDialog(frame, "Messaggio copiato");
                    }
                }
            });

            // Azione di codifica del testo
            codificaButton.addActionListener(e -> {
                String testoInput = messaggioField.getText().trim();
                if (!testoInput.isEmpty()) {
                    String encoded = Base64.getEncoder().encodeToString(testoInput.getBytes(StandardCharsets.UTF_8));
                    label.setText(encoded);
                    label.setBackground(new Color(230, 255, 230)); // feedback visivo
                } else {
                    JOptionPane.showMessageDialog(frame, "Inserisci un messaggio valido");
                }
            });

            frame.setVisible(true);
        });
    }
}
