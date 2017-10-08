package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.MatteBorder;

import entities.Labels;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Choose extends BaseFrame {

	private JPanel contentPane;
	private final ButtonGroup categoryRadioGroup = new ButtonGroup();
	private final ButtonGroup levelRadioGroup = new ButtonGroup();
	String category;
	String level;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Choose frame = new Choose();
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
	public Choose() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblChooseACategory = new JLabel(" Choose a category:");
		lblChooseACategory.setForeground(Color.WHITE);
		lblChooseACategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblChooseACategory.setBounds(10, 11, 199, 30);
		contentPane.add(lblChooseACategory);
		
		final JRadioButton animalsRadioButton = new JRadioButton("Animals");
		animalsRadioButton.setForeground(Color.WHITE);
		animalsRadioButton.setBackground(Color.BLACK);
		animalsRadioButton.setSelected(true);
		categoryRadioGroup.add(animalsRadioButton);
		animalsRadioButton.setBounds(212, 18, 97, 23);
		contentPane.add(animalsRadioButton);
		
		final JRadioButton countriesRadioButton = new JRadioButton("Countries");
		countriesRadioButton.setBackground(Color.BLACK);
		countriesRadioButton.setForeground(Color.WHITE);
		categoryRadioGroup.add(countriesRadioButton);
		countriesRadioButton.setBounds(212, 44, 97, 23);
		contentPane.add(countriesRadioButton);
		
		final JRadioButton sportsRadioButton = new JRadioButton("Sports");
		sportsRadioButton.setForeground(Color.WHITE);
		sportsRadioButton.setBackground(Color.BLACK);
		categoryRadioGroup.add(sportsRadioButton);
		sportsRadioButton.setBounds(212, 70, 97, 23);
		contentPane.add(sportsRadioButton);
		
		JLabel lblNewLabel = new JLabel(" Choose a level:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(10, 175, 187, 14);
		contentPane.add(lblNewLabel);
		
		final JRadioButton easyRadioButton = new JRadioButton("Easy");
		easyRadioButton.setBackground(Color.BLACK);
		easyRadioButton.setForeground(Color.WHITE);
		easyRadioButton.setSelected(true);
		levelRadioGroup.add(easyRadioButton);
		easyRadioButton.setBounds(212, 174, 97, 23);
		contentPane.add(easyRadioButton);
		
		final JRadioButton mediumRadioButton = new JRadioButton("Medium");
		mediumRadioButton.setForeground(Color.WHITE);
		mediumRadioButton.setBackground(Color.BLACK);
		levelRadioGroup.add(mediumRadioButton);
		mediumRadioButton.setBounds(212, 200, 97, 23);
		contentPane.add(mediumRadioButton);
		
		final JRadioButton hardRadioButton = new JRadioButton("Hard");
		hardRadioButton.setBackground(Color.BLACK);
		hardRadioButton.setForeground(Color.WHITE);
		levelRadioGroup.add(hardRadioButton);
		hardRadioButton.setBounds(212, 226, 97, 23);
		contentPane.add(hardRadioButton);
		
		JPanel categoryPanel = new JPanel();
		categoryPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		categoryPanel.setBounds(10, 11, 311, 144);
		contentPane.add(categoryPanel);
		categoryPanel.setLayout(new BorderLayout(0, 0));
		categoryPanel.setBackground(new Color(0, 0, 0, 125));
		
		JPanel levelPanel = new JPanel();
		levelPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		levelPanel.setBounds(10, 166, 311, 168);
		contentPane.add(levelPanel);
		levelPanel.setBackground(new Color(0, 0, 0, 125));
		//Utils.setBackground(levelPanel, "src/images/cat.jpg");
		
		JButton btnNewButton = new JButton("PLAY");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String level=null;
				String category=null;
				if(easyRadioButton.isSelected()) level = Labels.Levels.LEVEL1;
				if(mediumRadioButton.isSelected()) level = Labels.Levels.LEVEL2;
				if(hardRadioButton.isSelected()) level = Labels.Levels.LEVEL3;
				
				if(animalsRadioButton.isSelected()) category = Labels.Category.CATEGORY1;
				if(countriesRadioButton.isSelected()) category = Labels.Category.CATEGORY2;
				if(sportsRadioButton.isSelected()) category = Labels.Category.CATEGORY3;
				new GamePlay(category,level).setVisible(true);
				
				setVisible(false);
			}
		});
		btnNewButton.setBounds(644, 358, 130, 47);
		contentPane.add(btnNewButton);
		showBackgroundImage();
	}
}
