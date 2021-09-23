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

		createSideMenu();
		createGameEnvironment();
		
		root.setLeft(sideMenuPane);
		root.setCenter(chessboard);
		pvcscene = new Scene(root);
		
	}
	
	private void createSideMenu() {
		sideMenuPane = new VBox(20);
		sideMenuPane.setPadding(new Insets(10,10,10,10));
		sideMenuPane.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		MenuButton b = new MenuButton("Roll Dice");
		MenuButton c = new MenuButton("Finish turn");
		MenuButton d = new MenuButton("Undo");
		MenuButton e = new MenuButton("Redo");
		sideMenuPane.getChildren().addAll(b,c,d,e);
		
	}
	
	public void createGameEnvironment() {
		createChessBoard();
		King wKing = new King(handler, true, 500/2, 500/2);
		King bKing = new King(handler, false, 500/2, 500/2);
		Queen bQueen = new Queen(handler, false, 500/2, 500/2);

		

		
	}
	
	private void createChessBoard() {
		chessboard = new GridPane();
		chessboard.setAlignment(Pos.CENTER);
		
		//random board coloring
		Color[] colorPalette = {Color.BROWN, Color.CORAL, Color.CORNFLOWERBLUE, Color.DARKKHAKI};
		int randomNumber = (int) Math.round(Math.random()*3);
		
		int size = 9; //size of chessboard
		for(int i = 0; i < size-1; i++) {
			for(int j = 0; j < size-1; j++) {
				Rectangle square = new Rectangle();
				Color color;
				if((i+j) % 2 == 0) {
					color = Color.WHITE;
				} else {
					color = colorPalette[randomNumber];
				}
				
				square.setFill(color);
				
				chessboard.add(square, i, j);
				square.widthProperty().bind(chessboard.widthProperty().divide(size));
				square.heightProperty().bind(chessboard.heightProperty().divide(size));
			}
		}
		
		
		//lettering for board coordinates
		String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H"};
		
		for(int i = 0; i<8; i++) {
			Label bottom = new Label(alphabet[i]);
			BorderPane cellLayout = new BorderPane();
			cellLayout.setCenter(bottom);
			chessboard.add(cellLayout, i, 8);
		}
		
		for(int j = 0; j<8; j++) {
			Label left = new Label(""+(8-j));
			BorderPane cellLayout = new BorderPane();
			cellLayout.setCenter(left);
			chessboard.add(cellLayout, 8, j);
		}
		
		
	}

	public Scene getScene() {
		
		return pvcscene;
	}


}
