package be.vdab.terrarium.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum Terrarium {
    INSTANCE;

    public static final int AANTAL_NIEUWE_PLANTEN_PER_DAG = 2;

    private final Random random = new Random();
    private final Organisme[] startOrganismen = {new Plant(), new Plant(), new Plant(), new Plant(), new Herbivoor(),
            new Herbivoor(), new Herbivoor(), new Herbivoor(), new Herbivoor(), new Carnivoor(), new Carnivoor(),
            new Carnivoor()};
    private static Cel[][] matrix;
    private static int aantalBabyHerbivoren;
    private static int breedte;
    private static int hoogte;
    private List<Cel> legeCellen;


    private Terrarium() {
        this.legeCellen = new ArrayList<Cel>();
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

    public void initMatrix(int breedte, int hoogte) {
        Terrarium.breedte = breedte;
        Terrarium.hoogte = hoogte;
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
    public void initStartOrganismen() {
        // vul matrix met start organismen
        plaatsOrganisme(startOrganismen);
    }

    // plaats organismen uit een array op random plaatsen in de matrix
    public void plaatsOrganisme(Organisme[] organismen) {
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
        for (int i = 0; i < AANTAL_NIEUWE_PLANTEN_PER_DAG; i++) {
            plaatsOrganisme(new Plant());
        }
    }

    public void voegNieuweHerbivorenToe(int aantal) {
        for (int i = 0; i < aantal; i++) {
            plaatsOrganisme(new Herbivoor());
        }
    }

    public void voegBabyHerbivorenToe() {
        voegNieuweHerbivorenToe(aantalBabyHerbivoren);
        aantalBabyHerbivoren = 0;
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
        voegBabyHerbivorenToe();
        resetDieren();    // zet "heeftGeageerd" op false voor alle dieren;
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

    public void verhoogBabyHerbivoren() {
        aantalBabyHerbivoren++;
    }

    public boolean isValideHoogte(int hoogte) {
        return hoogte <= 25 && hoogte >= 6;
    }

    public boolean isValideBreedte(int hoogte, int breedte ) {
        return true;
    }

    public boolean isValideAantalOrganismen(int planten, int herbivoren, int carnivoren) {
        return true;
    }
}
