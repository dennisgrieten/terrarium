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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cel cel = (Cel) o;

        if (x != cel.x) return false;
        if (y != cel.y) return false;
        return organisme != null ? organisme.equals(cel.organisme) : cel.organisme == null;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + (organisme != null ? organisme.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        if (this.organisme != null) {
            return organisme.toString();
        }
        return ".";
    }
}
