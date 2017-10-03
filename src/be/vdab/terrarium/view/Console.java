package be.vdab.terrarium.view;

import be.vdab.terrarium.controller.Controller;

public class Console {

	public static void main(String[] args) {
		Controller controller = new Controller();

		System.out.println(controller.getTerrarium().toString());
	}

}
