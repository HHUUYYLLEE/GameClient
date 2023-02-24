package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
import game.Game;
import serverinputpanel.ServerInputPanel;


public class Main {

	public static void main(String[] args) {
		final int inputPanelWidth = 1500, inputPanelHeight = 600;
		final int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 50;
		final int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		JFrame window = new JFrame();
		window.setPreferredSize(new Dimension(screenWidth, screenHeight));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setTitle("2 Player Tiến lên");
//		window.setLocationRelativeTo(null);
		
		
		
		
		MainLayer mainLayer = new MainLayer();
		mainLayer.repaint();
		
		Game game = new Game(screenWidth, screenHeight, inputPanelWidth, inputPanelHeight);
//		serverInputPanel.setVisible(false);
//		game.setOpaque(true);
		game.setBounds(0, 0, screenWidth, screenHeight);
		game.sIPanel.setBounds(0, 0, inputPanelWidth, inputPanelHeight);
		game.aIPanel.setBounds(0, 0, inputPanelWidth, inputPanelHeight);
		game.rSIPanel.setBounds(0, 0, inputPanelWidth, inputPanelHeight);
//		serverInputPanel.setOpaque(true);
		mainLayer.add(game, Integer.valueOf(0), 0);
		mainLayer.add(game.sIPanel, Integer.valueOf(0), 0);
		mainLayer.add(game.aIPanel, Integer.valueOf(0), 0);
		mainLayer.add(game.rSIPanel, Integer.valueOf(0), 0);
		

		window.add(mainLayer);
		window.pack();
		window.setVisible(true);
		
		game.setupGame();
		game.startGameThread();
		
		

	}
	
}