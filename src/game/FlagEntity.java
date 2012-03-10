package game;

public class FlagEntity extends Entity {

	private Engine engine;

	public FlagEntity(String ref, int x, int y) {
		super(ref, x, y);
		this.engine = engine;
	}

	public void collidedWith(Entity other) {
	}
}