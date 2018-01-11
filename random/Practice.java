package random;

import java.util.HashSet;
import java.util.Set;

import sortings.HeapSort;
import sortings.linearSorting.CountingSort;

public class Practice {

	public double sumOfAllElementIn2DArray(int[][] dataArry, int x, int y) {
		double sum = 0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j += 2) {
				if (j == y - 1) {
					sum += dataArry[i][j];
				} else {
					sum += dataArry[i][j] + dataArry[i][j + 1];
				}
			}
		}
		return sum;
	}

	public boolean foundIfRepeatedNumber(int[] dataArry) {
		HeapSort.sort(dataArry);// this can be changed to any algo
		for (int i = 1; i < dataArry.length; i++) {
			if (dataArry[i] == dataArry[i - 1]) {
				return true;
			}
		}
		return false;
	}

	public boolean isSumAvailableInSortedArray(int[] arry, int sum) {
		int nLeft = 0;
		int nRight = arry.length - 1;
		while (nRight > nLeft) {
			int currentSum = arry[nLeft] + arry[nRight];
			if (currentSum == sum) {
				return true;
			} else if (currentSum > sum) {
				nRight--;
			} else {
				nLeft++;
			}
		}
		return false;
	}

	public boolean isSumAvailableInUnSortedArray(int[] arry, int sum) {
		int nLeft = 0;
		int nRight = arry.length;
		Set<Integer> complement = new HashSet<Integer>();

		while (nRight > nLeft) {
			if (complement.contains(arry[nLeft])) {
				return true;
			} else {
				complement.add(sum - arry[nLeft]);
			}
			nLeft++;
		}
		complement.clear();
		complement = null;
		return false;
	}
	
	public void sortAnArrayContaining012Counting(int[] dataArry) {
		CountingSort sort = new CountingSort();
		sort.doSort(dataArry, 3);
		printArry(dataArry);
	}

	public void sortAnArrayContaining012(int[] dataArry) {
		int nPivot = 1;
		int nLeft = 0;
		int nRight = dataArry.length - 1;

		while (nRight > nLeft) {

			while (dataArry[nLeft] < nPivot) {
				nLeft++;
			}
			while (dataArry[nRight] > nPivot) {
				nRight--;
			}
			if(dataArry[nRight]==nPivot || dataArry[nLeft]==nPivot){
				if(dataArry[nLeft]==nPivot){
					int i=nLeft;
					for(;i<nRight;i++){
						if(dataArry[i]!=nPivot){
							break;
						}
					}
					if(i>nLeft && i<nRight){
						swapNumbersInArray(dataArry, nLeft, i);
					}else{
						break;
					}
					
				}
				if(dataArry[nRight]==nPivot){
					int i=nRight;
					for(;i>nLeft;i--){
						if(dataArry[i]!=nPivot){
							break;
						}
					}
					if(i<nRight && i>nLeft){
						swapNumbersInArray(dataArry, nRight, i);
					}else{
						break;
					}
					
				}
			}else
			 if(nRight>nLeft){
				swapNumbersInArray(dataArry, nLeft, nRight);
			}
			
		}
	}
	
	private void swapNumbersInArray(int[] dataArry, int nLeft, int nRight){
		dataArry[nLeft] = dataArry[nLeft] + dataArry[nRight];
		dataArry[nRight] = dataArry[nLeft] - dataArry[nRight];
		dataArry[nLeft] = dataArry[nLeft] - dataArry[nRight];
	}

	public void printArry(int[] dataArry) {
		int nLength = dataArry.length;
		for (int i = 0; i < nLength; i++) {
			System.out.print(dataArry[i] + " ");
		}
		System.out.println(" ");
	}
	public int removeDuplicatesFromSortedArray(int[] dataArry){
		int nLength =  dataArry.length;
		int j = 0;
		for(int i=1;i<nLength;i++){
			if(dataArry[j]!=dataArry[i]){
				dataArry[++j] = dataArry[i];
			}
		}
		return j+1;
	}
	//constrain : all the numbers are in range of 1 to n
	public void printDuplicateNumbersFromArray(int[] dataArry){
		int nLength = dataArry.length;
		for(int i=0;i<nLength;i++){
			if(dataArry[dataArry[i]%nLength]>0){
				dataArry[dataArry[i]%nLength]+=nLength;
			}
		}
		System.out.print("Repeated Numbers are : ");
		for(int i=0;i<nLength;i++){
			if(dataArry[i]/nLength >1){
				System.out.print(i+" ");
			}
		}
		System.out.println(" ");
	}
	//given is an array of 1 to n numbers from which one number is missing
	public int findMissingValue(int[] dataArry,int range){
		int X = 0;
		int nLength = dataArry.length;
		int j=1;
		for(int i=0;i<nLength;i++){
			X^=j++;
			X^=dataArry[i];
		}
		X^= range;
//		System.out.println(X);
		return X;
	}

	public static void main(String str[]){
		Practice obj = new Practice();
		int[][]data = {{1,2,3,13},{4,5,6,14},{7,8,9,15},{10,11,12,16}};
		System.out.println(" Sum of all element is "+obj.sumOfAllElementIn2DArray(data, 4, 4));
		
		int data0[] = {3,7,4,6,8,5,3,5,79,5,3,5,7,9,1,3,8,0};
		System.out.println("repeated number is available : "+obj.foundIfRepeatedNumber(data0));
		
		int data1[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		System.out.println("repeated number is available : "+obj.foundIfRepeatedNumber(data1));
		
		System.out.println("is Sum Available in sorted array : "+obj.isSumAvailableInSortedArray(data1, 5000));
		
		System.out.println("is Sum Available in sorted array : "+obj.isSumAvailableInSortedArray(data1, 10));
		
		System.out.println("is Sum Available in unsorted array : "+obj.isSumAvailableInUnSortedArray(data0, 5000));
		
		System.out.println("is Sum Available in unsorted array : "+obj.isSumAvailableInUnSortedArray(data0, 10));
		
		
		int data012[] = {0,0,2,1,0,1,2,0,1,2,0,0,1,2,0,1,2,0,1,2,0,2,2,2,0,1,2,0,1,2,0,0}; 
		obj.sortAnArrayContaining012(data012);
		System.out.println("Sorted array having 012 is ");
		obj.printArry(data012);
		
		int data012Count[] = {0,0,2,1,0,1,2,0,1,2,0,0,1,2,0,1,2,0,1,2,0,2,2,2,0,1,2,0,1,2,0,0}; 
		
		System.out.println("Sorted array having 012 using counting sort is ");
		obj.sortAnArrayContaining012Counting(data012Count);
		
		
		
		int nLength = obj.removeDuplicatesFromSortedArray(data012Count);
		System.out.println("Length after removing duplicate is "+nLength);
		
		int[] dataDup = {1,2,3,4,5,5,6,7,8,8,9};
		obj.printDuplicateNumbersFromArray(dataDup);
		
		int[] dataMissing = {1,2,3,4,5,6,7,9,10};
		System.out.println("Missing value is  "+obj.findMissingValue(dataMissing, 10));
	}
}
