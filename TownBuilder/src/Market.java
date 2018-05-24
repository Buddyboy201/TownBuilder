import java.util.ArrayList;

//categories: natural resources, construction materials, manufactured goods
public class Market extends Thread {
	ArrayList<Item> natural_rsc = new ArrayList<Item>();
	ArrayList<Item> construction_materials = new ArrayList<Item>();
	ArrayList<Item> manufactured_goods = new ArrayList<Item>();
	ArrayList<Item> tools = new ArrayList<Item>();
	TownBuilder t;
	
	ArrayList<Item> for_sale = new ArrayList<Item>();
	
	public Market(TownBuilder t) {
		this.t = t;
	}
	
	public void run()
	{
		while(true)
		{
			natural_rsc.add(new Item((int)(Math.random()*50), "natural_rsc", "coal", (int)(Math.random()*50), (int)(Math.random()*50)));
			natural_rsc.add(new Item((int)(Math.random()*50), "natural_rsc", "oil", (int)(Math.random()*50), (int)(Math.random()*50)));
			natural_rsc.add(new Item((int)(Math.random()*50), "natural_rsc", "metal", (int)(Math.random()*50), (int)(Math.random()*50)));
			construction_materials.add(new Item((int)(Math.random()*50), "construction_materials", "lumber", (int)(Math.random()*50), (int)(Math.random()*50)));
			construction_materials.add(new Item((int)(Math.random()*50), "construction_materials", "bricks", (int)(Math.random()*50), (int)(Math.random()*50)));
			construction_materials.add(new Item((int)(Math.random()*50), "construction_materials", "steel", (int)(Math.random()*50), (int)(Math.random()*50)));
			manufactured_goods.add(new Item((int)(Math.random()*50), "manufactured_goods", "plastic", (int)(Math.random()*50), (int)(Math.random()*50)));
			manufactured_goods.add(new Item((int)(Math.random()*50), "manufactured_goods", "electronic_parts", (int)(Math.random()*50), (int)(Math.random()*50)));
			for(Item i : natural_rsc)
				System.out.println(i.name);
			try {
				Thread.sleep(60000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			for(Item i : for_sale)
			{
				sellItem(i);
			}
		}
		
	}
	
	public void sellItem(Item item)
	{
		double a = (double)(item.curr_value)/item.price;
		double prob = Math.random();
		if(prob-a < 0) 
		{
			t.money += item.price;
			System.out.println("***" + item.quantity + " " + item.name + " were sold at " + item.price + "!");
		}
	}
	
	public int purchaseItem(int pos, String category)
	{
		int price = 0;
		Item item;
		switch(category)
		{
		case "natural_rsc":
			item = natural_rsc.get(pos-1);
			price = item.price;
			break;
		case "construction_materials":
			item = natural_rsc.get(pos-1);
			price = item.price;
			break;
		case "manufactured_goods":
			item = natural_rsc.get(pos-1);
			price = item.price;
			break;
		default:
			System.out.println("Item not found");
			break;
		}
		return price;
	}
	
	public void listOnMarket(Item item)
	{
		for_sale.add(item);
	}
	
	public void printItems(String category)
	{
		int count = 0;
		switch(category)
		{
		case "natural_rsc":
			for(Item i : natural_rsc)
			{
				count++;
				System.out.print(count+") "+i.name+"("+i.quantity+"): "+i.price);
			}
			break;
		case "construction_materials":
			for(Item i : construction_materials)
			{
				count++;
				System.out.print(count+") "+i.name+"("+i.quantity+"): "+i.price);
			}
			break;
		case "manufactured_goods":
			for(Item i : manufactured_goods)
			{
				count++;
				System.out.print(count+") "+i.name+"("+i.quantity+"): "+i.price);
			}
			break;
		default:
			System.out.println("Not a valid category id");
			break;
		}
	}
	
}
