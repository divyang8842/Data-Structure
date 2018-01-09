package tree;


public class HeapTree<T extends Comparable<T>> {
	public static final int MAX_HEAP = 1;
	public static final int MIN_HEAP = 2;
	
	private final int TYPE;
	private T[] heapArry;
	private int currentindex = 0;
	private final int capacity;
	public HeapTree(int type,int size){
		TYPE = type;
		heapArry = (T[]) new Comparable[size];
		capacity = size;
	}
	public HeapTree(){
		this(MAX_HEAP,100);
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
	public boolean isEmpty(){
		return currentindex==0;
	}
	public T getFirst(){
		T data  =null;
		if(!isEmpty()){
			data  = heapArry[0];
			heapArry[0] =  heapArry[--currentindex];
			if(TYPE==MAX_HEAP){
				maxHeapify(0);
			}else if(TYPE==MIN_HEAP){
				minHeapify(0);
			}
		}
		
		return data;
	}
	
	private void maxHeapUp(int index){
		int current = index;
		int parent = parent(index);
		while(heapArry[current].compareTo(heapArry[parent])>0){
			swap(current, parent);
			current = parent;
			parent =  parent(current);
			
		}
	}
	
	private void minHeapUp(int index){
		int current = index;
		int parent = parent(index);
		while(heapArry[current].compareTo(heapArry[parent])<0){
			swap(current, parent);
			current = parent;
			parent =  parent(current);
			
		}
	}
	
	public T deleteElementAtIndex(int nIndex){
		T data  = (T) (""+Integer.MIN_VALUE);
		if(nIndex<currentindex){
			data  = heapArry[nIndex];
			heapArry[nIndex] =  heapArry[--currentindex];
			if(TYPE==MAX_HEAP){
				maxHeapify(nIndex);
			}else if(TYPE==MIN_HEAP){
				minHeapify(nIndex);
			}
		}
		return data;
	}
	
	
	
	private void maxHeapify(int index){
		int max = index;
		int left =left(index);
		int right = right(index);
		if(index<currentindex){
		if(left<currentindex){
			if(heapArry[index].compareTo(heapArry[left])<0){
				max = left;
			}
		}
		if(right<currentindex){
			if(heapArry[max].compareTo(heapArry[right])<0){
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
			if(heapArry[min].compareTo(heapArry[left])>0){
				min = left;
			}
		}
		if(right<currentindex){
			if(heapArry[min].compareTo(heapArry[right])>0){
				min = right;
			}
		}
		if(min!=index){
			swap(index, min);
			minHeapify(min);
		}
	}
	
	private void swap(int index1,int index2){
		T temp = heapArry[index1];
		heapArry[index1] = heapArry[index2];
		heapArry[index2] = temp;
	}
	
	
	
	public static void main(String args[]){
		HeapTree<Integer> maxTree =  new HeapTree<Integer>(HeapTree.MAX_HEAP,50);
		try {
			maxTree.insert(0);
			maxTree.insert(1);
			maxTree.insert(2);
			maxTree.insert(3);
			maxTree.insert(4);
			maxTree.insert(5);
			maxTree.insert(6);
			maxTree.insert(7);
			System.out.println("Max element is "+maxTree.getFirst());
			maxTree.insert(7);
			System.out.println("Max element is "+maxTree.getFirst());
			System.out.println("Max element is "+maxTree.getFirst());
			maxTree.insert(9);
			
			System.out.println("Max element is "+maxTree.getFirst());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		HeapTree<Integer> minTree =  new HeapTree<Integer>(HeapTree.MIN_HEAP,50);
		try {
			minTree.insert(7);
			minTree.insert(6);
			minTree.insert(5);
			minTree.insert(4);
			minTree.insert(3);
			minTree.insert(2);
			minTree.insert(1);
			minTree.insert(0);
			System.out.println("Min element is "+minTree.getFirst());
			minTree.insert(0);
			System.out.println("Min element is "+minTree.getFirst());
			System.out.println("Min element is "+minTree.getFirst());
			minTree.insert(-5);
			
			System.out.println("Min element is "+minTree.getFirst());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
