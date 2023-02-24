package main;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.JLayeredPane;
import customtools.UtilityTool;

public class MainLayer extends JLayeredPane{
		private BufferedImage bg;
		UtilityTool uTool = new UtilityTool();
		public MainLayer() {
		bg = uTool.setImage("/background/bg.png", (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 50);
		}
		@Override
		protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		        g.drawImage(bg, 0, 0, null);
		}
	}

