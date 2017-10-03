package be.vdab.terrarium.model;

import be.vdab.terrarium.util.DierException;

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

	public void eet() throws NullPointerException, DierException {
        Cel dezeCel = super.getCel();
        Cel buurCel = this.getRechterBuurCel();
        Organisme slachtoffer = buurCel.getOrganisme();

        // indien slachtoffer NULL
        if (slachtoffer == null) {
    		Cel slachtofferCel = slachtoffer.getCel();
    		throw new NullPointerException(String.format(
    				"Dier x:%1$d, y:%2$d krijgt NULL(%3$d, %4$d) te eten",
					dezeCel.getX(), dezeCel.getY(), slachtofferCel.getX(), slachtofferCel.getY())
			);
		}

		// indien Dier al een actie heeft ondergaan
		if (heeftActieOndergaan()) {
    	    throw new DierException(String.format(
                    "Dier x:%1$d, y:%2$d heeft al een actie ondergaan",
                    dezeCel.getX(), dezeCel.getY())
            );
        }

        super.setLevenskracht(super.getLevenskracht() + slachtoffer.getLevenskracht());
    	slachtoffer.sterf();
    	this.setHeeftActieOndergaan(true);
	}

	public void vecht(Organisme tegenstander) {
        Cel dezeCel = super.getCel();

        // indien slachtoffer NULL
        if (tegenstander == null) {
            Cel slachtofferCel = tegenstander.getCel();
            throw new NullPointerException(String.format(
                    "Dier x:%1$d, y:%2$d krijgt NULL(%3$d, %4$d) als tegenstander",
                    dezeCel.getX(), dezeCel.getY(), slachtofferCel.getX(), slachtofferCel.getY())
            );
        }
    }
}
