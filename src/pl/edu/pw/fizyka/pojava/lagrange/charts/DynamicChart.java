package pl.edu.pw.fizyka.pojava.lagrange.charts;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.Dataset;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.Wave;

public class DynamicChart extends JPanel implements ActionListener {

	private TimeSeries timeSeries;
	private TimeSeriesCollection timeSeriesCollection;
	private Wave wave;
	private Timer timer;
	private JFreeChart chart;
	
	public void setWave(Wave wave){
		this.wave = wave;
	}
	public DynamicChart(Wave wave) {
		
		int speed = 250;//miliseconds
		this.timer = new Timer(speed,this);
		this.timeSeries = new TimeSeries("Nazwa");
		this.timeSeriesCollection = new TimeSeriesCollection(this.timeSeries);
		this.chart = createChart(timeSeriesCollection);
		this.wave = wave;
		ChartPanel chartPanel = new ChartPanel(chart);
		this.add(chartPanel);
		
	}

	private JFreeChart createChart (XYDataset dataset){
		JFreeChart chartCreated = ChartFactory.createTimeSeriesChart(
				"Chart Name",
				"Time",
				"Value",
				dataset);
		
		return chartCreated;
		
	}
	public void start(){
		this.timer.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Millisecond now =  new Millisecond();
		this.timeSeries.add(now, this.wave.calculateWave(now.getMillisecond()));
	}

}
