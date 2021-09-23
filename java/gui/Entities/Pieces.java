package gui.Entities;


import Main.Handler;
import javafx.scene.image.ImageView;

public abstract class Pieces {
	private boolean isWhite;
	protected ImageView image;
	protected Handler handler;
	protected int column, row;
	protected int id;
	
	public Pieces(Handler handler, boolean isWhite, int column, int row) {
		this.handler = handler;
		this.isWhite = isWhite;
		this.column = column;
		this.row = row;
	}
	
	protected void setPieceColor() {
		if(isWhite) {
			image = handler.getLoadImages().getWPieces().get(id);
		} else {
			image = handler.getLoadImages().getBPieces().get(id);
		}
	}
	
	public ImageView getImage() {
		setPieceColor();
		return image;
	}
	
	public int getColumn() {
		return column;
	}
	public int getRow() {
		return row;
	}
	public void setColumn(int x) {
		this.column = column;
	}
	public void setRow(int row) {
		this.row = row;
	}
}
