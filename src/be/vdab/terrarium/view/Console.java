package be.vdab.terrarium.view;

import java.util.Scanner;

import be.vdab.terrarium.controller.Controller;

public class Console {

	public static void main(String[] args) {
		Controller controller = new Controller();
		Scanner scanner = new Scanner(System.in);
		String input = "";
		int dagCounter = 1;

		do {
			controller.initStartOrganismen();
			System.out.println("Begin dag " + dagCounter + "\n" + controller.getTerrarium().toString()
					+ "\n\nEinde dag " + dagCounter);
			controller.dagIteratie();

			// iets met controller.geboortesToevoegen?
			System.out.println(controller.getTerrarium().toString());

			input = scanner.nextLine();
			dagCounter++;
		} while (!input.equals("s"));

		scanner.close();

	}

}