package be.vdab.terrarium.controller;

import be.vdab.terrarium.model.Organisme;
import be.vdab.terrarium.model.Terrarium;

public class Controller {

	public Terrarium getTerrarium() {
		return Terrarium.INSTANCE;
	}

	public void initMatrix() {
		Terrarium.INSTANCE.initMatrix();
	}

	public void initStartOrganismen() {
		Terrarium.INSTANCE.initStartOrganismen();
	}

	public void dagInit() {
		Terrarium.INSTANCE.dagInit();
	}

	public void dagActies() {
		Terrarium.INSTANCE.dagActies();
	}

	public void dagActies(String simpleClassName) {
		Terrarium.INSTANCE.dagActies(simpleClassName);
	}

	public void plaatsOrganisme(Organisme organisme, int y, int x) {
		Terrarium.INSTANCE.plaatsOrganisme(organisme, y, x);
	}

	public int getAantalHerbivoren() {
		return Terrarium.INSTANCE.getAantalHerbivoren();
	}

	public int getAantalCarnivoren() {
		return Terrarium.INSTANCE.getAantalCarnivoren();
	}

	public int getAantalPlanten() {
		return Terrarium.INSTANCE.getAantalPlanten();
	}

}
