package pl.edu.pw.fizyka.pojava.lagrange.utilities;

import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.CosineWave;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.ExpTriangleWave;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.SawtoothWave;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.SineWave;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.SquareWave;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.Wave;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.WaveParameters;

/**
 * @author longman
 * Obsolete, WaveTypes takes care of everything
 *
 */
public class WaveFactory {

	private WaveFactory() {
	}
	
	static public Wave getWave(WaveParameters waveParams,WaveTypes waveType){
		switch(waveType){
		case SINE:
			System.out.println("Creating Sine Wave");
			return new SineWave(waveParams);
		case SQUARE :
			System.out.println("creating Square Wave");
			return new SquareWave(waveParams);
		case COSINE :
			System.out.println("Creating Cosine Wave");
			return new CosineWave(waveParams);
		case SAWTOOTH :
			System.out.println("Creating Sawtooth Wave");
			return new SawtoothWave(waveParams);
		case EXPONENTIAL_TRIANGLE:
			System.out.println("Creating "+WaveTypes.EXPONENTIAL_TRIANGLE.toString());
			return new ExpTriangleWave(waveParams);
		default:
			break;
		
		}
		return null;
		
	}

}
