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
    private int aantalBabyHerbivoren;

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
    	legeCellen.clear();
        // initialiseer cellen in de matrix met coördinaten
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Cel(i, j);
                legeCellen.add(matrix[i][j]);
            }
        }
    }

    // aparte init voor startorganismen om zo een leeg veld te krijgen
    public void initStartOrganismen() {
        // vul matrix met start organismen
    	initMatrix();
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
    
    public void plaatsOrganisme(Organisme organisme, int x, int y) {
    	Cel cel = matrix[y][x];
    	cel.setOrganisme(organisme);
    	legeCellen.remove(cel);
    }

    public void plaatsOrganisme(Organisme organisme, ArrayList<Cel> legeBuren) {
        int n = random.nextInt(legeBuren.size());
        legeBuren.get(n).setOrganisme(organisme);
    }

    public void voegNieuwePlantenToe(int aantal) {
    	Collections.shuffle(legeCellen);
    	for (int i = 0; i < aantal; i++) {
    		if (legeCellen.isEmpty()) break;
    		Cel cel = legeCellen.remove(0);
    		cel.setOrganisme(new Plant());
    	}
    }
    
    public void voegNieuweHerbivorenToe(int aantal){
    	Collections.shuffle(legeCellen);
    	for (int i = 0; i < aantal; i++) {
    		if (legeCellen.isEmpty()) break;
    		Cel cel = legeCellen.remove(0);
    		cel.setOrganisme(new Herbivoor());
    	}
    }

    public void voegBabyHerbivorenToe(){
    	voegNieuweHerbivorenToe(aantalBabyHerbivoren);
    }
    
    private void dagIteratie(String letter) {
    	for (int y = 0; y < getHoogte(); y++) {
    		for (int x = 0; x < getBreedte(); x++) {
        		if ( matrix[y][x].toString().equals(letter) ) {
        			matrix[y][x].getOrganisme().ageer();
        		}
        	}	
    	}
    }
    
    
    public void dagIteratie() {
    	voegNieuwePlantenToe(2);	// TODO proper
    	dagIteratie("H");
    	dagIteratie("C");
    	voegBabyHerbivorenToe();
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
                output.append(matrix[i][j].toString() + "  ");
            }
            output.append("\n");
        }
        return output.toString();
    }

    public void verhoogBabyHerbivoren() {
    	aantalBabyHerbivoren++;
    }

 	public void doMagicJump(int x, int y) {
        int n = random.nextInt(legeCellen.size());
        Cel cel = matrix[x][y];
        legeCellen.get(n).setOrganisme(cel.getOrganisme());
        legeCellen.remove(n);
	}

}    

