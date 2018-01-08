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

	
	Graph(int maxVertex){
		this.maxVertex = maxVertex;
		vertexList = new Vertex[maxVertex];
		adjacencyMAtrix = new boolean[maxVertex][maxVertex];
	}
	
	Graph(){
		this(20);
	}
	
	
	
	public int getVertexCount() {
		return vertexCount;
	}

	public int getMaxVertex() {
		return maxVertex;
	}

	public Vertex[] getVertexList() {
		return vertexList;
	}

	public boolean[][] getAdjacencyMAtrix() {
		return adjacencyMAtrix;
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

}

