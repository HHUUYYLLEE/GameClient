package game;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


import cards.Card;
import customtools.UtilityTool;


public class UI {
	private Game game;
	private Font DMSerif, Exo;
	protected final int cardScaleX = 100, cardScaleY = 145;
	protected final int cardDist = 25;
	protected int firstHandCardPosX = 0;
	protected final int firstHandCardPosY = 550;
	
	private int firstFieldCardPosX;
	private final int myFieldCardPosY = 360, opponentFieldCardPosY = 190;
	
	private int opponentFirstHandCardPosX = 0;
	private final int opponentFirstHandCardPosY = 20;
	
	protected final int selectedCardHigher = 80;
	
	
	
	protected final int buttonWidth = 210, buttonHeight = 98;
	
	
	//main menu buttons
	protected final int buttonAccountX, buttonAccountY = 110,
						buttonJoinRoomMenuX, buttonJoinRoomMenuY = 310,
						buttonCreateRoomMenuX, buttonCreateRoomMenuY = 210,
						buttonQuitX, buttonQuitY = 410,
						serverBoxX, serverBoxY = 550, serverBoxSizeX, serverBoxSizeY = 184,
						serverBoxOffsetLeft = 70, serverBoxOffsetTop = 70,
						serverBoxOffsetRight = 30, serverBoxOffsetBottom = 40,
						serverConnectedX, serverConnectedY = 580,
						serverNotConnectedX, serverNotConnectedY = 580;

	////room select buttons
	protected final int buttonJoinRoomX, buttonJoinRoomY = 310,
						buttonCreateRoomX, buttonCreateRoomY = 210,
						buttonBackRoomSelectX, buttonBackRoomSelectY = 400,
						buttonConfirmCreateRoomX, buttonConfirmCreateRoomY = 510,
						buttonConfirmJoinRoomX, buttonConfirmJoinRoomY = 510,
						buttonBackRoomX, buttonBackRoomY = 510,
						buttonStartGameX, buttonStartGameY = 510;
	
	
	//menu account buttons
	protected final int buttonLoginX, buttonLoginY = 600,
						buttonLogoutX, buttonLogoutY = 410,
						buttonSignupX, buttonSignupY = 610,
						buttonBackAccountX, buttonBackAccountY = 510;
	
	//menu account signup buttons
	protected final int buttonConfirmAccountX, buttonConfirmAccountY = 510,
						buttonBackSignupX, buttonBackSignupY = 650;
	
	//menu server buttons
	protected final int buttonConnectX, buttonConnectY = 450,
						buttonDisconnectX, buttonDisconnectY = 450,
						buttonBackServerX, buttonBackServerY = 600;
	
	//game buttons
	protected final int buttonPlayX, buttonPlayY = 210, 
					 buttonUnselectX, buttonUnselectY = 310, 
					 buttonSwapX, buttonSwapY = 410, 
					 buttonPassX, buttonPassY = 510,
					 buttonLoseGameX, buttonLoseGameY = 410,
					 buttonLeaveRoomX, buttonLeaveRoomY = 510;

	

	
	private BufferedImage
	back, backPressed,
	swap, swapNo, swapPressed, 
	play, playNo, playPressed, 
	pass, passNo, passPressed, 
	unselect, unselectNo, unselectPressed,
	loseGame, loseGameNo, loseGamePressed,
	leaveRoom, leaveRoomNo, leaveRoomPressed,
	account, accountNo, accountPressed,
	joinRoom, joinRoomNo, joinRoomPressed,
	createRoom, createRoomNo, createRoomPressed,
	quit, quitPressed,
	login, loginNo, loginPressed,
	logout, logoutNo, logoutPressed,
	signup, signupNo, signupPressed,
	confirmAccount, confirmAccountPressed,
	connect, connectNo, connectPressed,
	disconnect, disconnectNo, disconnectPressed,
	startGame, startGamePressed,
	
	serverBox, serverConnected, serverNotConnected;
	
