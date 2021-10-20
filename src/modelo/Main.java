package modelo;

import vista.Vista;

import javax.swing.*;


public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame ("Vista");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add (new Vista());
		frame.pack();
		frame.setVisible (true);
	}
}