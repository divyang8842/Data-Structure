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
			if(nPivot>nLeft)
			doQuickSort(dataArray, nLeft, nPivot-1);
			if(nPivot<nRight)
			doQuickSort(dataArray, nPivot+1, nRight);
		}
	}
	
	private int doPartition(T[] dataArry,int nLow,int nHigh){
		int nPivot = nLow;
		int nLeft = nLow;
		int nRight = nHigh;
		T pivotItem = dataArry[nPivot];
		while(nRight>nLeft){
			
			while(dataArry[nRight].compareTo(pivotItem)>0){
				nRight--;
			}
			while(dataArry[nLeft].compareTo(pivotItem)<0){
				nLeft++;
			}
			
			
			if(nRight>nLeft){
				T temp = dataArry[nLeft];
				dataArry[nLeft] = dataArry[nRight];
				dataArry[nRight] = temp;
			}
		}
		if(nRight>nLeft){
			dataArry[nPivot] = dataArry[nRight];
			dataArry[nRight] = pivotItem;
			
		}
		nPivot = nRight;
		
		return nPivot;
	}
	
	public void printArry(T[] dataArry){
		int nLength =  dataArry.length;
		for(int i=0;i<nLength;i++){
			System.out.print(dataArry[i]+" ");
		}
		System.out.println(" ");
	}
	
	public static void main(String str[]){
		QuickSort<Integer> objSort =  new QuickSort<Integer>();
		Integer[] data = {0,1,2,3,4,5,6,7,8,9,10};
		data = objSort.doSort(data);
		objSort.printArry(data);
		
		
		Integer[] data1 = {10,9,8,7,6,5,4,3,2,1,0};
		data1 = objSort.doSort(data1);
		objSort.printArry(data1);
	}
}
