package game;

import java.util.ArrayList;

public class LineRunner extends Minigame {
	long time = System.currentTimeMillis();
	long ntime;
	private DotEntity dot;
	private LineEntity line1;
	private LineEntity line2;
	private LineEntity line3;
	private LineEntity line4;
	private LineEntity line5;
	private LineEntity line6;
	private LineEntity line7;
	private LineEntity line8;
	private LineEntity line9;
	private LineEntity line10;
	private LineEntity rectangle1;
	private LineEntity rectangle2;
	private LineEntity rectangle3;
	private LineEntity rectangle4;
	private FlagEntity endline;
	private RiddleEntity starttxt;
	private RiddleEntity Timer;
	boolean down = false;
	int updown = 200;
	private int wherex = 100;
	private int wherey = 300;
	private int completedx = 1060;
	private int completedy = 12;
	public static boolean startmaze = false;
	public LineRunner(ArrayList<Entity> entities, ArrayList<Entity> removeList,
			Engine engine) {
		super(entities, removeList, engine);
	}
public void setup(){
		
		
		System.out.println("Setting up Maze");
		Entity frame = new FrameEntity(engine,"sprites/brownback.png", 0, 0);
		entities.add(frame);
		starttxt = new RiddleEntity(engine, 70, 55, "Get to the Red End Line by going through the Maze.");
		entities.add(starttxt);
		line1 = new LineEntity("sprites/black lineh.png", 150, 100);
		entities.add(line1);
		line2 = new LineEntity("sprites/black lineh.png", 150, 300);
		entities.add(line2);
		line3= new LineEntity("sprites/black linev.png", 352, 200);
		entities.add(line3);
		line4 = new LineEntity("sprites/black linev.png", 552, 200);
		entities.add(line4);
		line5 = new LineEntity("sprites/black lineh.png", 300, 550);
		entities.add(line5);
		line6 = new LineEntity("sprites/black lineh.png", 300, 750);
		entities.add(line6);
		line7= new LineEntity("sprites/black linev.png", 700, 300);
		entities.add(line7);
		line8 = new LineEntity("sprites/black linev.png", 920, 250);
		entities.add(line8);
		line9 = new LineEntity("sprites/black lineh.png", 450, 450);
		entities.add(line9);
		line10 = new LineEntity("sprites/black linev.png", 700, 30);
		entities.add(line10);
		rectangle1 = new LineEntity("sprites/rectangle.png", 100, 200);
		entities.add(rectangle1);
		rectangle2 = new LineEntity("sprites/rectangle.png", 300, 200);
		entities.add(rectangle2);
		rectangle3 = new LineEntity("sprites/rectangle.png", 500, 200);
		entities.add(rectangle3);
		rectangle4 = new LineEntity("sprites/rectangle.png", 700, 200);
		entities.add(rectangle4);
		endline = new FlagEntity("sprites/EndLine.png", 1000, 292);
		entities.add(endline);
		dot = new DotEntity("sprites/dotsmall.png", 3, 3);
		entities.add(dot);
}

		
public void logic() {
			if(down == false){
				line1.y --;
				line2.y --;
				line3.y ++;
				line4.y ++;
				rectangle1.y = rectangle1.y + 2;
				rectangle2.y = rectangle2.y + 3;
				rectangle3.y = rectangle3.y + 4;
				rectangle4.y = rectangle4.y + 5;
				rectangle2.x++;
				rectangle4.x++;
				line5.x = line5.x + 2;
				line6.x = line6.x + 2;
				line10.x = line10.x - 2;
				line7.y --;
				line8.y = line8.y - 2;
				updown++;
				line9.x = line9.x + 4;
			}
			if (down == true) {
				line1.y ++;
				line2.y ++;
				line3.y --;
				line4.y --;
				rectangle1.y = rectangle1.y - 2;
				rectangle2.y = rectangle2.y - 3;
				rectangle3.y = rectangle3.y - 4;
				rectangle4.y = rectangle4.y - 5;
				rectangle2.x--;
				rectangle4.x--;
				line5.x = line5.x - 2;
				line6.x = line6.x - 2;
				line7.y ++;
				line8.y = line8.y + 2;
				line9.x = line9.x - 4;
				line10.x = line10.x + 2;
				updown--;
			}
			if (updown>300){
				down=true;
			}
			if (updown<100){
				down=false;
			}
			
			ntime = System.currentTimeMillis();
			long vtime = ntime-time;
			long finaltime = vtime/1000;
			long countdown = 45-finaltime;
			Timer = new RiddleEntity(engine, 970, 35, "" + countdown);
			entities.add(Timer);
			removeList.add(Timer);
			if(startmaze == true){
				dot.x = 3;
				dot.y = 3;
				startmaze = false;
			}
			if(engine.upPressed){
				engine.upPressed = false;
				dot.y -= 8;
				wherey += 8;
				removeList.add(starttxt);
			}
			if(engine.downPressed){
				engine.downPressed = false;
				dot.y += 8;
				wherey -= 8;
				removeList.add(starttxt);
			}
			if(engine.rightPressed){
				engine.rightPressed = false;
				dot.x += 8;
				wherex += 8;
				removeList.add(starttxt);
			}
			if(engine.leftPressed){
				engine.leftPressed = false;
				dot.x -= 8;
				wherex -= 8;
				removeList.add(starttxt);
			}
			
			if(wherex == completedx && wherey == completedy){
				Entity frame = new FrameEntity(engine,"sprites/YouWin.png", 0, 0);
				entities.add(frame);
				result = true;
				complete = true;
					for(Entity e : entities){
						removeList.add(e);
					}
			}
			
			if(countdown<0){
				Entity frame = new FrameEntity(engine,"sprites/Game Over.jpg", 0, 0);
				entities.add(frame);
						complete = true;
						for(Entity e : entities){
							removeList.add(e);
						}
					}
			}
	}