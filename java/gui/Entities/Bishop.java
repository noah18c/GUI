package gui.Entities;


import Main.Handler;

import javafx.scene.image.ImageView;

public class Bishop extends Pieces{

	public Bishop(Handler handler, boolean isWhite, int column, int row) {
		super(handler, isWhite, column, row);
		id = 3;
	}
	
	public void update() {
		
	}
	
	public void draw() {
		image.setLayoutX(column-handler.getLoadImages().getPiecesImages().getPieceWidth()/2);
		image.setLayoutY(row-handler.getLoadImages().getPiecesImages().getPieceWidth()/2);
	}
	

}
