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

	}

	private void beweeg() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "C";
	}

}
