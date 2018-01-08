package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	
	private int vertexCount;
	private final int maxVertex;
	private Vertex[] vertexList;
	private boolean[][] adjacencyMAtrix;
	private Stack<Integer>  stack =  new Stack<Integer>();
	private Queue<Integer>  queue = new LinkedList<Integer>();
	private int[] indegreeCount;
	
	Graph(int maxVertex){
		this.maxVertex = maxVertex;
		vertexList = new Vertex[maxVertex];
		adjacencyMAtrix = new boolean[maxVertex][maxVertex];
		indegreeCount =  new int[maxVertex];
	}
	
	Graph(){
		this(20);
	}
	
	public void addVertex(char label){
		if(vertexCount<maxVertex){
			vertexList[vertexCount++] =  new Vertex(label);
		}else{
			System.out.println("Vertex list is full.");
		}
	}
	
	public void addEdge(int strtIndex, int endIndex){
		adjacencyMAtrix[strtIndex][endIndex] = true;
		adjacencyMAtrix[endIndex][strtIndex] = true;
	}
	
	public void displayVertex(int v){
		System.out.println(vertexList[v].getLabel());
	}
	
	public void removeAllEdges(){
		Arrays.fill(vertexList, Boolean.FALSE);
	}
	
	public void markVertexVisited(int index){
		vertexList[index].setVisited(true);
	}
	
	public void resetVisitedFlag(){
		for(int i=0;i<vertexCount;i++){
			vertexList[i].setVisited(false);
		}
	}
	
	public void dfs(){
		displayVertex(0);
		stack.push(0);
		markVertexVisited(0);
		
		while(!stack.isEmpty()){
			int v = getNonVisitedAdjVertex(stack.peek());
			if(v==-1){
				stack.pop();
			}else{
				displayVertex(v);
				stack.push(v);
				markVertexVisited(v);
			}
		}
		resetVisitedFlag();
	}
	
	public int getNonVisitedAdjVertex(int u){
		int v=0;
		while(v<vertexCount){
			if(adjacencyMAtrix[u][v]==true && !vertexList[v].isVisited()){
				return v;
			}
		}
		return -1;
	}
	public void bfs(){
		displayVertex(0);
		queue.offer(0);
		markVertexVisited(0);
		
		while(!queue.isEmpty()){
			int v = getNonVisitedAdjVertex(queue.peek());
			if(v==-1){
				queue.poll();
			}else{
				displayVertex(v);
				queue.offer(v);
				markVertexVisited(v);
			}
		}
		resetVisitedFlag();
	}
	//kahn's algorithm
	//Topological Sort codes 
	public void setIndegreeForNodes() {
		for (int i = 0; i < vertexCount; i++) {
			int inDegree = 0;
			for (int j = 0; j < vertexCount; j++) {
				if (adjacencyMAtrix[j][i]) {
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
		for(int u=0;u<vertexCount;u++){
			if(indegreeCount[u]==0){
				topoQueue.offer(u);
				displayVertex(u);
			}
		}
		while(!topoQueue.isEmpty()){
			nSortCount++;
			removeAllOutDegree(topoQueue.poll(),topoQueue);
		}
		
		if(nSortCount!=vertexCount){
			System.err.println("The grapth contains cycle.");
		}
	}
	
	public void removeAllOutDegree(int u, Queue<Integer> topoQueue){
		for(int v=0;v<vertexCount;v++){
			if(adjacencyMAtrix[u][v]){
				adjacencyMAtrix[u][v] = false;
				if(--indegreeCount[v] == 0){
					topoQueue.offer(v);
					displayVertex(v);
				}
			}
		}
	}
	//Kahn's algo completed
}

