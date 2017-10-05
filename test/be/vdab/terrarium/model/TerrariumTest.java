package be.vdab.terrarium.model;

import static org.junit.Assert.*;

import org.junit.Before;

import be.vdab.terrarium.controller.Controller;
import org.junit.Test;

public class TerrariumTest {

	private Controller controller;

	@Before
	public void before() {
		controller = new Controller();
		controller.initMatrix(6,6);
		controller.initStartOrganismen();
	}

	@Test
	public void getAantalPlantenIs4() {
		assertEquals(4, controller.getTerrarium().getAantalPlanten());
	}

	@Test
	public void getAantalHerbivoren() throws Exception {
		assertEquals(5, controller.getTerrarium().getAantalHerbivoren());
	}

	@Test
	public void getAantalCarnivoren() {
		assertEquals(3, controller.getTerrarium().getAantalCarnivoren());
	}

}