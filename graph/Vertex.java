package graph;

public class Vertex {
	private char label;
	private boolean isVisited;
	
	Vertex(char label)
	{
		this.label = label;
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
	
	
}
