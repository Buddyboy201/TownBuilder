
public class BrickFactory extends Factory {
	public BrickFactory()
	{
		super(12, 10, 10, 5);
		requiredItems.add("metal");
	     producedItems.add("bricks");
	     itemProductionTimes.add(1);

	}

}
