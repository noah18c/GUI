package View;

import Main.Handler;

public abstract class ViewManager {
	protected int width, height;
	protected Handler handler;
	
	public ViewManager(Handler handler) {
		this.handler = handler;
		this.width = 1;
		this.height = 2;
	}
}
