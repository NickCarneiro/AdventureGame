package game;



public class FrameEntity extends Entity {
	private Engine engine;
	/**
	 * Create a new frame entity
	 * 
	 * @param game The game in which this entity is being created
	 * @param ref The sprite which should be displayed for this alien
	 * @param x The intial x location of this alien
	 * @param y The intial y location of this alient
	 */
	public FrameEntity(Engine engine,String ref,int x,int y) {
		super(ref,x,y);
		
		this.engine = engine;
	}
	
	/**
	 * Request that this alien moved based on time elapsed
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
