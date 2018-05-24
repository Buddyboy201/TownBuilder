import java.util.ArrayList;

public class Factory extends Thread{
     int buildingCost;
     int itemGain;
     int itemProductionCost;
     int rscCost;
     TownBuilder town;
     ArrayList<String> requiredItems = new ArrayList<String>();
     ArrayList<String> producedItems = new ArrayList<String>();
     ArrayList<Integer> itemProductionTimes = new ArrayList<Integer>();
     
     public Factory(int buildingCost, int itemGain, int itemProductionCost, int rscCost)
     {
    	 this.buildingCost = buildingCost;
         this.itemGain = itemGain;
         this.itemProductionCost = itemProductionCost;
         this.rscCost = rscCost;
     }
   
     public void buildFactory(TownBuilder t)
     {
    	 this.town = t;
    	 town.money -= buildingCost;
     }
     
     public void run()
     {
    	 int sum = 0;
    	 for(int i : itemProductionTimes)
    		 sum += i;
    	 while(true)
    	 {
    	 try {
			Thread.sleep(1000*sum);
		} catch (Exception e) {
			System.out.println(e);
		}
    	 runFactory(town);
    	 }
    	 
     }
     
     public void runFactory(TownBuilder t)
     {
    	 town = t;
    	 town.money -= itemProductionCost;
    	 for(String i : requiredItems)
    	 {
    		switch(i)
    		{
    		case "water":
    			town.water -= rscCost;
    			break;
    		case "power":
    			town.power -= rscCost;
    			break;
    		case "coal":
    			town.inventory[0] -= rscCost;
    			break;
    		case "oil":
    			town.inventory[1] -= rscCost;
    			break;
    		case "lumber":
    			town.inventory[3] -= rscCost;
    			break;
    		case "metal":
    			town.inventory[2] -= rscCost;
    			break;
    		}
    	 }
    	 
    	 for(String i : producedItems)
    	 {
    		switch(i)
    		{
    		case "water":
    			town.water += itemGain;
    			break;
    		case "power":
    			town.power += itemGain;
    			break;
    		case "coal":
    			town.inventory[0] += itemGain;
    			break;
    		case "oil":
    			town.inventory[1] += itemGain;
    			break;
    		case "lumber":
    			town.inventory[3] += itemGain;
    			break;
    		case "metal":
    			town.inventory[2] += itemGain;
    			break;
    		case "bricks"://
    			town.inventory[4] += itemGain;
    			break;
    		case "plastic"://
    			town.inventory[6] += itemGain;
    			break;
    		case "food":
    			town.food += itemGain;
    			break;
    		case "steel":
    			town.inventory[5] += itemGain;
    			break;
    		}
    	 }
     }
}
     
     
     
     
     
    
     
     
     
     
     
    
