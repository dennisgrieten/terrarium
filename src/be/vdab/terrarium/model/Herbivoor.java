package be.vdab.terrarium.model;

public class Herbivoor extends Dier {

	@Override
	public void ageer() {
		if (getRechterBuurCel() == null) {
			magicJump();
		} else {
			String organisme = getRechterBuurCel().toString();
			switch (organisme) {
			case "P":
				super.eet();
				break;

			case "H":
				vrij();
				break;

			default:
				beweeg();
			}			
		}
		
	}

	private void vrij() {
		Organisme buur = getRechterBuur();
		if (buur == null || !(buur instanceof Herbivoor))
			throw new IllegalStateException();
		Terrarium.INSTANCE.verhoogBabyHerbivoren();
	}

	@Override
	public String toString() {
		return "H";
	}

}
