package Main;


import java.util.ArrayList;

import gui.Buttons.MenuButton;
import gui.Images.*;
import javafx.stage.Stage;

public class Handler {
	
	private ArrayList<MenuButton> menubuttons;
	private Main main;

	public Handler(Main main) {
		this.main = main;
	}
	
	public Main getMain() {
		return this.main;
	}
	
	public LoadImages getLoadImages() {
		return this.main.getLoadImages();
	}
		

}
