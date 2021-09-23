package Main;

import View.MainMenuViewer;
import gui.Images.LoadImages;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	private int fps;
	private boolean running;
	private String title;
	private Stage menuStage;
	private MainMenuViewer mmv;
	private Handler handler;
	private LoadImages loadImages;

	


	public Main() {
		this.title = "Dice Chess - Group 21";
	}
	
	private void initialize() {
		handler = new Handler(this);
		loadImages = new LoadImages();
		mmv = new MainMenuViewer(handler);
	}
	
	//starts the application
	@Override
	public void start(Stage mainStage) throws Exception {
		initialize();
		
		mmv.display();
		mainStage = mmv.getMainMenuStage();
		mainStage.show();
		
		
	}


	public void start(String[] args) {
		launch(args);
	}
	
	public LoadImages getLoadImages() {
		return loadImages;
	}

	
	/*
	@Override
	public void run() {
		init();
		fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		//fps checker
		long timer = 0;
		int updates = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				update();
				render();
				updates++;
				delta--;
			}
			
			if(timer>=1000000000) {
				System.out.println("Updates and frames: "+updates);
				updates = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	
	//method for starting the threads
	public synchronized void start() {
		if(running) 
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	//method for stopping the threads
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	*/
	

	

	
	
	
	
	
	
	
}
