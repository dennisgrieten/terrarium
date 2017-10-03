package be.vdab.terrarium.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Terrarium {
    INSTANCE;

    public static final int DIMENSIE = 6;
    
    private final Random random = new Random();
    private final Organisme[] startOrganismen = {
            new Plant(),
            new Plant(),
            new Plant(),
            new Plant(),
            new Herbivoor(),
            new Herbivoor(),
            new Herbivoor(),
            new Herbivoor(),
            new Herbivoor(),
            new Carnivoor(),
            new Carnivoor(),
            new Carnivoor()
    };
    private Cel[][] matrix;
    private List<Cel> legeCellen;

    Terrarium() {
        matrix = new Cel[DIMENSIE][DIMENSIE];
        legeCellen = new ArrayList<Cel>();
        initMatrix();
    }

    public Cel[][] getMatrix() {
    	return matrix;
    }
    
    public int getHoogte() {
    	return DIMENSIE;
    }
    
    public int getBreedte() {
    	return DIMENSIE;
    }
    
    private void initMatrix() {
        // initialiseer cellen in de matrix met coördinaten
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Cel(i, j);
                legeCellen.add(matrix[i][j]);
            }
        }
    }

    public void initStartOrganismen() {
        // vul matrix met start organismen
        plaatsOrganisme(startOrganismen);
    }


    // plaats organismen uit een array op random plaatsen in de matrix
    public void plaatsOrganisme(Organisme[] organismen) {
        for (Organisme organisme : organismen) {
            int n = random.nextInt(legeCellen.size());
            legeCellen.get(n).setOrganisme(organisme);
            legeCellen.remove(n);
        }
    }
    
    public void plaatsOrganisme(Organisme organisme, int i, int j) {
    	Cel cel = matrix[i][j];
    	cel.setOrganisme(organisme);
    	legeCellen.remove(cel);
    }

    public void voegNieuwePlantenToe(int aantal) {
    	Collections.shuffle(legeCellen);
    	for (int i = 0; i < aantal; i++) {
    		if (legeCellen.isEmpty()) break;
    		Cel cel = legeCellen.remove(0);
    		cel.setOrganisme(new Plant());
    	}
    }
    
    // voor test
    public int getAantalPlanten() {
        int aantal = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Organisme organisme = matrix[i][j].getOrganisme();
                if (organisme != null && organisme instanceof Plant) {
                    aantal++;
                }
            }
        }
        return aantal;
    }

    // voor test
    public int getAantalHerbivoren() {
        int aantal = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Organisme organisme = matrix[i][j].getOrganisme();
                if (organisme != null && organisme instanceof Herbivoor) {
                    aantal++;
                }
            }
        }
        return aantal;
    }

    // voor test
    public int getAantalCarnivoren() {
        int aantal = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Organisme organisme = matrix[i][j].getOrganisme();
                if (organisme != null && organisme instanceof Carnivoor) {
                    aantal++;
                }
            }
        }
        return aantal;
    }


    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                output.append(matrix[i][j].toString());
            }
            output.append("\n");
        }
        return output.toString();
    }
}
