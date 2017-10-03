package be.vdab.terrarium.model;

public abstract class Organisme {
	
    private int levenskracht;
    
    public Organisme() {
        setLevenskracht(1);
    }

    public void setLevenskracht(int levenskracht) {
        this.levenskracht = levenskracht;
    }

	public int getLevenskracht() {
		return levenskracht;
	}
    
}
