package com.alejandro.reservations.business.domain;

import java.time.LocalDate;
import java.util.Date;

public class RoomReservation {
	private Long roomId;
	private long guestId;
	private String roomName;
	private String roomNumber;
	private String firstName;
	private String lastName;
	private LocalDate date;
	
	
	
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public long getGuestId() {
		return guestId;
	}
	public void setGuestId(long guestId) {
		this.guestId = guestId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public String getLastName() {
		return lastName;
	}
	public LocalDate getDate() {
		return date;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

	
}
