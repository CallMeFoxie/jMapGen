package jMapGen.graph;

import jMapGen.Point;


public class Edge 
{
	public int index;
	public Center dCenter0, dCenter1;  // Delaunay edge
	public Corner vCorner0, vCorner1;  // Voronoi edge
	public Point midpoint;  // halfway between v0,v1
	public int river = 0;  // volume of water, or 0
	
	public void setVoronoiEdge(Corner c0, Corner c1)
	{
		vCorner0 = c0;
		vCorner1 = c1;
		
		if(/*v0 != null && */ !vCorner0.adjacent.contains(vCorner1) && vCorner0.index != vCorner1.index)
		{
			vCorner0.adjacent.add(vCorner1);
		}
		
		if(/*v1 != null && */ !vCorner1.adjacent.contains(vCorner0) && vCorner1.index != vCorner0.index)
		{
			vCorner1.adjacent.add(vCorner0);
		}
	}
	
	/**
	 * 
	 * @param c The Corner that you already have
	 * @return The opposite corner of the edge. Returns null if you feed it a corner that is not a part of this edge.
	 */
	public Corner otherCorner(Corner c)
	{
		if(c == vCorner0)
			return vCorner1;
		else if(c == vCorner1)
			return vCorner0;
		else return null;
	}
}

