
public class SteelFactory extends Factory 
{
	public SteelFactory()
	{
		super(12, 10, 10, 5);
		requiredItems.add("metal");
	     producedItems.add("steel");
	     itemProductionTimes.add(2);
	}
}
