package com.example.demo.cortroller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.demo.controller.IndexController;

public class IndexControllerTest {
	
	@Test
	public void welcomeTest() {
		
		IndexController indexController = new IndexController();
		String[] paramArray = null;
		String resultActual = "El array esta vacio";
		String resultReal = indexController.welcome(paramArray);
		assertEquals(resultActual, resultReal);
	}
	
	@Test
	public void arraySinDatosTest() {
		
		IndexController indexController = new IndexController();
		String[] paramArray = new String[3];
		String resultActual = "param[0]null\n" + "param[1]null\n" + "param[2]null\n";
		String resultReal = indexController.welcome(paramArray);
		assertEquals(resultActual, resultReal);
	}
	
	@Test
	public void arrayConDatosTest() {
		
		IndexController indexController = new IndexController();
		String[] paramArray = new String[] {"java","desde","0"};
		String resultActual = "param[0]Java\n" + "param[1]desde\n" + "param[2]0\n";
		String resultReal = indexController.welcome(paramArray);
		assertEquals(resultActual, resultReal);
	}

}
