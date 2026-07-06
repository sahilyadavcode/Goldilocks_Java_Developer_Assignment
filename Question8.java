import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question8 {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Login Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new BorderLayout());

        // Panel for inputs
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(230, 240, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username label + field
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField(15);
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(userLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(userField, gbc);

        // Password label + field
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(15);
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(passLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(passField, gbc);

        // Login button
        JButton loginButton = new JButton("Login");
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(loginButton, gbc);

        // Message label
        JLabel message = new JLabel("", SwingConstants.CENTER);
        message.setFont(new Font("Arial", Font.BOLD, 14));

        // Add action listener
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = userField.getText();
                String pass = new String(passField.getPassword());

                if ("admin".equals(user) && "1234".equals(pass)) {
                    message.setText("✅ Login Successful!");
                    message.setForeground(Color.GREEN.darker());
                } else {
                    message.setText("❌ Login Failed!");
                    message.setForeground(Color.RED);
                }
            }
        });

        // Add components to frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(message, BorderLayout.SOUTH);

        // Show frame
        frame.setVisible(true);
    }
}
