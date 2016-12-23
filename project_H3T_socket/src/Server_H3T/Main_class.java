package Server_H3T;

public class Main_class {
	public static void main(String [] args)
	{
		GUI_server myframe = new GUI_server();
		myframe.setSize(300,500);
		myframe.setResizable(false);
		myframe.setVisible(true);
		myframe.openServer();			
		
		while(true)
		{
			String str = myframe.getServer().recieveMessage();
			if(str.equals("Break"))
			{
				break;
			}
			if(!str.equals(""))
			{
				myframe.getTextArea().setText("");
				myframe.getTextArea().setText(str);
			}
		}
	}
}
