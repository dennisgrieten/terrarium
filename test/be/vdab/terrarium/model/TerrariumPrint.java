package be.vdab.terrarium.model;

import be.vdab.terrarium.controller.Controller;
import be.vdab.terrarium.view.console.Console;

public class TerrariumPrint {

	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.getTerrarium().initMatrix(6,6);
		controller.getTerrarium().initStartOrganismen(2,2,2,2, 2);
		System.out.println(Console.getStringRepresentation(Terrarium.INSTANCE));

	}

}
