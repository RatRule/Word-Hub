package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.rmi.CORBA.Util;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;

public class Home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}
	
	public void show() {
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(SystemColor.desktop);
		frame.getContentPane().setBackground(SystemColor.desktop);
		frame.setBounds(100, 100, 800, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton loginBtn = new JButton("LOGIN");
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setBackground(Color.BLACK);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onLogin();
			}
		});
		loginBtn.setBounds(597, 338, 115, 23);
		frame.getContentPane().add(loginBtn);
		
		JButton registerBtn = new JButton("REGISTER");
		registerBtn.setBackground(Color.BLACK);
		registerBtn.setForeground(Color.WHITE);
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onRegister();
			}
		});
		registerBtn.setBounds(597, 272, 115, 23);
		frame.getContentPane().add(registerBtn);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(255, 255, 255, 0));
		titlePanel.setBounds(249, 104, 182, 182);
		frame.getContentPane().add(titlePanel);
		Utils.setBackground(titlePanel, "src/images/logo2.png");
		
		Utils.setBackground(frame,"src/images/homeBackground.jpg");
	}
	
	private void onRegister() {
		frame.dispose();
		SignUp signup=new SignUp();
		signup.setVisible(true);
	}
	
	private void onLogin() {
		frame.dispose();
		Login login=new Login();
		login.setVisible(true);
		
	}
}
