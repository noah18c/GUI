package View;

import java.util.Optional;

import Main.Handler;
import Scene.PVCScene;
import Scene.PVPScene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class GameViewer extends ViewManager {
	Stage gameStage;
	Stage menuStage;
	
	PVPScene pvpscene;
	PVCScene pvcscene;
	
	
	public GameViewer(Handler handler, boolean isPVP) {
		super(handler);
		gameStage = new Stage();
		if(isPVP) {
			pvpscene = new PVPScene(handler);
			pvpscene.display();
			gameStage.setTitle("Dicechess - Player vs Player");
			gameStage.setScene(pvpscene.getScene());
			
		} else {
			pvcscene = new PVCScene(handler);
			pvcscene.display();
			gameStage.setTitle("Dicechess - Player vs AI");
			gameStage.setScene(pvcscene.getScene());
		}
	}
	
	public void display() {
		//alertbox popup when closing
		gameStage.setOnCloseRequest(e -> {
			e.consume();
			alertBox();
		});
	
		gameStage.getIcons().add(handler.getLoadImages().getIcons().get(0));
		gameStage.setMaximized(false);
		gameStage.setResizable(true);
		gameStage.centerOnScreen();
		gameStage.setMaximized(true);
		gameStage.show();
	}


	/**
	 * Method which creates a popup message when trying to close the game window
	 */
	private void alertBox() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.initOwner(gameStage);
		alert.setTitle("Hold up!");
		alert.setHeaderText("Giving up already?");
		alert.setContentText("Choose you destiny:");

		ButtonType alertButton1 = new ButtonType("Restart");
		ButtonType alertButton2 = new ButtonType("Main Menu");
		ButtonType alertButton3 = new ButtonType("Save & Exit");
		ButtonType alertButton4 = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

		alert.getButtonTypes().setAll(alertButton1, alertButton2, alertButton3, alertButton4);
		
		Optional<ButtonType> result = alert.showAndWait();
		
		if (result.get() == alertButton1){
			System.out.println("Restart this game");
		} else if (result.get() == alertButton2) {
		    System.out.println("File Saved");
		    MainMenuViewer mainMenuViewer = new MainMenuViewer(handler);
		    mainMenuViewer.returnToMainMenu(gameStage);
		    
		} else if (result.get() == alertButton3) {
			 System.out.println("File Saved");
			 alert.close();
			 gameStage.close();
		} else {
		    alert.close();
		    gameStage.show();
		}
	}

	/**
	 * Takes in the previous window, closes it, and then opens the menu stage again
	 * @param menuStage	takes in the previous window and closes it
	 */
	public void createNewGame(Stage menuStage) {
		this.menuStage = menuStage;
		this.menuStage.hide();
		display();
	}
	

	public Stage getGameStage() {
		return gameStage;
	}


}

