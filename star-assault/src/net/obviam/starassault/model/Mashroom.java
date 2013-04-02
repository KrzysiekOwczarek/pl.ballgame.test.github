package net.obviam.starassault.model;

import com.badlogic.gdx.math.Vector2;

public class Mashroom extends Bonus{

	public Mashroom(Vector2 pos) {
		this.position = pos;
		this.bounds.setX(pos.x);
		this.bounds.setY(pos.y);
		this.bounds.width = SIZE;
		this.bounds.height = SIZE;
	}
	
	public void useFeature(Bob bob){
		bob.changePower(1);
		bob.changeSize(1);
	}
}
