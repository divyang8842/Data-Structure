package sortings.generic;

public class SelectionSort<T extends Comparable<T>>  {
	
	public T[] doSort(T[] dataArry){
		int nLength = dataArry.length;
		for(int i=0;i<nLength;i++){
			int nMin = i;
			for(int j=i+1;j<nLength;j++){
				if(dataArry[j].compareTo(dataArry[j-1])<0){
					nMin = j;
				}
			}
			T temp =  dataArry[nMin];
			dataArry[nMin] =  dataArry[i];
			dataArry[i] =  temp;
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
		SelectionSort<Integer> objSort =  new SelectionSort<Integer>();
		Integer[] data = {0,1,2,3,4,5,6,7,8,9,10};
		data = objSort.doSort(data);
		objSort.printArry(data);
		
		
		Integer[] data1 = {10,9,8,7,6,5,4,3,2,1,0};
		data1 = objSort.doSort(data1);
		objSort.printArry(data1);
	}
	
}
