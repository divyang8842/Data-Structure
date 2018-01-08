package graph;

import java.util.LinkedList;
import java.util.Queue;

//Kahn's algorithm
public class TopologicalSort {
	private int[] indegreeCount;
	
	private Graph g;
	
	TopologicalSort(Graph g){
		this.g = g;
		indegreeCount =  new int[g.getMaxVertex()];
	}
	
	
	public void setIndegreeForNodes() {
		for (int i = 0; i < g.getVertexCount(); i++) {
			int inDegree = 0;
			for (int j = 0; j < g.getVertexCount(); j++) {
				if (g.getAdjacencyMAtrix()[j][i]==1) {
					inDegree++;
				}
			}
			indegreeCount[i] =  inDegree;
		}
	}
	
	public void getTopologicalSort(){
		setIndegreeForNodes();
		Queue<Integer> topoQueue =  new LinkedList<Integer>();
		int nSortCount = 0;
		for(int u=0;u<g.getVertexCount();u++){
			if(indegreeCount[u]==0){
				topoQueue.offer(u);
				g.displayVertex(u);
			}
		}
		while(!topoQueue.isEmpty()){
			nSortCount++;
			removeAllOutDegree(topoQueue.poll(),topoQueue);
		}
		
		if(nSortCount!=g.getVertexCount()){
			System.err.println("The grapth contains cycle.");
		}
	}
	
	public void removeAllOutDegree(int u, Queue<Integer> topoQueue){
		for(int v=0;v<g.getVertexCount();v++){
			if(g.getAdjacencyMAtrix()[u][v]==1){
				g.getAdjacencyMAtrix()[u][v] = 0;
				if(--indegreeCount[v] == 0){
					topoQueue.offer(v);
					g.displayVertex(v);
				}
			}
		}
	}
}
