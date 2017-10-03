package be.vdab.terrarium.model;

public class Plant extends Organisme {
	private int levensKracht;

	public Plant() {
		this.levensKracht = 1;
	}

    public int getLevensKracht() {
        return levensKracht;
    }

    @Override
	public String toString() {
		return "P";
	}
	
}
