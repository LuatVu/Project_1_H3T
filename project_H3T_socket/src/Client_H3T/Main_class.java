package Client_H3T;

import javax.swing.JOptionPane;

public class Main_class {
	public static void main(String [] args)
	{
		GUI_client myframe = new GUI_client();
		myframe.setSize(300,500);
		myframe.setResizable(false);
		myframe.setVisible(true);
		String ipHost = JOptionPane.showInputDialog(null,"Nhap ma Ip của máy chủ");
		myframe.connnectServer(ipHost);
		
		while(true)
		{
			String str;
			str = myframe.getClient().recieveMessage();
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
