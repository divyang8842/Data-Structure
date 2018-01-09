package graph;

import java.util.LinkedList;
import java.util.List;
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
	
	public List<Integer> getTopologicalSort(){
		setIndegreeForNodes();
		List<Integer> topologicalSort  = new LinkedList<Integer>();
		Queue<Integer> topoQueue =  new LinkedList<Integer>();
		int nSortCount = 0;
		for(int u=0;u<g.getVertexCount();u++){
			if(indegreeCount[u]==0){
				topoQueue.offer(u);
				topologicalSort.add(g.getVertexList()[u].getIndex());
				g.displayVertex(u);
			}
		}
		while(!topoQueue.isEmpty()){
			nSortCount++;
			removeAllOutDegree(topoQueue.poll(),topoQueue,topologicalSort);
		}
		
		if(nSortCount!=g.getVertexCount()){
			System.err.println("The grapth contains cycle.");
		}
		
		return topologicalSort;
	}
	
	public void removeAllOutDegree(int u, Queue<Integer> topoQueue, List<Integer> topologicalSort){
		for(int v=0;v<g.getVertexCount();v++){
			if(g.getAdjacencyMAtrix()[u][v]==1){
				g.getAdjacencyMAtrix()[u][v] = 0;
				if(--indegreeCount[v] == 0){
					topoQueue.offer(v);
					g.displayVertex(v);
					topologicalSort.add(g.getVertexList()[v].getIndex());
				}
			}
		}
	}
}
