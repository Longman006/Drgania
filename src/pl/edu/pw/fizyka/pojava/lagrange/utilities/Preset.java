package pl.edu.pw.fizyka.pojava.lagrange.utilities;

import java.util.ArrayList;

import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.Wave;

public class Preset {

	private ArrayList<Wave> presets;
	
	private String name;
	
	public Preset(String name) {
		presets = new ArrayList<Wave>();
		this.name = name;
	}
	public void addWave(Wave wave){
		presets.add(wave);
	}
	public ArrayList<Wave> getPreset(){
		return presets;
	}
	@Override
	public String toString(){
		return name;
	}
}
