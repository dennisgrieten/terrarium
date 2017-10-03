package be.vdab.terrarium.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import be.vdab.terrarium.controller.Controller;

public class TerrariumTest {

    private Controller controller;
    
    @Before
	public void before() {
    	controller = new Controller();
    	
    	controller.init();
    	
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
