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

	public void eet() throws NullPointerException {
        Cel dezeCel = super.getCel();
        Organisme slachtoffer = getRechterBuurCel().getOrganisme();

        // indien slachtoffer NULL
        if (slachtoffer == null) {
    		Cel slachtofferCel = slachtoffer.getCel();
    		throw new NullPointerException(String.format(
    				"Dier %1$d, %2$d krijgt NULL(%3$d, %4$d) te eten",
					dezeCel.getX(), dezeCel.getY(), slachtofferCel.getX(), slachtofferCel.getY())
			);
		}

		/*// indien Dier al een actie heeft ondergaan
		if (heeftActieOndergaan()) {
    	    throw new DierException(String.format(
                    "Dier %1$d, %2$d heeft al een actie ondergaan",
                    dezeCel.getX(), dezeCel.getY())
            );
        }*/

        super.setLevenskracht(super.getLevenskracht() + slachtoffer.getLevenskracht());
    	slachtoffer.sterf();
    	this.setHeeftActieOndergaan(true);
	}
	
	public abstract void ageer() throws DierException;


	
	public void magicJump() {
		
	}
}
