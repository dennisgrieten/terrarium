package be.vdab.terrarium.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarnivoorTest {
	private  Carnivoor carnivoor;

	@Test
	public void toStringVanCarnivoorIsC() {
		carnivoor = new Carnivoor();
		assertEquals("C", carnivoor.toString());
	}
	
	@Test
	public void levenskrachtVanEenCarnivoorIsEen() {
		carnivoor = new  Carnivoor();
		assertEquals(1, carnivoor.getLevenskracht());
	}
	
	

}
