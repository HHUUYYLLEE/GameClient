package accountinputpanel;

import java.awt.*;

import javax.swing.*;

import game.Game;

public class AccountInputPanel extends JPanel{
	Game game;
	public final JTextField usernameInput;
	public final JPasswordField passwordInput, confirmPasswordInput;
	public final JLabel confirmPassword;
	
	public AccountInputPanel(Game game, int inputPanelWidth, int inputPanelHeight) {
		this.game = game;
		final JLabel Username = new JLabel("Username:");
		Username.setFont(new Font(Username.getFont().getName(),Username.getFont().getStyle(), 30));
		Username.setForeground(Color.YELLOW);
		
		final JLabel Password = new JLabel("Password:");
		Password.setFont(new Font(Password.getFont().getName(),Password.getFont().getStyle(), 30));
		Password.setForeground(Color.YELLOW);
		
		confirmPassword = new JLabel("Confirm password:");
		confirmPassword.setFont(new Font(confirmPassword.getFont().getName(),confirmPassword.getFont().getStyle(), 30));
		confirmPassword.setForeground(Color.YELLOW);
		
		usernameInput = new JTextField(15);
		usernameInput.setFont(new Font(usernameInput.getFont().getName(),Font.ITALIC, 30));
		usernameInput.setHorizontalAlignment(JTextField.CENTER);
		usernameInput.setForeground(Color.GREEN);
		usernameInput.setBackground(Color.DARK_GRAY);
		usernameInput.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//		usernameInput.setOpaque(false);
		
		passwordInput = new JPasswordField(15);
		passwordInput.setFont(new Font(passwordInput.getFont().getName(),Font.ITALIC, 30));
		passwordInput.setHorizontalAlignment(JTextField.CENTER);
		passwordInput.setForeground(Color.GREEN);
		passwordInput.setBackground(Color.DARK_GRAY);
		passwordInput.setBorder(BorderFactory.createEmptyBorder());
//		passwordInput.setOpaque(false);
		
		confirmPasswordInput = new JPasswordField(15);
		confirmPasswordInput.setFont(new Font(confirmPasswordInput.getFont().getName(),Font.ITALIC, 30));
		confirmPasswordInput.setHorizontalAlignment(JTextField.CENTER);
		confirmPasswordInput.setForeground(Color.GREEN);
		confirmPasswordInput.setBackground(Color.DARK_GRAY);
		confirmPasswordInput.setBorder(BorderFactory.createEmptyBorder());
		
		
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(inputPanelWidth, inputPanelHeight));
//        this.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.ipadx = 10;
        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(Username, gbc);
        
        gbc.gridx = 1;
        gbc.ipadx = 200;
        gbc.ipady = 60;
        this.add(usernameInput,gbc);
        
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 10;
        gbc.ipady = 10;
        this.add(Password,gbc);
        
        gbc.gridx = 1;
        gbc.ipadx = 200;
        gbc.ipady = 60;
        this.add(passwordInput,gbc);
        
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 10;
        gbc.ipady = 10;
        this.add(confirmPassword,gbc);
        
        gbc.gridx = 1;
        gbc.ipadx = 200;
        gbc.ipady = 60;
        this.add(confirmPasswordInput,gbc);
        
        
        
		this.setOpaque(false);
		this.setVisible(true);
		
	}
}
