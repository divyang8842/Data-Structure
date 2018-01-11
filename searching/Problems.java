package searching;

import random.Practice;
import sortings.QuickSort;


public class Problems extends Searches{
	
	
	public boolean checkIfArrayHasRepeatedNumber(int[] dataArray){
		int nLength =  dataArray.length;
		for(int i=0;i<nLength;i++){
			if(dataArray[Math.abs(dataArray[i]) ]<0){
				return true;
			}else{
				dataArray[Math.abs(dataArray[i]) ]*=-1;
			}
		}
		
		return false;
	}
	
	//if all the numbers are in range of 1 to n
	// n is length of the array
	public int checkMaxepeatedNumber(int[] dataArry){
		int nLength = dataArry.length;
		for(int i=0;i<nLength;i++){
			dataArry[dataArry[i]%nLength]+=nLength;
		}
		int nMaxIndex = 0;
		int nMaxCount = 0;
		for(int i=0;i<nLength;i++){
			if(dataArry[i]/nLength  > nMaxCount){
				nMaxCount = dataArry[i]/nLength;
				nMaxIndex = i;
			}
		}
		//System.out.println(nMaxCount);
		return nMaxIndex;
	}
	//3 int i,j,k sucha that i*i + j*j = k*k
	public boolean findSumOfSquareInArray(int[] dataArry){
		QuickSort obj = new QuickSort();
		obj.sort(dataArry);
		int nLength =  dataArry.length;
		for(int i=0;i<nLength;i++){
			dataArry[i]*= dataArry[i];
		}
		Practice objP = new Practice();
		for(int i=0;i<nLength;i++){
			if( objP.isSumAvailableInSortedArray(dataArry, dataArry[i])){
				return true;
			}
		}
		
		return false;
	}
	
	
	public void find2ElementWithSumNearTo0(int[] dataArry){
		int nLength = dataArry.length;
		QuickSort obj = new QuickSort();
		obj.sort(dataArry);
		int j=0;
		int i = nLength-1;
		int sum = Integer.MAX_VALUE ,element1=0,element2=0;
		while(i>j && sum!=0){
			int currentSum = dataArry[i]+dataArry[j];
			
			if(Math.abs(currentSum)< Math.abs(sum) || currentSum==0){
				sum =  currentSum;
				element1 = dataArry[j];
				element2 = dataArry[i];
			}
			if(currentSum<0){
				j++;
			}else if(currentSum>0){
				i--;
			}
		}
		
		System.out.println("Sum close to 0 is "+sum +" with elements "+element1+" and "+element2);
	}
	
	public boolean is3ElementsAvailableWithSumK(int[] dataArry,int k){
		QuickSort sort = new QuickSort();
		sort.sort(dataArry);
		int nLength =  dataArry.length;
		for(int i=0;i<nLength-2;i++){
			int sum = k- dataArry[i];
			int nLeft = i+1;
			int nRight = nLength-1;
			while(nRight>nLeft){
				int nCurSum = dataArry[nLeft] + dataArry[nRight];
 				if(nCurSum == sum){
 					System.out.println("Elements are "+dataArry[i]+","+dataArry[nLeft]+","+dataArry[nRight]);
 					return true;
 				}else if(nCurSum>sum){
 					nRight--;
 				}else{
 					nLeft++;
 				}
			}
		}
		return false;
	}
	
	

	public static void main(String str[]){
		Problems obj = new Problems();
		int[] data = {1,1,1,1,1,2,3,4,5,6,7,8,9,10,11,11,11,11,11,11,11,11,11,11,11,11};
		System.out.println("Max repeated number is "+obj.checkMaxepeatedNumber(data)); 
		
		int[] data1 = {0,1,2,3,4,5,6,7,8,9,10,5};
		System.out.println("Array contains repeated number :"+obj.checkIfArrayHasRepeatedNumber(data1));
		
		
		int[] dataSqr = {4,3,5,6};
		System.out.println(obj.findSumOfSquareInArray(dataSqr));
		
		
		int[] dataSum = {4,-1,-2,9,-3,-4,0,5,6,7,8};
		obj.find2ElementWithSumNearTo0(dataSum);
		
		
		int[] data3Sum = {1,2,3,4,0,6,9,5,15};
		System.out.println("is 3 elements available having sum 29 :"+obj.is3ElementsAvailableWithSumK(data3Sum, 29));
		
		
		
	}
}
