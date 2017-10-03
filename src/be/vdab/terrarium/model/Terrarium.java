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
    	legeCellen.clear();
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
    
    public Cel getCelInMatrix(int x, int y) {
    	if (x < 0 || x >= DIMENSIE || y < 0 || y >= DIMENSIE) {
    		throw new IllegalArgumentException();
    	}
    	return matrix[x][y];
    }


    void beweeg(int x, int y) {
    	if (!beweegNaarBovenOK(x, y)) {
    		if (!beweegNaarOnderOK(x, y)) {
    			if (!beweegNaarLinksOK(x, y)) {
    				if (!beweegNaarRechtsOK(x, y)) {
    					doMagicJump(x, y);
    				}
    			}
    		}
    	}
    }
    
    boolean beweegNaarBovenOK(int x, int y) {
    	Cel celVan = matrix[x][y];
    	if (!isCelVanValid(celVan)) {
			return false;
		}
		// is er plaats boven?
		if (x - 1 < 0) {
			return false;
		}
		Cel celNaar = matrix[x - 1][y];
		// is cel erboven reeds bezet?
		if (celNaar.getOrganisme() != null) {
			return false;
		}
		matrix[x - 1][y] = matrix[x][y];
		celNaar.setOrganisme(celVan.getOrganisme());
		celVan.setOrganisme(null);
		return true;
	}
	
    private boolean isCelVanValid(Cel cel) {
		if (cel.getOrganisme() == null) {
			return false;
		}
		return true;
    }

    boolean beweegNaarOnderOK(int x, int y) {
    	Cel celVan = matrix[x][y];
    	if (!isCelVanValid(celVan)) {
			return false;
		}
		if (x + 1 >= DIMENSIE) {
			return false;
		}
		Cel celNaar = matrix[x + 1][y];
		if (celNaar.getOrganisme() != null) {
			return false;
		}

		matrix[x + 1][y] = matrix[x][y];
		celNaar.setOrganisme(celVan.getOrganisme());
		celVan.setOrganisme(null);
		return true;
	}
	
	boolean beweegNaarLinksOK(int x, int y) {
		if (y - 1 < 0) {
			return false;
		}
		Cel celNaar = matrix[x][y - 1];
		if (celNaar.getOrganisme() != null) {
			return false;
		}

		Cel celVan = matrix[x][y];
		matrix[x][y - 1] = matrix[x][y];
		celNaar.setOrganisme(celVan.getOrganisme());
		celVan.setOrganisme(null);
		return true;
	}
	
	boolean beweegNaarRechtsOK(int x, int y) {
		if (y + 1 >= DIMENSIE) {
			return false;
		}
		Cel celNaar = matrix[x][y + 1];
		if (celNaar.getOrganisme() != null) {
			return false;
		}

		Cel celVan = matrix[x][y];
		matrix[x][y + 1] = matrix[x][y];
		celNaar.setOrganisme(celVan.getOrganisme());
		celVan.setOrganisme(null);
		return true;
	}
	
	private void doMagicJump(int x, int y) {
        int n = random.nextInt(legeCellen.size());
        Cel cel = matrix[x][y];
        legeCellen.get(n).setOrganisme(cel.getOrganisme());
        legeCellen.remove(n);
	}

}    

