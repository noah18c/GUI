package gui.Entities;


import Main.Handler;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class King extends Pieces {
		
	public King(Handler handler, boolean isWhite, int column, int row, int squaresize) {
		super(handler, isWhite, column, row, squaresize);
		id = 0;
	}
	
	public void update() {
		
	}
	
	public void draw() {
		image.setLayoutX(column);
		image.setLayoutY(row);
	}
}
