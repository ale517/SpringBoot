package com.alejandro.reservations.business.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandro.reservations.business.domain.RoomReservation;
import com.alejandro.reservations.data.entity.Guest;
import com.alejandro.reservations.data.entity.Reservation;
import com.alejandro.reservations.data.entity.Room;
import com.alejandro.reservations.data.repository.GuestRepository;
import com.alejandro.reservations.data.repository.ReservationRepository;
import com.alejandro.reservations.data.repository.RoomRepository;

@Service
public class ReservationService {

	private RoomRepository roomRepository;
	private GuestRepository guestRepository;
	private ReservationRepository reservationRepository;

	@Autowired
	public ReservationService(ReservationRepository reservationRepository,RoomRepository roomRepository, GuestRepository guestRepository) {
		super();

		this.roomRepository=roomRepository;
		this.guestRepository=guestRepository;
		this.reservationRepository = reservationRepository;

	}

	public List<RoomReservation> getRoomReservationsForDate(String dataString) {
		
		
		
		LocalDate date = LocalDate.now();

		if (dataString != null) {
			try {
				date = LocalDate.parse(dataString);
			} catch (java.time.format.DateTimeParseException e) {
				
			}
		}
		
		

		Map<Long, RoomReservation> roomReservationMap = new HashMap<>();

		Iterable<Room> rooms = this.roomRepository.findAll();

		rooms.forEach(room -> {

			RoomReservation roomReservation = new RoomReservation();
			roomReservation.setRoomId(room.getId());
			roomReservation.setRoomName(room.getName());
			roomReservation.setRoomNumber(room.getNumber());
			roomReservationMap.put(room.getId(), roomReservation);
		});

		Iterable<Reservation> reservations = this.reservationRepository.findByDate(Date.valueOf(date));

		LocalDate date2=date;
		
		if (reservations != null) {

			reservations.forEach(reservation -> {

				Guest guest = this.guestRepository.findOne(reservation.getGuest().getId());
				if (guest != null) {
					RoomReservation roomReservation = roomReservationMap.get(reservation.getRoom().getId());
					roomReservation.setDate(date2);
					roomReservation.setFirstName(guest.getFirstName());
					roomReservation.setLastName(guest.getLastName());
					roomReservation.setGuestId(guest.getId());
				}

			});
		}

		List<RoomReservation> roomReservations = new ArrayList<>();

		for (Long roomId : roomReservationMap.keySet()) {
			roomReservations.add(roomReservationMap.get(roomId));
		}

		return roomReservations;

	}

	public List<RoomRepository> getRoomReservationsForDateDB(LocalDate date) {

		/*
		 * List<RoomReservation> roomReservations = new ArrayList<>();
		 * 
		 * 
		 * Iterable<RoomRepository> list=roomRepository.
		 * 
		 * return roomReservations;
		 */
		return null;
	}

}
