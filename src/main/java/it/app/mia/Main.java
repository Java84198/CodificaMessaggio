package it.app.mia;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Main class that creates a GUI application to encode text to Base64
 */
public class Main {
    public static void main(String[] args) {
        // Ensure GUI is created on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            // Create and setup the main window
            JFrame frame = new JFrame("Codifica il messaggio Base64");
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null); // Center on screen
            frame.setResizable(false);
            frame.setLayout(null);

            // Create input text field
            JTextField messaggioField = new JTextField();
            messaggioField.setBounds(10, 10, 280, 20);
            frame.add(messaggioField);

            // Create encode button
            JButton codificaButton = new JButton("Codifica");
            codificaButton.setBounds(10, 40, 89, 23);
            frame.add(codificaButton);

            // Create result label
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

            // Add mouse listener to copy text from label when clicked
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

            // Add action listener to encode button
            codificaButton.addActionListener(e -> {
                String testoInput = messaggioField.getText().trim();
                if (!testoInput.isEmpty()) {
                    // Encode input text to Base64
                    String encoded = Base64.getEncoder().encodeToString(testoInput.getBytes(StandardCharsets.UTF_8));
                    label.setText(encoded);
                    label.setBackground(new Color(230, 255, 230)); // Visual feedback for success
                } else {
                    JOptionPane.showMessageDialog(frame, "Inserisci un messaggio valido");
                }
            });

            // Make the frame visible
            frame.setVisible(true);
        });
    }
}
