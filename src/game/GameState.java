package game;

import java.util.ArrayList;

public class GameState {
	public Integer gold = 0;
	public Integer health = 100;
	public ArrayList<Item> items;
	
	public GameState(){
		items = new ArrayList<Item>();
	}
}
