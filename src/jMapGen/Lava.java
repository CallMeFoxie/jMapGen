// Randomly place lava on high elevation dry land.
// Author: amitp@cs.stanford.edu
// License: MIT

package jMapGen;

import jMapGen.graph.Edge;

import java.util.ArrayList;
import java.util.Random;

public class Lava 
{
	static public double FRACTION_LAVA_FISSURES = 0.2;  // 0 to 1, probability of fissure

	// The lava array marks the edges that hava lava.
	public ArrayList<Boolean> lava;  // edge index -> Boolean

	// Lava fissures are at high elevations where moisture is low
	public void createLava(Map map, Random random) 
	{
		lava = new ArrayList<Boolean>(map.edges.size());
		Edge edge;
		for(int i = 0; i < map.edges.size(); i++) 
		{
			edge = map.edges.get(i);
			if (edge.river != 1 && !edge.dCenter0.water && !edge.dCenter1.water
					&& edge.dCenter0.elevation > 0.8 && edge.dCenter1.elevation > 0.8
					&& edge.dCenter0.moisture < 0.3 && edge.dCenter1.moisture < 0.3
					&& random.nextDouble() < FRACTION_LAVA_FISSURES) 
			{
				lava.set(edge.index, true);
			}
		}
	}
}


