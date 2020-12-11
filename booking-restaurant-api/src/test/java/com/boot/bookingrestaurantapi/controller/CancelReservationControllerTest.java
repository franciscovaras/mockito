package com.boot.bookingrestaurantapi.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.bookingrestaurantapi.controllers.CancelReservationController;
import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.responses.BookingResponse;
import com.boot.bookingrestaurantapi.services.CancelReservationService;

public class CancelReservationControllerTest {
	
	private static final String RESERVATION_DELETE ="LOCATOR_DELETED";
	private static final String LOCATOR ="BURGER 3";
	private static final String SUCCES_STATUS = "Succes";
	private static final String SUCCES_CODE = "200 OK";
	private static final String OK = "OK";
	
	@Mock
	CancelReservationService cancelReservationService;
	
	@InjectMocks
	CancelReservationController cancelReservationController;
	
	@Before
	public void init() throws BookingException {
		MockitoAnnotations.initMocks(this);
		
		when(cancelReservationService.deleteReservation(LOCATOR)).thenReturn(RESERVATION_DELETE);
	}
	
	@Test
	public void CdeleteReservationTest() throws BookingException{
		
		final BookingResponse<String> response = cancelReservationController.deleteReservation(LOCATOR);
		
		assertEquals(response.getCode(), SUCCES_CODE);
		assertEquals(response.getData(), RESERVATION_DELETE);
		assertEquals(response.getMessage(), OK);
		assertEquals(response.getStatus(), SUCCES_STATUS);
	}
}
