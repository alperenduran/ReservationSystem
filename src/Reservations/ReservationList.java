package Reservations;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ReservationList {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationList window = new ReservationList();
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
	public ReservationList() {
		initialize();
		get();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 809, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
		
		JButton makeReservationButton = new JButton("Make Reservation");
		makeReservationButton.setBounds(6, 6, 151, 29);
		makeReservationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	MakeReservations makeReservation = new MakeReservations();
                frame.setVisible(false); 
            }
        });
		frame.getContentPane().add(makeReservationButton);
		
		JButton listReservationsButton = new JButton("List Reservations");
		listReservationsButton.setBounds(169, 6, 162, 29);
		frame.getContentPane().add(listReservationsButton);
		
		table = new JTable();
		table.setBounds(95, 204, 797, 365);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 40, 797, 365);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		
		frame.setVisible(true);
	}
	
	public void get() {
		String query = "SELECT date as Date, time as Time , CONCAT(first_name, ' ', last_name) as Name, CONCAT(area_number, '-', phone_number) as Number, notes as Notes FROM today ORDER BY date;";
		try {  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connection = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/reserv?characterEncoding=latin1","root","123456789");  
			Statement statement = connection.createStatement();  
			ResultSet resultSet = statement.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
			
			connection.close();  
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
				e.printStackTrace();
				System.out.println(e);
		}  
	}
}
