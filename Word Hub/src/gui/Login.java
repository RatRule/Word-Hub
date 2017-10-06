package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import logic.Session;
import logic.UserLogic;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField loginField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JLabel label;
	private JLabel lblLoginToWordhub;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		loginField = new JTextField();
		loginField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginField.setBounds(76, 128, 354, 30);
		contentPane.add(loginField);
		loginField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblUsername.setBounds(76, 112, 149, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblPassword.setBounds(76, 211, 127, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(76, 228, 354, 30);
		contentPane.add(passwordField);
		
		JButton backButton = new JButton("<");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				back();
			}
		});
		backButton.setBounds(10, 11, 41, 23);
		contentPane.add(backButton);
		
		loginButton = new JButton("LET'S PLAY\r\n");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginUser();	
			}
		});
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginButton.setBounds(596, 325, 135, 30);
		contentPane.add(loginButton);
		
		label = new JLabel("");
		label.setForeground(Color.RED);
		label.setBounds(314, 259, 256, 14);
		contentPane.add(label);
		
		lblLoginToWordhub = new JLabel("Login to Wordhub ");
		lblLoginToWordhub.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblLoginToWordhub.setBounds(76, 7, 305, 30);
		contentPane.add(lblLoginToWordhub);
	}
		
		public void loginUser() {
			UserLogic userLogic=new UserLogic();
			boolean userValid=userLogic.isUserValid(loginField.getText(),String.valueOf(passwordField.getPassword()));
			if(!userValid){
				label.setText("Incorrect username or password");
			}else {
				Session.setUserId(loginField.getText());
				login();
			}
		}
		public void back() {
			this.setVisible(false);
			
			Home home=new Home();
			home.show();
			
			
		}
		public void login() {
			this.setVisible(false);
			
			MainMenu menu=new MainMenu();
			menu.show();
	}
}


