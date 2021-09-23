package gui.Entities;


import Main.Handler;
import javafx.scene.image.ImageView;

public class Queen extends Pieces{

	public Queen(Handler handler, boolean isWhite, int column, int row) {
		super(handler, isWhite, column, row);
		id = 1;
		setPieceColor();
	}
	
	public void update() {
		
	}
	
	public void draw() {
		image.setLayoutX(column-handler.getLoadImages().getPiecesImages().getPieceWidth()/2);
		image.setLayoutY(row-handler.getLoadImages().getPiecesImages().getPieceWidth()/2);
	}
	

}
