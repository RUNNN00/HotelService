package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Hospede hospede;
	private Date checkIn;
	private Date checkOut;
	private boolean inderteminate;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Hospede hospede, Date checkIn, Date checkOut) {
		this.hospede = hospede;
		this.checkIn = checkIn;

		if (checkOut == null) {
			this.checkOut = null;
			inderteminate = true;
		} else {
			this.checkOut = checkOut;
			inderteminate = false;
		}
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		if (inderteminate == true)
			return -1;
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date in, Date out) {
		checkIn = in;
		checkOut = out;
	}
	
	public String getHospedeName() {
		return hospede.getNome();
	}

	@Override
	public String toString() {
		String description = "Reservation" + "\n"
				+ "Hospede: " + hospede.getNome() + "\n"
				+ "check-In: " + sdf.format(checkIn) + "\n"
				+ "check-Out: " + sdf.format(checkOut) + "\n"
				+ "Duration: " + (inderteminate ? "indeterminado" : duration() + "daily");

		return description;
	}
}
