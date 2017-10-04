package be.vdab.terrarium.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NieuwePlantenTest {

	@Before
	public void before() {
		Terrarium.INSTANCE.initStartOrganismen();
		System.out.println(Terrarium.INSTANCE);
	}

	@Test
	public void getAantalPlantenIs6NaToevoegenNieuwePlanten() {
		Terrarium.INSTANCE.voegNieuwePlantenToe();
		assertEquals(6, Terrarium.INSTANCE.getAantalPlanten());
	}

}