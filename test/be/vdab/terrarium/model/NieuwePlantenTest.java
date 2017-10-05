package be.vdab.terrarium.model;

import static org.junit.Assert.*;

import be.vdab.terrarium.controller.Controller;
import org.junit.Before;
import org.junit.Test;

import be.vdab.terrarium.view.console.Console;

public class NieuwePlantenTest {

    @Before
    public void before() {
        Controller controller = new Controller();
        controller.initMatrix(6, 6);
        controller.initStartOrganismen();
        System.out.println(Console.getStringRepresentation(Terrarium.INSTANCE));
    }

    @Test
    public void getAantalPlantenIs6NaToevoegenNieuwePlanten() {
        Terrarium.INSTANCE.voegNieuwePlantenToe();
        assertEquals(6, Terrarium.INSTANCE.getAantalPlanten());
    }

}