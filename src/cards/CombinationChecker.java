package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import game.Game;

public class CombinationChecker{
	Game game;
	Card myCard, oppCard;
	public CombinationChecker(Game game) {
		this.game = game;
	}
	public boolean validToPlay(ArrayList<Card> cardSetSelected, ArrayList<Card> opponentCardSetSelected) {
		Collections.sort(cardSetSelected, new Comparator<Card>() {
			@Override
			public int compare(Card c1, Card c2) {
				if(c1.getValue() == c2.getValue()) return c2.getSuitValue() - c1.getSuitValue();
				return c1.getValue() - c2.getValue();
			}
		});
		Collections.sort(opponentCardSetSelected, new Comparator<Card>() {
			@Override
			public int compare(Card c1, Card c2) {
				if(c1.getValue() == c2.getValue()) return c2.getSuitValue() - c1.getSuitValue();
				return c1.getValue() - c2.getValue();
			}
		});
		if(opponentCardSetSelected.isEmpty()) {
			switch(cardSetSelected.size()) {
			case 0:
				return false;
			case 1:
				return true;
			case 2:
				return checkPair(cardSetSelected);
			case 3:
				if(checkStraight(cardSetSelected)) return true;
				return checkThreeOfAKind(cardSetSelected);
			case 4:
				if(checkStraight(cardSetSelected)) return true;
				return checkFourOfAKind(cardSetSelected);
			default:
				return checkStraight(cardSetSelected);
			}
		}
		
		if(!cardSetSelected.isEmpty()) {
		oppCard = opponentCardSetSelected.get(0);
		myCard = cardSetSelected.get(0);
		switch(opponentCardSetSelected.size()) {
			case 1:
				if(cardSetSelected.size() == 1)  return checkBetterCard(myCard,oppCard);
				if(cardSetSelected.size() == 4 && oppCard.getValue() == 2 && checkFourOfAKind(cardSetSelected))
					return true;
				return false;
			case 2:
				if(cardSetSelected.size() == 2) {
					
					if(checkBetterPair(cardSetSelected, opponentCardSetSelected)) return true;
				}
					if(cardSetSelected.size() == 4) {
					if(oppCard.getValue() == 2 && checkPair(opponentCardSetSelected) && 
					checkFourOfAKind(cardSetSelected)) return true;
				}
				return false;
			case 3:
				if(checkStraight(opponentCardSetSelected) && checkBetterStraight(cardSetSelected, opponentCardSetSelected)) return true;
				return checkBetterThreeOfAKind(cardSetSelected, opponentCardSetSelected);
			case 4:
				if(checkStraight(opponentCardSetSelected) && checkBetterStraight(cardSetSelected, opponentCardSetSelected)) return true;
				return checkBetterFourOfAKind(cardSetSelected, opponentCardSetSelected);
			default:
				if(checkStraight(opponentCardSetSelected) && checkBetterStraight(cardSetSelected, opponentCardSetSelected)) return true;
				return false;
		}
	}
		return false;
}
	private boolean checkPair(ArrayList<Card> cardSetSelected) {
		if(cardSetSelected.size() != 2) return false;
		Card c1 = cardSetSelected.get(0), c2 = cardSetSelected.get(1);
		if(c1.getSuitValue() > 2 && c2.getSuitValue() > 2 && c1.getValue() == c2.getValue()) return true;
		if(c1.getSuitValue() <= 2 && c2.getSuitValue() <= 2 && c1.getValue() == c2.getValue()) return true;
		return false;
	}
	private boolean checkFourOfAKind(ArrayList<Card> cardSetSelected) {
		if(cardSetSelected.size() != 4) return false;
		Card c1 = cardSetSelected.get(0), c2 = cardSetSelected.get(1), c3 = cardSetSelected.get(2), c4 = cardSetSelected.get(3);
		if(c1.getValue() != c2.getValue()) return false;
		if(c1.getValue() != c3.getValue()) return false;
		if(c1.getValue() != c4.getValue()) return false;
		int sum = c1.getSuitValue() + c2.getSuitValue() + c3.getSuitValue() + c4.getSuitValue();
		int mul = c1.getSuitValue() * c2.getSuitValue() * c3.getSuitValue() * c4.getSuitValue();
		if (sum != 10) return false;
		if (mul != 24) return false;
		return true;
	}
	private boolean checkThreeOfAKind(ArrayList<Card> cardSetSelected) {
		if(cardSetSelected.size() != 3) return false;
		Card c1 = cardSetSelected.get(0), c2 = cardSetSelected.get(1), c3 = cardSetSelected.get(2);
		if(c1.getValue() != c2.getValue()) return false;
		if(c1.getValue() != c3.getValue()) return false;
		if(c1.getSuitValue() == c2.getSuitValue()) return false;
		if(c1.getSuitValue() == c3.getSuitValue()) return false;
		if(c2.getSuitValue() == c3.getSuitValue()) return false;
		return true;
	}
	private boolean checkStraight(ArrayList<Card> cardSet) {
		if(cardSet.size() < 3) return false;
		Card card = cardSet.get(0);
		if(card.getValue() < 4 || card.getValue() > 12) return false;
		for(int i = 1; i < cardSet.size(); ++i) {
			if (card.getSuitValue() != cardSet.get(i).getSuitValue()) return false;
			if(i < cardSet.size() - 1 && cardSet.get(i).getValue() != cardSet.get(i + 1).getValue() - 1) return false;
		}
		return true;
	}
	private boolean checkBetterCard(Card c1, Card c2) {
			if(c2.getValue() != 2) {
				if((c1.getValue() > c2.getValue() && c1.getSuitValue() == c2.getSuitValue()) || c1.getValue() == 2) return true;
				return false;
			}
			if(c1.getValue() == 2 && c1.getSuitValue() > c2.getSuitValue()) return true;
			return false;
	}
	private boolean checkBetterThreeOfAKind(ArrayList<Card> cardSetSelected, ArrayList<Card> opponentCardSetSelected) {
		if(cardSetSelected.size() != 3 || opponentCardSetSelected.size() != 3) return false;
		myCard = cardSetSelected.get(0); 
		oppCard = opponentCardSetSelected.get(0);
		if(!checkThreeOfAKind(cardSetSelected) || !checkThreeOfAKind(opponentCardSetSelected)) return false;
		if(oppCard.getValue() != 2) {
			if(myCard.getValue() == 2) return true;
			if(myCard.getValue() > oppCard.getValue() &&
					myCard.getSuitValue() + cardSetSelected.get(1).getSuitValue() + cardSetSelected.get(2).getSuitValue() == oppCard.getSuitValue() + opponentCardSetSelected.get(1).getSuitValue() + opponentCardSetSelected.get(2).getSuitValue()
					&& myCard.getSuitValue() * cardSetSelected.get(1).getSuitValue() * cardSetSelected.get(2).getSuitValue() == oppCard.getSuitValue() * opponentCardSetSelected.get(1).getSuitValue() * opponentCardSetSelected.get(2).getSuitValue()
				) return true;
			return false;
		}
		return false;
		
	}
	private boolean checkBetterFourOfAKind(ArrayList<Card> cardSetSelected, ArrayList<Card> opponentCardSetSelected) {
		if(checkFourOfAKind(cardSetSelected) || checkFourOfAKind(opponentCardSetSelected)) return false;
		myCard = cardSetSelected.get(0); 
		oppCard = opponentCardSetSelected.get(0);
		if(!checkFourOfAKind(cardSetSelected) 
				|| !checkFourOfAKind(opponentCardSetSelected)) 
			return false;
		if(oppCard.getValue() != 2) 
			if(myCard.getValue() == 2 || myCard.getValue() > oppCard.getValue()) return true;
			
		return false;
		
	}
	private boolean checkBetterPair(ArrayList<Card> cardSetSelected, ArrayList<Card> opponentCardSetSelected) {
		if(!checkPair(cardSetSelected) || !checkPair(opponentCardSetSelected)) return false;
		myCard = cardSetSelected.get(0); 
		oppCard = opponentCardSetSelected.get(0);
		if(oppCard.getValue() != 2) {
			if(myCard.getValue() == 2 || myCard.getValue() > oppCard.getValue()) return true;
			return false;
		}
		if(oppCard.getSuitValue() <= 2 && myCard.getSuitValue() > 2) return true;
		return false;
		
	}
	private boolean checkBetterStraight(ArrayList<Card> cardSetSelected, ArrayList<Card> opponentCardSetSelected) {
		if(!checkStraight(cardSetSelected) || !checkStraight(opponentCardSetSelected)) return false;
		if(cardSetSelected.size() != opponentCardSetSelected.size()) return false;
		myCard = cardSetSelected.get(0);
		oppCard = opponentCardSetSelected.get(0);
		if(myCard.getValue() > opponentCardSetSelected.get(opponentCardSetSelected.size() - 1).getValue() 
				&& myCard.getSuitValue() == oppCard.getSuitValue()) return true;
		return false;
	}
}
