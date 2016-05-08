package pl.edu.pw.fizyka.pojava.lagrange.sound.waves;

public class SquareWave extends Wave {
	
	
	public SquareWave(WaveParameters waveParams) {
		super(waveParams);
	}

	@Override
	protected double calculateWave(int frequency, double time) {

		return Math.signum(Math.sin(2 * Math.PI * frequency * time));
		
	}	
}
