package game;

import java.util.ArrayList;

public class RiddleGame extends Minigame {
	
	private int correct = 2;
	private DaggerEntity dagger;
	String[] choices = {"Air", "Footsteps", "Lives", "Chicken"};
	private int selected = 0;
	public RiddleGame(ArrayList<Entity> entities, ArrayList<Entity> removeList, Engine engine) {
		super(entities, removeList, engine);
	}


	
	public void setup(){
		
		
		System.out.println("Setting up RiddleGame");
		//draw background and riddles
		Entity frame = new FrameEntity(engine,"sprites/riddle.png", 0, 0);
		entities.add(frame);
		//only need to draw this once
		
		Entity riddle = new RiddleEntity(engine, 185, 190, "The more you take the more you leave behind.");
		entities.add(riddle);
		
		int y_offset = 40;
		int i = 0;
		
		for(String option : choices){
			Entity choice = new RiddleEntity(engine, 450, 600 + y_offset * i, option);
			entities.add(choice);
			//removeList.add(choice);
			i++;
		}
		
		//set up dagger entity
		dagger = new DaggerEntity(engine,"sprites/dagger.png", 380, 580);
		entities.add(dagger);
		selected = choices.length - 1;
		
	}
	
	public void logic(){
		//move selection dagger
		if(engine.upPressed){
			engine.upPressed = false;
			if(selected < choices.length - 1){
				dagger.y -= 40;
				selected++;
			}
			
		} else if(engine.downPressed){
			engine.downPressed = false;
			if(selected > 0 ){
				dagger.y += 40;
				selected--;
			}
		}
		
		//set completed true, set result
		if(engine.spacePressed){
			engine.spacePressed = false;
			if(selected == correct){
				result = true;
			} else {
				result = false;
			}
			complete = true;
			//remove all entities
			for(Entity e : entities){
				removeList.add(e);
			}
			
		}
	}
	
	
	
}
