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
		int imax = 20;
		
		Preset sineSquare = new Preset("Jumping Sine");
		sineSquare.addWave(WaveTypes.SINE.getWave(new WaveParameters(3300, 0.5)));
		sineSquare.addWave(WaveTypes.SQUARE.getWave(new WaveParameters(300, 1)));
		presets.add(sineSquare);
		
		Preset diracDeltas = new Preset("Dirac Deltas");
	
		for(int ii = 0; ii<imax ;ii++){
			diracDeltas.addWave(WaveTypes.SINE.getWave(new WaveParameters(ii, ii)));
		}
		presets.add(diracDeltas);
		
		Preset sawTooth = new Preset("Sawtooth");
		for(int ii = 1; ii<imax ; ii++){
			sawTooth.addWave(WaveTypes.SINE.getWave(
					new WaveParameters(
							ii,
							(double) 2*Math.pow(-1, ii+1)/ii
					)));
		}
		presets.add(sawTooth);
		
		Preset square = new Preset("Square");
		for(int ii = 1; ii<imax ; ii++){
			square.addWave(WaveTypes.SINE.getWave(
					new WaveParameters(
							2*ii+1,
							(double) 2/(2*ii+1)
					)));
		}
		presets.add(square);
		
		Preset xx = new Preset("x");
		for(int ii = 1; ii<imax ; ii++){
			xx.addWave(WaveTypes.SINE.getWave(
					new WaveParameters(
							4*ii,
							(double) 2*Math.pow(-1, ii+1)/ii/Math.PI
					)));
			xx.addWave(WaveTypes.COSINE.getWave(
					new WaveParameters(
							4*ii,
							(double) 2*(Math.pow(-1, ii+1)-1)/Math.pow(ii, 2)/Math.pow(Math.PI,2)
					)));
		}
		xx.addWave(WaveTypes.CONST.getWave(new WaveParameters(1, (double)1/2)));
		presets.add(xx);
		
		Preset rumble = new Preset ("Rumble 440 hz");
		rumble.addWave(WaveTypes.SINE.getWave(new WaveParameters(440, 1)));
		rumble.addWave(WaveTypes.SINE.getWave(new WaveParameters(444, 1)));
		rumble.addWave(WaveTypes.SINE.getWave(new WaveParameters(448, 1)));
		presets.add(rumble);
		
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
