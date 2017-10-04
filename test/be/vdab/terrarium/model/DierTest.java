package be.vdab.terrarium.model;

import be.vdab.terrarium.controller.Controller;
import org.junit.Test;

import static org.junit.Assert.*;

public class DierTest {
	Controller controller = new Controller();

	@Test
	public void testHerbivoorEetPlant() {
		System.out.println("testHerbivoorEetPlant");
		controller.initMatrix();
		controller.plaatsOrganisme(new Herbivoor(), 0, 0);
		controller.plaatsOrganisme(new Plant(), 0, 1);

		System.out.println(controller.getTerrarium());

		assertEquals(1, controller.getAantalHerbivoren());
		assertEquals(1, controller.getAantalPlanten());

		controller.dagActies("Herbivoor");

		System.out.println(controller.getTerrarium());

		assertEquals(1, controller.getAantalHerbivoren());
		assertEquals(0, controller.getAantalPlanten());
	}

	@Test
	public void testCarnivoorEetHerbivoor() {
		System.out.println("testCarnivoorEetHerbivoor");
		controller.initMatrix();
		controller.plaatsOrganisme(new Carnivoor(), 0, 0);
		controller.plaatsOrganisme(new Herbivoor(), 0, 1);

		System.out.println(controller.getTerrarium());

		assertEquals(1, controller.getAantalCarnivoren());
		assertEquals(1, controller.getAantalHerbivoren());

		controller.dagActies();

		System.out.println(controller.getTerrarium());

		assertEquals(1, controller.getAantalCarnivoren());
		assertEquals(0, controller.getAantalHerbivoren());

	}

	@Test
	public void testHerbivorenVrijen() {
		System.out.println("testHerbivorenVrijen");
		controller.initMatrix();
		controller.plaatsOrganisme(new Herbivoor(), 4, 2);
		controller.plaatsOrganisme(new Herbivoor(), 4, 3);

		System.out.println(controller.getTerrarium());

		assertEquals(2, controller.getAantalHerbivoren());

		controller.dagActies();

		System.out.println(controller.getTerrarium());

		assertEquals(3, controller.getAantalHerbivoren());

	}

}