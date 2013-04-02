package net.obviam.starassault.controller;

import net.obviam.starassault.model.World;

public class ProgressController {
	
	private int counterValue;
	private World world;
	
	public ProgressController(World world){
		this.world = world;
	}
	
	public void addPoints(int add){
		this.setPoints(this.getCounterValue() + add);
	}

	public int getCounterValue() {
		return this.counterValue;
	}

	public void setPoints(int points) {
		this.counterValue = points;
	}
	
	public void update(float delta) {
		if(this.world.getPoints().getPointsValue() > this.counterValue){
			this.setPoints(this.world.getPoints().getPointsValue());
			System.out.println(this.getCounterValue());
		}
	}
}
