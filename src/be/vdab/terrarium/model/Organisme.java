package be.vdab.terrarium.model;

public abstract class Organisme {
	
    private int levenskracht;
    private Cel cel;
    
    public Organisme() {
        setLevenskracht(1);
    }

    public void setLevenskracht(int levenskracht) {
        this.levenskracht = levenskracht;
    }

	public int getLevenskracht() {
		return levenskracht;
	}
	
	public Cel getCel() {
		return cel;
	}
	
	public void setCel(Cel cel) {
		this.cel.setOrganisme(null);
		this.cel = cel;
		cel.setOrganisme(this);
	}
	
	public Cel getRechterBuurCel() {
		Terrarium terrarium = Terrarium.INSTANCE;
		Cel[][] matrix = terrarium.getMatrix();
		Cel cel = getCel();
		int x = cel.getX();
		int y = cel.getY();
		if (x < terrarium.getBreedte()) {
			return matrix[y][x+1];
		} else {
			return null;
		}
	}
	
	public Organisme getRechterBuur() {
		return getRechterBuurCel().getOrganisme();
	}
    
}
