package be.vdab.terrarium.model;

import be.vdab.terrarium.controller.Controller;
import be.vdab.terrarium.view.console.Console;

import org.junit.Test;

import static org.junit.Assert.*;

public class DierTest {
	Controller controller = new Controller();

	@Test
	public void testHerbivoorEetPlant() {
		System.out.println("testHerbivoorEetPlant");
		controller.initMatrix(6, 6);

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
		controller.initMatrix(6,6);
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
        controller.initMatrix(6,6);

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

	@Test
	public void testBeweegNaarRechts() {
		System.out.println("testBeweegNaarRechts");
        controller.initMatrix(6,6);

		controller.plaatsOrganisme(new Plant(), 1, 0);
		Herbivoor herbivoor = new Herbivoor();
		controller.plaatsOrganisme(herbivoor, 0, 0);

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		herbivoor.beweeg();
		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		System.out.println(herbivoor.getCel().getY());
		System.out.println(herbivoor.getCel().getX());
		assertEquals(0, herbivoor.getCel().getY());
		assertEquals(1, herbivoor.getCel().getX());
	}

	@Test
	public void testBeweegNaarLinks() {
		System.out.println("testBeweegNaarLinks");
        controller.initMatrix(6,6);

		controller.plaatsOrganisme(new Herbivoor(), 0, 2);
		controller.plaatsOrganisme(new Herbivoor(), 1, 1);
		Herbivoor herbivoor = new Herbivoor();
		controller.plaatsOrganisme(herbivoor, 0, 1);

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		herbivoor.beweeg();

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		assertEquals(0, herbivoor.getCel().getY());
		assertEquals(0, herbivoor.getCel().getX());
	}

	@Test
	public void testBeweegNaarBoven() {
		System.out.println("testBeweegNaarBoven");
        controller.initMatrix(6,6);

		controller.plaatsOrganisme(new Herbivoor(), 1, 0);
		controller.plaatsOrganisme(new Herbivoor(), 1, 2);
		controller.plaatsOrganisme(new Herbivoor(), 2, 1);
		Herbivoor herbivoor = new Herbivoor();
		controller.plaatsOrganisme(herbivoor, 1, 1);

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		herbivoor.beweeg();

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		assertEquals(0, herbivoor.getCel().getY());
		assertEquals(1, herbivoor.getCel().getX());
	}

	@Test
	public void testBeweegNaarBeneden() {
		System.out.println("testBeweegNaarBeneden");
        controller.initMatrix(6,6);

		controller.plaatsOrganisme(new Herbivoor(), 0, 0);
		controller.plaatsOrganisme(new Herbivoor(), 0, 2);
		Herbivoor herbivoor = new Herbivoor();
		controller.plaatsOrganisme(herbivoor, 0, 1);

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		herbivoor.beweeg();

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		assertEquals(1, herbivoor.getCel().getY());
		assertEquals(1, herbivoor.getCel().getX());
	}

	@Test
	public void testBeweegNiet() {
		System.out.println("testBeweegNiet");
        controller.initMatrix(6,6);

		controller.plaatsOrganisme(new Herbivoor(), 0, 0);
		controller.plaatsOrganisme(new Herbivoor(), 0, 2);
		controller.plaatsOrganisme(new Herbivoor(), 1, 1);
		Herbivoor herbivoor = new Herbivoor();
		controller.plaatsOrganisme(herbivoor, 0, 1);

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		herbivoor.beweeg();

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		assertEquals(0, herbivoor.getCel().getY());
		assertEquals(1, herbivoor.getCel().getX());
	}

	@Test
	public void testMagicJump() {
		System.out.println("testMagicJump");
        controller.initMatrix(6,6);

		Herbivoor herbivoor = new Herbivoor();
		controller.plaatsOrganisme(herbivoor, 0, controller.getTerrarium().getBreedte() - 1);
		assertEquals(1, controller.getTerrarium().getAantalHerbivoren()); // check aantal herbivoren

		int oudeX = herbivoor.getCel().getX();
		int oudeY = herbivoor.getCel().getY();

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));
		herbivoor.beweeg();
		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		int nieuweX = herbivoor.getCel().getX();
		int nieuweY = herbivoor.getCel().getY();

		assertTrue((oudeX != nieuweX) || (oudeY != nieuweY));
		assertEquals(1, controller.getTerrarium().getAantalHerbivoren()); // check aantal herbivoren
	}

	@Test
	public void testVechtRechtseZwakker() {
		System.out.println("testVechtRechtseZwakker");
        controller.initMatrix(6,6);

		Carnivoor carnivoorSterk = new Carnivoor(2);
		Carnivoor carnivoorZwak = new Carnivoor(1);
		controller.plaatsOrganisme(carnivoorSterk, 0, 0);
		controller.plaatsOrganisme(carnivoorZwak, 0, 1);

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		Cel celZwak = carnivoorZwak.getCel();
		carnivoorSterk.vecht();

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		assertEquals(3, carnivoorSterk.getLevenskracht());

		assertEquals(null, celZwak.getOrganisme());

	}

	@Test
	public void testVechtLinkseZwakker() {
		System.out.println("testVechtLinkseZwakker");
        controller.initMatrix(6,6);

		Carnivoor carnivoorSterk = new Carnivoor(2);
		Carnivoor carnivoorZwak = new Carnivoor(1);
		controller.plaatsOrganisme(carnivoorSterk, 0, 1);
		controller.plaatsOrganisme(carnivoorZwak, 0, 0);

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		Cel celZwak = carnivoorZwak.getCel();
		carnivoorZwak.vecht();

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		assertEquals(3, carnivoorSterk.getLevenskracht());

		assertEquals(null, celZwak.getOrganisme());

	}

	@Test
	public void testVechtOnbeslist() {
		System.out.println("testVechtOnbeslist");
        controller.initMatrix(6,6);

		Carnivoor carnivoorSterk = new Carnivoor(2);
		Carnivoor carnivoorZwak = new Carnivoor(2);
		controller.plaatsOrganisme(carnivoorSterk, 0, 1);
		controller.plaatsOrganisme(carnivoorZwak, 0, 0);

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		Cel celZwak = carnivoorZwak.getCel();
		carnivoorZwak.vecht();

		System.out.println(Console.getStringRepresentation(controller.getTerrarium()));

		assertEquals(2, carnivoorSterk.getLevenskracht());
		assertEquals(2, carnivoorZwak.getLevenskracht());

	}

}