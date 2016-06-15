package pl.edu.pw.fizyka.pojava.lagrange.sound.waves;

public class Const extends Wave {

	public Const(WaveParameters waveParams) {
		super(waveParams);
		this.waveType = WaveTypes.CONST;
	}

	@Override
	public double calculateWave(double time) {
		// TODO Auto-generated method stub
		return this.waveParams.getAmplitude();
	}

}
