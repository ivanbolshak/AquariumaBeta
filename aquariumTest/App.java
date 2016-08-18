package aquariumTest;

import java.util.*;


/**
 * Created by Ivan on 03.01.2016.
 */
public class App {
    public static void main(String[] args) {

//{set aquarium size----------------------------------------
    	int sizeX = 15;
        int sizeY = 30;
        
//set aquarium object quantity        
        int stoneCount=7;
        int carasCount=10;
        int pikeCount = 1;
//}--------------------------------------------------------        
        
               
        Aquarium aquarium = new Aquarium(sizeX, sizeY);
        
//make and add stone in aquarium
        Stones stoneList[] = new Stones[stoneCount];
  
        for (int i=0;i<stoneCount; i++){
        	stoneList[i]=new Stones(aquarium);
        	aquarium.setAnyAquaObject(stoneList[i]);
        }
  
//make and add caras in aquarium         
        List<Carassius> carasList = new ArrayList<Carassius>();
        
        for (int i=0;i<carasCount; i++){
        	carasList.add(i, new Carassius(aquarium));
        	aquarium.setAnyAquaObject(carasList.get(i));
        }
        
//make and add pike in aquarium               
        
        List<Pike> pikeList = new ArrayList<Pike>();
        
        for (int i=0;i<pikeCount; i++){
        	pikeList.add(i, new Pike(aquarium));
        	aquarium.setAnyAquaObject(pikeList.get(i));
        }

//Print all aquatium        
        aquarium.print2D();

       //for (;;){
        while (carasList.size()>0){

        	System.out.println("Designation:");
        	System.out.println("Y : carassius(prey)");
        	System.out.println("<- : pike(predator)");
        	System.out.println("[] : stones");
        	System.out.println("Carasius count: "+carasList.size());
        	System.out.println("HuntCount: "+pikeList.get(0).getHuntCount());
        	
//move fish in aquarium
           for (int i=0;i<(carasList.size()+pikeList.size());i++){
        	   
        	   if (i<pikeList.size()){
        		   pikeList.get(i).moveFish(aquarium, pikeList);
        		   if (pikeList.get(i).getLife()==false)pikeList.remove(i); 
        		}
        	   if (i<carasList.size()){
        		   carasList.get(i).moveFish(aquarium, carasList);
        		   if (carasList.get(i).getLife()==false)carasList.remove(i); 
        	   }
           	
           	//if (i<carasList.size()&&!carasList.get(i).getLife()) carasList.remove(i);
           }

           
           
           System.out.println();
           aquarium.print2D();
        
        
        timerClearner();
        }
       
       
       

        
        
        
        
        
        System.out.println("----------------");
        System.out.println("    The End!    ");
        System.out.println("----------------");
        
        
    }
    
    public static void timerClearner(){
    	try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


       for (int i=0;i<20;i++){
    	System.out.println();
       }
    }


}
