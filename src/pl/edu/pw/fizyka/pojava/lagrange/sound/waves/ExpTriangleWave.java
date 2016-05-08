package pl.edu.pw.fizyka.pojava.lagrange.sound.waves;

public class ExpTriangleWave extends Wave {

	public ExpTriangleWave(WaveParameters waveParams) {
		super(waveParams);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected double calculateWave(int frequency, double time) {
		// TODO Auto-generated method stub
		return Math.exp(-Math.abs(2*Math.asin(Math.sin(2 * Math.PI * frequency * time))/Math.PI));
	}

}
