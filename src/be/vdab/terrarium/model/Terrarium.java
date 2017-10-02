package be.vdab.terrarium.model;

public enum Terrarium {
    INSTANCE;

    private final int DIMENSIE = 6;
    private final Organisme[] initOrganismen = {
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

    Terrarium() {
        matrix = new Cel[DIMENSIE][DIMENSIE];
        matrixInit();
    }

    private void matrixInit() {
        // initialiseer cellen in de matrix met coördinaten
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Cel(i, j);
            }
        }
    }
}
