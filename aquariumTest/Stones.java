package aquariumTest;

/**
 * Created by Ivan on 03.01.2016.
 *
 *
 */
public class Stones extends AquaObject {
	Coordinate coordinate;

	public Stones (){
		 super();
		 type="[]";
	 }
	public Stones(int x, int y) {
		super();
		type="[]";
		coordinate = new Coordinate(x ,y);
	}
	
	public Stones(Coordinate coordinate) {
		super();
		type="[]";
		this.coordinate = coordinate;
	}
	
	public Stones(Aquarium aquarium) {
		super();
		type="[]";
		coordinate = new Coordinate();
		coordinate.getRandomFreeCoordinate(aquarium);
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}


}
