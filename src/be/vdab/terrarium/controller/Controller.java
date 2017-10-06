package be.vdab.terrarium.controller;

import be.vdab.terrarium.model.Organisme;
import be.vdab.terrarium.model.Terrarium;

public class Controller {

	public Terrarium getTerrarium() {
		return Terrarium.INSTANCE;
	}

	public void initMatrix(int breedte, int hoogte) {
		Terrarium.INSTANCE.initMatrix(breedte, hoogte);
	}

	public void initStartOrganismen(int planten, int plantenPerDag, int herbivoren, int carnivoren, int omnivoren) {
		Terrarium.INSTANCE.initStartOrganismen(planten, plantenPerDag, herbivoren, carnivoren, omnivoren);
	}

	public void dagInit() {
		Terrarium.INSTANCE.dagInit();
	}

	public void dagActies() {
		Terrarium.INSTANCE.dagActies();
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

	public boolean isValideHoogte(int hoogte) {
		return getTerrarium().isValideHoogte(hoogte);
	}

	public boolean isValideBreedte(int lengte, int breedte) {
		return getTerrarium().isValideBreedte(lengte, breedte);
	}

	public boolean isValideAantalOrganismen(int planten, int herbivoren, int carnivoren) {
		return getTerrarium().isValideAantalOrganismen(planten, herbivoren, carnivoren);
	}

	public boolean isValideAantalNieuwePlanten(int planten) {
		return getTerrarium().isValideAantalNieuwePlanten(planten);
	}
}
