package pl.edu.pw.fizyka.pojava.lagrange.layout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import net.miginfocom.swing.MigLayout;
import pl.edu.pw.fizyka.pojava.lagrange.model.ModelManager;
import pl.edu.pw.fizyka.pojava.lagrange.utilities.LFChooser;

public class LayoutManager {

	private JFrame frame;
	private ControlsPanel controlsPanel;
	private SettingsPanel settingsPanel;
	private ChartsPanel chartsPanel;
	private JPanel mainPanel;
	
	public LayoutManager(ModelManager model) {
		
		frame = new JFrame();
		
		controlsPanel = new ControlsPanel(model);
		settingsPanel = new SettingsPanel(model);
		chartsPanel = new ChartsPanel(model);
		mainPanel = new JPanel(new MigLayout());
		
		frame.setVisible(true);
		frame.setSize(600,1200);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		mainPanel.add(chartsPanel, "span 2,growx,wrap");
		mainPanel.add(settingsPanel,"right,gapleft 40");
		mainPanel.add(controlsPanel,"left,gapleft 40,wrap");
		mainPanel.add(new JLabel("Select look and feel :"), "right");
		mainPanel.add(new LFChooser(frame),"center, growx,wrap");
		
		frame.add(mainPanel);
		
	}

}
