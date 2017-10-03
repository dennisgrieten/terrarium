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

	@Test
	public void beweegNaarBovenKan() {
		assertEquals("true", Terrarium.INSTANCE.beweegNaarBovenOK(1, 1));
	}
	
	@Test
	public void beweegNaarBovenKanNiet() {
		assertEquals("false", Terrarium.INSTANCE.beweegNaarBovenOK(0, 1));
	}

}