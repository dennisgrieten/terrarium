package be.vdab.terrarium.view.swing;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.vdab.terrarium.controller.Controller;

public class ConfigPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private int hoogte;
	private int breedte;
	private int aantalNieuwePlantenPerDag;
	private int aantalPlantenBijStart;
	private int aantalHerbivorenBijStart;
	private int aantalCarnivorenBijStart;
	private int aantalOmnivorenBijStart;

	public ConfigPanel() {
		Controller controller = new Controller();

		JTextField hoogteField = new JTextField(5);
		JTextField breedteField = new JTextField(5);
		JTextField aantalNieuwePlantenPerDagField = new JTextField(5);
		JTextField aantalPlantenBijStartField = new JTextField(5);
		JTextField aantalHerbivorenBijStartField = new JTextField(5);
		JTextField aantalCarnivorenBijStartField = new JTextField(5);
		JTextField aantalOmnivorenBijStartField = new JTextField(5);

		setLayout(new GridLayout(7, 2));
		add(new JLabel("hoogte:"));
		add(hoogteField);
		add(new JLabel("breedte:"));
		add(breedteField);
		add(new JLabel("aantal nieuwe planten per dag:"));
		add(aantalNieuwePlantenPerDagField);
		add(new JLabel("aantal planten bij start:"));
		add(aantalPlantenBijStartField);
		add(new JLabel("aantal herbivoren bij start:"));
		add(aantalHerbivorenBijStartField);
		add(new JLabel("aantal carnivoren bij start:"));
		add(aantalCarnivorenBijStartField);
		add(new JLabel("aantal omnivoren bij start:"));
		add(aantalOmnivorenBijStartField);

		boolean verkeerdeInvoer;
		do {
			verkeerdeInvoer = false;
			int result = JOptionPane.showConfirmDialog(null, this, "INGAVE FLEXIBELE GEGEVENS TERRARIUM:",
					JOptionPane.OK_CANCEL_OPTION);

			if (result == JOptionPane.CANCEL_OPTION) {
				System.exit(ABORT);
			}

			if (result == JOptionPane.OK_OPTION) {
				hoogte = Integer.parseInt(hoogteField.getText());
				breedte = Integer.parseInt(breedteField.getText());
				aantalNieuwePlantenPerDag = Integer.parseInt(aantalNieuwePlantenPerDagField.getText());
				aantalPlantenBijStart = Integer.parseInt(aantalPlantenBijStartField.getText());
				aantalHerbivorenBijStart = Integer.parseInt(aantalHerbivorenBijStartField.getText());
				aantalCarnivorenBijStart = Integer.parseInt(aantalCarnivorenBijStartField.getText());

				String errorMessage = "";
				if (!controller.isValideHoogte(hoogte)) {
					verkeerdeInvoer = true;
					errorMessage += "De hoogte is fout. Moet tussen 6 en 25 zijn.\n";
				}
				if (!controller.isValideBreedte(hoogte, breedte)) {
					verkeerdeInvoer = true;
					errorMessage += "De breedte is fout. Moet tussen 6 en 25 zijn. Bovendien breedte <= hoogte.\n";
				}

				if (!verkeerdeInvoer) {
					controller.initMatrix(breedte, hoogte);
					if (!controller.isValideAantalNieuwePlanten(aantalNieuwePlantenPerDag)) {
						verkeerdeInvoer = true;
						errorMessage += "Het aantal nieuwe planten per dag is fout. Moet > 0 en max. 5% van aantal cellen zijn.\n";
					}
					try {
						controller.isValideAantalOrganismen(aantalPlantenBijStart, aantalHerbivorenBijStart,
								aantalCarnivorenBijStart, aantalOmnivorenBijStart);
					} catch (IllegalArgumentException e) {
						verkeerdeInvoer = true;
						errorMessage += "Fout betreft aantal organismen bij start: " + e.getMessage() + "\n";
					}
				}
				if (verkeerdeInvoer) {
					JOptionPane.showMessageDialog(this, errorMessage, "Ingegeven data is foutief. ",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		} while (verkeerdeInvoer);

	}

	public int getHoogte() {
		return hoogte;
	}

	public int getBreedte() {
		return breedte;
	}

	public int getAantalNieuwePlantenPerDag() {
		return aantalNieuwePlantenPerDag;
	}

	public int getAantalPlantenBijStart() {
		return aantalPlantenBijStart;
	}

	public int getAantalHerbivorenBijStart() {
		return aantalHerbivorenBijStart;
	}

	public int getAantalCarnivorenBijStart() {
		return aantalCarnivorenBijStart;
	}

	public int getAantalOmnivorenBijStart() {
		return aantalOmnivorenBijStart;
	}

}