	private Card[] cards = new Card[53];
	UtilityTool uTool = new UtilityTool();
	
	public UI(Game game) {
		this.game = game;
		//main menu buttons
		buttonAccountX = 600;
		buttonJoinRoomMenuX = 600;
		buttonCreateRoomMenuX = 600;
		buttonQuitX = 600;
		serverBoxX = 500;
		serverBoxSizeX = 360;
		serverConnectedX = 420;
		serverNotConnectedX = 420;

		////room select buttons
		buttonCreateRoomX = 100;
		buttonJoinRoomX = 100;
		buttonBackRoomSelectX = 100;
		buttonConfirmCreateRoomX = 410;
		buttonConfirmJoinRoomX = 410;
		buttonBackRoomX = 600;
		buttonStartGameX = 410;
		
		//menu account buttons
		buttonLoginX = 400;
		buttonLogoutX = 350;
		buttonSignupX = 610;
		buttonBackAccountX = 350;
		
		//menu account signup buttons
		buttonConfirmAccountX = 410;
		buttonBackSignupX = 410;
		
		//menu server buttons
		buttonConnectX = 500;
		buttonDisconnectX = 750;
		buttonBackServerX = 625;
		
		//game buttons
		buttonPlayX = 1140;
		buttonUnselectX = 1140;
		buttonSwapX = 1140;
		buttonPassX = 1140;
		buttonLoseGameX = 100;
		buttonLeaveRoomX = 100;
		setupCardImage();
		setupButtons();
		setupMisc();
	}
	
