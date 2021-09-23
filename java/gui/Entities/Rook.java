package gui.Entities;


import Main.Handler;
import javafx.scene.image.ImageView;

public class Rook extends Pieces{

	public Rook(Handler handler, boolean isWhite, int column, int row) {
		super(handler, isWhite, column, row);
		id = 2;
	}
	
	public void update() {
		
	}
	
	public void draw() {
		image.setLayoutX(column-handler.getLoadImages().getPiecesImages().getPieceWidth()/2);
		image.setLayoutY(row-handler.getLoadImages().getPiecesImages().getPieceWidth()/2);
	}
	

}
