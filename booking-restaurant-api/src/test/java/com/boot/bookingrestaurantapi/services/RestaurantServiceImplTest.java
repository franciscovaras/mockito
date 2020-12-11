package com.boot.bookingrestaurantapi.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.bookingrestaurantapi.entities.Board;
import com.boot.bookingrestaurantapi.entities.Reservation;
import com.boot.bookingrestaurantapi.entities.Restaurant;
import com.boot.bookingrestaurantapi.entities.Turn;
import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.RestaurantRest;
import com.boot.bookingrestaurantapi.jsons.TurnRest;
import com.boot.bookingrestaurantapi.repositories.RestaurantRepository;
import com.boot.bookingrestaurantapi.services.impl.RestaurantServiceImpl;

public class RestaurantServiceImplTest {
	
	private static final Long RESTAURANT_ID = 1L;
	private static final String GET_ADRESS ="";
	
	private static final Restaurant RESTAURANT = new Restaurant();
	
	private static final String NAME = "burger";
	private static final String DESCRIPTION = "todo tipo de hamburguesa";
	private static final String ADDRESS = "avenida galindo";
	private static final String IMAGE = "www.image.com";
	private static final List<Turn> TURN_LIST = new ArrayList<>();
	private static final List<Board> BOARDS_LIST = new ArrayList<>();
	private static final List<Reservation> RESERVATIONS_LIST = new ArrayList<>();
	
	@Mock
	RestaurantRepository restaurantRepository;
	
	@InjectMocks
	RestaurantServiceImpl restaurantServiceImpl;

	
	@Before
	public void init() throws BookingException {
		MockitoAnnotations.initMocks(this);
		
		RESTAURANT.setName(NAME);
		RESTAURANT.setAddress(ADDRESS);
		RESTAURANT.setDescription(DESCRIPTION);
		RESTAURANT.setId(RESTAURANT_ID);
		RESTAURANT.setImage(IMAGE);
		RESTAURANT.setTurns(TURN_LIST);
		RESTAURANT.setBoards(BOARDS_LIST);
		RESTAURANT.setReservations(RESERVATIONS_LIST);
	}
	
	@Test
	public void getRestaurantByIdTest() throws BookingException {
		when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(Optional.of(RESTAURANT));
		restaurantServiceImpl.getRestaurantById(RESTAURANT_ID);
		
	}
	
	@Test(expected = BookingException.class)
	public void getRestaurantByIdTestError() throws BookingException {
		when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(Optional.empty());
		restaurantServiceImpl.getRestaurantById(RESTAURANT_ID);
		fail();
	}
	
	@Test
	public void getRestaurantsTest() throws BookingException {
		final Restaurant restaurant = new Restaurant();
		when(restaurantRepository.findAll()).thenReturn(Arrays.asList(restaurant));
		final List<RestaurantRest> response = restaurantServiceImpl.getRestaurants();
		assertNotNull(response);
		assertFalse(response.isEmpty());
		assertEquals(response.size(), 1);
	}
		
}
