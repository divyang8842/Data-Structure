package sortings.generic;

public class InsertionSort<T extends Comparable<T>> implements Sorting<T>{
	public T[] doSort(T[] dataArry){
		int nLength = dataArry.length;
		for(int i=1;i<nLength;i++){
			T current = dataArry[i];
			int j = i;
			while(j>=1 && dataArry[j-1].compareTo(current)>0 ){
				dataArry[j] =  dataArry[j-1];
				j--;
			}
			//System.out.println(j);
			dataArry[j]= current;
		}
		
		return dataArry;
	}
	
	public void printArry(T[] dataArry){
		int nLength =  dataArry.length;
		for(int i=0;i<nLength;i++){
			System.out.print(dataArry[i]+" ");
		}
		System.out.println(" ");
	}
	
	public static void main(String str[]){
		InsertionSort<Integer> objSort =  new InsertionSort<Integer>();
		Integer[] data = {0,1,2,3,4,5,6,7,8,9,10};
		data = objSort.doSort(data);
		objSort.printArry(data);
		
		
		Integer[] data1 = {10,9,8,7,6,5,4,3,2,1,0};
		data1 = objSort.doSort(data1);
		objSort.printArry(data1);
	}
	
	
}
