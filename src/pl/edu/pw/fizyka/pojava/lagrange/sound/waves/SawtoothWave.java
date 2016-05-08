package pl.edu.pw.fizyka.pojava.lagrange.sound.waves;

public class SawtoothWave extends Wave {

	public SawtoothWave(WaveParameters waveParams) {
		super(waveParams);

	}

	@Override
	protected double calculateWave(int frequency, double time) {
		
		return 2*Math.asin(Math.sin(2 * Math.PI * frequency * time))/Math.PI;
	}

}
