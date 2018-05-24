
public class WaterPump extends Factory {
	public WaterPump()
	{
		super(7, 5, 8, 6);
		producedItems.add("power");
	     requiredItems.add("water");
	     itemProductionTimes.add(2);

	}
}
