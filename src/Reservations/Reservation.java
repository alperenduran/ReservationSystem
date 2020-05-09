package Reservations;

public class Reservation {

	String date;
	String time;
	String name;
	String surname;
	String prefixNumber;
	String mobileNumber;
	String notes;
	
	public Reservation(
		String date,
		String time,
		String name,
		String surname,
		String prefixNumber,
		String mobileNumber,
		String notes
	) {
		this.date = date;
		this.time = time;
		this.name = name;
		this.surname = surname;
		this.prefixNumber  = prefixNumber;
		this.mobileNumber = mobileNumber;
		this.notes = notes;
	}
}
