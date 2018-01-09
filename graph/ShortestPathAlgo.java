package graph;

import java.util.LinkedList;
import java.util.List;
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
	
	public void shortestPathForWeightedGraph(Graph g, int s) {// dijkstra
		HeapTree<Vertex> minPriqueue = new HeapTree(HeapTree.MIN_HEAP,g.getVertexCount());
		int u, v;

		try {
			for (int i = 0; i < g.getVertexCount(); i++) {
				g.getVertexList()[i].setWeight(-1);
			}
			g.getVertexList()[s].setWeight(0);
			minPriqueue.insert(g.getVertexList()[s]);
			int vertexCount = g.getVertexCount();
			while (!minPriqueue.isEmpty()) {
				u = minPriqueue.getFirst().getIndex();
				v = 0;

				while (v < vertexCount) {
					if (g.getAdjacencyMAtrix()[u][v] == 1 && u != v) {

						if (relaxTheEdge(u, v, g)) {
							if (!g.getVertexList()[v].isVisited()) {
								minPriqueue.insert(g.getVertexList()[v]);
								g.getVertexList()[v].setVisited(true);
							} else {
								minPriqueue.updatePriority(g.getVertexList()[v]);
							}
						}
					}
					v++;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ShortestPathWeightedAlgo(Graph g){//DAG
		List<Integer> list = new TopologicalSort(g).getTopologicalSort();
		int length = list.size();
		int curIndex=0;
		for(int i=0;i<g.getVertexCount();i++){
			g.getVertexList()[i].setWeight(-1);
		}
		g.getVertexList()[list.get(curIndex)].setWeight(0);
		int vertexCount = g.getVertexCount();
		while(curIndex<length){
			int u = list.get(curIndex);
			int v = 0;

			while (v < vertexCount) {
				if (g.getAdjacencyMAtrix()[u][v] == 1 && u != v) {
					relaxTheEdge(u, v, g);
				}
			}
			curIndex++;
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
