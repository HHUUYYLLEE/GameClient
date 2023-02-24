package roomSelectInputPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game.Game;

public class RoomSelectInputPanel extends JPanel{
	Game game;
	public final JTextField roomNameInput;
	public RoomSelectInputPanel(Game game, int inputPanelWidth, int inputPanelHeight) {
		this.game = game;
		final JLabel roomName = new JLabel("Roomname:");
		roomName.setFont(new Font(roomName.getFont().getName(),roomName.getFont().getStyle(), 30));
		roomName.setForeground(Color.YELLOW);
		
		roomNameInput = new JTextField(16);
		roomNameInput.setFont(new Font(roomNameInput.getFont().getName(),Font.ITALIC, 30));
		roomNameInput.setHorizontalAlignment(JTextField.CENTER);
		roomNameInput.setForeground(Color.GREEN);
		roomNameInput.setBackground(Color.DARK_GRAY);
		roomNameInput.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//		roomNameInput.setOpaque(false);

        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(inputPanelWidth, inputPanelHeight));
//        this.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.ipadx = 10;
        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(roomName, gbc);
        
        gbc.gridx = 1;
        gbc.ipadx = 200;
        gbc.ipady = 60;
        this.add(roomNameInput,gbc);
        
        this.setOpaque(false);
		this.setVisible(true);
	}
}
