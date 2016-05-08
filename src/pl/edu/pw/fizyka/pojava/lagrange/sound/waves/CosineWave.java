package pl.edu.pw.fizyka.pojava.lagrange.sound.waves;

public class CosineWave extends Wave {

	public CosineWave(WaveParameters waveParams) {
		super(waveParams);
	}

	@Override
	protected double calculateWave(int frequency, double time) {
		
		return Math.cos(2 * Math.PI * frequency * time);
		
	}

}
