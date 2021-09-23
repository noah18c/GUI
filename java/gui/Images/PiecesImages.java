package gui.Images;

import java.util.ArrayList;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PiecesImages {
	
	private int PIECE_WIDTH = 60;
	ArrayList<String> bPieces, wPieces;
	 
	
	public PiecesImages() {
		bPieces = new ArrayList<>();
		wPieces = new ArrayList<>();
		
		loadImagePaths();
		
		// defines a viewport into the source image (achieving a "zoom" effect) and
        // displays it rotated
		
	}
	
	private void loadImagePaths() {
		
		
		
		wPieces.add("WKing.png");
		wPieces.add("WQueen.png");
		wPieces.add("WRook.png");
		wPieces.add("WBishop.png");
		wPieces.add("WKnight.png");
		wPieces.add("WPawn.png");
		
		
		
		bPieces.add("BKing.png");
		bPieces.add("BQueen.png");
		bPieces.add("BRook.png");
		bPieces.add("BBishop.png");
		bPieces.add("BKnight.png");
		bPieces.add("BPawn.png");
       
	}
	
	public int getPieceWidth() {
		return PIECE_WIDTH;
	}
	
	public ArrayList<String> getBPieces() {
		return bPieces;
	}
	
	public ArrayList<String> getWPieces() {
		return wPieces;
	}
}
