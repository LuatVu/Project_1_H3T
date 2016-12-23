package Client_H3T;


import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class Client {
	private Socket client; 	
	private DataInputStream inData;
	private DataOutputStream outData;
	
	
	public Client(String ip)
	{
		try {
			client = new Socket(ip,1234);
			//JOptionPane.showMessageDialog(null,"Đã kết nối được với Server");
			
			inData = new DataInputStream(client.getInputStream());
			outData = new DataOutputStream(client.getOutputStream());
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendMessage(String str)
	{
		try{
			outData.writeUTF(str);
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public String recieveMessage()
	{
		String buffer;
		try{			
			buffer = inData.readUTF();
			//System.out.println("->server rep: " +  buffer);
			return buffer;
		}catch(IOException e)
		{
			e.printStackTrace();
			return "Break";
		}		
	}
}