	private void setupCardImage() {
		setupCard(0, 2, "Hearts", 4, "2_of_hearts");
		setupCard(1, 3, "Hearts", 4, "3_of_hearts");
		setupCard(2, 4, "Hearts", 4, "4_of_hearts");
		setupCard(3, 5, "Hearts", 4, "5_of_hearts");
		setupCard(4, 6, "Hearts", 4, "6_of_hearts");
		setupCard(5, 7, "Hearts", 4, "7_of_hearts");
		setupCard(6, 8, "Hearts", 4, "8_of_hearts");
		setupCard(7, 9, "Hearts", 4, "9_of_hearts");
		setupCard(8, 10, "Hearts", 4, "10_of_hearts");
		setupCard(9, 11, "Hearts", 4, "jack_of_hearts");
		setupCard(10, 12, "Hearts", 4, "queen_of_hearts");
		setupCard(11, 13, "Hearts", 4, "king_of_hearts");
		setupCard(12, 14, "Hearts", 4, "ace_of_hearts");
		setupCard(13, 2, "Diamonds", 3, "2_of_diamonds");
		setupCard(14, 3, "Diamonds", 3, "3_of_diamonds");
		setupCard(15, 4, "Diamonds", 3, "4_of_diamonds");
		setupCard(16, 5, "Diamonds", 3, "5_of_diamonds");
		setupCard(17, 6, "Diamonds", 3, "6_of_diamonds");
		setupCard(18, 7, "Diamonds", 3, "7_of_diamonds");
		setupCard(19, 8, "Diamonds", 3, "8_of_diamonds");
		setupCard(20, 9, "Diamonds", 3, "9_of_diamonds");
		setupCard(21, 10, "Diamonds", 3, "10_of_diamonds");
		setupCard(22, 11, "Diamonds", 3, "jack_of_diamonds");
		setupCard(23, 12, "Diamonds", 3, "queen_of_diamonds");
		setupCard(24, 13, "Diamonds", 3, "king_of_diamonds");
		setupCard(25, 14, "Diamonds", 3, "ace_of_diamonds");
		setupCard(26, 2, "Clubs", 2, "2_of_clubs");
		setupCard(27, 3, "Clubs", 2, "3_of_clubs");
		setupCard(28, 4, "Clubs", 2, "4_of_clubs");
		setupCard(29, 5, "Clubs", 2, "5_of_clubs");
		setupCard(30, 6, "Clubs", 2, "6_of_clubs");
		setupCard(31, 7, "Clubs", 2, "7_of_clubs");
		setupCard(32, 8, "Clubs", 2, "8_of_clubs");
		setupCard(33, 9, "Clubs", 2, "9_of_clubs");
		setupCard(34, 10, "Clubs", 2, "10_of_clubs");
		setupCard(35, 11, "Clubs", 2, "jack_of_clubs");
		setupCard(36, 12, "Clubs", 2, "queen_of_clubs");
		setupCard(37, 13, "Clubs", 2, "king_of_clubs");
		setupCard(38, 14, "Clubs", 2, "ace_of_clubs");
		setupCard(39, 2, "Spades", 1, "2_of_spades");
		setupCard(40, 3, "Spades", 1, "3_of_spades");
		setupCard(41, 4, "Spades", 1, "4_of_spades");
		setupCard(42, 5, "Spades", 1, "5_of_spades");
		setupCard(43, 6, "Spades", 1, "6_of_spades");
		setupCard(44, 7, "Spades", 1, "7_of_spades");
		setupCard(45, 8, "Spades", 1, "8_of_spades");
		setupCard(46, 9, "Spades", 1, "9_of_spades");
		setupCard(47, 10, "Spades", 1, "10_of_spades");
		setupCard(48, 11, "Spades", 1, "jack_of_spades");
		setupCard(49, 12, "Spades", 1, "queen_of_spades");
		setupCard(50, 13, "Spades", 1, "king_of_spades");
		setupCard(51, 14, "Spades", 1, "ace_of_spades");
		setupCard(52, 0, "None", 0 , "cover");
	}
	

	
	private void setupButtons() {
		back = button("Back"); backPressed = button("BackPressed");
		swap = button("Swap"); swapNo = button("SwapNo"); swapPressed = button("SwapPressed");
		pass = button("Pass"); passNo = button("PassNo"); passPressed = button("PassPressed");
		play = button("Play"); playNo = button("PlayNo"); playPressed = button("PlayPressed");
		unselect = button("Unselect"); unselectNo = button("UnselectNo"); unselectPressed = button("UnselectPressed");
		loseGame = button("LoseGame"); loseGameNo = button("LoseGameNo"); loseGamePressed = button("LoseGamePressed");
		leaveRoom = button("LeaveRoom"); leaveRoomNo = button("LeaveRoomNo"); leaveRoomPressed = button("LeaveRoomPressed");
		account = button("Account"); accountNo = button("AccountNo"); accountPressed = button("AccountPressed");
		joinRoom = button("JoinRoom"); joinRoomNo = button("JoinRoomNo"); joinRoomPressed = button("JoinRoomPressed");
		createRoom = button("CreateRoom"); createRoomNo = button("CreateRoomNo"); createRoomPressed = button("CreateRoomPressed");
		quit = button("Quit"); quitPressed = button("QuitPressed");
		login = button("Login"); loginNo = button("LoginNo"); loginPressed = button("LoginPressed");
		logout = button("Logout"); logoutNo = button("LogoutNo"); logoutPressed = button("LogoutPressed");
		signup = button("Signup"); signupNo = button("SignupNo"); signupPressed = button("SignupPressed");
		connect = button("Connect"); connectNo = button("ConnectNo"); connectPressed = button("ConnectPressed");
		disconnect = button("Disconnect"); disconnectNo = button("DisconnectNo"); disconnectPressed = button("DisconnectPressed");
		startGame = button("StartGame"); startGamePressed = button("StartGamePressed");
		confirmAccount = button("ConfirmAccount"); confirmAccountPressed = button("ConfirmAccountPressed");
	}
	
