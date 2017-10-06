package be.vdab.terrarium.view.swing;

import be.vdab.terrarium.controller.Controller;

public class Swing {

	public static void main(String[] args) {
		ConfigPanel configPanel = new ConfigPanel();
		int hoogte = configPanel.getHoogte();
		int breedte  = configPanel.getBreedte();
		int aantalNieuwePlantenPerDag = configPanel.getAantalNieuwePlantenPerDag();
		int aantalPlantenBijStart = configPanel.getAantalPlantenBijStart();
		int aantalHerbivorenBijStart = configPanel.getAantalHerbivorenBijStart();
		int aantalCarnivorenBijStart = configPanel.getAantalCarnivorenBijStart();
		
		
		
		Controller controller = new Controller();
		controller.initMatrix(breedte, hoogte);
		controller.initStartOrganismen(aantalPlantenBijStart,aantalNieuwePlantenPerDag, aantalHerbivorenBijStart, aantalCarnivorenBijStart);
		
		
		new TerrariumFrame();
		
		
		
		
	}

}
