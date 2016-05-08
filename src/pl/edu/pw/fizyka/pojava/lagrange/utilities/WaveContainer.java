package pl.edu.pw.fizyka.pojava.lagrange.utilities;
import java.util.ArrayList;

import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.Wave;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.WaveParameters;

/**
 * 
 * @author longman
 * A container class, a package of wave functions
 *
 */
public class WaveContainer {

	private ArrayList<Wave> wavesList;
	
	public WaveContainer() {
		wavesList = new ArrayList<Wave>();
	}
	
	public void addWave(WaveParameters waveParams){
		wavesList.add(waveParams.getWaveType().getWave(waveParams));
	}
	
	public Wave[] toArray(){
		return (Wave[]) wavesList.toArray();
	}
}
