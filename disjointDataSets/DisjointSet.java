package disjointDataSets;

public class DisjointSet {
	private int[] set;
	private int size;
	
	public DisjointSet(int size) {
		this.size = size;
		set =  new int[size];
	}
	public DisjointSet() {
		this.size = 100;
		set =  new int[size];
	}
	
	public void makeSet(){
		for(int i=0;i<size;i++){
			set[i]=i;
		}
	}
	
	public int findSet(int value){
		if(validate(value)){
			if(set[value]==value){
				return value;
			}else{
				return findSet(set[value]);
			}
		}
		return -1;
	}
	
	public void union(int root1,int root2){
		if(findSet(root1)!=findSet(root2) && validate(root1) && validate(root2)){
			set[root1] = root2;
		}
	}
	
	private boolean validate(int value){
		return value>=0 && value<size;
	}
	
}
