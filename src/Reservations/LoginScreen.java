package Reservations;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.*;

import javax.swing.SwingConstants;

public class LoginScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
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
	public LoginScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 	frame = new JFrame();
	        frame.setBounds(100, 100, 809, 433);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().setLayout(null);

	        JLabel lblNewLabel = new JLabel("RESERVATIONS");
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
	        lblNewLabel.setBounds(269, 35, 186, 30);
	        frame.getContentPane().add(lblNewLabel);

	        JLabel lblNewLabel_1 = new JLabel("USERNAME");
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        lblNewLabel_1.setBounds(443, 114, 92, 30);
	        frame.getContentPane().add(lblNewLabel_1);

	        JLabel lblNewLabel_2 = new JLabel("PASSWORD");
	        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        lblNewLabel_2.setBounds(443, 181, 92, 30);
	        frame.getContentPane().add(lblNewLabel_2);

	        JTextField textField = new JTextField();
	        textField.setBounds(587, 121, 114, 20);
	        frame.getContentPane().add(textField);
	        textField.setColumns(10);

	        JPasswordField passwordField = new JPasswordField();
	        passwordField.setBounds(587, 188, 114, 20);
	        frame.getContentPane().add(passwordField);

	        JButton btnNewButton = new JButton("LOGIN");
	        btnNewButton.setBounds(493, 260, 114, 41);
	        btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	                MakeReservations makeReservation = new MakeReservations();
	                frame.setVisible(false); 
	            }
	        });

	        frame.getContentPane().add(btnNewButton);
	}
}
