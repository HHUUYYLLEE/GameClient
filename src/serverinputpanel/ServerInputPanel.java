package serverinputpanel;


import java.awt.*;
import javax.swing.*;
import javax.swing.text.AbstractDocument;

import game.Game;

public class ServerInputPanel extends JPanel{
	Game game;
	public final JTextField IPInput, portNoInput;
	
	public ServerInputPanel(Game game, int inputPanelWidth, int inputPanelHeight) {
		this.game = game;
		final JLabel IP = new JLabel("IP:");
		IP.setFont(new Font(IP.getFont().getName(),IP.getFont().getStyle(), 30));
		IP.setForeground(Color.YELLOW);
		
		final JLabel portNo = new JLabel("Port number:");
		portNo.setFont(new Font(portNo.getFont().getName(),portNo.getFont().getStyle(), 22));
		portNo.setForeground(Color.YELLOW);
		
		IPInput = new JTextField(15);
		IPInput.setFont(new Font(IPInput.getFont().getName(),Font.ITALIC, 20));
		IPInput.setHorizontalAlignment(JTextField.CENTER);
		IPInput.setForeground(Color.GREEN);
		IPInput.setBackground(Color.DARK_GRAY);
		IPInput.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//		IPInput.setOpaque(false);
		((AbstractDocument)IPInput.getDocument()).setDocumentFilter(new IPInputFilter());
		
		portNoInput = new JTextField(10);
		portNoInput.setFont(new Font(portNoInput.getFont().getName(),Font.ITALIC, 30));
		portNoInput.setHorizontalAlignment(JTextField.CENTER);
		portNoInput.setForeground(Color.GREEN);
		portNoInput.setBackground(Color.DARK_GRAY);
		portNoInput.setBorder(BorderFactory.createEmptyBorder());
//		portNoInput.setOpaque(false);
		((AbstractDocument)portNoInput.getDocument()).setDocumentFilter(new PortNumberInputFilter());
		
		
		
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(inputPanelWidth, inputPanelHeight));
//        this.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.ipadx = 10;
        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(IP, gbc);
        
        gbc.gridx = 1;
        gbc.ipadx = 200;
        gbc.ipady = 60;
        this.add(IPInput,gbc);
        
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 10;
        gbc.ipady = 10;
        this.add(portNo,gbc);
        
        gbc.gridx = 1;
        gbc.ipadx = 200;
        gbc.ipady = 60;
        this.add(portNoInput,gbc);
        
        this.setOpaque(false);
//		this.setOpaque(false);
		this.setVisible(true);
		
	}
}
