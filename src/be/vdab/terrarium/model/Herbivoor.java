package be.vdab.terrarium.model;

public class Herbivoor extends Dier {

    public Herbivoor() {
        super();
    }

    public Herbivoor(int levenskracht) {
        super(levenskracht);
    }

    @Override
    public void ageer() {
        Organisme rechterbuur = getRechterBuur();
        if (rechterbuur != null) {
            switch (rechterbuur.getClass().getSimpleName()) {
                case "Plant":
                    super.eet();
                    break;
                case "Herbivoor":
                    vrij(new Herbivoor(0));
                    break;
            }
        }
        if (!this.heeftGeageerd()) {
            beweeg();
        }
    }

    @Override
    public String toString() {
        return "Herbivoor [heeftGeageerd()=" + heeftGeageerd() + ", getLevenskracht()=" + getLevenskracht()
                + ", getCel()=" + getCel() + ", getRechterBuurCel()=" + getRechterBuurCel() + ", getRechterBuur()="
                + getRechterBuur() + ", getLinkerBuurCel()=" + getLinkerBuurCel() + ", getLinkerBuur()="
                + getLinkerBuur() + ", getBovenBuurCel()=" + getBovenBuurCel() + ", getBovenBuur()=" + getBovenBuur()
                + ", getOnderBuurCel()=" + getOnderBuurCel() + ", getOnderBuur()=" + getOnderBuur() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

}
