package sortings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
	public void doSort(int[] dataArry,int range){
		int divider = 1;
		double division = range/divider;
		while(division>1){
			divider*=10;
			division = range/divider;
		}
		List<Integer>[] bucket = new List[11];
		System.out.println(divider);
		for(int i=0;i<dataArry.length;i++){
			if(bucket[dataArry[i]*10/divider]==null){
				bucket[dataArry[i]*10/divider] =  new ArrayList<Integer>();
			}
			bucket[dataArry[i]*10/divider].add(dataArry[i]);
		}
		List<Integer> sortedList = new ArrayList<Integer>();
		for(int i=0;i<11;i++){
			List<Integer> currentBucket = bucket[i];
			if(currentBucket==null){
				continue;
			}
			//System.out.println(currentBucket.toArray().toString());
			Collections.sort(currentBucket);// we can change this to any sort operation
			sortedList.addAll(currentBucket);
		}
		
		int[] arry = sortedList.stream().mapToInt(Integer::intValue).toArray();
		for(int i=0;i<arry.length;i++){
			dataArry[i] = arry[i];
		}
	}
	
	public void printArry(int[] dataArry){
		int nLength =  dataArry.length;
		for(int i=0;i<nLength;i++){
			System.out.print(dataArry[i]+" ");
		}
		System.out.println(" ");
	}
	
	public static void main(String str[]){
		BucketSort objSort =  new BucketSort();
		int[] data = {0,1,2,3,4,6,5,6,7,8,9,9,10};
		objSort.doSort(data,10);
		objSort.printArry(data);
		
		
		int[] data1 = {10,9,9,8,7,6,5,4,3,2,1,0};
		 objSort.doSort(data1,10);
		objSort.printArry(data1);
	}
}
