package be.vdab.terrarium.model;

import java.util.Objects;

public class Cel {
    private final int x;
    private final int y;
    private Organisme organisme = null;

    public Cel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
    	return x;
    }
    
    public int getY() {
    	return y;
    }
    
    public void setOrganisme(Organisme organisme) {
        this.organisme = organisme;
    }

    public Organisme getOrganisme() {
        return organisme;
    }

    @Override
    public boolean equals(Object obj) {
    	if (this == obj) return true;
    	if (obj instanceof Cel) {
    		Cel other = (Cel)obj;
    		return x == other.x && y == other.y && Objects.equals(organisme, other.organisme);
    	} else {
    		return false;
    	}
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y,organisme);
    }

    @Override
    public String toString() {
        if (this.organisme != null) {
            return organisme.toString();
        }
        return ".";
    }
}
