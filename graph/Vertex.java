package graph;

public class Vertex implements Comparable<Vertex>{
	private char label;
	private boolean isVisited;
	private int parent;
	private int weight;
	private int index;
	
	Vertex(char label,int index)
	{
		this.label = label;
		this.index = index;
		isVisited = false;
	}

	public char getLabel() {
		return label;
	}

	public void setLabel(char label) {
		this.label = label;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public int compareTo(Vertex o) {
		return this.getWeight()-o.getWeight();
		//return 0;
	}
	
	
}
