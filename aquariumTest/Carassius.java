package aquariumTest;

import static aquariumTest.Coordinate.*;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 03.01.2016.
 */
public class Carassius extends Fish {
	
	public Carassius(int x, int y) {
		super(x, y);
		type="Y ";
		life = true;
	}
	
	public Carassius(Coordinate coordinate) { 
		super(coordinate);
		type="Y ";
		life = true;
	}
	
	public Carassius(Aquarium aquarium) {
		super();
		type="Y ";
		life = true;
		coordinate = new Coordinate();
		coordinate.getRandomFreeCoordinate(aquarium);
	} 
	
	

	public boolean getLife(){return life;}
	
	public void setLife(boolean life){this.life = life;}


	public void moveFish(Aquarium aquarium, List<Carassius> listFish) {

		if (!this.getLife()) return;

		int oldX = this.getCoordinate().getX();
		int oldY = this.getCoordinate().getY();
		//Coordinate coordinateTmp = new Coordinate(oldX, oldY, aquarium);
		Coordinate coordinateTmp = new Coordinate(oldX, oldY);
		coordinateTmp.changeXY(aquarium);
		int newX = coordinateTmp.getX();
		int newY = coordinateTmp.getY();

		if (newX==oldX&&newY==oldY) return;

		String nameClassNext = aquarium.getTypeInPoint(newX, newY);

		if (Stones.class.getName().equals(nameClassNext))return; //if Next Stone, don't move

		//--------- DIFFERENT betvine superClass----------------------
		if (Carassius.class.getName().equals(nameClassNext)) { //if Next elso Carrassius, don't move
			
			if (((aquarium.getSizeY()*(aquarium.getSizeX())/10)>listFish.size())){ //limit reproduction
				reproduction(this.getCoordinate(), listFish, aquarium);
				return;
			}
		}

		if (Pike.class.getName().equals(nameClassNext)){ //if next point is Pike, Carrasius die
				this.setLife(false);
				aquarium.setAnyAquaObject(aquarium.getAquaObject(), oldX, oldY);
				//Pike.class.setHuntCount(); ---??????????? Kak sdelat' poxojee?
				return;
		}


		//if all good, Carassius move next point:

		this.getCoordinate().setX(newX);
		this.getCoordinate().setY(newY);

		aquarium.setAnyAquaObject(this, newX, newY); //move fish from old coordinate to new
		aquarium.setAnyAquaObject(aquarium.getAquaObject(), oldX, oldY);
	}

	public void reproduction(Coordinate coordinate, List<Carassius> listFish, Aquarium aquarium){
		
		if (random.nextInt(7)!=1) return;
		
		//Coordinate newCoord = new Coordinate(coordinate.getX(), coordinate.getY(), aquarium);
		Coordinate newCoord = new Coordinate(coordinate.getX(), coordinate.getY());
		newCoord.changeXY(aquarium);
		
		if (AquaObject.class.getName().equals(
				aquarium.getTypeInPoint(newCoord.getX(), newCoord.getY()))){ 
				
			Carassius newCaras =new Carassius(newCoord); 
			listFish.add(newCaras);
			aquarium.setAnyAquaObject(newCaras);
			
		}
		
		 
		
		
		
		
	}

		
	
	
	
}







