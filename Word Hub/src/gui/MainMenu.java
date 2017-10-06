package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.UserDataAccess;
import entities.UserEntity;
import logic.Session;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	UserEntity user;
	
	public MainMenu() {
		
		user = new UserDataAccess().getUser(Session.getUserId());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel labelWelcome = new JLabel("Welcome "+user.getUserId());
		labelWelcome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		labelWelcome.setBounds(10, 11, 480, 29);
		contentPane.add(labelWelcome);
		
		JLabel labelHighscore = new JLabel("Your highscore is: "+user.getHighScore());
		labelHighscore.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		labelHighscore.setBounds(10, 78, 480, 29);
		contentPane.add(labelHighscore);
		
		JButton playButton = new JButton("PLAY");
		playButton.setBounds(354, 282, 89, 43);
		contentPane.add(playButton);
		
		JButton howToPlayButton = new JButton("How to play?\r\n");	
		howToPlayButton.setBounds(10, 373, 120, 32);
		contentPane.add(howToPlayButton);
		
		JButton logOutButton = new JButton("LOG OUT");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});
		logOutButton.setBounds(660, 373, 120, 32);
		contentPane.add(logOutButton);
	}
	
	
	public void logout() {
		this.setVisible(false);
		
		Home home=new Home();
		home.show();
		Session.logout();
	}
}
