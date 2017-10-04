package be.vdab.terrarium.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class HerbivoorTest {
	private Herbivoor herbivoor;

	@Test
	public void toStringVanHerbivoorIsH() {
		herbivoor = new Herbivoor();
		assertEquals("H", herbivoor.toString());
	}

	@Test
	public void levenskrachtVanEenHerbivoorIsEen() {
		herbivoor = new Herbivoor();
		assertEquals(1, herbivoor.getLevenskracht());
	}

}
