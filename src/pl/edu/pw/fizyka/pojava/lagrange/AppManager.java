package pl.edu.pw.fizyka.pojava.lagrange;

import pl.edu.pw.fizyka.pojava.lagrange.layout.LayoutManager;
import pl.edu.pw.fizyka.pojava.lagrange.model.ModelManager;

public class AppManager {
	
	private LayoutManager layoutManager;
	private ModelManager model;
	
	public AppManager() {
		
		model = new ModelManager();
		layoutManager = new LayoutManager(model);
		System.out.println(layoutManager.toString());
		
	}

	private void reset(){
		model.reset();
	}
	public static void main(String[] args) {
		
		AppManager app = new AppManager();
		app.reset();

	}

}
