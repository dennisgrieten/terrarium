package be.vdab.terrarium.model;

import be.vdab.terrarium.util.DierException;

public abstract class Dier extends Organisme {
    private boolean heeftGeageerd;

    public Dier() {
        this.heeftGeageerd = false;
    }

	public boolean heeftGeageerd() {
		return heeftGeageerd;
	}

	public void setHeeftGeageerd(boolean heeftGeageerd) {
		this.heeftGeageerd = heeftGeageerd;
	}

	protected void eet() {
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

        

        super.setLevenskracht(super.getLevenskracht() + slachtoffer.getLevenskracht());
    	slachtoffer.sterf();
    	this.setHeeftGeageerd(true);
	}
	
	


	
	public void magicJump() {
		
	}
}
