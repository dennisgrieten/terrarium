package be.vdab.terrarium.model;

public abstract class Organisme {

    private static int count;

    private int id;
    private int levenskracht;
    private Cel cel = null; // pointer naar de cel waar het organisme zich in bevindt

    public Organisme() {
        id = count++;
        setLevenskracht(1);
    }

    public int getId() {
        return id;
    }

    public abstract void ageer();

    public void setLevenskracht(int levenskracht) {
        this.levenskracht = levenskracht;
    }

    public abstract boolean heeftGeageerd();

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
        this.setCel(null);
    }

    public Cel getRechterBuurCel() {
        int x = cel.getX();
        int y = cel.getY();
        if (x < Terrarium.INSTANCE.getBreedte() - 1) {
            return Terrarium.INSTANCE.getMatrix()[y][x + 1];
        } else {
            return null;
        }
    }

    public Organisme getRechterBuur() {
        Cel buurCel = getRechterBuurCel();
        return buurCel == null ? null : buurCel.getOrganisme();
    }

    public Cel getLinkerBuurCel() {
        int x = cel.getX();
        int y = cel.getY();
        if (x > 0) {
            return Terrarium.INSTANCE.getMatrix()[y][x - 1];
        } else {
            return null;
        }
    }

    public Organisme getLinkerBuur() {
        return getLinkerBuurCel().getOrganisme();
    }

    public Cel getBovenBuurCel() {
        int x = cel.getX();
        int y = cel.getY();
        if (y > 0) {
            return Terrarium.INSTANCE.getMatrix()[y - 1][x];
        } else {
            return null;
        }
    }

    public Organisme getBovenBuur() {
        return getBovenBuurCel().getOrganisme();
    }

    public Cel getOnderBuurCel() {
        int x = cel.getX();
        int y = cel.getY();
        if (y < Terrarium.INSTANCE.getHoogte() - 1) {
            return Terrarium.INSTANCE.getMatrix()[y + 1][x];
        } else {
            return null;
        }
    }

    public Organisme getOnderBuur() {
        return getBovenBuurCel().getOrganisme();
    }

    public void addLevenskracht(int kracht) {
        this.levenskracht += kracht;
    }

}
