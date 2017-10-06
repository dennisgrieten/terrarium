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
		controller.initStartOrganismen(4,2,5,3);
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

	@Test
	public void isValideAantalOrganismen() {
		assertEquals(true, controller.getTerrarium().isValideAantalOrganismen(2,2,2));
		assertEquals(false , controller.getTerrarium().isValideAantalOrganismen(1,1,1));
		assertEquals(false , controller.getTerrarium().isValideAantalOrganismen(20,20,11));
	}

	@Test
	public void isValideHoogte() throws Exception {
		assertEquals(true, controller.getTerrarium().isValideHoogte(6));
		assertEquals(true, controller.getTerrarium().isValideHoogte(25));
		assertEquals(false, controller.getTerrarium().isValideHoogte(5));
		assertEquals(false, controller.getTerrarium().isValideHoogte(26));
		assertEquals(false, controller.getTerrarium().isValideHoogte(-1));
	}

	@Test
	public void isValideBreedte() throws Exception {
		assertEquals(true, controller.getTerrarium().isValideBreedte(6, 6));
		assertEquals(true, controller.getTerrarium().isValideBreedte(25, 25));
		assertEquals(false, controller.getTerrarium().isValideBreedte(5, 6));
		assertEquals(false, controller.getTerrarium().isValideBreedte(26, 25));
		assertEquals(false, controller.getTerrarium().isValideBreedte(25, -1));
	}

	@Test
	public void isValideAantalNieuwePlanten() throws Exception {
		assertEquals(true, controller.getTerrarium().isValideAantalNieuwePlanten(1));
		assertEquals(false, controller.getTerrarium().isValideAantalNieuwePlanten(2));
	}
}