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

	public void eet(Organisme slachtoffer) throws NullPointerException {
    	if (slachtoffer == null) {
    		Cel dezeCel = super.getCel();
    		Cel slachtofferCel = slachtoffer.getCel();
    		throw new NullPointerException(String.format(
    				"Dier %1$d, %2$d krijgt NULL(%3$d, %4$d) te eten",
					dezeCel.getX(), dezeCel.getY(), slachtofferCel.getX(), slachtofferCel.getY())
			);
		}

        super.setLevenskracht(super.getLevenskracht() + slachtoffer.getLevenskracht());
    	slachtoffer.sterf();
	}
}
