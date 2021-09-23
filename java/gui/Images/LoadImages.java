package gui.Images;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class LoadImages {
	
	private ArrayList<Image> icons;
	private ArrayList<ImageView> bPieces, wPieces;
	private PiecesImages pi;
	
	
	public LoadImages() {
		icons = new ArrayList<>();
		pi = new PiecesImages();
		bPieces = pi.getBPieces();
		wPieces = pi.getWPieces();
		
		
		icons.add(new Image("Chess-icon.png"));
		
	}
	
	public ArrayList<Image> getIcons() {
		return icons;
	}
	
	public PiecesImages getPiecesImages() {
		return pi;
	}
	
	public ArrayList<ImageView> getBPieces() {
		return bPieces;
	}
	
	public ArrayList<ImageView> getWPieces() {
		return wPieces;
	}
}
