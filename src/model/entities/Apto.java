package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Apto {
	private int number;
	private boolean available;
	private List<Reservation> listReservations;

	public Apto(int number) {
		this.number = number;
		listReservations = new ArrayList<Reservation>();
		available = true;
	}

	public boolean isAvailable() {
		return available;
	}

	public int getNumber() {
		return number;
	}

	public boolean addReservation(Reservation r) {
		available = false;
		return listReservations.add(r);
	}

	public boolean removeReservation(Reservation r) {
		if (!listReservations.remove(r))
			return false;

		if (listReservations.size() <= 0)
			available = true;
		return true;
	}

	public int countReservation() {
		return listReservations.size();
	}
}
