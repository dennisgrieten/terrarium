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
        assertEquals(1, Terrarium.INSTANCE.getAantalHerbivoren());
        assertEquals(1, Terrarium.INSTANCE.getAantalPlanten());

        Herbivoor herbivoor = (Herbivoor) Terrarium.INSTANCE.getMatrix()[0][0].getOrganisme();
        herbivoor.eet();

        assertEquals(1, Terrarium.INSTANCE.getAantalHerbivoren());
        assertEquals(0, Terrarium.INSTANCE.getAantalPlanten());
    }

}