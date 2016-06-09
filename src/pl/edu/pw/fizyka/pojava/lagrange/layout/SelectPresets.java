package pl.edu.pw.fizyka.pojava.lagrange.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import pl.edu.pw.fizyka.pojava.lagrange.model.ModelManager;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.WaveParameters;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.WaveTypes;
import pl.edu.pw.fizyka.pojava.lagrange.utilities.Preset;

public class SelectPresets extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Preset> presets;
	private ModelManager model;
	private JComboBox<Preset> presetsDisplay;
	private DefaultComboBoxModel<Preset> boxModel;
	
	public SelectPresets(ModelManager model) {
		
		this.model = model;
		this.presets = new ArrayList<Preset>();
		
		Preset sineSquare = new Preset("Jumping Sine");
		sineSquare.addWave(WaveTypes.SINE.getWave(new WaveParameters(3300, 0.5)));
		sineSquare.addWave(WaveTypes.SQUARE.getWave(new WaveParameters(300, 1)));
		
		presets.add(sineSquare);
		
		presetsDisplay=new JComboBox<Preset>();
		boxModel  = new DefaultComboBoxModel<Preset>();
		presetsDisplay.setModel(boxModel);
		
		for(Preset preset : presets){
			boxModel.addElement(preset);
		}
		
		presetsDisplay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SelectPresets.this.model.loadPreset((Preset) presetsDisplay.getSelectedItem());
				
			}
		});
		
		this.setLayout(new MigLayout());
		this.add(new JLabel("Load Preset :"),"wrap");
		this.add(presetsDisplay,"wrap,grow");
		
		
	}
	


}
