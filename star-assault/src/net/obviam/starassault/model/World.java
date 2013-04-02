package net.obviam.starassault.model;

import java.util.ArrayList;
import java.util.List;
import net.obviam.starassault.model.Points;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class World {

	/** Our player controlled hero **/
	Bob bob;
	/** A world has a level through which Bob needs to go through **/
	Level level;
	Points points;
	/** The collision boxes **/
	Array<Rectangle> collisionRects = new Array<Rectangle>();

	// Getters -----------
	
	public Array<Rectangle> getCollisionRects() {
		return collisionRects;
	}
	
	public Bob getBob() {
		return bob;
	}
	public Level getLevel() {
		return level;
	}
	public Points getPoints(){
		return points;
	}
	/** Return only the blocks that need to be drawn **/
	public List<Block> getDrawableBlocks(int width, int height) {
		int x = (int)bob.getPosition().x - width;
		int y = (int)bob.getPosition().y - height;
		if (x < 0) {
			x = 0;
		}
		if (y < 0) {
			y = 0;
		}
		int x2 = x + 2 * width;
		int y2 = y + 2 * height;
		if (x2 > level.getWidth()) {
			x2 = level.getWidth() - 1;
		}
		if (y2 > level.getHeight()) {
			y2 = level.getHeight() - 1;
		}
		
		List<Block> blocks = new ArrayList<Block>();
		Block block;
		for (int col = x; col <= x2; col++) {
			for (int row = y; row <= y2; row++) {
				block = level.getBlocks()[col][row];
				if (block != null) {
					blocks.add(block);
				}
			}
		}
		return blocks;
	}
	
	public List<Perk> getDrawablePerks(int width, int height) {
		int x = (int)bob.getPosition().x - width;
		int y = (int)bob.getPosition().y - height;
		if (x < 0) {
			x = 0;
		}
		if (y < 0) {
			y = 0;
		}
		int x2 = x + 2 * width;
		int y2 = y + 2 * height;
		if (x2 > level.getWidth()) {
			x2 = level.getWidth() - 1;
		}
		if (y2 > level.getHeight()) {
			y2 = level.getHeight() - 1;
		}
		
		List<Perk> perks = new ArrayList<Perk>();
		Perk perk;
		for (int col = x; col <= x2; col++) {
			for (int row = y; row <= y2; row++) {
				perk = level.getPerks()[col][row];
				if (perk != null) {
					perks.add(perk);
				}
			}
		}
		return perks;
	}
	
	public List<Mashroom> getDrawableMashrooms(int width, int height) {
		int x = (int)bob.getPosition().x - width;
		int y = (int)bob.getPosition().y - height;
		if (x < 0) {
			x = 0;
		}
		if (y < 0) {
			y = 0;
		}
		int x2 = x + 2 * width;
		int y2 = y + 2 * height;
		if (x2 > level.getWidth()) {
			x2 = level.getWidth() - 1;
		}
		if (y2 > level.getHeight()) {
			y2 = level.getHeight() - 1;
		}
		
		List<Mashroom> mashrooms = new ArrayList<Mashroom>();
		Mashroom mashroom;
		for (int col = x; col <= x2; col++) {
			for (int row = y; row <= y2; row++) {
				mashroom = level.getMashrooms()[col][row];
				if (mashroom != null) {
					mashrooms.add(mashroom);
				}
			}
		}
		return mashrooms;
	}

	// --------------------
	public World() {
		createDemoWorld();
	}

	public void createDemoWorld() {
		level = new Level();
		bob = new Bob(level.getBobPosition());
		points = new Points();
	}
}
