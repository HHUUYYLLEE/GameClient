package game;

import java.awt.*;
import java.util.*;
import javax.swing.JPanel;

import NetworkHandler.Client;
import accountinputpanel.AccountInputPanel;
import cards.*;
import roomSelectInputPanel.RoomSelectInputPanel;
import serverinputpanel.ServerInputPanel;



public class Game extends JPanel implements Runnable{
	
	
	private final int FPS = 40;
	protected final int screenWidth, screenHeight;
	private Thread gameThread;
	
	
	public String infoSent = "", infoRecv = "";
	public int messageCode;
	
	public int messageAccountState = 0;
	public final int usernameNotExist = 2, wrongPassword = 1, loggedInSomewhere = 3, databaseError = 4, success = 5;
	
	public int messageSignupState = 0;
	public final int wrongConfirmPassword = 1, usernameExisted = 2;
	
	public int messageRoomState = 0;
	public final int cannotJoin = 1, cannotCreate = 2, cannotStartGame = 3;

	protected int gameState;
	protected final int inMenuState = 0, accountState = 1, playState = 2;
	
	protected int menuState;
	protected final int menuServer = 1, menuAccount = 2, menuAccountSignup = 3, menuGuestRoom = 4,
			 mainMenu = 5, menuCreateRoom = 6, menuCreateRoomSuccess = 7, menuJoinRoomSuccess = 8;
	
	protected boolean playerTurn = false, startGame = false;
	protected int opponentHandNumber;
	
	
	
	protected Player player1 = new Player();
	public Client client = new Client(this);
	public ServerInputPanel sIPanel;
	public AccountInputPanel aIPanel;
	public RoomSelectInputPanel rSIPanel;
	protected MouseHandler mouseH = new MouseHandler(this);
	protected CombinationChecker cmbCh = new CombinationChecker(this);
	protected UI ui;
	
	protected ArrayList<Card> playerCardsPlayed = new ArrayList<Card>(), playerCardsPlayedDraw = new ArrayList<Card>(), myHandCopy = new ArrayList<Card>(),
						opponentCardsPlayed = new ArrayList<Card>(), opponentCardsPlayedDraw = new ArrayList<Card>();;
	
	
	public Game(int screenWidth, int screenHeight, int inputWidth, int inputHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		this.setOpaque(false);
		this.addMouseListener(mouseH);
		ui = new UI(this);
		sIPanel = new ServerInputPanel(this, inputWidth, inputHeight);
		aIPanel = new AccountInputPanel(this, inputWidth, inputHeight);
		rSIPanel = new RoomSelectInputPanel(this, inputWidth, inputHeight);
		gameState = inMenuState;
		menuState = mainMenu;
	}
	
