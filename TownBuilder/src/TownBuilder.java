import java.util.*;
import java.math.*;
import java.io.*;

public class TownBuilder {
	
	int population = 0;
	//int employed = 0;
	int[] rsc = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100}; 
	String[] rsc_names = {"money", "power", "food", "water", "lumber", "bricks", "plastic", "coal", "oil", "electronic_parts"};
	int[][] tile_map = new int[5][5];
	String[] tile_map_rsc_names = {"food", "water", "lumber", "coal", "oil"};
	
	
	public void generateResources(int[] tile) //Not fixed, will likely be modified to balance game
	{
		double rand = Math.random(); 
		tile[0] = (int) (rand*100);
		tile[1] = (int) (rand*150);
		tile[2] = (int) (rand*75);
		tile[3] = (int) (rand*60);
		tile[4] = (int) (rand*50);
	}
	
	
}
