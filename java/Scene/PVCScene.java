package Scene;

import Main.Handler;
import gui.Buttons.MenuButton;
import gui.Entities.King;
import gui.Entities.Queen;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PVCScene implements SceneInterface{
	
	private Scene pvcscene;
	private Handler handler;
	private VBox sideMenuPane;
	private GridPane chessboard;
	private BorderPane root;

	public PVCScene(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void display() {
		root = new BorderPane();

	
		
		root.setLeft(sideMenuPane);
		root.setCenter(chessboard);
		pvcscene = new Scene(root);
		
	}
	
	
	public Scene getScene() {
		
		return pvcscene;
	}


}
