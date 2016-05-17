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
	
	public void addWave(WaveParameters waveParams,WaveTypes waveType){
		System.out.println("creating wave : "+waveType.toString());
		wavesList.add(waveType.getWave(waveParams));
	}
	
	public Wave[] toArray(){
		return (Wave[]) wavesList.toArray();
	}
	
	public int getSize(){
		return wavesList.size();
	}
}
