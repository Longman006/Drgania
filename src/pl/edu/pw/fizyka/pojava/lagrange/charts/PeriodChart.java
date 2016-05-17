package pl.edu.pw.fizyka.pojava.lagrange.charts;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import net.miginfocom.swing.MigLayout;
import pl.edu.pw.fizyka.pojava.lagrange.model.ModelManager;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.SineWave;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.Wave;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.WaveParameters;

public class PeriodChart extends JPanel {

	private XYDataset dataset;
	private Wave wave;
	private JFreeChart chart;
	private ChartPanel chartPanel;
	private ModelManager model;
	private JComboBox<Wave> waveDisplaySelection;
	private JPanel settingsPanel;
	
	private int points = 100;
	private int updateSpeed = 2000;//miliseconds
	
	/**
	 * @param model
	 */
	public PeriodChart(ModelManager model) {
		
		this.setLayout(new MigLayout());
		settingsPanel = new JPanel(new FlowLayout());
		
		//waveDisplaySelection = new JComboBox<Wave>();
		this.model = model;
		/*
		
		
		waveDisplaySelection.addPopupMenuListener(new PopupMenuListener(){

			@Override
			public void popupMenuCanceled(PopupMenuEvent arg0) {
				
				Wave waveTmp = (Wave) waveDisplaySelection.getSelectedItem();
				if(waveTmp != wave){
					
					wave=waveTmp;
					UpdateDisplay();
				}
				
				
				
			}

			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				UpdateOptions();
				
			}

			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				System.out.println("JComboBox has become invisible");
			}
			
		});;
		waveDisplaySelection.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				wave= (Wave)waveDisplaySelection.getSelectedItem();
				
			}
			
		});
		*/
		wave= new SineWave(new WaveParameters(
				440, // frequency 
				1   // Amplitude
				));
		
		dataset = createDataset();
		chart = createChart(dataset);
		chartPanel = new ChartPanel(chart);
		this.add(chartPanel);
		//this.add(waveDisplaySelection);
	}

	protected void UpdateDisplay() {
		chart.getXYPlot().setDataset(createDataset());
	}

	protected void UpdateOptions() {
		
		if(this.waveDisplaySelection.getComponentCount() != 
				model.getCurrentWaveContainerSize()){
			
			waveDisplaySelection.removeAllItems();
			
			for(Wave wave : model.getCurrentWaveArray() ){
				
				waveDisplaySelection.addItem(wave);
			}
		}
		
	}

	/**
	 * @param dataset
	 * @return
	 */
	private JFreeChart createChart(XYDataset dataset) {
		
		JFreeChart chart = ChartFactory.createXYLineChart(
				wave.toString()+" "+wave.getFrequency()+"Hz", //chart title
				"t/T", //xAxisLabel
				"Displacement" , //yAxisLabel
				dataset, //data
				PlotOrientation.VERTICAL, //orientation
				true, //include legend
				true,  //include tooltips
				false //include urls ???
				); 
		
		chart.setBackgroundPaint(Color.white);

		XYPlot plot = chart.getXYPlot();
		
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		
		renderer.setSeriesLinesVisible(
				0, //series number
				false //include connecting lines
				);
		plot.setRenderer(renderer);
		
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		
		rangeAxis.setRange(-1.0, 1.0);
		//rangeAxis.setStandardTickUnits(NumberAxis.createStandardTickUnits());
		
		return chart;
	}

	/**
	 * @return
	 */
	private XYDataset createDataset() {
		
		XYSeries series1 = new XYSeries(wave.toString());
		double time =0;
		double displacement = 0 ;
		
		System.out.println("Creating dataset for "+wave.toString());
		
		for(int ii = 0  ; ii < points ; ii++){
			
			time = (double)ii/points/wave.getFrequency();
			displacement = wave.calculateWave(time);
			System.out.println("time : "+time+"displacement : "+displacement);
			series1.add((double) ii/points, displacement);
		}
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		
		return dataset;
	}

	

}
