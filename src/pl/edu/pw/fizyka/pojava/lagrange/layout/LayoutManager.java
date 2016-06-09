package pl.edu.pw.fizyka.pojava.lagrange.layout;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.WindowConstants;

import net.miginfocom.swing.MigLayout;
import pl.edu.pw.fizyka.pojava.lagrange.model.ModelManager;


public class LayoutManager {

	private JFrame frame;
	private ControlsPanel controlsPanel;
	private SettingsPanel settingsPanel;
	private ChartsPanel chartsPanel;
	private DeleteWavePanel deletePanel;
	private SelectPresets presetPanel;
	private JPanel comboPanel;
	private JPanel mainPanel;
	
	public LayoutManager(ModelManager model) {
		
		frame = new JFrame();
		
		comboPanel = new JPanel(new MigLayout());
		presetPanel = new SelectPresets(model);
		deletePanel = new DeleteWavePanel(model);
		controlsPanel = new ControlsPanel(model);
		settingsPanel = new SettingsPanel(model);
		chartsPanel = new ChartsPanel(model);
		mainPanel = new JPanel(new MigLayout());
		
		frame.setVisible(true);
		frame.setSize(600,1200);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		comboPanel.add(presetPanel,"grow,wrap");
		comboPanel.add(deletePanel,"grow,wrap");
	
		
		mainPanel.add(chartsPanel, "span 4,growx,growy,wrap");
		mainPanel.add(settingsPanel,"center");
		mainPanel.add(controlsPanel,"center");
		mainPanel.add(comboPanel,"grow,center");
		
		frame.add(mainPanel);
		frame.pack();
		
	}

}
