package game;

import java.util.ArrayList;

public abstract class Minigame {
	protected ArrayList<Entity> entities;
	protected ArrayList<Entity> removeList;
	protected Engine engine;
	public boolean complete = false;
	public boolean result = false;
	public Minigame(ArrayList<Entity> entities, ArrayList<Entity> removeList, Engine engine){
		this.entities = entities;
		this.removeList = removeList;
		this.engine = engine;
		this.complete = false;
	}
	/*
	 * Set up initial state of the minigame
	 */
	public abstract void setup();
	
	
	public abstract void logic();
	
	
}
