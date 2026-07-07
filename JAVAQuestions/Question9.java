/*
9.	Design a nice front-end page that take username and password and as
input and validate allow the user to be authenticated and if user
credential is ok, then print success else failure
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question9 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(230, 240, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField(15);
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(userLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(userField, gbc);

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(15);
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(passLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(passField, gbc);

        JButton loginButton = new JButton("Login");
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(loginButton, gbc);

        JLabel message = new JLabel("", SwingConstants.CENTER);
        message.setFont(new Font("Arial", Font.BOLD, 14));

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

        frame.add(panel, BorderLayout.CENTER);
        frame.add(message, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

/*
TEST CASES: 

Correct credentials → success.

Wrong credentials → failure.

Empty fields → failure.
*/

//TIME TAKEN: 40MIN
