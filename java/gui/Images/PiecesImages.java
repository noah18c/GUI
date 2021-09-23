package gui.Images;

import java.util.ArrayList;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PiecesImages {
	
	ArrayList<ImageView> bPieces, wPieces;
	private int PIECE_WIDTH = 60;
	 
	
	public PiecesImages() {
		
		loadPiecesImages();
		// defines a viewport into the source image (achieving a "zoom" effect) and
        // displays it rotated
		
	}
	
	private void loadPiecesImages() {
		bPieces = new ArrayList<>();
		wPieces = new ArrayList<>();
		
		
		
		wPieces.add(new ImageView(new Image("WKing.png")));
		wPieces.add(new ImageView(new Image("WQueen.png")));
		wPieces.add(new ImageView(new Image("WRook.png")));
		wPieces.add(new ImageView(new Image("WBishop.png")));
		wPieces.add(new ImageView(new Image("WKnight.png")));
		wPieces.add(new ImageView(new Image("WPawn.png")));
		
		bPieces.add(new ImageView(new Image("BKing.png")));
		bPieces.add(new ImageView(new Image("BQueen.png")));
		bPieces.add(new ImageView(new Image("BRook.png")));
		bPieces.add(new ImageView(new Image("BBishop.png")));
		bPieces.add(new ImageView(new Image("BKnight.png")));
		bPieces.add(new ImageView(new Image("BPawn.png")));
		
		setPiecesSize(PIECE_WIDTH);
       
	}
	
	public int getPieceWidth() {
		return PIECE_WIDTH;
	}
	
	public void setPiecesSize(int width) {
		for(int i = 0; i<=5; i++) {
			wPieces.get(i).setFitWidth(width);
			wPieces.get(i).setPreserveRatio(true);
			bPieces.get(i).setFitWidth(width);
			bPieces.get(i).setPreserveRatio(true);
		}
	}
	
	public ArrayList<ImageView> getBPieces() {
		return bPieces;
	}
	
	public ArrayList<ImageView> getWPieces() {
		return wPieces;
	}
}
