package aquariumTest;

/**
 * Created by Ivan on 03.01.2016.
 *
 *
 */
public class Fish extends AquaObject  {

	protected Coordinate coordinate;
	boolean life;

	public Fish(){
		super();
		life = true;
		
	}
	
	public Fish(int x, int y) {
        coordinate = new Coordinate(x ,y);
        life = true;
    }
    
    public Fish(Coordinate coordinate) { 
		this.coordinate = coordinate;
    	life = true;
		
	}
    
    public Fish(Aquarium aquarium) {
		super();
		life = true;
		this.coordinate = coordinate.getRandomFreeCoordinate(aquarium);
	}

    public void changeCoord(Aquarium aquarium){
    	coordinate.changeXY(aquarium);
    }
    
    public String getType(){return type;}
    
    public Coordinate getCoordinate(){return coordinate;}
    
    public boolean getLife(){return life;}
    public void setLife(boolean life){this.life=life;}
    
    public boolean createNewFish(Coordinate coordinate){
    	   	
    	return false;
    }
    
}
