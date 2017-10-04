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
	
	@Test
	public void testBeweegNaarRechts() {
		System.out.println("testBeweegNaarRechts");
		controller.initMatrix();
		
		controller.plaatsOrganisme(new Plant(), 1, 0);
		Herbivoor herbivoor = new Herbivoor();
		controller.plaatsOrganisme(herbivoor, 0, 0);

		System.out.println(controller.getTerrarium());

		herbivoor.beweeg();
		System.out.println(controller.getTerrarium());

		System.out.println(herbivoor.getCel().getY());
		System.out.println(herbivoor.getCel().getX());
		assertEquals(0, herbivoor.getCel().getY());
		assertEquals(1, herbivoor.getCel().getX());
	}
	
	@Test
	public void testBeweegNaarLinks() {
		System.out.println("testBeweegNaarLinks");
		controller.initMatrix();
		
		controller.plaatsOrganisme(new Herbivoor(), 0, 2);
		controller.plaatsOrganisme(new Herbivoor(), 1, 1);
		Herbivoor herbivoor = new Herbivoor();
		controller.plaatsOrganisme(herbivoor, 0, 1);

		System.out.println(controller.getTerrarium());

		herbivoor.beweeg();

		System.out.println(controller.getTerrarium());

		assertEquals(0, herbivoor.getCel().getY());
		assertEquals(0, herbivoor.getCel().getX());
	}
	
	@Test
	public void testBeweegNaarBoven() {
		System.out.println("testBeweegNaarBoven");
		controller.initMatrix();
		
		controller.plaatsOrganisme(new Herbivoor(), 1, 0);
		controller.plaatsOrganisme(new Herbivoor(), 1, 2);
		controller.plaatsOrganisme(new Herbivoor(), 2, 1);
		Herbivoor herbivoor = new Herbivoor();
		controller.plaatsOrganisme(herbivoor, 1, 1);

		System.out.println(controller.getTerrarium());

		herbivoor.beweeg();

		System.out.println(controller.getTerrarium());

		assertEquals(0, herbivoor.getCel().getY());
		assertEquals(1, herbivoor.getCel().getX());
	}
	
	
	@Test
	public void testBeweegNaarBeneden() {
		System.out.println("testBeweegNaarBeneden");
		controller.initMatrix();
		
		controller.plaatsOrganisme(new Herbivoor(), 0, 0);
		controller.plaatsOrganisme(new Herbivoor(), 0, 2);
		Herbivoor herbivoor = new Herbivoor();
		controller.plaatsOrganisme(herbivoor, 0, 1);

		System.out.println(controller.getTerrarium());

		herbivoor.beweeg();

		System.out.println(controller.getTerrarium());

		assertEquals(1, herbivoor.getCel().getY());
		assertEquals(1, herbivoor.getCel().getX());
	}
	
	@Test
	public void testBeweegNiet() {
		System.out.println("testBeweegNiet");
		controller.initMatrix();
		
		controller.plaatsOrganisme(new Herbivoor(), 0, 0);
		controller.plaatsOrganisme(new Herbivoor(), 0, 2);
		controller.plaatsOrganisme(new Herbivoor(), 1, 1);
		Herbivoor herbivoor = new Herbivoor();
		controller.plaatsOrganisme(herbivoor, 0, 1);

		System.out.println(controller.getTerrarium());

		herbivoor.beweeg();

		System.out.println(controller.getTerrarium());

		assertEquals(0, herbivoor.getCel().getY());
		assertEquals(1, herbivoor.getCel().getX());
	}
	
	

}