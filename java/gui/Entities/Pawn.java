package gui.Entities;


import Main.Handler;
import javafx.scene.image.ImageView;

public class Pawn extends Pieces{

	public Pawn(Handler handler, boolean isWhite, int column, int row, int squaresize) {
		super(handler, isWhite, column, row, squaresize);
		id = 5;
	}
	
	public void update() {
		
	}
	
	public void draw() {
		image.setLayoutX(column-handler.getLoadImages().getPiecesImages().getPieceWidth()/2);
		image.setLayoutY(row-handler.getLoadImages().getPiecesImages().getPieceWidth()/2);
	}

}
