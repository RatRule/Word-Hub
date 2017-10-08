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
import java.awt.Color;

public class EndGame extends BaseFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	public EndGame(int score,final String category,final String level) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel labelGameOver = new JLabel("GAME OVER");
		labelGameOver.setFont(new Font("Tahoma", Font.BOLD, 60));
		labelGameOver.setBounds(194, 62, 376, 86);
		contentPane.add(labelGameOver);
		
		JLabel labelScore = new JLabel("Your Score is:");
		labelScore.setFont(new Font("Tahoma", Font.BOLD, 22));
		labelScore.setBounds(313, 194, 154, 30);
		contentPane.add(labelScore);
		
		JLabel labelHighscore = new JLabel("Your High Score is:");
		labelHighscore.setFont(new Font("Tahoma", Font.BOLD, 22));
		labelHighscore.setBounds(255, 235, 212, 30);
		contentPane.add(labelHighscore);
		
		JLabel labelScoreValue = new JLabel(String.valueOf(score));
		labelScoreValue.setFont(new Font("Tahoma", Font.BOLD, 22));
		labelScoreValue.setBounds(477, 196, 46, 27);
		contentPane.add(labelScoreValue);
		
		UserEntity user = new UserDataAccess().getUser(Session.getUserId());
		
		JLabel labelHighScoreValue = new JLabel(String.valueOf(user.getHighScore()));
		labelHighScoreValue.setFont(new Font("Tahoma", Font.BOLD, 22));
		labelHighScoreValue.setBounds(477, 239, 46, 22);
		contentPane.add(labelHighScoreValue);
		
		JButton buttonPlayAgain = new JButton("PLAY AGAIN");
		buttonPlayAgain.setBackground(Color.BLACK);
		buttonPlayAgain.setForeground(Color.WHITE);
		buttonPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				GamePlay gamePlay=new GamePlay(category, level);
				gamePlay.setVisible(true);
				
			
			}	
		});	
			
		buttonPlayAgain.setBounds(620, 352, 154, 53);
		contentPane.add(buttonPlayAgain);
		
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
				
			}
		});
		btnNewButton_1.setBounds(10, 352, 154, 53);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("CHOOSE ANOTHER LEVEL/CATEGORY");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose();
			}
		});
		btnNewButton.setBounds(269, 352, 254, 53);
		contentPane.add(btnNewButton);
		
		showBackgroundImage();
	}
	public void logout() {
	this.setVisible(false);
	
	Home home=new Home();
	home.show();
	Session.logout();
	}

	public void choose() {
		setVisible(false);
		Choose choose=new Choose();
		choose.setVisible(true);
		
	}
	
	}
		