	private void setupMisc() {
		try {
			InputStream is = getClass().getResourceAsStream("/font/DMSerifDisplay-Italic.ttf");
			DMSerif = Font.createFont(Font.TRUETYPE_FONT, is);
			is = getClass().getResourceAsStream("/font/Exo-ExtraBold.ttf");
			Exo = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		serverBox = setupMiscImg("ServerBox", serverBoxSizeX, serverBoxSizeY);
		serverConnected = setupMiscImg("ServerConnected", 60, 60);
		serverNotConnected = setupMiscImg("ServerNotConnected", 60, 60);
	}
	
	protected void draw(Graphics2D g2) {
		drawButtons(g2);
		drawMyHand(g2);
		drawOpponentHand(g2, game.opponentHandNumber);
		drawCardsPlayed(g2, game.playerCardsPlayedDraw, game.opponentCardsPlayedDraw);
	}

	

	public int getCardIndex(Card card) {
		switch(card.getSuit()) {
		case "Hearts":
			return card.getValue() - 2;
		case "Diamonds":
			return card.getValue() + 11;
		case "Clubs":
			return card.getValue() + 24;
		case "Spades":
			return card.getValue() + 37;
		default:
			return 99;
		}
		
	}
	

	
	private void drawButtons(Graphics2D g2) {
		
		if(game.gameState == game.inMenuState) {
			if(game.menuState == game.mainMenu) {
				
				
				if(game.client.isConnected == true) {
					if(game.mouseH.buttonAccountPressed == true) g2.drawImage(accountPressed, buttonAccountX, buttonAccountY, null);
					else g2.drawImage(account, buttonAccountX, buttonAccountY, null);
				}
				else {
					g2.drawImage(accountNo, buttonAccountX, buttonAccountY, null);
				}
				
				
				if(game.player1.loggedIn == true){
					if(game.mouseH.buttonCreateRoomPressed == true) g2.drawImage(createRoomPressed, buttonCreateRoomMenuX, buttonCreateRoomMenuY, null);
					else g2.drawImage(createRoom, buttonCreateRoomMenuX, buttonCreateRoomMenuY, null);
						
					if(game.mouseH.buttonJoinRoomPressed == true) g2.drawImage(joinRoomPressed, buttonJoinRoomMenuX, buttonJoinRoomMenuY, null);
					else g2.drawImage(joinRoom, buttonJoinRoomMenuX, buttonJoinRoomMenuY, null);
				}
				else {
				g2.drawImage(createRoomNo, buttonCreateRoomMenuX, buttonCreateRoomMenuY, null);					
				g2.drawImage(joinRoomNo, buttonJoinRoomMenuX, buttonJoinRoomMenuY, null);
				}
				
				if(game.mouseH.buttonQuitPressed == true) g2.drawImage(quitPressed, buttonQuitX, buttonQuitY, null);
				else g2.drawImage(quit, buttonQuitX, buttonQuitY, null);
				
				
				g2.drawImage(serverBox, serverBoxX, serverBoxY, null);
				
				if(game.client.isConnected == false) {
					g2.setColor(Color.CYAN);
					g2.setFont(DMSerif);
					g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
					g2.drawString("Server", serverBoxX + 120, serverBoxY + 60);
					g2.setColor(Color.WHITE);
					g2.setFont(Exo);
					g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 30F));
					g2.drawString("Chưa kết nối", serverBoxX + 116, serverBoxY + 120);
					g2.drawImage(serverNotConnected, serverBoxX + 25, serverBoxY + 40, null);
				} else {
					g2.drawString("IP: " + game.client.IPConnect + "  portNo: " + Integer.toString(game.client.portNoConnect), serverBoxX + 50, serverBoxY + 20);
					g2.drawImage(serverConnected, serverBoxX + 25, serverBoxY + 40, null);
				}
				
				
			}
			if(game.menuState == game.menuServer) {
				
				if(game.mouseH.buttonBackPressed == true) g2.drawImage(backPressed, buttonBackServerX, buttonBackServerY, null);
				else g2.drawImage(back, buttonBackServerX, buttonBackServerY, null);
				
				if(game.client.isConnected == true) {
					
				g2.drawImage(connectNo, buttonConnectX, buttonConnectY, null);
				
				if(game.mouseH.buttonDisconnectPressed == true) g2.drawImage(disconnectPressed, buttonDisconnectX, buttonDisconnectY, null);
				else g2.drawImage(disconnect, buttonDisconnectX, buttonDisconnectY, null);
				
				} else {
					
					if(game.mouseH.buttonConnectPressed == true) g2.drawImage(connectPressed, buttonConnectX, buttonConnectY, null);
					else g2.drawImage(connect, buttonConnectX, buttonConnectY, null);
					
					g2.drawImage(disconnectNo, buttonDisconnectX, buttonDisconnectY, null);
				}
			}
			if(game.menuState == game.menuAccount) {
				
				if(game.mouseH.buttonBackPressed == true) g2.drawImage(backPressed, buttonBackAccountX, buttonBackAccountY, null);
				else g2.drawImage(back, buttonBackAccountX, buttonBackAccountY, null);
				
				if(game.player1.loggedIn == false) {
					if(game.mouseH.buttonLoginPressed == true) g2.drawImage(loginPressed, buttonLoginX, buttonLoginY, null);
					else g2.drawImage(login, buttonLoginX, buttonLoginY, null);
					
					g2.drawImage(logoutNo, buttonLogoutX, buttonLogoutY, null);
				}
				else {
					
					if(game.mouseH.buttonLogoutPressed == true) g2.drawImage(logoutPressed, buttonLogoutX, buttonLogoutY, null);
					else g2.drawImage(logout, buttonLogoutX, buttonLogoutY, null);
					
					g2.drawImage(loginNo, buttonLoginX, buttonLoginY, null);
				}
				
				if(game.mouseH.buttonSignupPressed == true) g2.drawImage(signupPressed, buttonSignupX, buttonSignupY, null);
				else g2.drawImage(signup, buttonSignupX, buttonSignupY, null);
				
				switch(game.messageAccountState) {
				case 1:
					//wrong pass
					g2.setColor(Color.blue);
					g2.setFont(DMSerif);
					g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
					g2.drawString("Wrong Password", 500, 700);
					break;
				case 2:
					//username doesn't exist
					g2.setColor(Color.blue);
					g2.setFont(DMSerif);
					g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
					g2.drawString("Username doesn't exist", 500, 700);
					break;
				case 3:
					//logged in somewhere
					g2.setColor(Color.blue);
					g2.setFont(DMSerif);
					g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
					g2.drawString("Logged in somewhere", 500, 700);
					break;
				case 4:
					//username doesn't exist
					g2.setColor(Color.blue);
					g2.setFont(DMSerif);
					g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
					g2.drawString("Database error", 500, 700);
					break;
				case 5:
					//Success
					g2.setColor(Color.green);
					g2.setFont(DMSerif);
					g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
					g2.drawString("Success", 500, 700);
					break;
					
				}
				
			}
			
			if(game.menuState == game.menuAccountSignup) {
				
				if(game.mouseH.buttonBackPressed == true) g2.drawImage(backPressed, buttonBackSignupX, buttonBackSignupY, null);
				else g2.drawImage(back, buttonBackSignupX, buttonBackSignupY, null);
				
				if(game.mouseH.buttonConfirmAccountPressed == true) g2.drawImage(confirmAccountPressed, buttonConfirmAccountX, buttonConfirmAccountY, null);
				else g2.drawImage(confirmAccount, buttonConfirmAccountX, buttonConfirmAccountY, null);
				
				switch(game.messageSignupState) {
				case 1:
					//wrong confirm pass
					g2.setColor(Color.blue);
					g2.setFont(DMSerif);
					g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
					g2.drawString("Wrong Confirm Password", 500, 700);
					break;
				case 2:
					//username existed
					g2.setColor(Color.blue);
					g2.setFont(DMSerif);
					g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
					g2.drawString("Wrong Confirm Password", 500, 700);
					break;
				case 5:
					//success
					g2.setColor(Color.green);
					g2.setFont(DMSerif);
					g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
					g2.drawString("Success", 500, 700);
					break;
				}
			}
			
			if(game.menuState == game.menuCreateRoom) {
				if(game.mouseH.buttonBackPressed == true) g2.drawImage(backPressed, buttonBackRoomX, buttonBackRoomY, null);
				else g2.drawImage(back, buttonBackRoomX, buttonBackRoomY, null);
				
				if(game.mouseH.buttonConfirmCreateRoomPressed == true) g2.drawImage(confirmAccountPressed, buttonConfirmCreateRoomX, buttonConfirmCreateRoomY, null);
				else g2.drawImage(confirmAccount, buttonConfirmCreateRoomX, buttonConfirmCreateRoomY, null);
				
				if(game.messageRoomState == game.cannotCreate) {
					//cannot create
					g2.setColor(Color.blue);
					g2.setFont(DMSerif);
					g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
					g2.drawString("Cannot create room", 500, 700);
				}
			}
			
			if(game.menuState == game.menuGuestRoom) {
				if(game.mouseH.buttonBackPressed == true) g2.drawImage(backPressed, buttonBackRoomX, buttonBackRoomY, null);
				else g2.drawImage(back, buttonBackRoomX, buttonBackRoomY, null);
				
				if(game.mouseH.buttonConfirmJoinRoomPressed == true) g2.drawImage(confirmAccountPressed, buttonConfirmJoinRoomX, buttonConfirmJoinRoomY, null);
				else g2.drawImage(confirmAccount, buttonConfirmJoinRoomX, buttonConfirmJoinRoomY, null);
				
				if(game.messageRoomState == game.cannotJoin) {
					//cannot create
					g2.setColor(Color.blue);
					g2.setFont(DMSerif);
					g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
					g2.drawString("Cannot join room", 500, 700);
				}
			}
			
			if(game.menuState == game.menuCreateRoomSuccess) {
				if(game.mouseH.buttonStartGamePressed == true) g2.drawImage(startGamePressed, buttonStartGameX, buttonStartGameY, null);
				else g2.drawImage(startGame, buttonStartGameX, buttonStartGameY, null);
				g2.setColor(Color.green);
				g2.setFont(DMSerif);
				g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
				g2.drawString("Success", 500, 700);
			}
			
			if(game.menuState == game.menuJoinRoomSuccess) {
				g2.setColor(Color.green);
				g2.setFont(DMSerif);
				g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
				g2.drawString("Success", 500, 700);
			}
		}
		
		
		
