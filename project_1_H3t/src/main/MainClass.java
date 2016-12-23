package main;

import Graphic_user_interface.GUIclass;

public class MainClass {
	public static void main(String[] args)
	{
		GUIclass myframe = new GUIclass();
		myframe.setSize(1200,900);
		myframe.setUpComponent();
		myframe.setVisible(true);
	}
	
}
