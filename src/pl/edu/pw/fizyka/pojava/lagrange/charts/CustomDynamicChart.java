package pl.edu.pw.fizyka.pojava.lagrange.charts;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import net.miginfocom.swing.MigLayout;
import pl.edu.pw.fizyka.pojava.lagrange.model.ModelManager;
import pl.edu.pw.fizyka.pojava.lagrange.utilities.Units;

public abstract class CustomDynamicChart extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected XYSeries series;
	protected XYSeriesCollection seriesCollection;
	protected XYDataset dataset;
	protected JFreeChart chart;
	protected ChartPanel chartPanel;
	
	protected int unitsPerTick;
	protected long ticksDisplayed;
	protected Units unit;
	
	protected int tickCount;
	protected ModelManager model;
	
	private Timer timer;
	private int refreshRate;
	
	/**
	 * @return the number of ticks 
	 * displayed on chart at any given moment  
	 */
	public long getTicksDisplayed() {
		return ticksDisplayed;
	}
	/**
	 * @param ticksDisplayed the number of ticks 
	 * displayed on chart at any given moment 
	 */
	public void setTicksDisplayed(long ticksDisplayed) {
		this.ticksDisplayed = ticksDisplayed;
	}
	/**
	 * @return the unit as in mathematical prefix
	 */
	public Units getUnit() {
		return unit;
	}
	/**
	 * @param unit the unit as in mathematical prefix
	 */
	public void setUnit(Units unit) {
		this.unit = unit;
	}
	
	/**
	 * @return 
	 */
	public int getUnitsPerTick() {
		return unitsPerTick;
	}
	public void setUnitsPerTick(int unitsPerTick) {
		this.unitsPerTick = unitsPerTick;
	}
	
	public CustomDynamicChart(ModelManager model) {
		

		this.model = model;
		
		this.unit = Units.MILLI;
		this.tickCount = 0;
		this.ticksDisplayed = 100;
		this.unitsPerTick = 1;
		this.refreshRate = 220;
		
		this.series = new XYSeries("Series");
		this.series.add(0, 0);
		this.seriesCollection = new XYSeriesCollection();
		this.seriesCollection.addSeries(this.series);
		this.dataset = seriesCollection;
		this.chart = createChart(dataset);
		this.chartPanel = new ChartPanel(chart);
		
		this.setLayout(new MigLayout());
		this.add(chartPanel,"wrap");
		
		this.timer = new Timer(refreshRate,this);
		
	}
	public void start(){
		this.timer.start();
	}
	public void stop(){
		this.timer.stop();
	}
	public void restart(){
		this.timer.restart();
	}
	
	private JFreeChart createChart(XYDataset dataset) {
		
		JFreeChart chart = ChartFactory.createXYLineChart(
				"Chart Title ", //chart title
				"time", //xAxisLabel
				"Displacement" , //yAxisLabel
				dataset, //data
				PlotOrientation.VERTICAL, //orientation
				false, //include legend
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
				true //include connecting lines
				);
		plot.setRenderer(renderer);
		
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setRange(-1.0, 1.0);
		
		NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
		domainAxis.setAutoRange(true);
		domainAxis.setFixedAutoRange(ticksDisplayed);
		domainAxis.setVerticalTickLabels(true);
		domainAxis.setTickUnit(new NumberTickUnit(unitsPerTick));
		domainAxis.setVisible(false);
	
		return chart;
	}
	public void updateChart(){
		
		XYPlot plot = this.chart.getXYPlot();
		NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
		
		domainAxis.setFixedAutoRange(ticksDisplayed);
		domainAxis.setTickUnit(new NumberTickUnit(unitsPerTick));
		
		updateTitle();
		
	}
	
	protected abstract void updateTitle(); 

	@Override
	public abstract void actionPerformed(ActionEvent arg0);


}
