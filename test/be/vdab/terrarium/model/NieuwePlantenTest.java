package be.vdab.terrarium.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import be.vdab.terrarium.controller.Controller;

public class NieuwePlantenTest {

    @Test
    public void getAantalPlantenIs6NaToevoegenNieuwePlanten() {
    	Controller controller = new Controller();
        controller.initMatrix(10, 10);
        controller.initStartOrganismen(4,2,5,3);
        controller.voegNieuwePlantenToe();
        assertEquals(6, controller.getAantalPlanten());
    }

}