package game;

import java.util.ArrayList;

public class RunningGame extends Minigame {

	//introducing private entity
	private IconEntity arrow_left;
	private IconEntity arrow_right;
	long countdown;
	private int leftcount = 0;
	private int rightcount = 0;
	private long left_time = 0;
	private long right_time = 0;
	private long start_time = 0;
	private RiddleEntity Timer;
	private RiddleEntity starttxt;
	private boolean game_started = false;
	private Entity frameA;
	private Entity frameB;
	long delta;

	//Public class
	public RunningGame(ArrayList<Entity> entities, ArrayList<Entity> removeList, Engine engine) {
		super(entities, removeList, engine);
	}

	public void setup(){

		//Setting up the Frame
		System.out.println("Setting up RunningGame");
		frameA = new FrameEntity(engine,"sprites/background_coffee.jpg", 0, 0);
		frameB = new FrameEntity(engine,"sprites/background_coffee.jpg", 1024, 0);
		entities.add(frameA);
		entities.add(frameB);
		game_started = false;				
	}




	//Setting up the Logic
	public void logic(){
		if(game_started == false){
			if(engine.leftPressed == true){
				System.out.println("Starting RunningGame!");
				//Stating that the game has started after pressing left arrow key
				game_started = true;
				//Setting up the timer
				start_time = System.currentTimeMillis();
			} 

			if(frameB.x < -1024){
				frameB.x = 1024;
			}
			else{
				frameB.x -= 5;
				if(frameA.x < -1024){
					frameA.x = 1024;
				}
				else{
					frameA.x -= 5;
				}
			}


		}else {
			delta = System.currentTimeMillis();
			long vtime = delta - start_time;
			System.out.println(delta);
			long finaltime = vtime/1000;
			countdown = 45-finaltime;
			System.out.println(countdown);
			Timer = new RiddleEntity(engine, 980, 30, "" + countdown);
			entities.add(Timer);
			removeList.add(Timer);
			if (countdown < 0) {
				complete = true;
				//Showing user whether they win or lose

				if(leftcount + rightcount > 25){
					//you win
					result = true;
					Entity frame = new FrameEntity(engine,"sprites/YouWin.PNG", 0, 0);
					entities.add(frame);
				} else {
					//you lose
					result = false;
					Entity frame = new FrameEntity(engine,"sprites/GameOver.jpg", 0, 0);
					entities.add(frame);

				}

				System.out.println("Game Ended" + result);	
				System.out.println(leftcount + " " + rightcount + " ");
			}

			//we're running
			if(engine.leftPressed){
				leftcount++;
				arrow_left = new IconEntity(engine,"sprites/left_arrow.png", 450, 500);
				entities.add(arrow_left);
				engine.leftPressed = false;
				left_time = System.currentTimeMillis();
			}

			if(engine.rightPressed){
				rightcount++;
				arrow_right = new IconEntity(engine,"sprites/right_arrow.png", 550, 500);
				entities.add(arrow_right);
				engine.rightPressed = false;
				right_time = System.currentTimeMillis();
			}

			long left_delta = System.currentTimeMillis() - left_time;
			if(left_delta > 150){
				removeList.add(arrow_left);
			}

			long right_delta = System.currentTimeMillis() - right_time;
			if(right_delta > 150){
				removeList.add(arrow_right);
			}

			//check if we're done
		}
	}
}