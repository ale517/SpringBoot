package com.alejandro.reservations.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "RESERVATION")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RESERVATION_ID")
	private long id;

	@OneToOne
	@JoinColumn(name="ROOM_ID")
	private Room room;

	@ManyToOne 
	@JoinColumn(name = "GUEST_ID") 
	private Guest guest;
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}


	public Guest getGuest() {
		return guest;
	}


	public void setGuest(Guest guest) {
		this.guest = guest;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	@Column(name = "RES_DATE")
	private Date date;


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}