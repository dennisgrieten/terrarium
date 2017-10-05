package be.vdab.terrarium.view.console;

import java.lang.reflect.GenericSignatureFormatError;
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

		System.out.println("INGAVE FLEXIBELE GEGEVENS TERRARIUM: ");
		int hoogte = geefHoogte(scanner, controller);
		int breedte = geefBreedte(scanner, controller, hoogte);

		controller.initMatrix(breedte, hoogte);

		int aantalPlanten = 0;
		int aantalPlantenPerDag = 0;
		int aantalHerbivoren = 0;
		int aantalCarnivoren = 0;
		String errorMelding = null;
		
		do {
			if (errorMelding != null) {
				System.out.println("ERROR: " + errorMelding);
			}
			System.out.println("INGAVE FLEXIBELE GEGEVENS ORGANISMEN: ");
			aantalPlanten = geefAantalPlanten(scanner);
			aantalPlantenPerDag = geefAantalPlantenPerDag(scanner);
			aantalHerbivoren = geefAantalHerbivoren(scanner);
			aantalCarnivoren = geefAantalCarnivoren(scanner);
			errorMelding = "Validatie van inputgegevens is fout gegaan. Geef opnieuw in. ";
			System.out.println("isValideAantalOrganismen= " + controller.isValideAantalOrganismen(aantalPlanten, aantalHerbivoren, aantalCarnivoren));
			System.out.println("isValideAantalNieuwePlanten= " + controller.isValideAantalNieuwePlanten(aantalPlanten));
		} while ((!controller.isValideAantalOrganismen(aantalPlanten, aantalHerbivoren, aantalCarnivoren)
				|| (!controller.isValideAantalNieuwePlanten(aantalPlanten))));

		System.out.println("hoogte= " + hoogte);
		System.out.println("breedte= " + breedte);
		System.out.println("aantalPlanten= " + aantalPlanten);
		System.out.println("aantalHerbivoren= " + aantalHerbivoren);
		System.out.println("aantalCarnivoren= " + aantalCarnivoren);

		// init matrix met TIJDELIJKE startwaarden, pas aan voor flexibel console view
		// controller.initMatrix(8, 8);
		controller.initStartOrganismen(aantalPlanten, aantalPlantenPerDag, aantalHerbivoren, aantalCarnivoren);

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

	private static int geefHoogte(Scanner scanner, Controller controller) {
		String message = "     Geef de hoogte van het raster (tussen 6 en 25): ";
		System.out.print(message);
		int hoogte = getNumericValue(scanner, message);

//		System.out.println("hoogte= " + hoogte);
		while (!controller.isValideHoogte(hoogte)) {
			System.out.print(message);
			hoogte = getNumericValue(scanner, message);
		}
		return hoogte;
	}

	private static int geefBreedte(Scanner scanner, Controller controller, int hoogte) {
		String message = "     Geef de breedte van het raster (moet <= hoogte zijn): ";
		System.out.print(message);
		int breedte = getNumericValue(scanner, message);
		while (!controller.isValideBreedte(hoogte, breedte)) {
			System.out.print(message);
			breedte = getNumericValue(scanner, message);
		}
		return breedte;
	}

	private static int geefAantalPlanten(Scanner scanner) {
		String message = "     Geef aantal planten (minimum 2): ";
		System.out.print(message);
		int aantalPlanten = getNumericValue(scanner, message);
		return aantalPlanten;
	}

	private static int geefAantalPlantenPerDag(Scanner scanner) {
		String message = "     Geef aantal planten per dag: ";
		System.out.print(message);
		int aantalPlantenPerDag = getNumericValue(scanner, message);
		return aantalPlantenPerDag;
	}

	private static int geefAantalHerbivoren(Scanner scanner) {
		String message = "     Geef aantal herbivoren (minimum 2): ";
		System.out.print(message);
		int aantalHerbivoren = getNumericValue(scanner, message);
		return aantalHerbivoren;
	}

	private static int geefAantalCarnivoren(Scanner scanner) {
		String message = "     Geef aantal carnivoren (minimum 2): ";
		System.out.print(message);
		int aantalCarnivoren = getNumericValue(scanner, message);
		return aantalCarnivoren;
	}

	private static int getNumericValue(Scanner scanner, String message) {
		int num = 0;
		while (true) {
			try {
				num = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("Foutieve input.");
				System.out.print(message);
			}
		}
		return num;
	}
}