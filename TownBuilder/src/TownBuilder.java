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
	String[] categories = {"natural_rsc", "natural_rsc", "natural_rsc", "construction_materials", "construction_materials", "construction_materials", "manufactured_goods", "manufactured_goods"};
	int[] item_values = {10, 9, 7, 8, 6, 7, 5, 7};
	int[] inventory = {100, 100, 100, 100, 100, 100, 100, 100};
	
	int farms = 0;
	int brick_factories = 0;
	int coal_mines = 0;
	int coal_power_plants = 0;
	int oil_mines = 0;
	int oil_power_plants = 0;
	int ore_mines = 0;
	int plastic_factories = 0;
	int steel_factories = 0;
	int water_pumps = 0;
	int windmills = 0;
	int woodcutting_plants = 0;
	
	
	public void printStats()
	{
		System.out.println("Town Stats:");
		System.out.println("	Population: " + population);
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
	
	public boolean gameLoop(TownBuilder game, Market market)
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
				System.out.println("Build type: ");
				command = sc.nextLine();
				switch(command)
				{
				case "BrickFactory":
					brick_factories++;
					BrickFactory bf = new BrickFactory();
					bf.buildFactory(game);
					bf.start();
					break;
				case "CoalMine":
					coal_mines++;
					CoalMine cm = new CoalMine();
					cm.buildFactory(game);
					cm.start();
					break;
				case "CoalPowerPlant":
					coal_power_plants++;
					CoalPowerPlant cpp = new CoalPowerPlant();
					cpp.buildFactory(game);
					cpp.start();
					break;
				case "Farm":
					farms++;
					Farm farm = new Farm();
					farm.buildFactory(game);
					farm.start();
					break;
				case "OilMine":
					oil_mines++;
					OilMine om = new OilMine();
					om.buildFactory(game);
					om.start();
					break;
				case "OilPowerPlant":
					oil_power_plants++;
					OilPowerPlant opp = new OilPowerPlant();
					opp.buildFactory(game);
					opp.start();
					break;
				case "OreMine":
					ore_mines++;
					OreMine orm = new OreMine();
					orm.buildFactory(game);
					orm.start();
					break;
				case "PlasticFactory":
					plastic_factories++;
					PlasticFactory pf =new PlasticFactory();
					pf.buildFactory(game);
					pf.start();
					break;
				case "SteelFactory":
					steel_factories++;
					SteelFactory sf = new SteelFactory();
					sf.buildFactory(game);
					sf.start();
					break;
				case "WaterPump":
					water_pumps++;
					WaterPump wp = new WaterPump();
					wp.buildFactory(game);
					wp.start();
					break;
				case "Windmill":
					windmills++;
					Windmill w = new Windmill();
					w.buildFactory(game);
					w.start();
					break;
				case "WoodcuttingPlant":
					woodcutting_plants++;
					WoodcuttingPlant wcp = new WoodcuttingPlant();
					wcp.buildFactory(game);
					wcp.start();
					break;
				default:
					System.out.println("Not a valid build type.");
					break;
				}
				break;
			case "market":
				System.out.println("Buy or list: ");
				command = sc.nextLine();
				int i;
				int price;
				switch(command) {
				case "buy":
					System.out.println("Category to list: ");
					command = sc.nextLine();
					switch(command)
					{
					case "natural_rsc":
						market.printItems("natural_rsc");
						System.out.println("Item to buy(Exit=0): ");
						i = sc.nextInt();
						price = market.purchaseItem(i, "natural_rsc");
						if(money>=price) 
						{
							money -= price;
							inventory[i-1] += market.natural_rsc.get(i-1).quantity;
						}
						else System.out.println("Not enough money");
						
						break;
					case "construction_materials":
						market.printItems("construction_materials");
						System.out.println("Item to buy(Exit=e): ");
						i = sc.nextInt();
						price = market.purchaseItem(i, "construction_materials");
						if(money>=price) 
						{
							money -= price;
							inventory[i+3-1] += market.construction_materials.get(i-1).quantity;
						}
						else System.out.println("Not enough money");
						break;
					case "manufactured_goods":
						market.printItems("manufactured_goods");
						System.out.println("Item to buy(Exit=e): ");
						i = sc.nextInt();
						price = market.purchaseItem(i, "manufactured_goods");
						if(money>=price) 
						{
							money -= price;
							inventory[i+6-1] += market.manufactured_goods.get(i-1).quantity;
						}
						else System.out.println("Not enough money");
						break;
					default:
						System.out.println("Not a valid category");
						break;
					}
					break;
				case "list":
					System.out.println("Item to list: ");
					command = sc.nextLine();
					int q;
					int p;
					switch(command)
					{
					case "coal":
						System.out.println("Quantity: ");
						q = sc.nextInt();
						if(inventory[0] <= q)
						{
							inventory[0] -= q;
							p = sc.nextInt();
							market.for_sale.add(new Item(item_values[0], "natural_rsc", "coal", q, p));
						}
						else
						{
							System.out.println("Too big a quantity");
						}
						break;
					case "oil": 
						System.out.println("Quantity: ");
						q = sc.nextInt();
						if(inventory[1] <= q)
						{
							inventory[1] -= q;
							p = sc.nextInt();
							market.for_sale.add(new Item(item_values[1], "natural_rsc", "oil", q, p));
						}
						else
						{
							System.out.println("Too big a quantity");
						}
						break;
					case "metal":
						System.out.println("Quantity: ");
						q = sc.nextInt();
						if(inventory[2] <= q)
						{
							inventory[2] -= q;
							p = sc.nextInt();
							market.for_sale.add(new Item(item_values[2], "natural_rsc", "metal", q, p));
						}
						else
						{
							System.out.println("Too big a quantity");
						}
						break;
					case "lumber":
						System.out.println("Quantity: ");
						q = sc.nextInt();
						if(inventory[3] <= q)
						{
							inventory[3] -= q;
							p = sc.nextInt();
							market.for_sale.add(new Item(item_values[3], "construction_materials", "lumber", q, p));
						}
						else
						{
							System.out.println("Too big a quantity");
						}
						break;
					case "bricks": 
						System.out.println("Quantity: ");
						q = sc.nextInt();
						if(inventory[4] <= q)
						{
							inventory[4] -= q;
							p = sc.nextInt();
							market.for_sale.add(new Item(item_values[4], "construction_materials", "bricks", q, p));
						}
						else
						{
							System.out.println("Too big a quantity");
						}
						break;
					case "steel":
						System.out.println("Quantity: ");
						q = sc.nextInt();
						if(inventory[5] <= q)
						{
							inventory[5] -= q;
							p = sc.nextInt();
							market.for_sale.add(new Item(item_values[5], "construction_materials", "steel", q, p));
						}
						else
						{
							System.out.println("Too big a quantity");
						}
						break;
					case "plastic":
						System.out.println("Quantity: ");
						q = sc.nextInt();
						if(inventory[6] <= q)
						{
							inventory[6] -= q;
							p = sc.nextInt();
							market.for_sale.add(new Item(item_values[6], "manufactured_goods", "plastic", q, p));
						}
						else
						{
							System.out.println("Too big a quantity");
						}
						break;
					case "electronic_parts":
						System.out.println("Quantity: ");
						q = sc.nextInt();
						if(inventory[7] <= q)
						{
							inventory[7] -= q;
							p = sc.nextInt();
							market.for_sale.add(new Item(item_values[7], "manufactured_goods", "electronic_parts", q, p));
						}
						else
						{
							System.out.println("Too big a quantity");
						}
						break;
					default:
						System.out.println("Not a valid item");
						break;
					}
					break;
				default:
					System.out.println("That is not a valid option.");
					break;
				}
				break;
			}
			
		}
		return lose;
	}
	
	public static void main(String[] args)
	{
		TownBuilder game = new TownBuilder();
		Market market = new Market(game);
		game.gameLoop(game, market);
		market.start();
	}
}
