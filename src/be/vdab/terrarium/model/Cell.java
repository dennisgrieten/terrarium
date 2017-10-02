package be.vdab.terrarium.model;

public class Cell {
    private int x;
    private int y;
    private Organisme organisme = null;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setOrganisme(Organisme organisme) {
        this.organisme = organisme;
    }
}
