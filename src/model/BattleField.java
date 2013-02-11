package model;
import java.util.Random;


	/**
	 * @author bar0n
	 * reflects the battlefield. ship link to the ship in all positions ship
	 */
 
public class BattleField {


	public static  int DIMENTION_FIELD = 10;
	
	private Ship[][] field = new Ship[DIMENTION_FIELD][DIMENTION_FIELD];
	
	// is the point of field busy
	public boolean isPointBusy(int x,int y){
		if (!isValid(x, y)) throw  new IllegalArgumentException("x="+x+" y="+y);
		return field[x][y]!=null;
	}
	
	// correct  the point with that coordinates
	private  boolean isValid(int i, int j) {

		return  !(i<0 || i>=DIMENTION_FIELD || j<0 || j>=DIMENTION_FIELD) ;
		
	}
	
	private boolean canPutShip(int x, int y,Ship ship){
		int dim = ship.getDimention();
		int startX = 0;
		int stopX  = 0;
		int startY = 0;
		int stopY  = 0;

		if (ship.isVertical()){
			startX = x-1;stopX=x+1;
			startY = y-1;stopY= y+dim+1;
		}
		else {
			startX = x-1;stopX = x+dim+1;
			startY = y-1;stopY = y+1;
		}
		if (stopX>=DIMENTION_FIELD || stopY>=DIMENTION_FIELD) return false;
		for (int i=startX;i<=stopX;i++){
			for (int j = startY; j <=stopY ; j++) {
				if (isValid(i,j)){
					
					if (isPointBusy(i,j)) return false;
				}
			}
		}
		
		return true;
	}

/*  1 корабль Ч р€д из 4 клеток (Ђлинкорыї, или ЂчетырЄхпалубныеї) 1 ship - a row of 4 cells (" battleships " or " Four- ")
    2 корабл€ Ч р€д из 3 клеток (Ђкрейсерыї, или ЂтрЄхпалубныеї)   2 ships - a series of three cells ("Cruiser " or " triple-decker ")
    3 корабл€ Ч р€д из 2 клеток (Ђэсминцыї, или Ђдвухпалубныеї)	   3 ships - a series of two cells (" destroyers " or " Double-deck ")
    4 корабл€ Ч 1 клетка (Ђподлодкиї, или Ђоднопалубныеї)		   4 ships - 1 cell (" submarine " or " single-deck ") */

	//prints field
	public void print(){
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				System.out.print( isPointBusy(i, j)?'X':' ');
			}
			System.out.println("|");
		}
		System.out.println("----------");
	}
	
	// try locate ship random
	public void putShipRandom(Ship ship) {
		Random rnd = new Random();
		int x = 0;
		int y = 0;

		do {
			x = rnd.nextInt(DIMENTION_FIELD);
			y = rnd.nextInt(DIMENTION_FIELD);
		} while (!canPutShip(x, y, ship));
		putShip(x,y,ship);
	}
	
	private void putShip(int x, int y, Ship ship) {
		int dim = ship.getDimention();
		
		for (int i=0;i<=dim;i++){
			if (ship.isVertical()) field[x][y+i]=ship;
			else field[x+i][y]=ship;
		}
		
	}

	public void putAllRandom(){
		Random rnd = new Random();
		putShipRandom(new Ship(0, 3, rnd.nextBoolean()));
		for (int i = 0; i < 2; i++) {
			putShipRandom(new Ship(1+i, 2, rnd.nextBoolean()));			
		}
		
		for (int i = 0; i < 3; i++) {
			putShipRandom(new Ship(3+i, 1, rnd.nextBoolean()));			
		}
		
		for (int i = 0; i < 4; i++) {
			putShipRandom(new Ship(6+i, 0, rnd.nextBoolean()));		
		}
	}
	
	public static void main(String[] args) {

		BattleField battleField = new BattleField();
		
		battleField.putAllRandom();

		battleField.print();
	}

	
}
