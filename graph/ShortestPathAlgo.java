package graph;

import java.util.LinkedList;
import java.util.Queue;

import tree.HeapTree;

public class ShortestPathAlgo {
	//UnWeighted Graph
	public void shortestPathUnWeightedGraph(Graph g,int start){
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
	
	public void shortestPathForWeightedGraph(Graph g,int s){//dijkstra
		HeapTree<Vertex> minPriqueue =  new HeapTree(HeapTree.MIN_HEAP,g.getVertexCount());
		int u,v;
		
		try {
			minPriqueue.insert(g.getVertexList()[s]);
			while(!minPriqueue.isEmpty()){
				u =  minPriqueue.getFirst().getIndex();
				v = g.getAdjVertex(u);
				while(v!=-1){
					
					if(relaxTheEdge(u, v,g)){
						if(!g.getVertexList()[v].isVisited()){
							minPriqueue.insert(g.getVertexList()[v]);
							g.getVertexList()[v].setVisited(true);
						}else{
							minPriqueue.updatePriority(g.getVertexList()[v]);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean relaxTheEdge(int u,int v,Graph g){
		Vertex vu = g.getVertexList()[u];
		Vertex vv = g.getVertexList()[v];
		if(vv.getWeight()> vu.getWeight() + g.getAdjacencyMAtrix()[u][v]){
			vv.setWeight(vu.getWeight() + g.getAdjacencyMAtrix()[u][v]);
			return true;
		}
		return false;
	}
}
