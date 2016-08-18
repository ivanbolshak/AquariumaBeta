package aquariumTest;

/**
 * Created by Ivan on 03.01.2016.
 */

public class Aquarium {
	
	private AquaObject aquaObject = new AquaObject();
	private AquaObject arr2D[][] ;

	
	public Aquarium(int sizeX, int sizeY) {
	
		arr2D=makeArr2D(sizeX, sizeY);
	}

	public AquaObject getAquaObject() {return aquaObject;}

	public String getTypeInPoint(int getX, int getY){
		return arr2D[getX][getY].getClass().getName();
	}

	public int getSizeX(){return arr2D.length;}
    
    public int getSizeY(){return arr2D[0].length;}

	public void setAnyAquaObject(AquaObject aquaObj, int x, int y){
		if (x>=0&&y>=0&&x<getSizeX()&&y<getSizeY()) arr2D[x][y]=aquaObj;
		else throw new IllegalAccessError("setAnyAquaObject out of diapazon!!!");
	}
	
	public void setAnyAquaObject(AquaObject aquaObj){
		int x=aquaObj.getCoordinate().getX();
		int y=aquaObj.getCoordinate().getY();
		if (x>=0&&y>=0&&x<getSizeX()&&y<getSizeY()) arr2D[x][y]=aquaObj;
		else throw new IllegalAccessError("setAnyAquaObject out of diapazon!!!");
	}

	public AquaObject getAnyAquaObject(int x, int y){
		if (x>=0&&y>=0&&x<getSizeX()&&y<getSizeY()) return arr2D[x][y];
		else return null;
	}
	
	public AquaObject getAnyAquaObject(Coordinate coord){
		int x=coord.getX();
		int y=coord.getY();
		if (x>=0&&y>=0&&x<getSizeX()&&y<getSizeY()) return arr2D[x][y];
		else return null;
	}
    
    public AquaObject[][] makeArr2D(int sizeX, int sizeY){

        AquaObject arr[][] = new AquaObject[sizeX][sizeY];
        for (int i = 0; i < sizeX ; i++) {
            for (int j = 0; j< sizeY; j++) {
                arr[i][j]=aquaObject;
            }
        }
        return arr;
    }
    
    public void print2D(){
    	
    	for (int i=0; i<getSizeX(); i++ ){
    		for (int j=0; j<getSizeY(); j++){
    			System.out.print(arr2D[i][j]);
    		}
    		System.out.println();
    	}
    	
    }
    


}



