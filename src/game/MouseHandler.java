package game;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class MouseHandler implements MouseListener{
	private Game game;
	protected int posClickedX = 0, posClickedY = 0, 
			   posPressedX = 0, posPressedY = 0;
	
	//back button
	protected boolean buttonBackActive = false, buttonBackPressed = false;
	
	//main menu buttons
		protected boolean  buttonAccountActive = false, buttonAccountPressed = false,
							buttonQuitActive = false, buttonQuitPressed = false,
							serverBoxActive = false, serverBoxPressed = false;
				
		////room select buttons
		protected boolean  buttonJoinRoomActive = false, buttonJoinRoomPressed = false,
							buttonConfirmJoinRoomActive = false, buttonConfirmJoinRoomPressed = false,
							buttonCreateRoomActive = false, buttonCreateRoomPressed = false,
							buttonConfirmCreateRoomActive = false, buttonConfirmCreateRoomPressed = false,
							buttonStartGameActive = false, buttonStartGamePressed = false;
		
		//menu account buttons
		protected boolean  buttonLoginActive = false, buttonLoginPressed = false,
							buttonLogoutActive = false, buttonLogoutPressed = false,
							buttonSignupActive = false, buttonSignupPressed = false;
		
		//menu account signup buttons
		protected boolean buttonConfirmAccountActive = false, buttonConfirmAccountPressed = false;
		
		//menu server buttons
		protected boolean  buttonConnectActive = false, buttonConnectPressed = false,
							buttonDisconnectActive = false, buttonDisconnectPressed = false;
		
		//game buttons
		protected boolean  buttonPlayActive = false, buttonPlayPressed = false, 
						 buttonUnselectActive = false, buttonUnselectPressed = false, 
						 buttonSwapActive = false, buttonSwapPressed = false, 
						 buttonPassActive = false, buttonPassPressed = false,
						 buttonLoseGameActive = false, buttonLoseGamePressed = false,
						 buttonLeaveRoomActive = false, buttonLeaveRoomPressed = false;


	public MouseHandler(Game game) {
		this.game = game;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		posClickedX = e.getX();
		posClickedY = e.getY();
		
		
		if(game.gameState == game.inMenuState) {
			
			if(game.menuState == game.mainMenu) {
				if(posClickedX >= game.ui.buttonAccountX && posClickedX <= game.ui.buttonAccountX + game.ui.buttonWidth && posClickedY >= game.ui.buttonAccountY && posClickedY <= game.ui.buttonAccountY + game.ui.buttonHeight)
					buttonAccountActive = true;
				if(posClickedX >= game.ui.buttonCreateRoomMenuX && posClickedX <= game.ui.buttonCreateRoomMenuX + game.ui.buttonWidth && posClickedY >= game.ui.buttonCreateRoomMenuY && posClickedY <= game.ui.buttonCreateRoomMenuY + game.ui.buttonHeight)
					buttonCreateRoomActive = true;
				if(posClickedX >= game.ui.buttonJoinRoomMenuX && posClickedX <= game.ui.buttonJoinRoomMenuX + game.ui.buttonWidth && posClickedY >= game.ui.buttonJoinRoomMenuY && posClickedY <= game.ui.buttonJoinRoomMenuY + game.ui.buttonHeight)
					buttonJoinRoomActive = true;
				if(posClickedX >= game.ui.buttonQuitX && posClickedX <= game.ui.buttonQuitX + game.ui.buttonWidth && posClickedY >= game.ui.buttonQuitY && posClickedY <= game.ui.buttonQuitY + game.ui.buttonHeight)
					buttonQuitActive = true;
				if(posClickedX >= game.ui.serverBoxX + game.ui.serverBoxOffsetLeft && 
						posClickedX <= game.ui.serverBoxX + game.ui.serverBoxSizeX - game.ui.serverBoxOffsetRight && 
						posClickedY >= game.ui.serverBoxY + game.ui.serverBoxOffsetTop && 
						posClickedY <= game.ui.serverBoxY + game.ui.serverBoxSizeY - game.ui.serverBoxOffsetBottom)
					serverBoxActive = true;
			}
			if(game.menuState == game.menuServer) {
				if(posClickedX >= game.ui.buttonBackServerX && posClickedX <= game.ui.buttonBackServerX + game.ui.buttonWidth && posClickedY >= game.ui.buttonBackServerY && posClickedY <= game.ui.buttonBackServerY + game.ui.buttonHeight)
					buttonBackActive = true;
				if(posClickedX >= game.ui.buttonConnectX && posClickedX <= game.ui.buttonConnectX + game.ui.buttonWidth && posClickedY >= game.ui.buttonConnectY && posClickedY <= game.ui.buttonConnectY + game.ui.buttonHeight)
					buttonConnectActive = true;
				if(posClickedX >= game.ui.buttonDisconnectX && posClickedX <= game.ui.buttonDisconnectX + game.ui.buttonWidth && posClickedY >= game.ui.buttonDisconnectY && posClickedY <= game.ui.buttonDisconnectY + game.ui.buttonHeight)
					buttonDisconnectActive = true;
			}
			
			if(game.menuState == game.menuAccount) {
				if(posClickedX >= game.ui.buttonBackAccountX && posClickedX <= game.ui.buttonBackAccountX + game.ui.buttonWidth && posClickedY >= game.ui.buttonBackAccountY && posClickedY <= game.ui.buttonBackAccountY + game.ui.buttonHeight)
					buttonBackActive = true;
				
				if(posClickedX >= game.ui.buttonLoginX && posClickedX <= game.ui.buttonLoginX + game.ui.buttonWidth && posClickedY >= game.ui.buttonLoginY && posClickedY <= game.ui.buttonLoginY + game.ui.buttonHeight)
					buttonLoginActive = true;
				
				if(posClickedX >= game.ui.buttonLogoutX && posClickedX <= game.ui.buttonLogoutX + game.ui.buttonWidth && posClickedY >= game.ui.buttonLogoutY && posClickedY <= game.ui.buttonLogoutY + game.ui.buttonHeight)
					buttonLogoutActive = true;
				
				if(posClickedX >= game.ui.buttonSignupX && posClickedX <= game.ui.buttonSignupX + game.ui.buttonWidth && posClickedY >= game.ui.buttonSignupY && posClickedY <= game.ui.buttonSignupY + game.ui.buttonHeight)
					buttonSignupActive = true;
			}
			
			if(game.menuState == game.menuAccountSignup) {
				if(posClickedX >= game.ui.buttonBackSignupX && posClickedX <= game.ui.buttonBackSignupX + game.ui.buttonWidth && posClickedY >= game.ui.buttonBackSignupY && posClickedY <= game.ui.buttonBackSignupY + game.ui.buttonHeight)
					buttonBackActive = true;
				
				if(posClickedX >= game.ui.buttonConfirmAccountX && posClickedX <= game.ui.buttonConfirmAccountX + game.ui.buttonWidth && posClickedY >= game.ui.buttonConfirmAccountY && posClickedY <= game.ui.buttonConfirmAccountY + game.ui.buttonHeight)
					buttonConfirmAccountActive = true;
			}
			
			if(game.menuState == game.menuCreateRoom) {
				if(posClickedX >= game.ui.buttonBackRoomX && posClickedX <= game.ui.buttonBackRoomX + game.ui.buttonWidth && posClickedY >= game.ui.buttonBackRoomY && posClickedY <= game.ui.buttonBackRoomY + game.ui.buttonHeight)
					buttonBackActive = true;
				
				if(posClickedX >= game.ui.buttonConfirmCreateRoomX && posClickedX <= game.ui.buttonConfirmCreateRoomX + game.ui.buttonWidth && posClickedY >= game.ui.buttonConfirmCreateRoomY && posClickedY <= game.ui.buttonConfirmCreateRoomY + game.ui.buttonHeight)
					buttonConfirmCreateRoomActive = true;
			}
			
			if(game.menuState == game.menuGuestRoom) {
				if(posClickedX >= game.ui.buttonBackRoomX && posClickedX <= game.ui.buttonBackRoomX + game.ui.buttonWidth && posClickedY >= game.ui.buttonBackRoomY && posClickedY <= game.ui.buttonBackRoomY + game.ui.buttonHeight)
					buttonBackActive = true;
				
				if(posClickedX >= game.ui.buttonConfirmJoinRoomX && posClickedX <= game.ui.buttonConfirmJoinRoomX + game.ui.buttonWidth && posClickedY >= game.ui.buttonConfirmJoinRoomY && posClickedY <= game.ui.buttonConfirmJoinRoomY + game.ui.buttonHeight)
					buttonConfirmJoinRoomActive = true;
			}
			if(game.menuState == game.menuCreateRoomSuccess) {
				if(posClickedX >= game.ui.buttonStartGameX && posClickedX <= game.ui.buttonStartGameX + game.ui.buttonWidth && posClickedY >= game.ui.buttonStartGameY && posClickedY <= game.ui.buttonStartGameY + game.ui.buttonHeight)
					buttonStartGameActive = true;
			}
			
			if(game.menuState == game.menuJoinRoomSuccess) {
				
			}
		}
		
		if(game.gameState == game.playState) {
		if(posClickedX >= game.ui.buttonPlayX && posClickedX <= game.ui.buttonPlayX + game.ui.buttonWidth && posClickedY >= game.ui.buttonPlayY && posClickedY <= game.ui.buttonPlayY + game.ui.buttonHeight)
			buttonPlayActive = true;
		if(posClickedX >= game.ui.buttonUnselectX && posClickedX <= game.ui.buttonUnselectX + game.ui.buttonWidth && posClickedY >= game.ui.buttonUnselectY && posClickedY <= game.ui.buttonUnselectY + game.ui.buttonHeight)
			buttonUnselectActive = true;
		if(posClickedX >= game.ui.buttonSwapX && posClickedX <= game.ui.buttonSwapX + game.ui.buttonWidth && posClickedY >= game.ui.buttonSwapY && posClickedY <= game.ui.buttonSwapY + game.ui.buttonHeight)
			buttonSwapActive = true;
		if(posClickedX >= game.ui.buttonPassX && posClickedX <= game.ui.buttonPassX + game.ui.buttonWidth && posClickedY >= game.ui.buttonPassY && posClickedY <= game.ui.buttonPassY + game.ui.buttonHeight)
			buttonPassActive = true;
		if(posClickedX >= game.ui.buttonLoseGameX && posClickedX <= game.ui.buttonLoseGameX + game.ui.buttonWidth && posClickedY >= game.ui.buttonLoseGameY && posClickedY <= game.ui.buttonLoseGameY + game.ui.buttonHeight)
			buttonLoseGameActive = true;
		if(posClickedX >= game.ui.buttonLeaveRoomX && posClickedX <= game.ui.buttonLeaveRoomX + game.ui.buttonWidth && posClickedY >= game.ui.buttonLeaveRoomY && posClickedY <= game.ui.buttonLeaveRoomY + game.ui.buttonHeight)
			buttonLeaveRoomActive = true;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		posPressedX = e.getX();
		posPressedY = e.getY();
		
		if(game.gameState == game.inMenuState) {
			
			if(game.menuState == game.mainMenu) {
				if(posPressedX >= game.ui.buttonAccountX && posPressedX <= game.ui.buttonAccountX + game.ui.buttonWidth && posPressedY >= game.ui.buttonAccountY && posPressedY <= game.ui.buttonAccountY + game.ui.buttonHeight)
					buttonAccountPressed = true;
				if(posPressedX >= game.ui.buttonCreateRoomMenuX && posPressedX <= game.ui.buttonCreateRoomMenuX + game.ui.buttonWidth && posPressedY >= game.ui.buttonCreateRoomMenuY && posPressedY <= game.ui.buttonCreateRoomMenuY + game.ui.buttonHeight)
					buttonCreateRoomPressed = true;
				if(posPressedX >= game.ui.buttonJoinRoomMenuX && posPressedX <= game.ui.buttonJoinRoomMenuX + game.ui.buttonWidth && posPressedY >= game.ui.buttonJoinRoomMenuY && posPressedY <= game.ui.buttonJoinRoomMenuY + game.ui.buttonHeight)
					buttonJoinRoomPressed = true;
				if(posPressedX >= game.ui.buttonQuitX && posPressedX <= game.ui.buttonQuitX + game.ui.buttonWidth && posPressedY >= game.ui.buttonQuitY && posPressedY <= game.ui.buttonQuitY + game.ui.buttonHeight)
					buttonQuitPressed = true;
				if(posPressedX >= game.ui.serverBoxX + game.ui.serverBoxOffsetLeft && posPressedX <= game.ui.serverBoxX+ game.ui.serverBoxSizeX && posPressedY >= game.ui.serverBoxY + game.ui.serverBoxOffsetTop && posPressedY <= game.ui.serverBoxY + game.ui.serverBoxSizeY)
					serverBoxPressed = true;
			}
			if(game.menuState == game.menuServer) {
				if(posPressedX >= game.ui.buttonBackServerX && posPressedX <= game.ui.buttonBackServerX + game.ui.buttonWidth && posPressedY >= game.ui.buttonBackServerY && posPressedY <= game.ui.buttonBackServerY + game.ui.buttonHeight)
					buttonBackPressed = true;
				if(posPressedX >= game.ui.buttonConnectX && posPressedX <= game.ui.buttonConnectX + game.ui.buttonWidth && posPressedY >= game.ui.buttonConnectY && posPressedY <= game.ui.buttonConnectY + game.ui.buttonHeight)
					buttonConnectPressed = true;
				if(posPressedX >= game.ui.buttonDisconnectX && posPressedX <= game.ui.buttonDisconnectX + game.ui.buttonWidth && posPressedY >= game.ui.buttonDisconnectY && posPressedY <= game.ui.buttonDisconnectY + game.ui.buttonHeight)
					buttonDisconnectPressed = true;
			}
			
			if(game.menuState == game.menuAccount) {
				if(posPressedX >= game.ui.buttonBackAccountX && posPressedX <= game.ui.buttonBackAccountX + game.ui.buttonWidth && posPressedY >= game.ui.buttonBackAccountY && posPressedY <= game.ui.buttonBackAccountY + game.ui.buttonHeight)
					buttonBackPressed = true;
				
				if(posPressedX >= game.ui.buttonLoginX && posPressedX <= game.ui.buttonLoginX + game.ui.buttonWidth && posPressedY >= game.ui.buttonLoginY && posPressedY <= game.ui.buttonLoginY + game.ui.buttonHeight)
					buttonLoginPressed = true;
				
				if(posPressedX >= game.ui.buttonLogoutX && posPressedX <= game.ui.buttonLogoutX + game.ui.buttonWidth && posPressedY >= game.ui.buttonLogoutY && posPressedY <= game.ui.buttonLogoutY + game.ui.buttonHeight)
					buttonLogoutPressed = true;
				
				if(posPressedX >= game.ui.buttonSignupX && posPressedX <= game.ui.buttonSignupX + game.ui.buttonWidth && posPressedY >= game.ui.buttonSignupY && posPressedY <= game.ui.buttonSignupY + game.ui.buttonHeight)
					buttonSignupPressed = true;
			}
			
			if(game.menuState == game.menuAccountSignup) {
				if(posPressedX >= game.ui.buttonBackSignupX && posPressedX <= game.ui.buttonBackSignupX + game.ui.buttonWidth && posPressedY >= game.ui.buttonBackSignupY && posPressedY <= game.ui.buttonBackSignupY + game.ui.buttonHeight)
					buttonBackPressed = true;
				
				if(posPressedX >= game.ui.buttonConfirmAccountX && posPressedX <= game.ui.buttonConfirmAccountX + game.ui.buttonWidth && posPressedY >= game.ui.buttonConfirmAccountY && posPressedY <= game.ui.buttonConfirmAccountY + game.ui.buttonHeight)
					buttonConfirmAccountPressed = true;
			}
			
			if(game.menuState == game.menuCreateRoom) {
				if(posPressedX >= game.ui.buttonBackRoomX && posPressedX <= game.ui.buttonBackRoomX + game.ui.buttonWidth && posPressedY >= game.ui.buttonBackRoomY && posPressedY <= game.ui.buttonBackRoomY + game.ui.buttonHeight)
					buttonBackPressed = true;
				
				if(posPressedX >= game.ui.buttonConfirmCreateRoomX && posPressedX <= game.ui.buttonConfirmCreateRoomX + game.ui.buttonWidth && posPressedY >= game.ui.buttonConfirmCreateRoomY && posPressedY <= game.ui.buttonConfirmCreateRoomY + game.ui.buttonHeight)
					buttonConfirmCreateRoomPressed = true;
			}
			if(game.menuState == game.menuGuestRoom) {
				if(posPressedX >= game.ui.buttonBackRoomX && posPressedX <= game.ui.buttonBackRoomX + game.ui.buttonWidth && posPressedY >= game.ui.buttonBackRoomY && posPressedY <= game.ui.buttonBackRoomY + game.ui.buttonHeight)
					buttonBackPressed = true;
				
				if(posPressedX >= game.ui.buttonConfirmJoinRoomX && posPressedX <= game.ui.buttonConfirmJoinRoomX + game.ui.buttonWidth && posPressedY >= game.ui.buttonConfirmJoinRoomY && posPressedY <= game.ui.buttonConfirmJoinRoomY + game.ui.buttonHeight)
					buttonConfirmJoinRoomPressed = true;
			}
			if(game.menuState == game.menuCreateRoomSuccess) {
				if(posPressedX >= game.ui.buttonStartGameX && posPressedX <= game.ui.buttonStartGameX + game.ui.buttonWidth && posPressedY >= game.ui.buttonStartGameY && posPressedY <= game.ui.buttonStartGameY + game.ui.buttonHeight)
					buttonStartGamePressed = true;
			}
			
			if(game.menuState == game.menuJoinRoomSuccess) {
				
			}
		}
		
		if(game.gameState == game.playState) {
		if(posPressedX >= game.ui.buttonPlayX && posPressedX <= game.ui.buttonPlayX + game.ui.buttonWidth && posPressedY >= game.ui.buttonPlayY && posPressedY <= game.ui.buttonPlayY + game.ui.buttonHeight)
			buttonPlayPressed = true;
		if(posPressedX >= game.ui.buttonUnselectX && posPressedX <= game.ui.buttonUnselectX + game.ui.buttonWidth && posPressedY >= game.ui.buttonUnselectY && posPressedY <= game.ui.buttonUnselectY + game.ui.buttonHeight)
			buttonUnselectPressed = true;
		if(posPressedX >= game.ui.buttonSwapX && posPressedX <= game.ui.buttonSwapX + game.ui.buttonWidth && posPressedY >= game.ui.buttonSwapY && posPressedY <= game.ui.buttonSwapY + game.ui.buttonHeight)
			buttonSwapPressed = true;
		if(posPressedX >= game.ui.buttonPassX && posPressedX <= game.ui.buttonPassX + game.ui.buttonWidth && posPressedY >= game.ui.buttonPassY && posPressedY <= game.ui.buttonPassY + game.ui.buttonHeight)
			buttonPassPressed = true;
		if(posPressedX >= game.ui.buttonLoseGameX && posPressedX <= game.ui.buttonLoseGameX + game.ui.buttonWidth && posPressedY >= game.ui.buttonLoseGameY && posPressedY <= game.ui.buttonLoseGameY + game.ui.buttonHeight)
			buttonLoseGamePressed = true;
		if(posPressedX >= game.ui.buttonLeaveRoomX && posPressedX <= game.ui.buttonLeaveRoomX + game.ui.buttonWidth && posPressedY >= game.ui.buttonLeaveRoomY && posPressedY <= game.ui.buttonLeaveRoomY + game.ui.buttonHeight)
			buttonLeaveRoomPressed = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		posClickedX = 0;
//		posClickedY = 0;
		posPressedX = 0;
		posPressedY = 0;
		setAllFalse();
	}
	
private void setAllFalse() {
	
	//back button
		buttonBackActive = false; 
		buttonBackPressed = false;
		
	//main menu buttons
		
		buttonAccountActive = false; buttonAccountPressed = false;
		buttonQuitActive = false; buttonQuitPressed = false;
		serverBoxActive = false; serverBoxPressed = false;
	
////room select buttons
				buttonJoinRoomActive = false; buttonJoinRoomPressed = false;
				buttonCreateRoomActive = false; buttonCreateRoomPressed = false;
				buttonConfirmJoinRoomActive = false; buttonConfirmJoinRoomPressed = false;
				buttonConfirmCreateRoomActive = false; buttonConfirmCreateRoomPressed = false;
				buttonStartGameActive = false; buttonStartGamePressed = false;

//menu account buttons
				buttonLoginActive = false; buttonLoginPressed = false;
				buttonLogoutActive = false; buttonLogoutPressed = false;
				buttonSignupActive = false; buttonSignupPressed = false;

//menu account signup buttons
				buttonConfirmAccountActive = false; buttonConfirmAccountPressed = false;

//menu server buttons
				buttonConnectActive = false; buttonConnectPressed = false;
				buttonDisconnectActive = false; buttonDisconnectPressed = false;

//game buttons
				buttonPlayActive = false; buttonPlayPressed = false; 
			 buttonUnselectActive = false; buttonUnselectPressed = false; 
			 buttonSwapActive = false; buttonSwapPressed = false; 
			 buttonPassActive = false; buttonPassPressed = false;
			 buttonLoseGameActive = false; buttonLoseGamePressed = false;
			 buttonLeaveRoomActive = false; buttonLeaveRoomPressed = false;
}
	public int cardNumberClicked(int handNumber, int posClickedX, int posClickedY) {
		if(posClickedY >= game.ui.firstHandCardPosY && posClickedY <= game.ui.firstHandCardPosY + game.ui.cardScaleY) {
			if(posClickedX > (handNumber - 1) * game.ui.cardDist + game.ui.firstHandCardPosX && posClickedX <= handNumber * game.ui.cardDist + game.ui.firstHandCardPosX + game.ui.cardScaleX) 
				return handNumber;
			else return ((int)((posClickedX - game.ui.firstHandCardPosX) / game.ui.cardDist) + 1);
		}
		if(posClickedY >= game.ui.firstHandCardPosY - game.ui.selectedCardHigher && posClickedY < game.ui.firstHandCardPosY && posClickedX >= game.ui.firstHandCardPosX && posClickedX < game.ui.firstHandCardPosX + (handNumber - 1) * game.ui.cardDist + game.ui.cardScaleX) {
			int left = 0, right = handNumber - 1, i = 0;
			while(posClickedX > left * game.ui.cardDist + game.ui.firstHandCardPosX + game.ui.cardScaleX && left <= handNumber - 2) left++;
			while(posClickedX < right * game.ui.cardDist + game.ui.firstHandCardPosX) right--;
			left++;
			right++;
			for(i = right; i >= left; --i) if(game.player1.Hand.get(i - 1).selected == true) return i;
		}
		return 99;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
