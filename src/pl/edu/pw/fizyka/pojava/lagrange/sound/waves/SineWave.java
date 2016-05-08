package pl.edu.pw.fizyka.pojava.lagrange.sound.waves;

public class SineWave extends Wave {

	public SineWave(WaveParameters waveParams) {
		super(waveParams);
	}

	@Override
	protected double calculateWave(int frequency, double time) {
		
		return Math.sin(2 * Math.PI * frequency * time);
		
	}

}
