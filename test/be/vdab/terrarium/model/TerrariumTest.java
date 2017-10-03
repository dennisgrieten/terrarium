package be.vdab.terrarium.model;

import static org.junit.Assert.*;

import be.vdab.terrarium.controller.Controller;
import org.junit.Test;

public class TerrariumTest {
    private Controller controller = new Controller();
    
    
    @Test
    public void getAantalPlantenIs4() {
    	controller.init();
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

}