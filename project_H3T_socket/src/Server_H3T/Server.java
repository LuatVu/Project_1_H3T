package Server_H3T;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
public class Server {
	private ServerSocket server;
	private Socket client;
	private DataInputStream dis;
	private DataOutputStream dos;
	private InetAddress inet;
	
	public Server(JLabel lbl)
	{
		try {
			server = new ServerSocket(1234);
			inet = InetAddress.getLocalHost();
			lbl.setText(inet.toString());
			
			client= server.accept();
			System.out.println("co Client ket noi");
			
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
			
			
												
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendMessage(String str)
	{
		try{
			dos.writeUTF(str);
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public String recieveMessage()
	{
		String buffer = new String();
		try{
			
			buffer = dis.readUTF();
			//System.out.println("->client rep: " + buffer);
		}catch(IOException e)
		{
			e.printStackTrace();
			return "Break";
		}
		return buffer;
	}

	public InetAddress getInet() {
		return inet;
	}
			
}
