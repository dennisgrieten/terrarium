package be.vdab.terrarium.model;

public class Carnivoor extends Dier {

	@Override
	public void ageer() {
		String organisme = getRechterBuurCel().toString();
		switch (organisme) {
		case "H":
			super.eet();
			break;

		case "C":
			vecht();
			break;

		default:
			beweeg();
		}

	}

	private void vecht() {

	}

	@Override
	public String toString() {
		return "C";
	}

}
