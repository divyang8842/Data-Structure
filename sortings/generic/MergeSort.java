package sortings.generic;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> {

	public T[] doSort(T[] dataArry) {
		T[] tempArry =  Arrays.copyOf(dataArry, dataArry.length);
		doMergeSort(dataArry,tempArry , 0, dataArry.length-1);
		return dataArry;
	}

	private void doMergeSort(T[] dataArry, T[] tempArry, int nLeft, int nRight) {
		if (nRight > nLeft) {
			int nMid = (nRight + nLeft) / 2;
			doMergeSort(dataArry, tempArry, nLeft, nMid);
			doMergeSort(dataArry, tempArry, nMid+1, nRight);
			doMerge(dataArry, tempArry, nLeft, nMid+1, nRight);
		}
	}
	
	private void doMerge(T[] dataArry, T[] tempArry, int nLeft,int nMid, int nRight){
		int i= nLeft;
		int j=nMid;
		int k = nLeft;
		
		while(i<= nMid-1 && j<=nRight){
			if(dataArry[i].compareTo(dataArry[j])<0){
				tempArry[k++] = dataArry[i++];
			}else{
				tempArry[k++] = dataArry[j++];
			}
		}
		
		while(i<= nMid-1){
			tempArry[k++] =  dataArry[i++];
		}
		while(j<=nRight){
			tempArry[k++] = dataArry[j++];
		}
		
		i= nLeft;
		while(i<=nRight){
			dataArry[i] =  tempArry[i++];
		}
		
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
