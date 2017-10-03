package be.vdab.terrarium.model;

public class Plant extends Organisme {
	public Plant() {
		super();
	}

    public int getLevensKracht() {
        return super.getLevenskracht();
    }

    @Override
	public String toString() {
		return "P";
	}
	
}
