package be.vdab.terrarium.model;

public class Plant extends Organisme {

	@Override
	public void ageer() {
		// Niets.
	}

	@Override
	public boolean heeftGeageerd() {
		return false;
	}

	@Override
	public String toString() {
		return "Plant [heeftGeageerd()=" + heeftGeageerd() + ", getLevenskracht()=" + getLevenskracht() + ", getCel()="
				+ getCel() + ", getRechterBuurCel()=" + getRechterBuurCel() + ", getRechterBuur()=" + getRechterBuur()
				+ ", getLinkerBuurCel()=" + getLinkerBuurCel() + ", getLinkerBuur()=" + getLinkerBuur()
				+ ", getBovenBuurCel()=" + getBovenBuurCel() + ", getBovenBuur()=" + getBovenBuur()
				+ ", getOnderBuurCel()=" + getOnderBuurCel() + ", getOnderBuur()=" + getOnderBuur() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
