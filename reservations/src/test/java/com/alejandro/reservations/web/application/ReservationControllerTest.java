package com.alejandro.reservations.web.application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.alejandro.reservations.business.domain.RoomReservation;
import com.alejandro.reservations.business.service.ReservationService;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {

	@MockBean
	private ReservationService reservationService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void ReservationControllerTest() throws Exception {

		List<RoomReservation> mockReservationList = new ArrayList<>();

		RoomReservation mockRoomReservation = new RoomReservation();
		mockRoomReservation.setLastName("Test");
		mockRoomReservation.setFirstName("JUnit");
		mockRoomReservation.setDate(LocalDate.parse("2017-01-01"));
		mockRoomReservation.setGuestId(1);
		mockRoomReservation.setRoomNumber("J1");
		mockRoomReservation.setRoomId(100L);
		mockRoomReservation.setRoomName("JUnit Room");
		mockReservationList.add(mockRoomReservation);

		
		given(reservationService.getRoomReservationsForDate(LocalDate.now().toString())).willReturn(mockReservationList);
		
		
        this.mockMvc.perform(get("/reservations?date=2017-01-01")).andExpect(status().isOk()).andExpect(content().string(containsString("Test, JUnit")));
		
	}

}
