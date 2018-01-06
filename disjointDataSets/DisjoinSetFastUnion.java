package disjointDataSets;

public class DisjoinSetFastUnion {
	private int[] set;
	private int size;
	
	public DisjoinSetFastUnion(int size) {
		this.size = size;
		set =  new int[size];
	}
	public DisjoinSetFastUnion() {
		this.size = 100;
		set =  new int[size];
	}
	
	public void makeSet(){
		for(int i=0;i<size;i++){
				set[i]=-1;
		}
	}
	
	public int findSet(int value){
		if(validate(value)){
			if(set[value]==-1){
				return value;
			}else{
				int temp = findSet(set[value]);
				return validate(temp)?temp:value;
			}
		}
		return -1;
	}
	
	public void unionBySize(int root1,int root2){
		if(findSet(root1)!=findSet(root2) && findSet(root1)!=-1 && validate(root1) && validate(root2)){
			if(set[root1]<set[root2]){
				set[root1]+= set[root2];
				set[root2] = root1;
			}else{
				set[root2]+= set[root1];
				set[root1] = root2;
			}
		}
	}
	
	public int findByPathCompression(int value){
		if(validate(value)){
			if(set[value]==-1){
				return value;
			}else{
				int temp = findSet(set[value]);
				return  validate(temp)?set[value]=temp:value;
			}
		}
		return -1;
	}
	
	private boolean validate(int value){
		return value>=0 && value<size;
	}
	
}
