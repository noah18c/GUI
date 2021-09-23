package gui.Entities;


import Main.Handler;
import javafx.scene.image.ImageView;

public class Pawn extends Pieces{

	public Pawn(Handler handler, boolean isWhite, int column, int row) {
		super(handler, isWhite, column, row);
		id = 5;
	}
	
	public void update() {
		
	}
	
	public void draw() {
		image.setLayoutX(column-handler.getLoadImages().getPiecesImages().getPieceWidth()/2);
		image.setLayoutY(row-handler.getLoadImages().getPiecesImages().getPieceWidth()/2);
	}

}
