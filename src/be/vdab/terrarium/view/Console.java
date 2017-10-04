package be.vdab.terrarium.view;

import java.util.Scanner;

import be.vdab.terrarium.controller.Controller;

public class Console {

	public static void main(String[] args) {
		Controller controller = new Controller();

		Scanner scanner = new Scanner(System.in);
		String input = "";
		int dagCounter = 1;

		controller.initStartOrganismen();
		do {
			System.out.println("Begin dag " + dagCounter + "\n" + controller.getTerrarium());
			controller.dagActies();
			System.out.println("Einde dag " + dagCounter + "\n" + controller.getTerrarium());
			controller.dagInit();
			input = scanner.nextLine();
			dagCounter++;
		} while (!input.equals("s"));

		scanner.close();

	}

}