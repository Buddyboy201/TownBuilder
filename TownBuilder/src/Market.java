import java.util.ArrayList;

//categories: natural resources, construction materials, manufactured goods
public class Market {
	ArrayList<Item> natural_rsc = new ArrayList<Item>();
	ArrayList<Item> construction_materials = new ArrayList<Item>();
	ArrayList<Item> manufactured_goods = new ArrayList<Item>();
	ArrayList<Item> tools = new ArrayList<Item>();
	
	ArrayList<Item> for_sale = new ArrayList<Item>();
	
	public Market() {}
	
	public double purchaseItem(int pos, String category)
	{
		double price = 0;
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
