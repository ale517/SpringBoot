package com.alejandro.reservations.web.application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alejandro.reservations.business.domain.RoomReservation;
import com.alejandro.reservations.business.service.ReservationService;

@Controller
@RequestMapping(value = "/reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@RequestMapping(method = RequestMethod.GET)
	public String getReservations(@RequestParam(value = "date", required = false) String dataString, Model model) {

		

		List<RoomReservation> roomReservationList = reservationService.getRoomReservationsForDate(dataString);	
		model.addAttribute("roomReservations", roomReservationList);
		
		//reservationService.getRoomReservationsForDateDB(date);
		
		return "reservations";
	}

}
