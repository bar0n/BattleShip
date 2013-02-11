package model;
import java.util.ArrayList;
import java.util.List;

//reflects ship

public class Ship {

	private int id;
	private int dimention; // start with 0 - (1-cell ship) ... 3 - 4 cell ship
	@Override
	public String toString() {
		return "Ship [id=" + id + ", dimention=" + dimention + ", isVertical="
				+ isVertical + "]";
	}
	private boolean isVertical;
	List<Boolean> sectionsLife; //section defines the ship if true then this section is destroyed. counting from left to right and top to bottom
	
	public void hitInSection(int i){
		if (i<0 || i>=dimention) throw new IllegalArgumentException("hit section illigal i:"+i);
		sectionsLife.set(i, true);
	}
	
	public Ship(int id,int dimention, boolean isVertical) {
		this.id = id;
		this.dimention = dimention;
		this.isVertical = isVertical;
		sectionsLife = new ArrayList<>(dimention);				
	}
	
	
	public int getDimention() {
		return dimention;
	}
	public boolean isVertical() {
		return isVertical;
	}
	public void setDimention(int dimention) {
		this.dimention = dimention;
	}
	public void setVertical(boolean isVertical) {
		this.isVertical = isVertical;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
