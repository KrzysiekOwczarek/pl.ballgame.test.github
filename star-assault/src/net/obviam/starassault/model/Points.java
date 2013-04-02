package net.obviam.starassault.model;

public class Points {
	
	public static final float SIZE_X = 1f;
	public static final float SIZE_Y = 1f;
	
	private int points;
	
	public Points(){
		this.points = 0;
	}
	
	public void addPoints(float points){
		this.points += points;
	}
	
	public void writePoints(){
		System.out.println(this.points);
	}
	
	public int getPointsValue(){
		return this.points;
	}
}
