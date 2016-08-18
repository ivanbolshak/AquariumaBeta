package aquariumTest;

import java.util.*;

/**
 * Created by Ivan on 03.01.2016.
 */
public class Pike extends Fish {

    private int huntCount=0;
    
    
	
	public Pike(int x, int y) {
        super(x, y);
        type = "<-";
    }
    
    public Pike(Aquarium aquarium) {
		super();
		type="<-";
		life = true;
		coordinate = new Coordinate();
		coordinate.getRandomFreeCoordinate(aquarium);
	} 
    
    public int getHuntCount() {return huntCount;}
    public void setHuntCount() {huntCount++;}

    public void moveFish(Aquarium aquarium, List<Pike> pikeList) {
        int oldX = this.getCoordinate().getX();
        int oldY = this.getCoordinate().getY();
        //Coordinate coordinateTmp = new Coordinate(oldX, oldY, aquarium);
        Coordinate coordinateTmp = new Coordinate(oldX, oldY);
        coordinateTmp.changeXY(aquarium);
        int newX = coordinateTmp.getX();
        int newY = coordinateTmp.getY();

        if (newX==oldX&&newY==oldY) return;
        
        Coordinate huntCoord = huntingNextPoint(aquarium);
        
        if (huntCoord!=null){
        	
        	newX=huntCoord.getX();
        	newY=huntCoord.getY();
        	
        }

        String nameClassNext = aquarium.getTypeInPoint(newX, newY);
         if (Stones.class.getName().equals(nameClassNext)) return; //if Next Stone, don't move

        //--------- DIFFERENT betvine superClass----------------------
        if (Pike.class.getName().equals(nameClassNext)) return;  //if Next elso Pike, don't move

        if (Carassius.class.getName().equals(nameClassNext)) { //if next point is Carassius, Carrasius die
            Carassius tmpCarassius = (Carassius) aquarium.getAnyAquaObject(newX, newY);
            tmpCarassius.setLife(false);
          }


        //if all good, Pike move next point:

        
        this.getCoordinate().setX(newX);
        this.getCoordinate().setY(newY);
        
        aquarium.setAnyAquaObject(this, newX, newY); //move fish from old coordinate to new
        aquarium.setAnyAquaObject(aquarium.getAquaObject(), oldX, oldY);

    }
    
    public Coordinate huntingNextPoint(Aquarium aquarium){
    	
    	int x = this.getCoordinate().getX();
    	int y = this.getCoordinate().getY();
    	
    	for (int i=-1; i<=1; i++){
    		for (int j=-1; j<=1; j++){
    			
    			if (x+i>=0&&y+j>=0&&x+i<aquarium.getSizeX()&&y+j<aquarium.getSizeY()){

    				
    				if (Carassius.class.getName().equals(aquarium.getTypeInPoint(x+i, y+j))){
    					huntCount++;
    					return new Coordinate(x+i, y+j);
    				}}
    			}
    		}
    		
    	
    	return null;
    	
    }
}















