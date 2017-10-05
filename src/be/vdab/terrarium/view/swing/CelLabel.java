package be.vdab.terrarium.view.swing;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import be.vdab.terrarium.model.Cel;
import be.vdab.terrarium.model.Organisme;

public class CelLabel extends JLabel {

	private static final long serialVersionUID = 1L;

	private final Cel cel;

	public CelLabel(Cel cel) {
		this.cel = cel;

		// setVerticalTextPosition(JLabel.TOP);
		// setHorizontalTextPosition(JLabel.LEFT);
		setBorder(LineBorder.createBlackLineBorder());
		// setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		// werkBij();
	}

	public void werkBij() {
		Organisme organisme = cel.getOrganisme();
		setIcon(new OrganismeIcon(organisme));
		repaint();
	}

}
