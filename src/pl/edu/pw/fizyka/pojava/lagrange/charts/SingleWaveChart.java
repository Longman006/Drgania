package pl.edu.pw.fizyka.pojava.lagrange.charts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;


import pl.edu.pw.fizyka.pojava.lagrange.model.ModelManager;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.Wave;

import pl.edu.pw.fizyka.pojava.lagrange.utilities.WaveSelection;


public class SingleWaveChart extends CustomDynamicChart {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Wave wave;
	protected JComboBox<Wave> waveDisplaySelection;
	protected WaveSelection waveSelection;
	protected DefaultComboBoxModel<Wave> boxModel;
	
	public SingleWaveChart(ModelManager model) {
		super(model);
		
		
		super.chart.setTitle("SingleWaveChart");
		
		wave = null;
		boxModel = new DefaultComboBoxModel<>();
		waveDisplaySelection =  new JComboBox<Wave>();
		
		this.waveSelection = new WaveSelection(model);
		this.waveSelection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ActionPerformed");
				Wave newWave = (Wave) waveSelection.getSelectedItem();
				wave = newWave;
				System.out.println("wave : "+wave);
				updateTitle();
			}
		});
		
		this.add(new JLabel("Select Wave : "),"split 2");
		this.add(waveSelection,"growx,wrap");
		this.updateTitle();
		
	}

	/**
	 * @return the wave
	 */
	public Wave getWave() {
		return wave;
	}

	/**
	 * @param wave the wave to set
	 */
	public void setWave(Wave wave) {
		this.wave = wave;
	}

	@Override
	protected void updateTitle() {
		try{
			super.chart.setTitle(this.wave.toString());
		}
		catch(Exception e){
			System.out.println("Chart Title exception:"+e);
			super.chart.setTitle("No wave Selected");
			return;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		long numberOfUnits = super.tickCount*super.unitsPerTick;
		double time = super.unit.getDecimal()*numberOfUnits;
		double displacement = 0;
		try{
			displacement = this.wave.calculateWave(time);
		}
		catch(Exception e){
			//System.out.println(e);
			return;
		}
		
		super.series.add(tickCount,displacement);
		super.tickCount++;

	}

}
