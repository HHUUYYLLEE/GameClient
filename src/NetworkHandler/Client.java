package NetworkHandler;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import game.Game;

public class Client {
	private Game game;
	private Socket socket;
	private DataOutputStream out;
	private DataInputStream in;
	
	public String IPConnect;
	public int portNoConnect;
	
	public boolean willDisconnect = false, isConnected = false;
	public Client(Game game) {
		this.game = game;
	}
	public void connectToServer() {
		
		if(isValidInet4Address()) {
			try {
				socket = new Socket(IPConnect, portNoConnect);
				out = new DataOutputStream(socket.getOutputStream());
		        in = new DataInputStream(socket.getInputStream());
		        isConnected = true;
			} catch(IOException e) {
				e.printStackTrace();
				isConnected = false;
			}
		}
		////else wrong ip address
	}
	
	public void disconnectFromServer() {
		if(socket != null) {
		try {
			socket.close();
			isConnected = false;
		} catch (IOException e) {
			isConnected = true;
	        e.printStackTrace();
		}
		}
	}
	public void sendMessage(int messageCode, String sent) {
		String messageCodeString, lengthString;
		if(messageCode < 10) messageCodeString = "0" + Integer.toString(messageCode);
		else messageCodeString = Integer.toString(messageCode);
		lengthString = Integer.toString(sent.length());
    	while(lengthString.length() < 5) lengthString = "0" + lengthString;
    	System.out.println("Sending " + lengthString + messageCodeString + sent);
        try {
        	out.write(lengthString.getBytes(), 0, 5);
			out.write(messageCodeString.getBytes(), 0, 2);
			out.write(sent.getBytes(), 0, sent.length());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
	}
	public String recvMessage() {
		byte[] bytesRecv = new byte[1024];
		int lengthRecv;
		try {
	        in.readNBytes(bytesRecv, 0, 5);
	        lengthRecv = Integer.valueOf(new String(bytesRecv, 0, 5));
	        Arrays.fill(bytesRecv, (byte) 0);
	        in.readNBytes(bytesRecv, 0, 2);
	        game.messageCode = Integer.valueOf(new String(bytesRecv, 0, 2));
	        Arrays.fill(bytesRecv, (byte) 0);
	        in.readNBytes(bytesRecv, 0, lengthRecv);
	        game.infoRecv = new String(bytesRecv, 0, lengthRecv);
	        System.out.println("Receiving " + lengthRecv + "length " + game.messageCode + " " + game.infoRecv);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	private boolean isValidInet4Address()
    {
		String IPV4_PATTERN =
	            "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";

	    Pattern pattern = Pattern.compile(IPV4_PATTERN);

	    
	    Matcher matcher = pattern.matcher(IPConnect);
	        return matcher.matches();
	    
    }
}