	public void setupGame() {
		startGame = true;
		opponentHandNumber = 0;
		player1.Hand.clear();
		myHandCopy.clear();
		playerCardsPlayed.clear();
		playerCardsPlayedDraw.clear();
		opponentCardsPlayed.clear();
		opponentCardsPlayedDraw.clear();
		sIPanel.setEnabled(false);
		aIPanel.setEnabled(false);
		rSIPanel.setEnabled(false);
		sIPanel.setVisible(false);
		aIPanel.setVisible(false);
		rSIPanel.setVisible(false);		
	}
	public void run() {
		double drawInterval = 1000000000/FPS; // 0.0166 seconds
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		while(gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime)/drawInterval;
			lastTime = currentTime;
			if(delta >= 1) {
			// 1. Update: Update information
			update();
			// 2. Draw: Draw the screen with the updated information
			repaint();
			delta--;
			}
		}
		
}
	
	
	
	public void update() {
		
		if(gameState == inMenuState) menuState();
		
		if(gameState == playState) playState();	
			
		
}
	
	
		

	

	private void playState() {
		if(startGame == true) {
			getCardsFromServer();
			decideTurn();
			myHandCopy = new ArrayList<Card>(player1.Hand);
			startGame = false; 
			return;
		}
		
		if(playerTurn == true) {
			
			playerCardsPlayed.clear();
			playerCardsPlayedDraw.clear();
			
			
			selectCard();
			
			if(mouseH.buttonUnselectActive == true) clearSelection();
			
			if(mouseH.buttonSwapActive == true) swapping();
			
			if(mouseH.buttonPlayActive == true) playCards();
			
			if(mouseH.buttonPassActive == true) passTurn();
			
			if(mouseH.buttonLoseGameActive == true) abandonGame();
			
		}
		else OpponentPlay();
}


	private void abandonGame() {
		
		mouseH.buttonLoseGameActive = false;
	}

	private void menuState() {
		
		if(menuState == mainMenu) {
			
			if(mouseH.buttonAccountActive == true) {
				if(client.isConnected == true) {
					menuState = menuAccount;
					aIPanel.setEnabled(true);
					aIPanel.setVisible(true);
					aIPanel.confirmPassword.setEnabled(false);
					aIPanel.confirmPasswordInput.setEnabled(false);
					aIPanel.confirmPassword.setVisible(false);
					aIPanel.confirmPasswordInput.setVisible(false);
					aIPanel.usernameInput.setText("");
					aIPanel.passwordInput.setText("");
				}
				mouseH.buttonAccountActive = false;
				return;
			}
			if(mouseH.buttonCreateRoomActive == true) {
				///////In progress
				///////////////////////
				///////////////////////
				///////////////////////
				if(client.isConnected && player1.loggedIn) {
					menuState = menuCreateRoom;
					rSIPanel.setEnabled(true);
					rSIPanel.setVisible(true);
				}
				
				mouseH.buttonCreateRoomActive = false;
				return;
				///////In progress
				///////////////////////
				///////////////////////
				///////////////////////
			}
			
			if(mouseH.buttonJoinRoomActive == true) {
				///////In progress
				///////////////////////
				///////////////////////
				///////////////////////
				if(client.isConnected && player1.loggedIn) {
					menuState = menuGuestRoom;
					rSIPanel.setEnabled(true);
					rSIPanel.setVisible(true);
				}
					
				mouseH.buttonJoinRoomActive = false;
				return;
				///////In progress
				///////////////////////
				///////////////////////
				///////////////////////
			}
			
			if(mouseH.buttonQuitActive == true) {
				disconnect();
				//logout
				gameThread.interrupt();
				System.exit(0);
			}
			
			if(mouseH.serverBoxActive == true) {
				menuState = menuServer;
				sIPanel.setEnabled(true);
				sIPanel.setVisible(true);
				mouseH.serverBoxActive = false;
				return;
			}
		}
		
		if(menuState == menuServer) {
			
			if(mouseH.buttonBackActive == true) {
				menuState = mainMenu;
				sIPanel.IPInput.setText("");
				sIPanel.portNoInput.setText("");
				sIPanel.setEnabled(false);
				sIPanel.setVisible(false);
				mouseH.buttonBackActive = false;
				return;
			}
			
			if(mouseH.buttonConnectActive == true) {
				if(client.isConnected == false) {
					client.IPConnect = sIPanel.IPInput.getText();
					client.portNoConnect = Integer.parseInt(sIPanel.portNoInput.getText());
					connect();
				}
				mouseH.buttonAccountActive = false;
				return;
			}
			
			if(mouseH.buttonDisconnectActive == true) {
				if(client.isConnected == true) {
					disconnect();
					client.IPConnect = "";
					client.portNoConnect = 0;
				}
				mouseH.buttonDisconnectActive = false;
				return;
			}
		}
		
		if(menuState == menuAccount) {
			
			if(mouseH.buttonBackActive == true) {
				messageAccountState = 0;
				menuState = mainMenu;
				aIPanel.setEnabled(false);
				aIPanel.setVisible(false);
				mouseH.buttonBackActive = false;
				return;
			}
			
			if(mouseH.buttonLoginActive == true) {
					player1.loggedIn = false;
					player1.username = aIPanel.usernameInput.getText();
					player1.password = String.valueOf(aIPanel.passwordInput.getPassword());
					client.sendMessage(1, player1.username);
					client.sendMessage(2, player1.password);
					client.recvMessage();
					switch(messageCode) {
					case 0:
						switch(Integer.valueOf(infoRecv)) {
						case 1:
							//wrong pass
							messageAccountState = wrongPassword;
							break;
						case 2:
							//username not exist
							messageAccountState = usernameNotExist;
							break;
						case 3:
							//logged in somewhere
							messageAccountState = loggedInSomewhere;
							break;
						case 4:
							//database error
							messageAccountState = databaseError;
							break;
						default:
							break;
						}
						break;
					case 1:
						// success
						messageAccountState = success;
						player1.loggedIn = true;
						break;
					default:
						break;
					}
					

				mouseH.buttonLoginActive = false;
				return;
			}
			
			if(mouseH.buttonLogoutActive == true) {
				client.sendMessage(6, "07");
				player1.loggedIn = false;
				mouseH.buttonLogoutActive = false;
				return;
			}
			
			if(mouseH.buttonSignupActive == true) {
				menuState = menuAccountSignup;
				aIPanel.confirmPassword.setEnabled(true);
				aIPanel.confirmPasswordInput.setEnabled(true);
				aIPanel.confirmPassword.setVisible(true);
				aIPanel.confirmPasswordInput.setVisible(true);
				aIPanel.usernameInput.setText("");
				aIPanel.passwordInput.setText("");
				aIPanel.confirmPasswordInput.setText("");
				mouseH.buttonSignupActive = false;
				return;
			}
		}
		if(menuState == menuAccountSignup) {
			
			if(mouseH.buttonBackActive == true) {
				menuState = menuAccount;
				messageSignupState = 0;
				aIPanel.confirmPassword.setEnabled(false);
				aIPanel.confirmPasswordInput.setEnabled(false);
				aIPanel.confirmPassword.setVisible(false);
				aIPanel.confirmPasswordInput.setVisible(false);
				aIPanel.usernameInput.setText("");
				aIPanel.passwordInput.setText("");
				aIPanel.confirmPasswordInput.setText("");
				mouseH.buttonBackActive = false;
				return;
			}
			
			if(mouseH.buttonConfirmAccountActive == true) {
				player1.username = aIPanel.usernameInput.getText();
				player1.password = String.valueOf(aIPanel.passwordInput.getPassword());
				if(player1.password.equals(String.valueOf(aIPanel.confirmPasswordInput.getPassword()))) {
					client.sendMessage(5, player1.username);
					client.sendMessage(2, player1.password);
					client.recvMessage();
						if(messageCode == 0) messageSignupState = usernameExisted;
						else messageSignupState = success;
				}
				//else lỗi không đúng pass confirm
				else messageSignupState = wrongConfirmPassword;
				mouseH.buttonConfirmAccountActive = false;
				return;
			}
		}
		if(menuState == menuCreateRoom) {
			if(mouseH.buttonBackActive == true) {
				menuState = mainMenu;
				messageRoomState = 0;
				rSIPanel.setEnabled(false);
				rSIPanel.setVisible(false);
				mouseH.buttonBackActive = false;
				return;
			}
			if(mouseH.buttonConfirmCreateRoomActive == true) {
				infoSent = rSIPanel.roomNameInput.getText();
				client.sendMessage(7, infoSent);
				client.recvMessage();
				if(messageCode == 0) messageRoomState = cannotCreate;
				else {
					messageRoomState = success;
					menuState = menuCreateRoomSuccess;
				}
				mouseH.buttonConfirmCreateRoomActive = false;
				return;
			}

		}
		
		
		if(menuState == menuGuestRoom) {
			if(mouseH.buttonBackActive == true) {
				menuState = mainMenu;
				messageRoomState = 0;
				rSIPanel.setEnabled(false);
				rSIPanel.setVisible(false);
				mouseH.buttonBackActive = false;
				return;
			}
			if(mouseH.buttonConfirmJoinRoomActive == true) {
				infoSent = rSIPanel.roomNameInput.getText();
				client.sendMessage(3, infoSent);
				client.recvMessage();
				if(messageCode == 0) messageRoomState = cannotJoin;
				else {
					menuState = menuJoinRoomSuccess;
					messageRoomState = success;
				}
				mouseH.buttonConfirmJoinRoomActive = false;
				return;
			}

		}
		
		if(menuState == menuCreateRoomSuccess) {
			if(mouseH.buttonStartGameActive == true) {
				client.sendMessage(6, "03");
				client.recvMessage();
				if(messageCode == 0) messageRoomState = cannotStartGame;
				else {
					gameState = playState;
					rSIPanel.setVisible(false);
					rSIPanel.setEnabled(false);
					startGame = true;
				}
				mouseH.buttonStartGameActive = false;
				return;
			}
		}
		
		if(menuState == menuJoinRoomSuccess) {
			client.recvMessage();
			if(infoRecv.equals("04")) menuState = menuCreateRoomSuccess;
			else {
				gameState = playState;
				rSIPanel.setVisible(false);
				rSIPanel.setEnabled(false);
				startGame = true;
			}
			return;
		}
		
}

	private void connect() {
		client.connectToServer();
	}
	
	private void disconnect() {
		client.disconnectFromServer();
	}

	private void getCardsFromServer() {
			client.recvMessage();
			String[] split = infoRecv.split("(?<=\\G.{" + 2 + "})");
			for(String temp : split) player1.Hand.add(new Card(Integer.parseInt(temp)));
			Collections.sort(player1.Hand, new Comparator<Card>() {
				
				@Override
				public int compare(Card c1, Card c2) {
					if(c1.getValue() == c2.getValue()) return c2.getSuitValue() - c1.getSuitValue();
					return c1.getValue() - c2.getValue();
				}
			});
			
		
	}

	private void decideTurn() {
		for(Card card: player1.Hand) if(card.getValue() == 3 && card.getSuit().equals("Spades"))
			{
				playerTurn = true;
				client.sendMessage(6, "01");
				removeThree();
				return;
			}
			playerTurn = false;
			client.sendMessage(6, "02");
		removeThree();
}

	
	
	private void passTurn() {
		if(!opponentCardsPlayed.isEmpty()) {
		client.sendMessage(6, "06");
		// temp message
		client.sendMessage(9, "00");
		//
		playerCardsPlayed.clear();
		playerCardsPlayedDraw.clear();
		for (Card card : player1.Hand) card.selected = false;
		opponentCardsPlayedDraw.clear();
		opponentCardsPlayed.clear();
		playerTurn = false;
		mouseH.buttonPassActive = false;
		myHandCopy = new ArrayList<Card>(player1.Hand);
	}
		mouseH.buttonPassActive = false;
}

	private void playCards() {
		if(cmbCh.validToPlay(playerCardsPlayed, opponentCardsPlayed)) {
		infoSent = "";
		String cardIndexSent;
		for(Card card : playerCardsPlayed) {
			cardIndexSent = Integer.toString(ui.getCardIndex(card));
			if(cardIndexSent.length() == 1) infoSent += "0" + cardIndexSent;
			else infoSent += cardIndexSent;
		}
		client.sendMessage(4, infoSent);
		player1.Hand.removeAll(playerCardsPlayed);
		if(player1.Hand.isEmpty()) {
			//wins
			client.sendMessage(6, "05");
			setupGame();
			return;
		}
		// temp message
		else client.sendMessage(9, "00");
		//
		playerCardsPlayedDraw.clear();
		playerCardsPlayedDraw = new ArrayList<Card>(playerCardsPlayed);
		playerCardsPlayed.clear();
		for (Card card : player1.Hand) card.selected = false;
		opponentCardsPlayedDraw.clear();
		opponentCardsPlayed.clear();
		playerTurn = false;
		mouseH.buttonPlayActive = false;
		myHandCopy = new ArrayList<Card>(player1.Hand);
		}
		mouseH.buttonPlayActive = false;
	}

	private void clearSelection() {
			for (Card card : player1.Hand) card.selected = false;
			playerCardsPlayed.clear();
			mouseH.buttonUnselectActive = false;
	}

	private void selectCard() {
		int handIndex = mouseH.cardNumberClicked(player1.Hand.size(), mouseH.posClickedX, mouseH.posClickedY) - 1;
		if(handIndex >= 0 && handIndex < player1.Hand.size()) {
			if(player1.Hand.get(handIndex).selected == false) {
				player1.Hand.get(handIndex).selected = true;
				playerCardsPlayed.add(player1.Hand.get(handIndex));
			}
			else {
				player1.Hand.get(handIndex).selected = false;
				playerCardsPlayed.removeIf(c -> (c.getValue() == player1.Hand.get(handIndex).getValue() && c.getSuitValue() == player1.Hand.get(handIndex).getSuitValue()));
				
			}
			mouseH.posClickedX = 0;
			mouseH.posClickedY = 0;
		}
	}
	
	private void removeThree() {
		int size = player1.Hand.size();
		player1.Hand.removeIf(card -> (card.getValue() == 3));
		opponentHandNumber = size * 2 - 4 - player1.Hand.size();
	}
	
	private void swapping() {
		int indexSwap1 = 99, indexSwap2 = 99;
		if(playerCardsPlayed.size() == 2) {
			for (Card card : player1.Hand) {
			if(card.selected == true && indexSwap1 == 99) {
				indexSwap1 = player1.Hand.indexOf(card);
				continue;
			}
			if(card.selected == true) indexSwap2 = player1.Hand.indexOf(card);
		}
		Collections.swap(player1.Hand, indexSwap1, indexSwap2);
		myHandCopy = new ArrayList<Card>(player1.Hand);
		}
		mouseH.buttonSwapActive = false;
	}
	
	private void OpponentPlay() {
		opponentCardsPlayed.clear();
		opponentCardsPlayedDraw.clear();
		client.recvMessage();
			 if(messageCode == 4){
				String[] split = infoRecv.split("(?<=\\G.{" + 2 + "})");
				for(String temp : split) opponentCardsPlayed.add(new Card(Integer.parseInt(temp)));
				Collections.sort(opponentCardsPlayed, new Comparator<Card>() {
					@Override
					public int compare(Card c1, Card c2) {
						if(c1.getValue() == c2.getValue()) return c2.getSuitValue() - c1.getSuitValue();
						return c1.getValue() - c2.getValue();
					}
				});
				opponentHandNumber -= opponentCardsPlayed.size();
				opponentCardsPlayedDraw = new ArrayList<Card>(opponentCardsPlayed);
				
			}
			 playerTurn = true;
			 //check if opponent wins
			client.recvMessage();
			if(infoRecv.equals("00")) {
				setupGame();
				return;
			}
			
			//check if opponent quits
			client.recvMessage();
			if(infoRecv.equals("06")) {
				gameState = menuCreateRoomSuccess;
				return;
			}
}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		ui.draw(g2);
		g2.dispose();
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}


}
