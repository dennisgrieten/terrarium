package be.vdab.terrarium.model;

public abstract class Organisme {
    private int levenskracht;
    private Cel cel = null; // pointer naar de cel waar het organisme zich in bevindt

    public Organisme() {
        setLevenskracht(1);
    }

    public void setLevenskracht(int levenskracht) {
        this.levenskracht = levenskracht;
    }

	public int getLevenskracht() {
		return levenskracht;
	}

	public void setCel(Cel cel) {
        this.cel = cel;
    }

    public Cel getCel() {
        return this.cel;
    }

    public void sterf() {
        this.cel.unSetOrganisme();
    }

	public Cel getRechterBuurCel() {
		int x = cel.getX();
		int y = cel.getY();
		if (x < Terrarium.INSTANCE.getBreedte() - 1) {
			return Terrarium.INSTANCE.getMatrix()[y][x+1];
		} else {
			return null;
		}
	}

	public Organisme getRechterBuur() {
		return getRechterBuurCel().getOrganisme();
	}
	
}