		if(game.gameState == game.playState) {
		if(game.playerTurn == true) {
			
		if(game.playerCardsPlayed.size() >= 1 && game.cmbCh.validToPlay(game.playerCardsPlayed, game.opponentCardsPlayed)) {
			if(game.mouseH.buttonPlayPressed == true) g2.drawImage(playPressed, buttonPlayX, buttonPlayY, null);
			else g2.drawImage(play, buttonPlayX, buttonPlayY, null);
		}
		else g2.drawImage(playNo, buttonPlayX, buttonPlayY, null);
		
		
		
		if(game.playerCardsPlayed.size() >= 1) {
			if(game.mouseH.buttonUnselectPressed == true) g2.drawImage(unselectPressed, buttonUnselectX, buttonUnselectY, null);
		else g2.drawImage(unselect, buttonUnselectX, buttonUnselectY, null);
		}
		else g2.drawImage(unselectNo, buttonUnselectX, buttonUnselectY, null);
		
		
		
		if(game.playerCardsPlayed.size() == 2) {
			if(game.mouseH.buttonSwapPressed == true) g2.drawImage(swapPressed, buttonSwapX, buttonSwapY, null);
		else g2.drawImage(swap, buttonSwapX, buttonSwapY, null);
		}
		else g2.drawImage(swapNo, buttonSwapX, buttonSwapY, null);
		
	
		
		if(game.playerTurn == true && !game.opponentCardsPlayed.isEmpty()) {
			if(game.mouseH.buttonPassPressed == true) g2.drawImage(passPressed, buttonPassX, buttonPassY, null);
			else g2.drawImage(pass, buttonPassX, buttonPassY, null);
		}
		else g2.drawImage(passNo, buttonPassX, buttonPassY, null);
		
		if(game.mouseH.buttonLoseGamePressed == true) g2.drawImage(loseGamePressed, buttonLoseGameX, buttonLoseGameY, null);
		else g2.drawImage(loseGame, buttonLoseGameX, buttonLoseGameY, null);
			
		if(game.mouseH.buttonLeaveRoomPressed == true) g2.drawImage(leaveRoomPressed, buttonLeaveRoomX, buttonLeaveRoomY, null);
		else g2.drawImage(leaveRoom, buttonLeaveRoomX, buttonLeaveRoomY, null);
		
		g2.setColor(Color.green);
		g2.setFont(DMSerif);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
		g2.drawString("Turn to play", 500, 750);
		
		}
		else {
			
			g2.drawImage(playNo, buttonPlayX, buttonPlayY, null);
			
			g2.drawImage(unselectNo, buttonUnselectX, buttonUnselectY, null);
			
			g2.drawImage(swapNo, buttonSwapX, buttonSwapY, null);
			
			g2.drawImage(passNo, buttonPassX, buttonPassY, null);
		}
			
		}
	}
	
	private void drawMyHand(Graphics2D g2) {
		if(game.gameState == game.playState) {
		int i = 0;
		firstHandCardPosX = (game.screenWidth - cardDist * (game.myHandCopy.size() - 3) - cardScaleX) / 2;
		for(Card card : game.myHandCopy) {
			if(card.selected == false) g2.drawImage(cards[getCardIndex(card)].getImage(), firstHandCardPosX + i, firstHandCardPosY, null);
			else g2.drawImage(cards[getCardIndex(card)].getImage(), firstHandCardPosX + i, firstHandCardPosY - selectedCardHigher, null);
			i += cardDist;
		}
		}
	}
	
	private void drawOpponentHand(Graphics2D g2, int handNumber) {
		if(game.gameState == game.playState) {
		int i;
		opponentFirstHandCardPosX = (game.screenWidth - cardDist * (handNumber - 3) - cardScaleX) / 2;
		for (i = 0; i < handNumber; ++i) 
			g2.drawImage(cards[52].getImage(), opponentFirstHandCardPosX + i * cardDist, opponentFirstHandCardPosY, null);
		}
	}
	
	private void drawCardsPlayed(Graphics2D g2, ArrayList<Card> myFieldCards, ArrayList<Card> opponentFieldCards) {
		if(game.gameState == game.playState) {
		int i = 0;
		if(!myFieldCards.isEmpty()) {
		firstFieldCardPosX = (game.screenWidth - cardDist * (myFieldCards.size() - 1) - cardScaleX)/2;
		for(Card card : myFieldCards) {
			g2.drawImage(cards[getCardIndex(card)].getImage(), firstFieldCardPosX + i, myFieldCardPosY, null);
			i += cardDist;
		}
		}
		if(!opponentFieldCards.isEmpty()) {
		i = 0;
		firstFieldCardPosX = (game.screenWidth - cardDist * (opponentFieldCards.size() - 1) - cardScaleX)/2;
		for(Card card : opponentFieldCards) {
			g2.drawImage(cards[getCardIndex(card)].getImage(), firstFieldCardPosX + i, opponentFieldCardPosY, null);
			i += cardDist;
		}
		}
		}
	}
	private void setupCard(int index, int value, String suit, int suitValue, String imageName) {
		cards[index] = new Card(value, suit, suitValue);
		cards[index].setImage(uTool.setImage("/cards/" + imageName + ".png", cardScaleX , cardScaleY));
	}
	private BufferedImage button(String fileName) {
		return uTool.setImage("/buttons/" + fileName + ".png", buttonWidth, buttonHeight);
	}
	private BufferedImage setupMiscImg(String fileName, int width, int height) {
		return uTool.setImage("/misc/" + fileName + ".png", width, height);
	}
}
