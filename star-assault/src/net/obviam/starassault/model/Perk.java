package net.obviam.starassault.model;

import com.badlogic.gdx.math.Vector2;

public class Perk extends Bonus{

	public static final float BONUS = 100f;
	
	public Perk(Vector2 pos) {
		this.position = pos;
		this.bounds.setX(pos.x);
		this.bounds.setY(pos.y);
		this.bounds.width = SIZE;
		this.bounds.height = SIZE;
	}
	
	public float useFeature() {
		return BONUS;
	}
	
	
}

