package be.vdab.terrarium.model;

import be.vdab.terrarium.controller.Controller;
import be.vdab.terrarium.view.Console;

import org.junit.Test;

import static org.junit.Assert.*;

public class DierTest {
	Controller controller = new Controller();

	@Test
	public void testHerbivoorEetPlant() {
		System.out.println("testHerbivoorEetPlant");
		controller.initMatrix();

		Herbivoor herbivoor = new Herbivoor();

		controller.plaatsOrganisme(herbivoor, 0, 0);
		controller.plaatsOrganisme(new Plant(), 0, 1);

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		assertEquals(1, controller.getAantalHerbivoren());
		assertEquals(1, controller.getAantalPlanten());

		herbivoor.ageer();

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		assertEquals(1, controller.getAantalHerbivoren());
		assertEquals(0, controller.getAantalPlanten());
	}

	@Test
	public void testCarnivoorEetHerbivoor() {
		System.out.println("testCarnivoorEetHerbivoor");
		controller.initMatrix();
		Carnivoor carnivoor = new Carnivoor();

		controller.plaatsOrganisme(carnivoor, 0, 0);
		controller.plaatsOrganisme(new Herbivoor(), 0, 1);

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));
		assertEquals(1, controller.getAantalCarnivoren());
		assertEquals(1, controller.getAantalHerbivoren());

		carnivoor.ageer();

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		assertEquals(1, controller.getAantalCarnivoren());
		assertEquals(0, controller.getAantalHerbivoren());

	}

	@Test
	public void testHerbivorenVrijen() {
		System.out.println("testHerbivorenVrijen");
		controller.initMatrix();

		Herbivoor herbivoor = new Herbivoor();

		controller.plaatsOrganisme(herbivoor, 4, 2);
		controller.plaatsOrganisme(new Herbivoor(), 4, 3);

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		assertEquals(2, controller.getAantalHerbivoren());

		herbivoor.ageer();
		Terrarium.INSTANCE.voegBabyHerbivorenToe();

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		assertEquals(3, controller.getAantalHerbivoren());

	}

}