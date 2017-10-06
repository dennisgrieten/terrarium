package be.vdab.terrarium.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum Terrarium {
    INSTANCE;

    private final Random random = new Random();
    private Cel[][] matrix;
    private int aantalNieuwePlantenPerDag;
    private List<Organisme> geborenOrganismen;
    private int breedte;
    private int hoogte;
    private List<Cel> legeCellen;


    private Terrarium() {
        this.legeCellen = new ArrayList<Cel>();
        this.geborenOrganismen = new ArrayList<Organisme>();
    }

    public Cel[][] getMatrix() {
        return this.matrix;
    }

    public int getHoogte() {
        return this.hoogte;
    }

    public int getBreedte() {
        return this.breedte;
    }

    public List<Cel> getLegeCellen() {
        return this.legeCellen;
    }

    public List<Organisme> getGeborenOrganismen() {
        return this.geborenOrganismen;
    }

    public void initMatrix(int breedte, int hoogte) {
        this.breedte = breedte;
        this.hoogte = hoogte;
        legeCellen.clear();
        matrix = new Cel[hoogte][breedte];
        // initialiseer cellen in de matrix met coördinaten
        for (int y = 0; y < getHoogte(); y++) {
            for (int x = 0; x < getBreedte(); x++) {
                matrix[y][x] = new Cel(y, x);
                legeCellen.add(matrix[y][x]);
            }
        }
    }

    // aparte init voor startorganismen om zo een leeg veld te krijgen
    public void initStartOrganismen(int planten, int plantenPerDag, int herbivoren, int carnivoren, int omnivoren) {
        if (isValideAantalNieuwePlanten(plantenPerDag)) {
            aantalNieuwePlantenPerDag = plantenPerDag;
        }

        if (isValideAantalOrganismen(planten, herbivoren, carnivoren, omnivoren)) {
            voegNieuwePlantenToe(planten);
            voegNieuweHerbivorenToe(herbivoren);
            voegNieuweCarnivorenToe(carnivoren);
            voegNieuweOmnivorenToe(omnivoren);
        }
    }

    // plaats organismen uit een array op random plaatsen in de matrix
    public void plaatsOrganisme(List<Organisme> organismen) {
        for (Organisme organisme : organismen) {
            if (!legeCellen.isEmpty()) {
                int n = random.nextInt(legeCellen.size());
                legeCellen.get(n).setOrganisme(organisme);
            }
        }
    }

    // plaats organisme op specifieke plaats
    public void plaatsOrganisme(Organisme organisme, int y, int x) {
        Cel cel = matrix[y][x];
        cel.setOrganisme(organisme);
    }

    // plaats organisme op willekeurige plaats
    public void plaatsOrganisme(Organisme organisme) {
        if (!legeCellen.isEmpty()) {
            int n = random.nextInt(legeCellen.size());
            legeCellen.get(n).setOrganisme(organisme);
        }
    }

    public void verplaatsOrganisme(Organisme organisme, List<Cel> legeCellen) {
        if (!legeCellen.isEmpty()) {
            int n = random.nextInt(legeCellen.size());
            organisme.getCel().unSetOrganisme();
            legeCellen.get(n).setOrganisme(organisme);
        }
    }

    public void verplaatsOrganisme(Organisme organisme) {
        verplaatsOrganisme(organisme, this.legeCellen);
    }

    public void voegNieuwePlantenToe() {
        for (int i = 0; i < aantalNieuwePlantenPerDag; i++) {
            plaatsOrganisme(new Plant());
        }
    }

    public void voegNieuwePlantenToe(int aantal) {
        for (int i = 0; i < aantal; i++) {
            plaatsOrganisme(new Plant());
        }
    }

    public void voegNieuweHerbivorenToe(int aantal) {
        for (int i = 0; i < aantal; i++) {
            plaatsOrganisme(new Herbivoor());
        }
    }

    public void voegNieuweCarnivorenToe(int aantal) {
        for (int i = 0; i < aantal; i++) {
            plaatsOrganisme(new Carnivoor());
        }
    }

    public void voegNieuweOmnivorenToe(int aantal) {
        for (int i = 0; i < aantal; i++) {
            plaatsOrganisme(new Omnivoor());
        }
    }

    private void dagActies(String simpleClassName) {
        for (int y = 0; y < getHoogte(); y++) {
            for (int x = 0; x < getBreedte(); x++) {
                Cel cel = matrix[y][x];
                Organisme organisme = cel.getOrganisme();
                if (organisme != null && organisme.getClass().getSimpleName().equals(simpleClassName)) {
                    if (!organisme.heeftGeageerd()) {
                        organisme.ageer();
                    }
                }
            }
        }
    }

    public void dagInit() {
        voegNieuwePlantenToe();
    }

    public void dagActies() {
        dagActies("Herbivoor");
        dagActies("Carnivoor");
        dagActies("Omnivoor");
        resetDieren();    // zet "heeftGeageerd" op false voor alle dieren;
        plaatsOrganisme(geborenOrganismen); // zet pasgeboren organismen in het terrarium
        geborenOrganismen.clear();
    }

    private void resetDieren() {
        for (int y = 0; y < getHoogte(); y++) {
            for (int x = 0; x < getBreedte(); x++) {
                Cel cel = matrix[y][x];
                Organisme organisme = cel.getOrganisme();
                if (organisme instanceof Dier) {
                    ((Dier) organisme).setHeeftGeageerd(false);
                }
            }
        }
    }

    // voor test
    private int getAantalOrganismen(String simpleClassName) {
        int aantal = 0;
        for (int y = 0; y < getHoogte(); y++) {
            for (int x = 0; x < getBreedte(); x++) {
                Organisme organisme = matrix[y][x].getOrganisme();
                if (organisme != null && organisme.getClass().getSimpleName().equals(simpleClassName)) {
                    aantal++;
                }
            }
        }
        return aantal;
    }

    // voor test
    public int getAantalPlanten() {
        return getAantalOrganismen("Plant");
    }

    // voor test
    public int getAantalHerbivoren() {
        return getAantalOrganismen("Herbivoor");
    }

    // voor test
    public int getAantalCarnivoren() {
        return getAantalOrganismen("Carnivoor");
    }

    // voor test
    public int getAantalOmnivoren() {
        return getAantalOrganismen("Omnivoor");
    }

    public boolean isValideHoogte(int hoogte) {
        return hoogte <= 25 && hoogte >= 6;
    }

    public boolean isValideBreedte(int hoogte, int breedte) {
        return isValideHoogte(hoogte) && hoogte >= breedte && breedte >= 6;
    }

    public boolean isValideAantalOrganismen(int planten, int herbivoren, int carnivoren, int omnivoren) {
        int minimum = 2;

        if (planten < minimum) {
            throw new IllegalArgumentException("foutieve aantal planten");
        }
        if (herbivoren < minimum) {
            throw new IllegalArgumentException("foutieve aantal herbivoren");
        }
        if (carnivoren < minimum) {
            throw new IllegalArgumentException("foutieve aantal carnivoren");
        }
        if (omnivoren < minimum) {
            throw new IllegalArgumentException("foutieve aantal omnivoren");
        }
        if (planten + herbivoren + carnivoren + omnivoren > (hoogte * breedte) / 2) {
            throw new IllegalArgumentException("Aantal organismen > 50% van het terrarium");
        }

        return true;
    }

    public boolean isValideAantalNieuwePlanten(int planten) {
        return planten > 0 && planten <= (int) Math.floor((hoogte * breedte) * 0.05);
    }
}
