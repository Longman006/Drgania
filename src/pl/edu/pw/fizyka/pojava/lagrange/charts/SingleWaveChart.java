package pl.edu.pw.fizyka.pojava.lagrange.charts;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import pl.edu.pw.fizyka.pojava.lagrange.model.ModelManager;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.Wave;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.WaveParameters;
import pl.edu.pw.fizyka.pojava.lagrange.utilities.WaveTypes;

public class SingleWaveChart extends CustomDynamicChart {

	protected Wave wave;
	protected JComboBox<Wave> waveDisplaySelection;
	
	public SingleWaveChart(ModelManager model) {
		super(model);
		wave = WaveTypes.SINE.getWave(new WaveParameters(100, 1));
		waveDisplaySelection =  new JComboBox<Wave>();
		//waveDisplaySelection.setMinimumSize(new Dimension(100,50));
		waveDisplaySelection.addPopupMenuListener(new PopupMenuListener() {
			
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				System.out.println("PopupBecameVisible");
				
				int itemCount = SingleWaveChart.this.waveDisplaySelection.getItemCount();
				Wave[] array = SingleWaveChart.this.model.getWavesArray();
				int diff = array.length- itemCount;
						
				if(diff>0){
					for(int ii = itemCount ; ii < diff ; ii++){
						SingleWaveChart.this.waveDisplaySelection.addItem(array[ii]);
					}
				}
			}
			
			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				System.out.println("JComboBox has become invisible");
				
	
				
				
				
			}
			
			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
				System.out.println("PopupMenuCanceled");
				
				
			}
		});
		this.waveDisplaySelection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				wave = (Wave) waveDisplaySelection.getSelectedItem();
				updateTitle();
				//SingleWaveChart.this.tickCount = 0;
				
			}
		});
		this.add(new JLabel("Select Wave : "),"split 2");
		this.add(waveDisplaySelection,"growx,wrap");
		
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
		super.chart.setTitle(this.wave.toString());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		long numberOfUnits = super.tickCount*super.unitsPerTick;
		double time = super.unit.getDecimal()*numberOfUnits;
		double displacement = this.wave.calculateWave(time);
		
		super.series.add(tickCount,displacement);
		super.tickCount++;

	}

}
