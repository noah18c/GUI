package Model;

import java.util.ArrayList;

import Main.Handler;
import gui.Entities.King;
import gui.Entities.PieceTest;
import gui.Entities.Pieces;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class ChessBoard{
	private Pane chessboard;
	private boolean[][] occupancy = new boolean[8][8];
	private ArrayList<Pieces> whites, blacks;
	private Handler handler;
	private int squaresize;
	
	private ArrayList<PieceTest> pieces;
	
	public ChessBoard(Handler handler) {
		this.handler = handler;
		
		for(int rows = 0; rows < occupancy.length; rows++) {
			for(int columns = 0; columns < occupancy[0].length; columns++) {
				occupancy[rows][columns] = false;
			}
		}
	}
	
	
	
	
	public void createChessBoard() {
		chessboard = new Pane();
		pieces = new ArrayList<>();
		
		chessboard.setMaxSize(850, 850);
		chessboard.setMinSize(400, 400);
		//random board coloring
		Color[] colorPalette = {Color.BROWN, Color.CORAL, Color.CORNFLOWERBLUE, Color.DARKKHAKI};
		int randomNumber = (int) Math.round(Math.random()*3);
		
		
		int boardsize = 850;
		int spots = 8;
		squaresize = (boardsize-50)/spots;
		boolean isWhite = true;

		for(int columns = 0; columns < spots; columns++) {
			for (int rows = 0; rows < spots; rows++){
				Rectangle square = new Rectangle(columns*squaresize, rows*squaresize, squaresize, squaresize);
				Color color;
				if((columns+rows) % 2 == 0) {
					color = Color.WHITE;
					isWhite = false;
				} else {
					color = colorPalette[randomNumber];
					isWhite = true;
				}
				square.setFill(color);
				chessboard.getChildren().add(square);
					
			}
		}
		
		//lettering for board coordinates
		String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H"};
		for(int columns = 0; columns < spots; columns++) {
			Label bottom = new Label(alphabet[columns]);
			BorderPane cellLayout = new BorderPane();
			bottom.setLayoutX(columns*squaresize + (squaresize/2));
			bottom.setLayoutY(boardsize);
			chessboard.getChildren().add(bottom);
		}
		
		for(int rows = 0; rows < spots; rows++) {
			Label bottom = new Label(""+(8-rows));
			BorderPane cellLayout = new BorderPane();
			bottom.setLayoutX(boardsize);
			bottom.setLayoutY(rows*squaresize + (squaresize/2));
			chessboard.getChildren().add(bottom);
		}

		
		for(int i = 0; i< 5; i++) {
			Circle c = new Circle();
			c.setFill(Color.GREEN);
			c.setStroke(Color.BLACK);
			double radius = squaresize/3.0;
			int x = (int)(Math.random()*spots);
			int y = (int)(Math.random()*spots);
			PieceTest p = new PieceTest(x, y, radius, squaresize, c);
			pieces.add(p);
			chessboard.getChildren().add(c);
			p.draw();
			
			
			c.setOnMousePressed(e -> pressed(e, p));
			c.setOnMouseDragged(e -> dragged(e, p));
			c.setOnMouseReleased(e -> released(e, p));
		}
		
		King wKing = new King(handler, true, 0, 0, squaresize);
		
		
		
	
	}
	
	
	

	private void pressed(MouseEvent e, PieceTest p) {
		p.setColor(Color.RED);
		//System.out.println("1: "+p.getColumn() + ", "+p.getRow());
	}

	private void dragged(MouseEvent e, PieceTest p) {
		p.setX(p.getX() + e.getX());
		p.setY(p.getY() + e.getY());
		p.draw();

	}
	
	private void released(MouseEvent e, PieceTest p) {
		
		int column = (int) p.getX() / squaresize;
		int row = (int) p.getY() / squaresize;
		
		p.setX(squaresize/2 + squaresize*column);
		p.setY(squaresize/2 + squaresize*row);
		p.draw();
		//System.out.println("2: "+p.getColumn() + ", "+p.getRow());
		p.setColor(Color.GREEN);
	
	}

	
	
	
	
	
	
	
	
	public void movePiece(int prevColumn, int prevRow, int newColumn, int newRow) {
		occupancy[prevRow][prevColumn] = false;
		occupancy[newRow][newColumn] = true;
	}
	
	public boolean isOccupied(int column, int row) {
		return occupancy[row][column];
	}
	
	public Pane getChessBoard() {
		return chessboard;
	}

}
