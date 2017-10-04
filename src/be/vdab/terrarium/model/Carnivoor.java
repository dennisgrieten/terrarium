package be.vdab.terrarium.model;

public class Carnivoor extends Dier {

	@Override
	public void ageer() {
		Organisme rechterbuur = getRechterBuur();
		if (rechterbuur != null) {
			switch (rechterbuur.getClass().getSimpleName()) {
			case "Herbivoor":
				super.eet();
				break;
			case "Carnivoor":
				vecht();
				break;
			}
		}
		if (!this.heeftGeageerd()) {
			beweeg();
		}
	}

	private void vecht() {
		// Organisme buur = getRechterBuur();
		// if (buur == null || !(buur instanceof Carnivoor)) {
		// throw new IllegalStateException();
		// }
	}

	@Override
	public String toString() {
		return "Carnivoor [heeftGeageerd()=" + heeftGeageerd() + ", getLevenskracht()=" + getLevenskracht()
				+ ", getCel()=" + getCel() + ", getRechterBuurCel()=" + getRechterBuurCel() + ", getRechterBuur()="
				+ getRechterBuur() + ", getLinkerBuurCel()=" + getLinkerBuurCel() + ", getLinkerBuur()="
				+ getLinkerBuur() + ", getBovenBuurCel()=" + getBovenBuurCel() + ", getBovenBuur()=" + getBovenBuur()
				+ ", getOnderBuurCel()=" + getOnderBuurCel() + ", getOnderBuur()=" + getOnderBuur() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
