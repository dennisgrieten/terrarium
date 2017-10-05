package be.vdab.terrarium.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Terrarium {
	INSTANCE;

	public static final int DIMENSIE = 6;
	public static final int AANTAL_NIEUWE_PLANTEN_PER_DAG = 2;

	private final Random random = new Random();
	private final Organisme[] startOrganismen = { new Plant(), new Plant(), new Plant(), new Plant(), new Herbivoor(),
			new Herbivoor(), new Herbivoor(), new Herbivoor(), new Herbivoor(), new Carnivoor(), new Carnivoor(),
			new Carnivoor() };
	private Cel[][] matrix;
	private List<Cel> legeCellen;
	private int aantalBabyHerbivoren;

	private Terrarium() {
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

	public List<Cel> getLegeCellen() {
		return this.legeCellen;
	}

	public void initMatrix() {
		legeCellen.clear();
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
		initMatrix();
		verplaatsOrganisme(startOrganismen);
	}

	// plaats organismen uit een array op random plaatsen in de matrix
	public void verplaatsOrganisme(Organisme[] organismen) {
		for (Organisme organisme : organismen) {
			int n = random.nextInt(legeCellen.size());
			legeCellen.get(n).setOrganisme(organisme);
		}
	}

	public void verplaatsOrganisme(Organisme organisme, int y, int x) {
		Cel cel = matrix[y][x];
		cel.setOrganisme(organisme);
	}

	public void verplaatsOrganisme(Organisme organisme, List<Cel> legeCellen) {
		int n = random.nextInt(legeCellen.size());
		organisme.getCel().unSetOrganisme();
		legeCellen.get(n).setOrganisme(organisme);
	}

	public void verplaatsOrganisme(Organisme organisme) {
		verplaatsOrganisme(organisme, this.legeCellen);
	}

	public void voegNieuwePlantenToe() {
		Collections.shuffle(legeCellen);
		for (int i = 0; i < AANTAL_NIEUWE_PLANTEN_PER_DAG; i++) {
			if (legeCellen.isEmpty())
				break;
			Cel cel = legeCellen.get(0);
			cel.setOrganisme(new Plant());
		}
	}

	public void voegNieuweHerbivorenToe(int aantal) {
		Collections.shuffle(legeCellen);
		for (int i = 0; i < aantal; i++) {
			if (legeCellen.isEmpty())
				break;
			Cel cel = legeCellen.get(0);
			cel.setOrganisme(new Herbivoor());
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

}
