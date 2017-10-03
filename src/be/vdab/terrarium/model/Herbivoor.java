package be.vdab.terrarium.model;

public class Herbivoor extends Dier {
    @Override
    public String toString() {
        return "H";
    }
    
    public void vrij() {
    	Organisme buur = getRechterBuur();
		if (buur == null || !(buur instanceof Herbivoor)) throw new IllegalStateException();
		Terrarium.INSTANCE.verhoogBabyHerbivoren();
	}
    
}
