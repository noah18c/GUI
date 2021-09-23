package View;

import java.util.ArrayList;

import Main.Handler;
import Scene.GameSelectScene;
import Scene.MainMenuScene;
import gui.Buttons.MenuButton;
import gui.Menu.MainMenu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class MainMenuViewer extends ViewManager implements EventHandler<ActionEvent>{
	
	VBox mainMenuLayout;
	Stage mainMenuStage;
	Stage gameStage;
	
	MainMenuScene mainMenuScene;
	GameSelectScene gameSelectScene;
	String mainMenuTitle = "Main Menu";
	String gameSelectTitle = "Main Menu - Choose Gamemode";
	
	Button test;
	
	public MainMenuViewer(Handler handler) {
		super(handler);
		width = 300;
		height = 300;
		mainMenuScene = new MainMenuScene(handler, width, height);
		gameSelectScene = new GameSelectScene(handler);
		setButtonsOnAction();
		
	}
	
	public void display() {
		mainMenuStage = new Stage();
		mainMenuStage.setTitle(mainMenuTitle);
		mainMenuScene.display();
		mainMenuStage.getIcons().add(handler.getLoadImages().getIcons().get(0));
		mainMenuStage.setMaximized(false);
		mainMenuStage.setResizable(false);
		mainMenuStage.centerOnScreen();
		mainMenuStage.setScene(mainMenuScene.getScene());
		
		
		
		
		mainMenuStage.show();
	}
	
	public void returnToMainMenu(Stage gameStage) {
		this.gameStage = gameStage;
		this.gameStage.hide();
		display();
		
	}

	public Stage getMainMenuStage() {
		return mainMenuStage;
	}
	
	//set action for all buttons
	private void setButtonsOnAction() {
		for(int i = 0; i<=3; i++) {
			mainMenuScene.getMenuButtons().get(i).setOnAction(this);
		}
		gameSelectScene.getButtons().get(0).setOnAction(this);
		gameSelectScene.getButtons().get(1).setOnAction(this);
		gameSelectScene.getButtons().get(2).setOnAction(this);
	}

	@Override
	public void handle(ActionEvent e) {
		//resume game button
		if(e.getSource().equals(mainMenuScene.getMenuButtons().get(0))) {
			System.out.println("resume old game");
		}
		//new game button
		if(e.getSource().equals(mainMenuScene.getMenuButtons().get(1))) {
			gameSelectScene.display();
			mainMenuStage.setScene(gameSelectScene.getScene());
			mainMenuStage.setTitle(gameSelectTitle);
			mainMenuStage.centerOnScreen();
			
			
			
				
		}
		//load game button
		if(e.getSource().equals(mainMenuScene.getMenuButtons().get(2))) {
			System.out.println("load game");
		}
		//exit button
		if(e.getSource().equals(mainMenuScene.getMenuButtons().get(3))) {
			System.out.println("goodbye!");
			mainMenuStage.close();
		}
		
		if(e.getSource().equals(gameSelectScene.getButtons().get(0))) {
			mainMenuScene.display();
			mainMenuStage.setScene(mainMenuScene.getScene());
			mainMenuStage.setTitle(mainMenuTitle);
			mainMenuStage.centerOnScreen();
		} else if (e.getSource().equals(gameSelectScene.getButtons().get(1))) {
			GameViewer gameViewer = new GameViewer(handler, true);
			gameViewer.createNewGame(mainMenuStage);
			
			
		} else if (e.getSource().equals(gameSelectScene.getButtons().get(2))) {
			GameViewer gameViewer = new GameViewer(handler, false);
			gameViewer.createNewGame(mainMenuStage);
		}
	}
}
;;