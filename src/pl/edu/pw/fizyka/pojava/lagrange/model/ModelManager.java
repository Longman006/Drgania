package pl.edu.pw.fizyka.pojava.lagrange.model;
import java.util.ArrayList;

import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.Wave;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.WaveParameters;
import pl.edu.pw.fizyka.pojava.lagrange.utilities.WaveContainer;
public class ModelManager {
	
	private ArrayList<WaveContainer> waveContainers = new ArrayList<WaveContainer>();

	/**
	 * Manages all the wave functions. Contains an ArrayList of WaveContainers, 
	 * each being a package of wave functions for which to calculate 
	 * the total displacement(superposition)
	 * also takes care of scaling. By default works on the last wave package added.
	 */
	public ModelManager() {
		
		waveContainers.add(new WaveContainer());
		
	}
	
	/**
	 * Creates and adds a new WaveContainer to the ArrayList of wave packages.
	 */
	public void newWaveContainer(){
		
		waveContainers.add(new WaveContainer());
		
	}
	
	/**
	 * Adds a new wave to current wave package
	 * @param waveParams 
	 */
	public void addWave(WaveParameters waveParams){
		
		this.getCurrentWaveContainer().addWave(waveParams);
		
	}
	private WaveContainer getCurrentWaveContainer(){
		return waveContainers.get(waveContainers.size()-1);
	}
	
	/**
	 * @return returns a Wave array containing all the current working wave functions
	 */
	public Wave[] getCurrentWaveArray(){
		return getCurrentWaveContainer().toArray();
		
	}

}
