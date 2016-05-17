package pl.edu.pw.fizyka.pojava.lagrange.charts;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
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
		
		int speed = 50;//miliseconds
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
		
		XYPlot plot = chartCreated.getXYPlot();
		//plot.setBackgroundPaint(new Color(250,0,0));
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(new Color(0,250,0));
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(new Color(0,0,250));
		
		ValueAxis xAxis = plot.getDomainAxis();
		xAxis.setAutoRange(true);
		xAxis.setFixedAutoRange(8000);
		xAxis.setVerticalTickLabels(true);
		
		ValueAxis yAxis = plot.getRangeAxis();
		yAxis.setRange(0.0,1.0);
		
		return chartCreated;
		
	}
	public void start(){
		this.timer.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Millisecond now2 =  new Millisecond();
		long now = System.currentTimeMillis();
		Double displacement = this.wave.calculateWave(now/1000);
		System.out.println("displacement : " + displacement +
				" at time"+ now);
		this.timeSeries.add(now2, displacement );
	}

}
