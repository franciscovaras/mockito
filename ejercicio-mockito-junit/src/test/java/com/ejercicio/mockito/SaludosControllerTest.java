package com.ejercicio.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ejercicio.mockito.controllers.SaludosController;
import com.ejercicio.mockito.services.SaludosService;

public class SaludosControllerTest {
	
	@Mock
	SaludosService saludosService;
	
	@InjectMocks
	SaludosController saludosController;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		when(saludosService.saludo()).thenReturn("Buenos dias");
	}
	
	@Test
	public void darSaludoTest() {
		assertEquals("Buenos dias", saludosController.darSaludo());
	}
}
