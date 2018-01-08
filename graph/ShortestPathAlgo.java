package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathAlgo {
	//UnWeighted Graph
	public void ShortestPathUnWeightedGraph(Graph g,int start){
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		for(int i=0;i<g.getVertexCount();i++){
			g.getVertexList()[i].setWeight(-1);
		}
		g.getVertexList()[start].setWeight(0);
		while(!q.isEmpty()){
			int u = q.poll();
			int v = g.getNonVisitedAdjVertex(u);
			while(v!=-1){
				if(g.getVertexList()[v].getWeight()==-1){
					g.getVertexList()[v].setWeight(g.getVertexList()[u].getWeight()+1 );
					g.getVertexList()[v].setParent(u);
					q.offer(v);
				}
			}
		}
		q.clear();
	}
}
