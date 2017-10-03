package be.vdab.terrarium.model;

public class Herbivoor extends Dier {

	@Override
	public void ageer() {
		String organisme = getRechterBuurCel().toString();
		switch (organisme) {
		case "P":
			eet();
			break;

		case "H":
			vrij();
			break;

		default:
			beweeg();
		}

	}

	private void eet() {

	}

	private void vrij() {
		Organisme buur = getRechterBuur();
		if (buur == null || !(buur instanceof Herbivoor))
			throw new IllegalStateException();
		Terrarium.INSTANCE.verhoogBabyHerbivoren();
	}

	private void beweeg() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "H";
	}

}
