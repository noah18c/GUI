package gui.Entities;


import Main.Handler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public abstract class Pieces {
	private int PIECE_WIDTH = 60;
	private boolean isWhite;
	protected ImageView image;
	protected Handler handler;
	protected int column, row;
	protected int squaresize;
	protected int id;
	
	protected double x,y;
	
	public Pieces(Handler handler, boolean isWhite, int column, int row, int squaresize) {
		this.handler = handler;
		this.isWhite = isWhite;
		this.column = column;
		this.row = row;
		this.squaresize = squaresize;
		this.x = squaresize/2 + column*squaresize;
		this.y = squaresize/2 + row*squaresize;
	}
	
	protected void setPieceColor() {
		if(isWhite) {
			image = new ImageView(new Image(handler.getLoadImages().getWPieces().get(id)));
			image.setFitWidth(PIECE_WIDTH);
			image.setPreserveRatio(true);
		} else {
			image = new ImageView(new Image(handler.getLoadImages().getBPieces().get(id)));
			image.setFitWidth(PIECE_WIDTH);
			image.setPreserveRatio(true);
		}
	}
	
	public ImageView getImage() {
		setPieceColor();
		return image;
	}
	
	public void setColumn(int x) {
		this.column = column;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	public void setCellPosition(int column, int row) {
		this.setX(squaresize/2 + squaresize*column);
		this.setY(squaresize/2 + squaresize*row);
	}
	
	public double getColumn() {
		return column;
	}
	
	public double getRow() {
		return row;
	}
	
	private void convertToColumn(double x) {
		this.column = (int) (x/squaresize);
	}
	
	private void convertToRow(double y) {
		this.row = (int) (y/squaresize);
	}

	public double getX() {
		
		return x;
	}

	public void setX(double x) {
		this.x = x;
		convertToColumn(this.x);
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
		convertToRow(this.y);
	}
	public void draw() {
		
	}
}
