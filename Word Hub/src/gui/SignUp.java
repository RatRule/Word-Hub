package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import logic.UserLogic;
import logic.UserLogic.UserStatus;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField signupField;
	private JPasswordField passwordField;
	private JButton signUpButton;
	private JLabel labelUsername;
	private JLabel labelPassword;
	private JPasswordField confirmPassField;
	private JLabel confirmPassLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 454);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		signupField = new JTextField();
		signupField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		signupField.setBounds(61, 112, 354, 30);
		contentPane.add(signupField);
		signupField.setColumns(10);
		signupField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				labelUsername.setText("");
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel lblUsername = new JLabel("Create a Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblUsername.setBounds(61, 97, 242, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Create a password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblPassword.setBounds(61, 156, 184, 23);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(61, 178, 354, 30);
		passwordField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				labelPassword.setText("");
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				matchPassword();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		contentPane.add(passwordField);
		
		signUpButton = new JButton("SIGNUP & PLAY\r\n");
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUser();
			}
		});
		signUpButton.setEnabled(false);
		signUpButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		signUpButton.setBounds(582, 325, 149, 30);
		contentPane.add(signUpButton);
		
		labelUsername = new JLabel("");
		labelUsername.setForeground(new Color(255, 0, 0));
		labelUsername.setBounds(323, 142, 172, 14);
		contentPane.add(labelUsername);
		
		labelPassword = new JLabel("");
		labelPassword.setBounds(323, 208, 158, 14);
		contentPane.add(labelPassword);
		
		JButton backButton = new JButton("<");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				back();
			}
		});
		backButton.setBounds(10, 11, 41, 23);
		contentPane.add(backButton);
		
		JLabel lblWelcomeToWordhub = new JLabel("Welcome to Wordhub registration, let's get started");
		lblWelcomeToWordhub.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblWelcomeToWordhub.setBounds(61, 11, 695, 23);
		contentPane.add(lblWelcomeToWordhub);
		
		JLabel labelConfirmPass = new JLabel("Confirm password:");
		labelConfirmPass.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		labelConfirmPass.setBounds(61, 228, 184, 23);
		contentPane.add(labelConfirmPass);
		
		confirmPassField = new JPasswordField();
		confirmPassField.setBounds(61, 252, 354, 30);
		contentPane.add(confirmPassField);
		
		confirmPassLabel = new JLabel("");
		confirmPassLabel.setForeground(Color.RED);
		confirmPassLabel.setBounds(321, 293, 174, 14);
		contentPane.add(confirmPassLabel);

        confirmPassField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}	
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				matchPassword();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
	}
	
	public void matchPassword() {
		if(String.valueOf(confirmPassField.getPassword()).equals("")) {
			confirmPassLabel.setText("");
			return;
		}
		
		if(String.valueOf(passwordField.getPassword()).equals(String.valueOf(confirmPassField.getPassword()))) {
			signUpButton.setEnabled(true);
			confirmPassLabel.setText("Passwords match");
		}else {
			signUpButton.setEnabled(false);
			confirmPassLabel.setText("Passwords do not match");
		}
		}
	
	public void addUser() {		
		UserLogic userLogic=new UserLogic();
		UserStatus userStatus = userLogic.addUser(signupField.getText(),String.valueOf(passwordField.getPassword()));

		if(userStatus==UserStatus.USERNAME_INVALID)
			labelUsername.setText("Enter a Username");
		if(userStatus==UserStatus.PASSWORD_INVALID)
			labelPassword.setText("Enter a Password");
		if(userStatus==UserStatus.USER_EXISTS)
			labelUsername.setText("Username Taken");
			
		
	}
	public void back() {
		this.setVisible(false);
		
		Home home=new Home();
		home.show();
		
		
	}
}

