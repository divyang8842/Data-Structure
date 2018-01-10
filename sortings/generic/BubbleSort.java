package sortings.generic;

public class BubbleSort<T extends Comparable<T>> implements Sorting<T>{
	
	//ascending
	public T[] doSort(T[] dataArry){
		int nLength =  dataArry.length;
		boolean bSwapped = true;
		for(int nSorted=nLength; nSorted>0 && bSwapped ;nSorted--){
				bSwapped = false;
				System.out.println("Inetarion "+(nLength-nSorted));
				for(int nCurrent=0;nCurrent<nSorted-1;nCurrent++){
					if(dataArry[nCurrent].compareTo(dataArry[nCurrent+1])>0){
						bSwapped = true;
						T temp =  dataArry[nCurrent];
						dataArry[nCurrent] =  dataArry[nCurrent+1];
						dataArry[nCurrent+1] =  temp;
					}
				}
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
		BubbleSort<Integer> objSort =  new BubbleSort<Integer>();
		Integer[] data = {0,1,2,3,4,5,6,7,8,9,10};
		data = objSort.doSort(data);
		objSort.printArry(data);
		
		
		Integer[] data1 = {10,9,8,7,6,5,4,3,2,1,0};
		data1 = objSort.doSort(data1);
		objSort.printArry(data1);
	}
	
	
	
}
