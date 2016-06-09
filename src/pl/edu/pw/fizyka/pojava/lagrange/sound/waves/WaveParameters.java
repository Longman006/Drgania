package pl.edu.pw.fizyka.pojava.lagrange.sound.waves;


public class WaveParameters {


	
	protected double amplitude;
	protected int frequency;
	
	public double getAmplitude() {
		return amplitude;
	}

	public void setAmplitude(double amplitude) {
		this.amplitude = amplitude;
	}

	public int getFrequency() {
		return frequency;
	}

	public WaveParameters(int frequency, double amplitude) {
		
		this.frequency = frequency;
		this.amplitude = amplitude;

	}

}
