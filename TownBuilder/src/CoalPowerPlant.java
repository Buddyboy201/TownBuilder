
public class CoalPowerPlant extends Factory {
	public CoalPowerPlant()
	{
		super(16, 8, 8, 6);
		requiredItems.add("coal");
	     producedItems.add("power");
	     itemProductionTimes.add(3);

	}
}
