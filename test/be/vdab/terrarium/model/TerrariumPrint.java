package be.vdab.terrarium.model;

import be.vdab.terrarium.view.console.Console;

public class TerrariumPrint {

	public static void main(String[] args) {
		Terrarium.INSTANCE.initStartOrganismen(4,2,5,3);
		System.out.println(Console.getStringRepresentation(Terrarium.INSTANCE));

	}

}
