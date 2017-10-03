package be.vdab.terrarium.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class NieuwePlantenTest {
    
    @Test
    public void getAantalPlantenIs6() {
        Terrarium.INSTANCE.voegNieuwePlantenToe();
        assertEquals(5, Terrarium.INSTANCE.getAantalPlanten());
    }
    
    public static void main(String[] args) {
    	Terrarium.INSTANCE.initStartOrganismen();
    	Terrarium.INSTANCE.voegNieuwePlantenToe();
		System.out.println(Terrarium.INSTANCE);
	}
    
}