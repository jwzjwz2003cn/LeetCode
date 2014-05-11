package Solutions;
import java.util.*;

class Point{
	int x;
	int y;
	Point(){ x=0; y=0;}
	Point(int a, int b){ x=a; y=b; } 
}

public class maxPointsProblem {

	public int maxPoints(Point[] points)
	{
		// y = x+c then c=y-x
		int maxCount = 0;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < points.length; i++)
		{
			int c = points[i].y-points[i].x;
			int count = 1;
			if (hm.containsKey(c))
			{
				count = hm.get(c) + 1;
			}
			hm.put(c, count);
			if (count >= maxCount)
				maxCount = count;
		}
		return maxCount;
	}
	
	public void testMaxPoints()
	{
		
	}
}
