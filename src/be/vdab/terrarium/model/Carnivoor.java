package be.vdab.terrarium.model;

public class Carnivoor extends Dier {

	@Override
	public void ageer() {
		if (getRechterBuurCel() == null) {
			magicJump();
		} else {
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

	}

	private void vecht() {
		// bezig
	}

	@Override
	public String toString() {
		return "C";
	}

}
