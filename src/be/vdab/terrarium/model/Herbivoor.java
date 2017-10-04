package be.vdab.terrarium.model;

public class Herbivoor extends Dier {

	@Override
	public void ageer() {
		Organisme rechterbuur = getRechterBuur();
		if (rechterbuur != null) {
			switch (rechterbuur.getClass().getSimpleName()) {
			case "Plant":
				super.eet();
				break;
			case "Herbivoor":
				vrij();
				break;
			}
		}
		if (!this.heeftGeageerd()) {
			beweeg();
		}
	}

	private void vrij() {
		Organisme buur = getRechterBuur();
		if (buur == null || !(buur instanceof Herbivoor)) {
			throw new IllegalStateException();
		}
		Terrarium.INSTANCE.verhoogBabyHerbivoren();
	}

	@Override
	public String toString() {
		return "Herbivoor [heeftGeageerd()=" + heeftGeageerd() + ", getLevenskracht()=" + getLevenskracht()
				+ ", getCel()=" + getCel() + ", getRechterBuurCel()=" + getRechterBuurCel() + ", getRechterBuur()="
				+ getRechterBuur() + ", getLinkerBuurCel()=" + getLinkerBuurCel() + ", getLinkerBuur()="
				+ getLinkerBuur() + ", getBovenBuurCel()=" + getBovenBuurCel() + ", getBovenBuur()=" + getBovenBuur()
				+ ", getOnderBuurCel()=" + getOnderBuurCel() + ", getOnderBuur()=" + getOnderBuur() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
