package com.boot.bookingrestaurantapi.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.boot.bookingrestaurantapi.entities.Reservation;
import com.boot.bookingrestaurantapi.entities.Restaurant;
import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.repositories.ReservationRespository;
import com.boot.bookingrestaurantapi.services.impl.CancelReservationServiceImpl;

public class CancelReservationServiceImplTest {
	
	private static final Long LOCATOR_ID = 3L;
	private static final Reservation RESERVATION = new Reservation();
	private static final Optional<Reservation> OPTIONAL_RESERVATION = Optional.of(RESERVATION);
	
	private static final Date DATE = new Date();
	private static final Long RESERVATION_ID =5L;
	private static final String LOCATOR ="BURGER 3";
	private static final String TURNO ="TURN_12_004";
	private static final Long PERSON = 30L;
	private static final String LOCATOR_DELETED = "LOCATOR_DELETED";
	
	@Mock
	private ReservationRespository reservationRespository;
	
	@InjectMocks
	CancelReservationServiceImpl cancelReservationServiceImpl;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		
		RESERVATION.setDate(DATE);
		RESERVATION.setId(RESERVATION_ID);
		RESERVATION.setLocator(LOCATOR);
		RESERVATION.setPerson(PERSON);
		//RESERVATION.setRestaurant(RESTAURANT);
		RESERVATION.setTurn(TURNO);
	}
	
	
	@Test
	public void deleteReservationTest() throws BookingException{
		when(reservationRespository.findByLocator(LOCATOR)).thenReturn(OPTIONAL_RESERVATION);
		when(reservationRespository.deleteByLocator(LOCATOR)).thenReturn(OPTIONAL_RESERVATION);
		final String response = cancelReservationServiceImpl.deleteReservation(LOCATOR);
		
		assertEquals(response, LOCATOR_DELETED);
	}
	
	@Test(expected = BookingException.class)
	public void deleteReservationLocatorTestError() throws BookingException{
		when(reservationRespository.findByLocator(LOCATOR)).thenReturn(Optional.empty());
		when(reservationRespository.deleteByLocator(LOCATOR)).thenReturn(OPTIONAL_RESERVATION);
		final String response = cancelReservationServiceImpl.deleteReservation(LOCATOR);
		
		assertEquals(response, LOCATOR_DELETED);
		fail();
	}
	
	@Test(expected = BookingException.class)
	public void deleteReservationfindByLocatorTestError() throws BookingException {
		when(reservationRespository.findByLocator(LOCATOR)).thenReturn(OPTIONAL_RESERVATION);
		Mockito.doThrow(Exception.class).when(reservationRespository).deleteByLocator(LOCATOR);

//.Mockito(OPTIONAL_RESERVATION);
		
		final String response = cancelReservationServiceImpl.deleteReservation(LOCATOR);
		assertEquals(response, LOCATOR_DELETED);
		fail();
	}
	
}
