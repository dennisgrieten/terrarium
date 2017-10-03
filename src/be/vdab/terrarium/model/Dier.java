package be.vdab.terrarium.model;

public abstract class Dier extends Organisme {
    private boolean heeftActieOndergaan;

    public Dier() {
        this.heeftActieOndergaan = false;
    }

	public boolean heeftActieOndergaan() {
		return heeftActieOndergaan;
	}

	public void setHeeftActieOndergaan(boolean heeftActieOndergaan) {
		this.heeftActieOndergaan = heeftActieOndergaan;
	}
	
	public void eet() {
		Organisme buur = getRechterBuur();
		if (buur == null) throw new IllegalStateException();
		setLevenskracht(getLevenskracht() + buur.getLevenskracht());
		buur.getCel().setOrganisme(null);
	}
	
}
