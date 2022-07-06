package model.entities;

import java.rmi.AccessException;
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

		if (checkIn == null)
			throw new IllegalAccessError("Data de checkIn não encontrada");
		
		if (checkOut == null) {
			this.checkOut = null;
			inderteminate = true;
		} else {
			this.checkOut = checkOut;
			inderteminate = false;
		}
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now))
			throw new IllegalArgumentException("Não é possivel fazer reservas em datas passadas");
		else if (checkOut.before(checkIn))
			throw new IllegalArgumentException("checkOut deve ser posterior a data de checkIn");
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
