package aquariumTest;


import java.util.*;

public class Coordinate {
	static Random random = new Random();
	private int x;
	private int y;
	
	public Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Coordinate() {}
	
	public int getX(){return x;}
	public int getY(){return y;}
	public int setX(int x){return this.x=x;}
	public int setY(int y){return this.y=y;}
	public String toString() {return  ("x: "+x+"; y: "+y);}
		
		
	public void changeXY(Aquarium aquarium)
	{
		int delta = random.nextInt(4)+1;

		int oldX=x;
		int oldY=y;
		
		if (delta==1){
			
			y=y+1;
		}
		if (delta==2){
			x=x+1;
			
		}
		if (delta==3){
			
			y=y-1;
		}
		if (delta==4){
			x=x-1;
			
		}
		if (x<0 || y<0 || x>=aquarium.getSizeX() || y>=aquarium.getSizeY()){
			x=oldX;
			y=oldY;
		}
		if (oldX==x&&oldY==y)changeXY(aquarium);
	}
	
	public Coordinate getRandomFreeCoordinate(Aquarium aquarium){
		x = random.nextInt(aquarium.getSizeX());
		y = random.nextInt(aquarium.getSizeY());
		if (AquaObject.class.getName().equals(aquarium.getTypeInPoint(x, y))){
			//return new Coordinate(x, y, aquarium);
			return new Coordinate(x, y);
		}
		
		return getRandomFreeCoordinate(aquarium); //call recursion
	} 
	


}
