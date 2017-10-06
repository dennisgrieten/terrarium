package be.vdab.terrarium.model;

public class Omnivoor extends Dier {

    public Omnivoor() {
        super();
    }

    public Omnivoor(int levenskracht) {
        super(levenskracht);
    }

    @Override
    public void ageer() {
        Organisme rechterbuur = getRechterBuur();
        if (rechterbuur != null) {
            switch (rechterbuur.getClass().getSimpleName()) {
                case "Plant":
                case "Herbivoor":
                    eet();
                    break;
                case "Carnivoor":
                    vecht();
                    break;
                case "Omnivoor":
                    vrij(new Omnivoor(0));
                    break;
            }
        }
        if (!this.heeftGeageerd()) {
            beweeg();
        }
    }

    @Override
    public String toString() {
        return "Omnivoor{}";
    }
}
