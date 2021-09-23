package gui.Menu;

import java.util.ArrayList;

import Main.Handler;
import gui.Buttons.MenuButton;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MainMenu {

	private VBox mainMenuLayout;
	ArrayList<MenuButton> menuButtons;
	private final int width = 300, height = 300;
	private Handler handler;

	public MainMenu(Handler handler) {
		this.handler = handler;
		menuButtons = new ArrayList<>();
		createButtonMenu();
	}
	
	private void createButtonMenu() {
		mainMenuLayout = new VBox(4);
		mainMenuLayout.setPadding(new Insets(10,10,10,10));
		mainMenuLayout.setSpacing(20.0);
		mainMenuLayout.setAlignment(Pos.CENTER);
		menuButtons.add(new MenuButton("Resume Game"));
		menuButtons.add(new MenuButton("New Game"));
		menuButtons.add(new MenuButton("Load game"));
		menuButtons.add(new MenuButton("Exit"));
		mainMenuLayout.getChildren().addAll(menuButtons.get(0), menuButtons.get(1), menuButtons.get(2), menuButtons.get(3));
		
		
	}
	
	public ArrayList<MenuButton> getMenuButtons(){
		return menuButtons;
	}

	
	
	
	public VBox getMainMenuLayout() {
		return mainMenuLayout;
	}


}
