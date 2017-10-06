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
	private JPanel panel_2;
	private JPanel pane_1;

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
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblUsername.setBounds(61, 97, 242, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Create a password:");
		lblPassword.setForeground(Color.WHITE);
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
		
		signUpButton = new JButton("REGISTER\r\n");
		signUpButton.setBackground(Color.BLACK);
		signUpButton.setForeground(Color.WHITE);
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUser();
				goToLogin();
				
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
		backButton.setForeground(Color.WHITE);
		backButton.setBackground(Color.BLACK);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				back();
			}
		});
		backButton.setBounds(10, 382, 41, 23);
		contentPane.add(backButton);
		
		JLabel labelConfirmPass = new JLabel("Confirm password:");
		labelConfirmPass.setForeground(Color.WHITE);
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
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0, 125));
		panel_2.setBounds(49, 62, 491, 269);
		contentPane.add(panel_2);
		
		JLabel lblWelcomeToWordhub = new JLabel("Welcome to Wordhub registration, let's get started");
		lblWelcomeToWordhub.setBounds(49, 11, 479, 30);
		contentPane.add(lblWelcomeToWordhub);
		lblWelcomeToWordhub.setBackground(Color.WHITE);
		lblWelcomeToWordhub.setForeground(Color.WHITE);
		lblWelcomeToWordhub.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		
		pane_1 = new JPanel();
		pane_1.setBackground(new Color(0, 0, 0, 125));
		pane_1.setBounds(49, 11, 491, 40);
		contentPane.add(pane_1);

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
        Utils.setBackground(this, "src/images/homeBackground.jpg");
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
	public void goToLogin() {
		this.setVisible(false);
		
		Login login=new Login();
		login.setVisible(true);
		login.changeLabel("Your account has been created,login to continue");
		
		
	}
	public void back() {
		this.setVisible(false);
		
		Home home=new Home();
		home.show();
		
		
	}
}

