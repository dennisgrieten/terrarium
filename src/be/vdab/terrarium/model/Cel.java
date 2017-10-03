package be.vdab.terrarium.model;

import java.util.Objects;

public class Cel {

    private final int y;
    private final int x;

    private Organisme organisme = null;

    public Cel(int y, int x) {
        this.y = y;
        this.x = x;
    }
    
    public void setOrganisme(Organisme organisme) {
        this.organisme = organisme;
        if (organisme != null) {
            this.organisme.setCel(this);    // megeven van pointer naar deze cel
        }
    }

    public void unSetOrganisme() {
        this.organisme = null;
    }

    public Organisme getOrganisme() {
        return organisme;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
