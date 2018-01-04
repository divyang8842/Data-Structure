package tree;


public class HeapTree<T extends Number> {
	public static final int MAX_HEAP = 1;
	public static final int MIN_HEAP = 2;
	
	private final int TYPE;
	private Number[] heapArry = {-1};
	private int currentindex = 0;
	private final int capacity;
	HeapTree(int type,int size){
		TYPE = type;
		heapArry = new Number[size];
		capacity = size;
	}
	HeapTree(){
		TYPE = MAX_HEAP;
		heapArry = new Number[100];
		capacity = 100;
	}
	
	public void insert(T data) throws Exception{
		if(currentindex<capacity){
			heapArry[currentindex] = data;
			if(TYPE==MAX_HEAP){
				maxHeapUp(currentindex);
			}else if(TYPE==MIN_HEAP){
				minHeapUp(currentindex);
			}
			currentindex++;
		}else{
			throw new Exception("Heap is full.");
		}
		
	}
	private int left(int index){
		return index*2 + 1;
	}
	private int right(int index){
		return index*2 + 2;
	}
	private int parent(int index){
		return (index-1)/2;
	}
	public Number getFirst(){
		Number data  = heapArry[0];
		heapArry[0] =  heapArry[--currentindex];
		if(TYPE==MAX_HEAP){
			maxHeapify(0);
		}else if(TYPE==MIN_HEAP){
			minHeapify(0);
		}
		return data;
	}
	
	private void maxHeapUp(int index){
		int current = index;
		int parent = parent(index);
		while(heapArry[current].doubleValue()>heapArry[parent].doubleValue()){
			swap(current, parent);
			current = parent;
			parent =  parent(current);
			
		}
	}
	
	private void minHeapUp(int index){
		int current = index;
		int parent = parent(index);
		while(heapArry[current].doubleValue()<heapArry[parent].doubleValue()){
			swap(current, parent);
			current = parent;
			parent =  parent(current);
			
		}
	}
	
	
	private void maxHeapify(int index){
		int max = index;
		int left =left(index);
		int right = right(index);
		if(index<currentindex){
		if(left<currentindex){
			if(heapArry[index].doubleValue()<heapArry[left].doubleValue()){
				max = left;
			}
		}
		if(right<currentindex){
			if(heapArry[max].doubleValue()<heapArry[right].doubleValue()){
				max = right;
			}
		}
		if(max!=index){
			swap(index, max);
			maxHeapify(max);
		}
		}
	}
	
	
	private void minHeapify(int index){
		int min = index;
		int left =left(index);
		int right = right(index);
		if(left<currentindex){
			if(heapArry[index].doubleValue()>heapArry[left].doubleValue()){
				min = left;
			}
		}
		if(right<currentindex){
			if(heapArry[min].doubleValue()>heapArry[right].doubleValue()){
				min = right;
			}
		}
		if(min!=index){
			swap(index, min);
			minHeapify(min);
		}
	}
	
	private void swap(int index1,int index2){
		Number temp = heapArry[index1];
		heapArry[index1] = heapArry[index2];
		heapArry[index2] = temp;
	}
	
	
	
	
}
