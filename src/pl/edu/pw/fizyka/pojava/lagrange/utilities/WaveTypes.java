package pl.edu.pw.fizyka.pojava.lagrange.utilities;

import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.CosineWave;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.ExpTriangleWave;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.SawtoothWave;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.SineWave;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.SquareWave;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.Wave;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.WaveParameters;

public enum WaveTypes {
	SINE(){		
		@Override
		public Wave getWave(WaveParameters waveParams) {
			System.out.println("Creating "+this.toString());
			return new SineWave(waveParams);
		}
	}, COSINE {
		@Override
		public Wave getWave(WaveParameters waveParams) {
			System.out.println("Creating "+this.toString());
			return new CosineWave(waveParams);
		}
	}, SQUARE {
		@Override
		public Wave getWave(WaveParameters waveParams) {
			System.out.println("Creating "+this.toString());
			return new SquareWave(waveParams);
		}
	} , SAWTOOTH {
		@Override
		public Wave getWave(WaveParameters waveParams) {
			System.out.println("Creating "+this.toString());
			return new SawtoothWave(waveParams);
		}
	}, EXPONENTIAL_TRIANGLE {
		@Override
		public Wave getWave(WaveParameters waveParams) {
			System.out.println("Creating "+this.toString());
			return new ExpTriangleWave(waveParams);
		}
	};
	
	public abstract Wave getWave(WaveParameters waveParams);
	
	public static WaveTypes getWaveType(int index){
		
		return WaveTypes.values()[index];
		
	}
}
