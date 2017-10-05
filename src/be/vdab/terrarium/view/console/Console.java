package be.vdab.terrarium.view.console;

import java.util.Scanner;

import be.vdab.terrarium.controller.Controller;
import be.vdab.terrarium.model.Cel;
import be.vdab.terrarium.model.Organisme;
import be.vdab.terrarium.model.Terrarium;

public class Console {

	public static String getStringRepresentation(Terrarium terrarium) {
		Cel[][] matrix = terrarium.getMatrix();
		StringBuilder output = new StringBuilder();
		for (int y = 0; y < terrarium.getHoogte(); y++) {
			for (int x = 0; x < terrarium.getBreedte(); x++) {
				Organisme organisme = matrix[y][x].getOrganisme();
				if (organisme != null) {
					switch (organisme.getClass().getSimpleName()) {
					case "Plant":
						output.append("P  ");
						break;
					case "Herbivoor":
						output.append("H  ");
						break;
					case "Carnivoor":
						output.append("C  ");
						break;
					default:
						break;
					}
				} else {
					output.append(".  ");
				}
			}
			output.append("\n");
		}
		return output.toString();
	}

	public static void main(String[] args) {
		Controller controller = new Controller();

		Scanner scanner = new Scanner(System.in);
		String input = "";
		int dagCounter = 1;

		// init matrix met TIJDELIJKE startwaarden, pas aan voor flexibel console view
		controller.initMatrix(8,8);
		controller.initStartOrganismen();
		do {
			System.out.println("Begin dag " + dagCounter + "\n" + getStringRepresentation(controller.getTerrarium()));
			controller.dagActies();
			System.out.println("Einde dag " + dagCounter + "\n" + getStringRepresentation(controller.getTerrarium()));
			controller.dagInit();
			input = scanner.nextLine();
			dagCounter++;
		} while (!input.equals("s"));

		scanner.close();

	}

}