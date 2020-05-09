package Reservations;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MakeReservations {

	private JFrame frame;
	private JTextField notesTextField;
	private JTextField prefixNumberTextField;
	private JTextField mobileNumberTextField;
	private JTextField surnameTextField;
	private JTextField nameTextField;
	private JButton submitButton;
	private String selectedDate = "2020-05-01";
	private String selectedTime = "LUNCH";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MakeReservations window = new MakeReservations();
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
	public MakeReservations() {
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
		
		mobileNumberTextField = new JTextField();
		mobileNumberTextField.setBounds(562, 196, 114, 20);
		frame.getContentPane().add(mobileNumberTextField);
		mobileNumberTextField.setColumns(10);
		
		surnameTextField = new JTextField();
		surnameTextField.setBounds(509, 153, 114, 20);
		frame.getContentPane().add(surnameTextField);
		surnameTextField.setColumns(10);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(509, 111, 114, 20);
		frame.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		prefixNumberTextField = new JTextField();
		prefixNumberTextField.setBounds(510, 196, 42, 20);
		frame.getContentPane().add(prefixNumberTextField);
		prefixNumberTextField.setColumns(3);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(388, 112, 67, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Surname");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(388, 156, 67, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mobile");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(388, 199, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Notes");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(388, 245, 56, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date Selection");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(67, 83, 100, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JComboBox dateComboBox = new JComboBox();
		dateComboBox.setMaximumRowCount(10);
		dateComboBox.setModel(new DefaultComboBoxModel(new String[] {"2020-05-01", "2020-05-02", "2020-05-03", "2020-05-04", "2020-05-05", "2020-05-06", "2020-05-07", "2020-05-08", "2020-05-09", "2020-05-10", "2020-05-11", "2020-05-12", "2020-05-13", "2020-05-14", "2020-05-15", "2020-05-16", "2020-05-17", "2020-05-18", "2020-05-19", "2020-05-20", "2020-05-21", "2020-05-22", "2020-05-23", "2020-05-24", "2020-05-25", "2020-05-26", "2020-05-27", "2020-05-28", "2020-05-29", "2020-05-30", "2020-05-31"}));
		dateComboBox.setBounds(67, 122, 151, 20);
		dateComboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        selectedDate = (String) dateComboBox.getSelectedItem();
		        makeButtonActive(selectedDate, selectedTime);
		    }
		});
		frame.getContentPane().add(dateComboBox);
		
		JLabel lblNewLabel_5 = new JLabel("Time Selection");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(67, 174, 114, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JRadioButton lunchRadioButton = new JRadioButton("LUNCH");
		lunchRadioButton.setActionCommand("LUNCH");
		lunchRadioButton.setSelected(true);
		lunchRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lunchRadioButton.setBounds(67, 221, 109, 23);
		lunchRadioButton.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        selectedTime = "LUNCH";
		        makeButtonActive(selectedDate, selectedTime);
		    }
		});
		frame.getContentPane().add(lunchRadioButton);
		
		JRadioButton dinnerRadioButton = new JRadioButton("DINNER");
		dinnerRadioButton.setActionCommand("DINNER");
		dinnerRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		dinnerRadioButton.setBounds(67, 270, 109, 23);
		dinnerRadioButton.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        selectedTime = "DINNER";
		        makeButtonActive(selectedDate, selectedTime);
		    }
		});
		frame.getContentPane().add(dinnerRadioButton);
		
		ButtonGroup group = new ButtonGroup();
		group.add(dinnerRadioButton);
		group.add(lunchRadioButton);
		
		JLabel lblNewLabel_6 = new JLabel("CUSTOMER INFO");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(504, 51, 156, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton makeReservationButton = new JButton("Make Reservation");
		makeReservationButton.setBounds(6, 6, 151, 29);
		frame.getContentPane().add(makeReservationButton);
		
		JButton listReservationsButton = new JButton("List Reservations");
		listReservationsButton.setBounds(169, 6, 162, 29);
		listReservationsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ReservationList reservationList = new ReservationList();
                frame.setVisible(false); 
            }
        });
		frame.getContentPane().add(listReservationsButton);
		
		notesTextField = new JTextField();
		notesTextField.setBounds(515, 240, 263, 26);
		frame.getContentPane().add(notesTextField);
		notesTextField.setColumns(10);
		
		submitButton = new JButton("MAKE RESERVATION");
		submitButton.setBounds(513, 331, 151, 47);
		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String date = getValueOrDefault((String) dateComboBox.getSelectedItem(), "-");
				String time = getValueOrDefault(group.getSelection().getActionCommand(), "-");
				String name = getValueOrDefault(nameTextField.getText(), "-");
				String surname = getValueOrDefault(surnameTextField.getText(), "-");
				String prefixNumber = getValueOrDefault(prefixNumberTextField.getText(), "111");
				String mobileNumber = getValueOrDefault(mobileNumberTextField.getText(), "1111111");
				String notes = getValueOrDefault(notesTextField.getText(), "-");
				Reservation res = new Reservation(date, time, name, surname, prefixNumber, mobileNumber, notes);
				insert(res);
				makeButtonActive(selectedDate, selectedTime);
			}
		});
		frame.getContentPane().add(submitButton);
		
		frame.setVisible(true);

	}
	
	public void insert(Reservation res) {
		String insertQuery = "INSERT INTO today" + " (date, time, first_name, last_name, area_number, phone_number, notes) VALUES" 
			+ "('" 
			+ res.date 
			+ "', '" 
			+ res.time 
			+ "', '" 
			+ res.name 
			+ "', '" 
			+ res.surname 
			+ "', '" 
			+ res.prefixNumber 
			+ "', '" 
			+ res.mobileNumber 
			+ "', '" 
			+ res.notes 
			+ "');";
		String countQuery = "SELECT COUNT(*) FROM today WHERE date = '" + res.date + "'" + " AND time = '" + res.time + "';";
		try {  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con= DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/reserv?characterEncoding=latin1","root","123456789");  
			Statement stmt=con.createStatement();  
			ResultSet resultSet = stmt.executeQuery(countQuery);
			if (resultSet.next()) {
				int count = resultSet.getInt(1);
				if (count < 8) {
					Boolean isExecuted = stmt.execute(insertQuery);
					JOptionPane.showMessageDialog(null, "Reservation has been made successfully!");
					nameTextField.setText("");
					surnameTextField.setText("");
					prefixNumberTextField.setText("");
					mobileNumberTextField.setText("");
					notesTextField.setText("");
					con.close();
				} else {
					JOptionPane.showMessageDialog(null, "You have reached to the maximum reservations.");
				}
			}
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
				System.out.println(e);
		}  
	}
	
	public void makeButtonActive(String date, String time) {
		String query = "SELECT COUNT(*) FROM today WHERE date = '" + date + "' AND time = '" + time + "';";
		try {  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con= DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/reserv?characterEncoding=latin1","root","123456789");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(query);
			if (rs.next()) {
				int count = rs.getInt(1);
				if (count >= 8) {
					con.close(); 
					submitButton.setVisible(false);
				} else {
					con.close(); 
					submitButton.setVisible(true);
				} 
			} else {
				submitButton.setVisible(true);
			}
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
				System.out.println(e);
				submitButton.setVisible(true);
		}
	}
	
	public static <T> T getValueOrDefault(T value, T defaultValue) {
	    return value == null ? defaultValue : value;
	}
}
