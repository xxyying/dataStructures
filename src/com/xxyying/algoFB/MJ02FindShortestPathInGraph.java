package com.xxyying.algoFB;

public class MJ02FindShortestPathInGraph {
	// A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
	
	static final int vertex = 9;
	
	public void dijkstra(int[][] graph, int src) {
		
		int[] dist = new int[vertex]; // the output array, dist[i] will hold the shortest distance from src to i
		
		boolean[] sptSet = new boolean[vertex]; // if vertex i is included or not
		
		// initialize all distances to infinite, and sptSet to false
		for(int i = 0; i < vertex; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		
		
		dist[src] = 0;
		
		for(int cnt = 0; cnt < vertex - 1; cnt++) {
			int u = minDistance(dist, sptSet);
			sptSet[u] = true;
			
			for(int v = 0; v < vertex; v++) {
				// Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
				if (!sptSet[v] && graph[u][v]!=0 
						&& dist[u] != Integer.MAX_VALUE 
						&& dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
			}
		}
        printSolution(dist, vertex);

	}
	
	
	public int minDistance(int[] dist, boolean[] sptSet) {
		// Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < vertex; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
	}
	
	
	 public void printSolution(int dist[], int n)
	    {
	        System.out.println("Vertex    Distance from Source");
	        for (int i = 0; i < vertex; i++)
	            System.out.println(i+" \t\t "+dist[i]);
	    }
	
	/*	Graph:  
	 *  		     (1) -8- (2) -7- (3)
	 *				/ |      | \	  | \	
	 * 			   4  |	     2  \  	  |  9
	 * 			  /	  |      |   \	  |	  \
	 * 			(0)	 11     (8)   4   14  (4)
	 *			  \	  |   /  |     \  |   /
	 *			   8  |  7   6      \ |  10
	 *				\ | /    |       \| /
	 *			   	 (7) -1- (6) -2- (5)
	 */
	public static void main(String[] args) {
		int graph[][] = new int[][]{
			{0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
           };
           
           MJ02FindShortestPathInGraph t = new MJ02FindShortestPathInGraph();
           t.dijkstra(graph, 0);
	}


}
