package be.vdab.terrarium.view.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import be.vdab.terrarium.controller.Controller;

public class TerrariumFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private Controller controller = new Controller();

	private TerrariumPanel linksPanel, rechtsPanel;

	private final class VolgendeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			controller.dagInit();
			linksPanel.werkBij();
			controller.dagActies();
			rechtsPanel.werkBij();
		}

	}

	private final class SluitButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(DISPOSE_ON_CLOSE); // TODO
		}

	}

	public TerrariumFrame() {
		super("Terrarium");
		setLayout(new BorderLayout());

		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);

		
		linksPanel = new TerrariumPanel();
		centerPanel.add(linksPanel);
		controller.dagActies();
		rechtsPanel = new TerrariumPanel();
		centerPanel.add(rechtsPanel);

		JButton volgendeButton = new JButton("volgende");
		JButton sluitButton = new JButton("sluit");
		southPanel.add(volgendeButton);
		southPanel.add(sluitButton);
		volgendeButton.addActionListener(new VolgendeButtonListener());
		sluitButton.addActionListener(new SluitButtonListener());

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
//		controller.dagActies();
//		rechtsPanel.werkBij();

	}

}
