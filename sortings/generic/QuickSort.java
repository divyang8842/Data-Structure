package sortings.generic;

public class QuickSort<T extends Comparable<T>> implements Sorting<T>{

	@Override
	public T[] doSort(T[] dataArry) {
		doQuickSort(dataArry, 0, dataArry.length-1);
		return dataArry;
	}
	
	private void doQuickSort(T[] dataArray,int nLeft,int nRight){
		while(nRight>nLeft){
			int nPivot = doPartition(dataArray, nLeft, nRight);
			doQuickSort(dataArray, nLeft, nPivot-1);
			doQuickSort(dataArray, nPivot+1, nRight);
		}
	}
	
	private int doPartition(T[] dataArry,int nLeft,int nRight){
		int nPivot = nLeft;
		int nHigh = 0;
		int nLow = 0;
		T pivotItem = dataArry[nPivot];
		while(nHigh>nLow){
			while(dataArry[nHigh].compareTo(pivotItem)<=0){
				nHigh++;
			}
			while(dataArry[nLow].compareTo(pivotItem)>0){
				nLow++;
			}
			if(nHigh>nLow){
				T temp = dataArry[nHigh];
				dataArry[nHigh] = dataArry[nLow];
				dataArry[nLow] = temp;
			}
		}
		dataArry[nPivot]= dataArry[nLow];
		dataArry[nLow] = pivotItem;
		return nLow;
		
	}
	
	public void printArry(T[] dataArry){
		int nLength =  dataArry.length;
		for(int i=0;i<nLength;i++){
			System.out.print(dataArry[i]+" ");
		}
		System.out.println(" ");
	}
	
	public static void main(String str[]){
		MergeSort<Integer> objSort =  new MergeSort<Integer>();
		Integer[] data = {0,1,2,3,4,5,6,7,8,9,10};
		data = objSort.doSort(data);
		objSort.printArry(data);
		
		
		Integer[] data1 = {10,9,8,7,6,5,4,3,2,1,0};
		data1 = objSort.doSort(data1);
		objSort.printArry(data1);
	}
}
