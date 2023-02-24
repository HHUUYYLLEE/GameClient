package cards;
import java.awt.image.BufferedImage;


public class Card {
	private BufferedImage image;
	private int value;
	private String suit;
	private int suitValue;
	public boolean selected = false;
	
	public Card(int value, String suit, int suitValue) {
		this.value = value;
		this.suit = suit;
		this.suitValue = suitValue;
	}
	
	public Card(int index) {
		if(index < 13) {
			this.suit = "Hearts";
			this.suitValue = 4;
			this.value = index + 2;
		} 
		else if(index < 26) {
			this.suit = "Diamonds";
			this.suitValue = 3;
			this.value = index - 11;
		}
		else if(index < 39) {
			this.suit = "Clubs";
			this.suitValue = 2;
			this.value = index - 24;
		}
		else {
			this.suit = "Spades";
			this.suitValue = 1;
			this.value = index - 37;
		}
	}
	
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public int getValue() {
		return this.value;
	}
	public String getSuit() {
		return this.suit;
	}
	public int getSuitValue() {
		return this.suitValue;
	}
	
}