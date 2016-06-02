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
		
		
		mainPanel.add(chartsPanel, "growx,growy,wrap");
		mainPanel.add(settingsPanel,"split 2,center");
		mainPanel.add(controlsPanel,"wrap");
		mainPanel.add(new JLabel("Select look and feel :"), "split 2,center");
		mainPanel.add(new LFChooser(frame),"right, growx,wrap");
		
		frame.add(mainPanel);
		frame.pack();
		
	}

}
