import java.util.*;
import java.math.*;
import java.io.*;

public class TownBuilder {
	
	int population = 0;
	//int employed = 0;
	int[] rsc = {0, 0, 0, 0, 0, 0, 0, 0, 0}; 
	String[] rsc_names = {"power", "food", "water", "lumber", "bricks", "plastic", "coal", "oil", "electronic_parts"};
	int[][] tile_map = new int[5][5];
	String[] tile_map_rsc_names = {"food", "water", "lumber", "coal", "oil"};
	
	
	public void generateResources(int[] tile)
	{
		//food
		double rand = Math.random();
		tile[0] = rand*x;
	}
}
