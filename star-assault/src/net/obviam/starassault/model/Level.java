package net.obviam.starassault.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import net.obviam.starassault.addons.Reader;

public class Level {
	
	private int width;
	private int height;
	private Block[][] blocks;
	private Perk[][] perks;
	private Mashroom[][] mashrooms;
	private Reader reader;
	private Vector2 bobPosition;
	private Array<Perk> perkList = new Array<Perk>();
	private Array<Mashroom> mashroomList = new Array<Mashroom>();
	private Array<Block> woodList = new Array<Block>();
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Block[][] getBlocks() {
		return blocks;
	}
	
	public Perk[][] getPerks(){
		return perks;
	}
	
	public Mashroom[][] getMashrooms(){
		return mashrooms;
	}
	
	public void deletePerk(int col, int row){
		perks[row][col] = null;
	}
	
	public void deleteMashroom(int col, int row){
		mashrooms[row][col] = null;
	}
	
	public void deleteWood(int col, int row){
		blocks[row][col] = null;
	}
	
	public void extractPerks(){
		
		int width = perks[0].length;
		int height = perks.length;
		
		for (int col = 0; col < width; col++) {
			for (int row = 0; row < height; row++) {
				if(perks[row][col] != null){
					perkList.add(new Perk(new Vector2(row, col)));
				}
			}
		}
	}
	
	public void extractWoods(){
		
		int width = blocks[0].length;
		int height = blocks.length;
		
		for (int col = 0; col < width; col++) {
			for (int row = 0; row < height; row++) {
				if(blocks[row][col] != null && blocks[row][col].SUPER == 1){
					woodList.add(new Block(new Vector2(row, col)));
				}
			}
		}
	}
	
	public void extractMashrooms(){
		
		int width = mashrooms[0].length;
		int height = mashrooms.length;
		
		for (int col = 0; col < width; col++) {
			for (int row = 0; row < height; row++) {
				if(mashrooms[row][col] != null){
					mashroomList.add(new Mashroom(new Vector2(row, col)));
				}
			}
		}
	}
	
	public Array<Perk> getPerkArr(){
		return this.perkList;
	}
	
	public Array<Mashroom> getMashroomArr(){
		return this.mashroomList;
	}
	
	public Array<Block> getWoodArr(){
		return this.woodList;
	}
	
	public void setBlocks(Block[][] blocks) {
		this.blocks = blocks;
	}

	public Level() {
		loadDemoLevel();
	}
	
	public Block get(int x, int y) {
		return blocks[x][y];
	}
	
	public Vector2 getBobPosition(){
		return this.bobPosition;
	}
	
	private void loadDemoLevel() {
		reader = new Reader();
		
		String[] lines = reader.getLines();
		
		List<String> list = Arrays.asList(lines);
         
         //next, reverse the list using Collections.reverse method
        Collections.reverse(list);
        
         //next, convert the list back to String array
        lines = (String[]) list.toArray();
        
		width = lines[0].length();
		height = lines.length;
		
		blocks = new Block[width][height];
		perks = new Perk[width][height];
		mashrooms = new Mashroom[width][height];
		
		for (int col = 0; col < width; col++) {
			for (int row = 0; row < height; row++) {
				blocks[col][row] = null;
				perks[col][row] = null;
				mashrooms[col][row] = null;
				
				if(lines[row].charAt(col) == '*')
					blocks[col][row] = new Block(new Vector2(col, row));
				if(lines[row].charAt(col) == '+')
					blocks[col][row] = new Block(new Vector2(col, row), 1);
				if(lines[row].charAt(col) == '$')
					perks[col][row] = new Perk(new Vector2(col, row));
				if(lines[row].charAt(col) == '%')
					mashrooms[col][row] = new Mashroom(new Vector2(col, row));
				if(lines[row].charAt(col) == '^')
					this.bobPosition = new Vector2(col, row);
			}
		}
		
		extractPerks();
		extractMashrooms();
		extractWoods();
	}
}
