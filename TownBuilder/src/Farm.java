
public class Farm extends Factory{
	public Farm()
	{
		super(10, 10, 10, 5);
		requiredItems.add("water");
	    producedItems.add("food");
	    itemProductionTimes.add(1);
	}
}
