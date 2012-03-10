package game;
public class DotEntity extends Entity {

	private Engine engine;

	public DotEntity(String ref, int x, int y) {
		super(ref, x, y);
		this.engine = engine;
	}
	public void move(long delta) {
		if ((dx < 0) && (x < 10)) {
			return;
		}
		if ((dx > 0) && (x > 750)) {
			return;
		}
		super.move(delta);
	}
	public void collidedWith(Entity other) {
		if (other instanceof LineEntity) {
			LineRunner.startmaze=true;
		}
	}
}