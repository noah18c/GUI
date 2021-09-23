package Scene;

import java.util.ArrayList;

import Main.Handler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

public class GameSelectScene implements SceneInterface{
	
	private Handler handler;
	private Button previous, pvpbutton, pvcbutton;
	private ArrayList<Button> buttons;
	private Scene gameSelectScene;
	//private String BUTTON_STYLE_RIGHT = 
	
	public GameSelectScene(Handler handler) {
		buttons = new ArrayList<Button>();
		this.handler = handler;
		previous = new Button();
		pvpbutton = new Button();
		pvcbutton = new Button();
		
		buttons.add(previous);
		buttons.add(pvpbutton);
		buttons.add(pvcbutton);
	}
	
	
	
	@Override
	public void display() {
		BorderPane root = new BorderPane();
		
		HBox hbox = new HBox(2);
		hbox.setPadding(new Insets(10,10,10,10));
		
		
		previous.setText("Previous");
		
		hbox.getChildren().add(previous);
		
		
		
		FlowPane flowpane = new FlowPane();
		
		buttons.add(pvpbutton);
		pvpbutton.setText("Player vs Player");
		pvpbutton.setMinSize(200, 300);
		pvpbutton.setMaxSize(200, 300);

		
		
		
		buttons.add(pvcbutton);
		pvcbutton.setText("Player vs AI");
		//hvcbutton.setStyle(BUTTON_STYLE_RIGHT);
		pvcbutton.setMinSize(200, 300);
		pvcbutton.setMaxSize(200, 300);
		
		flowpane.getChildren().addAll(pvpbutton, pvcbutton);
		root.setCenter(flowpane);
		root.setTop(hbox);
		
		gameSelectScene = new Scene(root);
	}
	
	public Scene getScene() {
		return gameSelectScene;
	}
	
	public ArrayList<Button> getButtons() {
		return buttons;
	}



	

}
