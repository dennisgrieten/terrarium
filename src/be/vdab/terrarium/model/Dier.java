package be.vdab.terrarium.model;

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
			throw new NullPointerException(String.format("Dier %1$d, %2$d krijgt NULL(%3$d, %4$d) te eten",
					dezeCel.getX(), dezeCel.getY(), slachtofferCel.getX(), slachtofferCel.getY()));
		}

		super.setLevenskracht(super.getLevenskracht() + slachtoffer.getLevenskracht());
		slachtoffer.sterf();
		this.setHeeftGeageerd(true);
	}

	private void magicJump() {

	}

	protected void beweeg() {
		// Cel dezeCel = super.getCel();
		// ArrayList<Cel> legeBuren = new ArrayList<>();
		// Cel bovenbuur = dezeCel.getOrganisme().getBovenBuurCel();
		// if ((bovenbuur != null) && (bovenbuur.getOrganisme() != null)) {
		// legeBuren.add(bovenbuur);
		// }
		// Cel onderbuur = dezeCel.getOrganisme().getOnderBuurCel();
		// if ((onderbuur != null) && (onderbuur.getOrganisme() != null)) {
		// legeBuren.add(onderbuur);
		// }
		// Cel linkerbuur = dezeCel.getOrganisme().getLinkerBuurCel();
		// if ((linkerbuur != null) && (linkerbuur.getOrganisme() != null)) {
		// legeBuren.add(linkerbuur);
		// }
		// Cel rechterbuur = dezeCel.getOrganisme().getRechterBuurCel();
		// if ((rechterbuur != null) && (rechterbuur.getOrganisme() != null)) {
		// legeBuren.add(rechterbuur);
		// }
		//
		// Terrarium.INSTANCE.plaatsOrganisme(dezeCel.getOrganisme(), legeBuren);
		// dezeCel.unSetOrganisme();
		// this.setHeeftGeageerd(true);
	}
}
