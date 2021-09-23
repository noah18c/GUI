package Model;

import java.util.ArrayList;

import gui.Entities.Pieces;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessBoard {
	private GridPane chessboard;
	private boolean[][] occupancy = new boolean[8][8];
	private ArrayList<Pieces> whites, blacks;
	
	public ChessBoard() {
		for(int rows = 0; rows < occupancy.length; rows++) {
			for(int columns = 0; columns < occupancy[0].length; columns++) {
				occupancy[rows][columns] = false;
			}
		}
	}
	
	public void createChessBoard() {
		chessboard = new GridPane();
		
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
	
	public void initPieces(){
		whites = new ArrayList<Pieces>();
		blacks = new ArrayList<Pieces>();
		initWPieces();
		
		
		
		
	}
	
	private void initBPieces(){
		
	}
	
	private void initWPieces() {
		//whites.add(null)
	}
	
	public void movePiece(int prevColumn, int prevRow, int newColumn, int newRow) {
		occupancy[prevRow][prevColumn] = false;
		occupancy[newRow][newColumn] = true;
	}
	
	public boolean isOccupied(int column, int row) {
		return occupancy[row][column];
	}
	
	public GridPane getChessBoard() {
		return chessboard;
	}
}
