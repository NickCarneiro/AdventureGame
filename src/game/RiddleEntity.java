package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;



public class RiddleEntity extends Entity {
	private Engine engine;
	protected Color color;
	/**
	 * Create a new frame entity
	 * 
	 * @param game The game in which this entity is being created
	 * @param ref The sprite which should be displayed for this entity
	 * @param x The intial x location of this alien
	 * @param y The intial y location of this alient
	 */
	
	public RiddleEntity(Engine engine, int x, int y, String riddle_text){
		super(x, y, riddle_text);
		this.engine = engine;
	}
	
	public RiddleEntity(Engine engine, int x, int y, String riddle_text, Color color){
		super(x, y, riddle_text);
		this.engine = engine;
		this.color = color;
	}
	
	/**
	 * Request that this entity moved based on time elapsed
	 * 
	 * @param delta The time that has elapsed since last move
	 */
	public void move(long delta) {
		// if we have reached the left hand side of the screen and
		// are moving left then request a logic update 
		
		// and vice vesa, if we have reached the right hand side of 
		// the screen and are moving right, request a logic update
		
		
		// proceed with normal move
		super.move(delta);
	}
	
	@Override
	public void draw(Graphics g){
		//draw a text entity or a sprite
		if(sprite != null){
			sprite.draw(g,(int) x,(int) y);
		} else {
			//draw text
			Font font = new Font("Arial", Font.PLAIN, 30);
			g.setColor(this.color);
			g.setFont(font);
			g.drawChars(this.text.toCharArray(), 0, this.text.length(), (int)x, (int)y);
			
		}
	}
	
	/**
	 * Update the game logic related to aliens
	 */
	public void doLogic() {
		// swap over horizontal movement and move down the
		// screen a bit
		
		
		// if we've reached the bottom of the screen then the player
		// dies
		
	}
	
	/**
	 * Notification that this alien has collided with another entity
	 * 
	 * @param other The other entity
	 */
	public void collidedWith(Entity other) {
		// collisions with aliens are handled elsewhere
	}

}
