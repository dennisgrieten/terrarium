package be.vdab.terrarium.model;

public class Carnivoor extends Dier {

    public Carnivoor() {
        super();
    }

    public Carnivoor(int levenskracht) {
        super(levenskracht);
    }

    @Override
    public void ageer() {
        Organisme rechterbuur = getRechterBuur();
        if (rechterbuur != null) {
            switch (rechterbuur.getClass().getSimpleName()) {
                case "Herbivoor":
                    super.eet();
                    break;
                case "Carnivoor":
                case "Omnivoor":
                    vecht();
                    break;
            }
        }
        if (!this.heeftGeageerd()) {
            beweeg();
        }
    }

    @Override
    public String toString() {
        return "Carnivoor [heeftGeageerd()=" + heeftGeageerd() + ", getLevenskracht()=" + getLevenskracht()
                + ", getCel()=" + getCel() + ", getRechterBuurCel()=" + getRechterBuurCel() + ", getRechterBuur()="
                + getRechterBuur() + ", getLinkerBuurCel()=" + getLinkerBuurCel() + ", getLinkerBuur()="
                + getLinkerBuur() + ", getBovenBuurCel()=" + getBovenBuurCel() + ", getBovenBuur()=" + getBovenBuur()
                + ", getOnderBuurCel()=" + getOnderBuurCel() + ", getOnderBuur()=" + getOnderBuur() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

}
