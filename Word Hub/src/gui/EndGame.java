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

public class EndGame extends JFrame {

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
		labelScore.setBounds(84, 194, 154, 30);
		contentPane.add(labelScore);
		
		JLabel labelHighscore = new JLabel("Your High Score is:");
		labelHighscore.setFont(new Font("Tahoma", Font.BOLD, 22));
		labelHighscore.setBounds(26, 235, 212, 30);
		contentPane.add(labelHighscore);
		
		JLabel labelScoreValue = new JLabel(String.valueOf(score));
		labelScoreValue.setFont(new Font("Tahoma", Font.BOLD, 22));
		labelScoreValue.setBounds(248, 196, 46, 27);
		contentPane.add(labelScoreValue);
		
		UserEntity user = new UserDataAccess().getUser(Session.getUserId());
		
		JLabel labelHighScoreValue = new JLabel(String.valueOf(user.getHighScore()));
		labelHighScoreValue.setFont(new Font("Tahoma", Font.BOLD, 22));
		labelHighScoreValue.setBounds(248, 240, 46, 22);
		contentPane.add(labelHighScoreValue);
		
		JButton buttonPlayAgain = new JButton("PLAY AGAIN");
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
		btnNewButton_1.setBounds(10, 352, 154, 53);
		contentPane.add(btnNewButton_1);
			
	}}
		
