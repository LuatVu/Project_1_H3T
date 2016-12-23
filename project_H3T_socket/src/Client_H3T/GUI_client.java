package Client_H3T;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;

public class GUI_client extends JFrame implements ActionListener{
	
	private JLabel lbl;
	private JTextArea ta;
	private JTextField tf;
	private JPanel pn1,pn2;
	private GridBagLayout gb = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	private String serverReply;
	private String comment;	
	private Client myClient;	
	
	public GUI_client()
	{
		super();
		setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		lbl = new JLabel("Client",JLabel.CENTER);		
		
		ta = new JTextArea();
		tf = new JTextField();			
		
		ta.setPreferredSize(new Dimension(250,300));
		ta.setBackground(new Color(204,255,255));
		tf.setPreferredSize(new Dimension(250,30) );		
		
		tf.addActionListener(this);
		
		pn1 = new JPanel();
		pn2 = new JPanel();
		
		this.add(pn1,BorderLayout.NORTH);
		pn1.setPreferredSize(new Dimension(0,30));
		pn1.add(lbl);
		this.add(pn2,BorderLayout.CENTER);
		
		addComponent(pn2,ta,0,0);
		addComponent(pn2,tf,0,1);		
		
	}
	
	
	public void connnectServer(String ip)
	{
		myClient = new Client(ip);		
	}
	
	
	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource() == tf)
		{
			comment = tf.getText();
			myClient.sendMessage(comment);								
			tf.setText("");			
		}
	}
		
	public void addComponent(Container container, Component con, int x, int y)
	{
		gbc.gridx = x;
		gbc.gridy = y;
		gb.setConstraints(con,gbc);
		container.add(con);
	}
	
	public Client getClient()
	{
		return this.myClient;
	}
	
	public JTextArea getTextArea()
	{
		return this.ta;
	}
}
