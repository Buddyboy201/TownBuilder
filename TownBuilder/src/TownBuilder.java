import java.util.Scanner;
import java.util.ArrayList;

public class TownBuilder{
	Scanner sc = new Scanner(System.in);
	int population = 100;
	double money = 100;
	int water = 100;
	int food = 100;
	int power = 100;
	int happiness = 100;
	
	String[] map_rsc_names = {"water", "lumber", "coal", "oil", "metal"};
	int[] map_rsc_values = {0, 0, 0, 0, 0};
	
	String[] item_names = {"coal", "oil", "metal", "lumber", "bricks", "steel", "plastic", "electronic_parts"};
	double[] item_values = {};
	int[] inventory = {100, 100, 100, 100, 100, 100, 100, 100, 100};
	
	ArrayList<Factory> factories = new ArrayList<Factory>();
	
	Market market = new Market();
	
	public void printStats()
	{
		System.out.println("Town Stats:");
		System.out.println("	Population: " + population);
		System.out.println("	employed: " + employed);
		System.out.println("	money: " + money);
		System.out.println("	happiness: " + happiness);
		System.out.println("\nUntapped Resources:");
		System.out.println("	water: " + map_rsc_values[0]);
		System.out.println("	lumber: " + map_rsc_values[1]);
		System.out.println("	coal: " + map_rsc_values[2]);
		System.out.println("	oil: " + map_rsc_values[3]);
		System.out.println("	metal: " + map_rsc_values[4]);
	}
	
	public void printInventory()
	{
		for(int i = 0; i < inventory.length; i++)
		{
			System.out.println(item_names[i] + ": " + inventory[i]);
		}
	}
	
	public boolean gameLoop()
	{
		boolean lose = false;
		while(true)
		{
			int tally = 0;
			if(happiness < 10) tally++;
			if(population < 20) tally++;
			if(money < 0) tally++;
			if(tally >= 2)
			{
				lose = true;
				break;
			}
			
			//command handling
			System.out.println("\nCOMMAND: ");
			String command = sc.nextLine();
			switch(command)
			{
			case "stats":
				printStats();
				break;
			case "inventory":
				printInventory();
				break;
			case "factories":
				break;
			case "market":
				break;
			}
			
			
			
			
			//market
			
			
			//resources
			
			
		}
		
		return lose;
	}
	
	public static void main(String[] args)
	{
		TownBuilder game = new TownBuilder();
		game.gameLoop();
	}
}
