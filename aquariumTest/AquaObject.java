package aquariumTest;


/**
 * Created by Ivan on 04.01.2016.
 */
public class AquaObject {
    protected String type;
    protected Coordinate coordinate;

    public AquaObject() {
        this.type = ". ";
    }
    
    public Coordinate getCoordinate(){return coordinate;}
    

    @Override
    public String toString() {
        return  type;
    }
    
    public boolean createAquaObject(Aquarium aquarium, Coordinate coordinate){
    	int x = coordinate.getX();
    	int y = coordinate.getY();
    	if (AquaObject.class.getClass().getName().equals(
    			aquarium.getAnyAquaObject(coordinate).getClass().getName())){
    		aquarium.setAnyAquaObject(this, x, y); 
    		return true;
    	}
    	else return false;}   


}
