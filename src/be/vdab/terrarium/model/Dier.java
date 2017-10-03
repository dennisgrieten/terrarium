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

	public void eet(Organisme slachtoffer) throws NullPointerException, DierException {
        Cel dezeCel = super.getCel();

        // indien slachtoffer NULL
        if (slachtoffer == null) {
    		Cel slachtofferCel = slachtoffer.getCel();
    		throw new NullPointerException(String.format(
    				"Dier %1$d, %2$d krijgt NULL(%3$d, %4$d) te eten",
					dezeCel.getX(), dezeCel.getY(), slachtofferCel.getX(), slachtofferCel.getY())
			);
		}

		// indien Dier al een actie heeft ondergaan
		if (heeftActieOndergaan()) {
    	    throw new DierException(String.format(
                    "Dier %1$d, %2$d heeft al een actie ondergaan",
                    dezeCel.getX(), dezeCel.getY())
            );
        }

        super.setLevenskracht(super.getLevenskracht() + slachtoffer.getLevenskracht());
    	slachtoffer.sterf();
    	this.setHeeftActieOndergaan(true);
	}
	
	
		
	
	
	public void magicJump() {
		
	}
}
