package be.vdab.terrarium.model;

import be.vdab.terrarium.controller.Controller;
import org.junit.Test;

import static org.junit.Assert.*;

public class DierTest {
    Controller controller = new Controller();
    
    @Test
    public void testHerbivoorEetPlant() {
        controller.getTerrarium().plaatsOrganisme(new Herbivoor(), 0,0);
        controller.getTerrarium().plaatsOrganisme(new Plant(), 0,1);
        
        System.out.println(controller.getTerrarium());
        
        assertEquals(1, Terrarium.INSTANCE.getAantalHerbivoren());
        assertEquals(1, Terrarium.INSTANCE.getAantalPlanten());

        Terrarium.INSTANCE.dagIteratie();
        
        System.out.println(controller.getTerrarium());
        
        assertEquals(1, Terrarium.INSTANCE.getAantalHerbivoren());
        assertEquals(2, Terrarium.INSTANCE.getAantalPlanten());
    }

    @Test
    public void testCarnivoorEetHerbivoor() {
        controller.getTerrarium().plaatsOrganisme(new Carnivoor(), 0,0);
        controller.getTerrarium().plaatsOrganisme(new Herbivoor(), 0,1);
        
        System.out.println(controller.getTerrarium());
        
        assertEquals(1, Terrarium.INSTANCE.getAantalCarnivoren());
        assertEquals(1, Terrarium.INSTANCE.getAantalHerbivoren());

        Terrarium.INSTANCE.dagIteratie();
        
        System.out.println(controller.getTerrarium());
        
        assertEquals(1, Terrarium.INSTANCE.getAantalCarnivoren());
        assertEquals(0, Terrarium.INSTANCE.getAantalHerbivoren());

    }
    
    @Test
    public void testHerbivorenVrijen() {
        controller.getTerrarium().plaatsOrganisme(new Herbivoor(), 4,2);
        controller.getTerrarium().plaatsOrganisme(new Herbivoor(), 4,3);
        
        System.out.println(controller.getTerrarium());
        
        assertEquals(2, Terrarium.INSTANCE.getAantalHerbivoren());

        Terrarium.INSTANCE.dagIteratie();
        
        System.out.println(controller.getTerrarium());
        
        assertEquals(3, Terrarium.INSTANCE.getAantalHerbivoren());

    }
    
    
    
}