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
	
	public Cel getCel() {
		Terrarium terrarium = Terrarium.INSTANCE;
		Cel[][] matrix = terrarium.getMatrix();
		for (int i = 0; i < terrarium.getHoogte(); i++ ) {
			for (int j = 0; j < terrarium.getBreedte(); j++ ) {
				Cel cel = matrix[i][j];
				if (this == cel.getOrganisme()) return cel;
			}
		}
		return null;
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
