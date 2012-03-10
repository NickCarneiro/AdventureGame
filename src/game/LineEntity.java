package game;

public class LineEntity extends Entity {
	private Engine engine;

	public LineEntity(String ref, int x, int y) {
		super(ref, x, y);
		this.engine = engine;
	}

	public void collidedWith(Entity other) {
	}
}