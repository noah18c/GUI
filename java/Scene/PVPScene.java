package Scene;

import java.util.Arrays;

import Main.Handler;
import Model.ChessBoard;
import gui.Buttons.MenuButton;
import gui.Entities.King;
import gui.Entities.Queen;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PVPScene implements SceneInterface {
	
	private Scene pvpscene;
	private Handler handler;
	private VBox sideMenuPane;
	private GridPane chessBoardLayout;
	private BorderPane root;
	
	private ChessBoard chessboard;
	
	public PVPScene(Handler handler) {
		this.handler = handler;
		chessboard = new ChessBoard();
		
	}
	
	@Override
	public void display(){
		root = new BorderPane();

		chessboard.createChessBoard();
		chessboard.initPieces();
		chessBoardLayout = chessboard.getChessBoard();
		createSideMenu();
		//createGameEnvironment();
		createEventHandler();
		
		root.setLeft(sideMenuPane);
		root.setCenter(chessBoardLayout);
		pvpscene = new Scene(root);
	}
	
	private void createEventHandler() {
		/*
		chessboard.getChildren().forEach(cell -> {
			cell.setOnMouseClicked(e -> );
		});
		*/
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
	
	/*
	public void createGameEnvironment() {
		chessboard.createChessBoard();
		chessBoardLayout = chessboard.getChessBoard();
		setBInit();
		setBInit();
		King wKing = new King(handler, true, 3, 0);
		King bKing = new King(handler, false, 3, 7);
		Queen bQueen = new Queen(handler, false, 4, 7);
		
		
		
		chessBoardLayout.add(wKing.getImage(), wKing.getColumn(), wKing.getRow());
		chessBoardLayout.add(bKing.getImage(), bKing.getColumn(), bKing.getRow());
		chessBoardLayout.add(bQueen.getImage(), bQueen.getColumn(), bQueen.getRow());

		
	}
	*/
	
	private void setBInit() {
		// TODO Auto-generated method stub
		
	}

	public Scene getScene() {
		return pvpscene;
	}

}
