package be.vdab.terrarium.model;

import java.util.ArrayList;

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
		Organisme slachtoffer = getRechterBuurCel().getOrganisme();
		super.addLevenskracht(slachtoffer.getLevenskracht());
		slachtoffer.sterf();
		this.setHeeftGeageerd(true);
	}

	protected void eet(Organisme tegenstander) {
		Organisme slachtoffer = getRechterBuurCel().getOrganisme();
		super.setLevenskracht(super.getLevenskracht() + slachtoffer.getLevenskracht());
		slachtoffer.sterf();
		this.setHeeftGeageerd(true);
	}

	public void beweeg() {
		Cel dezeCel = super.getCel();
		if (dezeCel.getX() == Terrarium.INSTANCE.getBreedte() - 1) {
			Terrarium.INSTANCE.plaatsOrganisme(dezeCel.getOrganisme()); // DIT IS DE MAGIC JUMP
		}

		ArrayList<Cel> legeBuren = new ArrayList<>();
		Cel rechterbuur = dezeCel.getOrganisme().getRechterBuurCel();
		if ((rechterbuur != null) && (rechterbuur.isLeeg())) {
			legeBuren.add(rechterbuur);
		}
		Cel bovenbuur = dezeCel.getOrganisme().getBovenBuurCel();
		if ((bovenbuur != null) && (bovenbuur.isLeeg())) {
			legeBuren.add(bovenbuur);
		}
		Cel onderbuur = dezeCel.getOrganisme().getOnderBuurCel();
		if ((onderbuur != null) && (onderbuur.isLeeg())) {
			legeBuren.add(onderbuur);
		}
		Cel linkerbuur = dezeCel.getOrganisme().getLinkerBuurCel();
		if ((linkerbuur != null) && (linkerbuur.isLeeg())) {
			legeBuren.add(linkerbuur);
		}

		if (legeBuren.size() > 0) {
			Terrarium.INSTANCE.plaatsOrganisme(dezeCel.getOrganisme(), legeBuren);
			dezeCel.unSetOrganisme();
			this.setHeeftGeageerd(true);
		}
	}

	protected void vecht() {
		Organisme tegenstander = getRechterBuur();
		if (this.getLevenskracht() > tegenstander.getLevenskracht()) {
			this.addLevenskracht(tegenstander.getLevenskracht());
			tegenstander.sterf();
			this.setHeeftGeageerd(true);
		} else if (this.getLevenskracht() < tegenstander.getLevenskracht()) {
			tegenstander.addLevenskracht(this.getLevenskracht());
			this.sterf();
		}
	}
}
