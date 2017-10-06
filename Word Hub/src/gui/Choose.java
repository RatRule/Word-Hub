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
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Choose extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup categoryRadioGroup = new ButtonGroup();
	private final ButtonGroup levelRadioGroup = new ButtonGroup();

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
		lblChooseACategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblChooseACategory.setBounds(10, 11, 199, 30);
		contentPane.add(lblChooseACategory);
		
		final JRadioButton c1RadioButton = new JRadioButton("Category 1\r\n");
		c1RadioButton.setSelected(true);
		categoryRadioGroup.add(c1RadioButton);
		c1RadioButton.setBounds(212, 18, 97, 23);
		contentPane.add(c1RadioButton);
		
		final JRadioButton c2RadioButton = new JRadioButton("Category 2");
		categoryRadioGroup.add(c2RadioButton);
		c2RadioButton.setBounds(212, 44, 97, 23);
		contentPane.add(c2RadioButton);
		
		final JRadioButton c3RadioButton = new JRadioButton("Category 3");
		categoryRadioGroup.add(c3RadioButton);
		c3RadioButton.setBounds(212, 70, 97, 23);
		contentPane.add(c3RadioButton);
		
		JLabel lblNewLabel = new JLabel(" Choose a level:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(10, 175, 187, 14);
		contentPane.add(lblNewLabel);
		
		final JRadioButton easyRadioButton = new JRadioButton("Easy");
		easyRadioButton.setSelected(true);
		levelRadioGroup.add(easyRadioButton);
		easyRadioButton.setBounds(212, 174, 97, 23);
		contentPane.add(easyRadioButton);
		
		final JRadioButton mediumRadioButton = new JRadioButton("Medium");
		levelRadioGroup.add(mediumRadioButton);
		mediumRadioButton.setBounds(212, 200, 97, 23);
		contentPane.add(mediumRadioButton);
		
		final JRadioButton hardRadioButton = new JRadioButton("Hard");
		levelRadioGroup.add(hardRadioButton);
		hardRadioButton.setBounds(212, 226, 97, 23);
		contentPane.add(hardRadioButton);
		
		JPanel categoryPanel = new JPanel();
		categoryPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		categoryPanel.setBounds(10, 11, 311, 144);
		contentPane.add(categoryPanel);
		categoryPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel levelPanel = new JPanel();
		levelPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		levelPanel.setBounds(10, 166, 311, 168);
		contentPane.add(levelPanel);
		Utils.setBackground(levelPanel, "src/images/cat.jpg");
		
		JButton btnNewButton = new JButton("PLAY");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String level;
				String category;
				if(easyRadioButton.isSelected()) level = "easy";
				if(mediumRadioButton.isSelected()) level = "medium";
				if(hardRadioButton.isSelected()) level = "hard";
				
				if(c1RadioButton.isSelected()) category = "Category 1";
				if(c2RadioButton.isSelected()) category = "Category 2";
				if(c3RadioButton.isSelected()) category = "Category 3";
				
				setVisible(false);
			}
		});
		btnNewButton.setBounds(644, 358, 130, 47);
		contentPane.add(btnNewButton);
		
	}
}
