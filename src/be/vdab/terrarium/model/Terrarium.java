package be.vdab.terrarium.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum Terrarium {
    INSTANCE;

    private final int DIMENSIE = 6;
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
        legeCellen = new ArrayList<>();
        initMatrix();
    }

    private void initMatrix() {
        // initialiseer cellen in de matrix met coÃ¶rdinaten
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Cel(i, j);
                legeCellen.add(matrix[i][j]);
            }
        }

        // vul matrix met start organismen
        plaatsOrganisme(startOrganismen);
    }

    // plaats organismen uit een array op random plaatsen in de matrix
    private void plaatsOrganisme(Organisme[] organismen) {
        for (Organisme organisme : organismen) {
            int n = random.nextInt(legeCellen.size());
            legeCellen.get(n).setOrganisme(organisme);
            legeCellen.remove(n);
        }
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
    
//    public void beweeg(int x, int y) {
//    	if (!beegNaarBovenOK(x, y)) {
//    		if (!beweegNaarOnderOK) {
//    			if (!beweegNaarLinksOk) {
//    				if (!beweegNaarRechtsOK) {
//    					magicJump();
//    				}
//    			}
//    		}
//    	}
//    		
//    		
//    }

//	if (((x - 1) < 0) || ((y + 1) > DIMENSIE)) {
//	
//}
//if ((y + 1) > DIMENSIE) {
//	magicJump();
//} else {
//	
//}

    
    boolean beweegNaarBovenOK(int x, int y) {
    	if (x - 1 < 0) {
    		return false;
    	}
    	matrix[x - 1][y] = matrix[x][y];
    	Cel celNaar = (Cel) (matrix[x - 1][y]);
    	celNaar.setOrganisme(null);
    	Cel celVan = (Cel) (matrix[x][y]);
    	celVan.setOrganisme(celNaar.getOrganisme());
    	return true;
    }
    
    private void magicJump() {
    	
    }
}
