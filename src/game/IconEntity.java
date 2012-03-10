package game;
/**
 * An entity which represents one of our space invader aliens.
 * 
 * @author Kevin Glass
 */
public class IconEntity extends Entity {
	
	/** The game in which the entity exists */
	private Engine engine;
	
	/**
	 * Create a new alien entity
	 * 
	 * @param game The game in which this entity is being created
	 * @param ref The sprite which should be displayed for this alien
	 * @param x The intial x location of this dagger
	 * @param y The intial y location of this dagger
	 */
	public IconEntity(Engine engine,String ref,int x,int y) {
		super(ref,x,y);
		
		this.engine = engine;
	}

	/**
	 * Request that this alien moved based on time elapsed
	 * 
	 * @param delta The time that has elapsed since last move
	 */
	public void move(long delta) {
	
		super.move(delta);
	
	}
	
	/**
	 * Update the game logic related to aliens
	 */
	public void doLogic() {
		
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