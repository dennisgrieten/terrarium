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
    public void getAantalCarnivoren() throws Exception {  	
        assertEquals(3, controller.getTerrarium().getAantalCarnivoren());
    }

//	@Test
//	public void beweegNaarBovenKan() {
//		controller.getTerrarium().plaatsOrganisme(null, 0, 1);
//		assertEquals(true, Terrarium.INSTANCE.beweegNaarBovenOK(1, 1));
//	}
//	
//	@Test
//	public void beweegNaarBovenKanNietWegensBezet() {
//		controller.getTerrarium().plaatsOrganisme(new Carnivoor(), 0, 1);
//		assertEquals(false, Terrarium.INSTANCE.beweegNaarBovenOK(1, 1));
//	}
//
//	@Test
//	public void beweegNaarBovenKanNietWegensGrens() {
//		assertEquals(false, Terrarium.INSTANCE.beweegNaarBovenOK(0, 1));
//	}
//
//	@Test
//	public void beweegNaarOnderKan() {
//		controller.getTerrarium().plaatsOrganisme(null, 1, 1);
//		assertEquals(true, Terrarium.INSTANCE.beweegNaarOnderOK(0, 1));
//	}
//	
//	@Test
//	public void beweegNaarOnderKanNietWegensBezet() {
//		controller.getTerrarium().plaatsOrganisme(new Carnivoor(), 5, 1);
//		assertEquals(false, Terrarium.INSTANCE.beweegNaarOnderOK(4, 1));
//	}
//
//	@Test
//	public void beweegNaarOnderKanNietWegensGrens() {
//		assertEquals(false, Terrarium.INSTANCE.beweegNaarOnderOK(6, 1));
//	}
//	
//	
//	@Test
//	public void beweegNaarLinksKan() {
//		controller.getTerrarium().plaatsOrganisme(null, 0, 0);
//		controller.getTerrarium().plaatsOrganisme(new Carnivoor(), 0, 1);
//		assertEquals(true, Terrarium.INSTANCE.beweegNaarLinksOK(0, 1));
//	}
//	
//	@Test
//	public void beweegNaarLinksKanNietWegensBezet() {
//		controller.getTerrarium().plaatsOrganisme(new Carnivoor(), 0, 1);
//		controller.getTerrarium().plaatsOrganisme(new Carnivoor(), 0, 2);
//		assertEquals(false, Terrarium.INSTANCE.beweegNaarLinksOK(0, 2));
//	}
//
//	@Test
//	public void beweegNaarLinksKanNietWegensGrens() {
//		assertEquals(false, Terrarium.INSTANCE.beweegNaarLinksOK(0, 0));
//	}
//	
//	
//	@Test
//	public void beweegNaarRechtsKan() {
//		controller.getTerrarium().plaatsOrganisme(null, 0, 1);
//		controller.getTerrarium().plaatsOrganisme(new Carnivoor(), 0, 0);
//		assertEquals(true, Terrarium.INSTANCE.beweegNaarRechtsOK(0, 0));
//	}
//	
//	@Test
//	public void beweegNaarRechtsKanNietWegensBezet() {
//		controller.getTerrarium().plaatsOrganisme(new Carnivoor(), 0, 1);
//		controller.getTerrarium().plaatsOrganisme(new Carnivoor(), 0, 2);
//		assertEquals(false, Terrarium.INSTANCE.beweegNaarRechtsOK(0, 1));
//	}
//
//	@Test
//	public void beweegNaarRechtsKanNietWegensGrens() {
//		assertEquals(false, Terrarium.INSTANCE.beweegNaarRechtsOK(0, 5));
//	}	
}