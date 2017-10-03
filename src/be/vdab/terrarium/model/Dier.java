package be.vdab.terrarium.model;

import java.util.ArrayList;

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

	public void eet() {
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
	
	public abstract void ageer();


    public void beweeg() {
        Cel dezeCel = super.getCel();
        ArrayList<Cel> legeBuren = new ArrayList<>();
    	Cel bovenbuur = dezeCel.getOrganisme().getBovenBuurCel();
        if ((bovenbuur != null) && (bovenbuur.getOrganisme() != null)) {
        	legeBuren.add(bovenbuur);
        }
    	Cel onderbuur = dezeCel.getOrganisme().getOnderBuurCel();
        if ((onderbuur != null) && (onderbuur.getOrganisme() != null)) {
        	legeBuren.add(onderbuur);
        }
    	Cel linkerbuur = dezeCel.getOrganisme().getLinkerBuurCel();
        if ((linkerbuur != null) && (linkerbuur.getOrganisme() != null)) {
        	legeBuren.add(linkerbuur);
        }
    	Cel rechterbuur = dezeCel.getOrganisme().getRechterBuurCel();
        if ((rechterbuur != null) && (rechterbuur.getOrganisme() != null)) {
        	legeBuren.add(rechterbuur);
        }
        
        Terrarium.INSTANCE.plaatsOrganisme(dezeCel.getOrganisme(), legeBuren);
        dezeCel.unSetOrganisme();
        
    }

}
