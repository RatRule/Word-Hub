package gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import data.UserDataAccess;
import entities.UserEntity;
import logic.ClockTimer;
import logic.ClockTimer.ClockTimerListener;
import logic.GamePlaylogic;
import logic.Session;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GamePlay extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldWord;
//	private GamePlaylogic w;
	
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GamePlay(final String category,final String level) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelYourScore = new JLabel("YOUR SCORE : ");
		labelYourScore.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelYourScore.setBounds(10, 34, 136, 31);
		contentPane.add(labelYourScore);
		
		JLabel labelHighScore = new JLabel("HIGH SCORE:\r\n");
		labelHighScore.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelHighScore.setBounds(10, 11, 136, 14);
		contentPane.add(labelHighScore);
		
		final JLabel clockLabel = new JLabel("00:00");
		clockLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		clockLabel.setBounds(638, 11, 136, 53);
		contentPane.add(clockLabel);
		
		final JLabel labelWord = new JLabel("New label");
		labelWord.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelWord.setBounds(185, 135, 380, 76);
		contentPane.add(labelWord);
		
		textFieldWord = new JTextField();
		textFieldWord.setBounds(185, 289, 380, 39);
		contentPane.add(textFieldWord);
		textFieldWord.setColumns(10);
		
		final GamePlaylogic gmLogic=new GamePlaylogic(category, level);
		final String word=gmLogic.getWord();
		labelWord.setText(word);
		
		final JLabel labelScorevalue = new JLabel(String.valueOf(gmLogic.getCurrentScore()));
		labelScorevalue.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelScorevalue.setBounds(156, 34, 77, 31);
		contentPane.add(labelScorevalue);
		
		
		JButton checkButton = new JButton("Check");
		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(gmLogic.checkWord(textFieldWord.getText())) {
				labelWord.setText(gmLogic.getWord());
				gmLogic.updateScore();
				textFieldWord.setText("");
				labelScorevalue.setText(String.valueOf(gmLogic.getCurrentScore()));				
			}
			}});
		checkButton.setBounds(581, 289, 89, 39);
		contentPane.add(checkButton);
		
		UserEntity user = new UserDataAccess().getUser(Session.getUserId());
		
		JLabel labelHighScoreValue = new JLabel(String.valueOf(user.getHighScore()));
		labelHighScoreValue.setBounds(116, 7, 46, 27);
		contentPane.add(labelHighScoreValue);
		
		ClockTimer timer=new ClockTimer(0,2,0,0);
		timer.startTimer();
		timer.setScale(1);
		timer.setClockTimerListener(new ClockTimerListener() {
			@Override
			public void onTimerEnd(ClockTimer timer) {
				setVisible(false);
				gmLogic.updateHighScore();
				EndGame endGame=new EndGame(gmLogic.getCurrentScore(),category,level);
				endGame.setVisible(true);
			}
			@Override
			public void onSecondsUpdate(ClockTimer timer) {
				clockLabel.setText(timer.getExcessMinutes() + ":" + timer.getExcessSeconds());
			}
			
			@Override
			public void onMinutesUpdate(ClockTimer timer) {
				
				
			}
			
			@Override
			public void onHoursUpdate(ClockTimer timer) {
				
				
			}
			
			@Override
			public void on100MilisUpdate(ClockTimer timer) {
				
				
			}
		});
		
	}
}
