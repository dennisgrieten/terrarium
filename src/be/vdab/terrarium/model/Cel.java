package be.vdab.terrarium.model;

public class Cel {
    private final int x;
    private final int y;
    private Organisme organisme = null;

    public Cel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setOrganisme(Organisme organisme) {
        this.organisme = organisme;
    }

    public Organisme getOrganisme() {
        return organisme;
    }
}
