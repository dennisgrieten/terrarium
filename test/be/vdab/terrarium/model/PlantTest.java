package be.vdab.terrarium.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlantTest {
	private Plant plant;

	@Test
	public void toStringVanPlantIsP() {
		plant = new Plant();
		assertEquals("P", plant.toString());
	}

	@Test
	public void levenskrachtVanEenPlantIsEen() {
		plant = new Plant();
		assertEquals(1, plant.getLevenskracht());
	}

}
