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
	
	//rotated by n digits
	public int findInRotatedArray(int[] dataArry,int nStart,int nEnd,int nFind){
		
		while(nStart<=nEnd){
			if(dataArry[nStart]<nFind){
				nStart++;
			}
			if(dataArry[nEnd]<nFind){
				nEnd--;
			}
			if(dataArry[nStart]==nFind || dataArry[nEnd]==nFind){
				return dataArry[nStart]==nFind?nStart:nEnd;
			}
		}
		return -1;
	}
	
	
	//rotated by n digits {5,6,7,8,9,10,11,12,13,0,1,2,3,4}
	public int findInRotatedArray1(int[] dataArry,int nStart,int nEnd,int nFind){
		
		
		while(nStart<=nEnd){
			if(dataArry[nStart]==nFind || dataArry[nEnd]==nFind){
				return dataArry[nStart]==nFind?nStart:nEnd;
			}
			int nMid = (nEnd+nStart)/2;
			
			if(dataArry[nMid]>nFind){
				if(dataArry[nStart]<dataArry[nMid]){
					nStart = nMid+1;
				}else{
					nEnd = nMid-1;
				}
			}else if(dataArry[nMid]<nFind){
				if(dataArry[nStart]<dataArry[nMid]){
					nStart = nMid+1;
				}else{
					nEnd = nMid-1;
				}
			}else{
				return nMid;
			}
			
		}
		return -1;
	}
	
	//{8,9,10,11,12,13,14,16,17,18,19,20,15,7,6,5,4,3,2,1,0}
	public int findMaxInIncreasingDecreasingArray(int[] dataArry,int nLeft,int nRight){
		int max = Integer.MIN_VALUE;
		while(nLeft<=nRight){
			int nMid = (nRight+nLeft)/2;
			
			System.out.println(nLeft +"+"+nRight +" = 2* "+nMid);
			if(max<dataArry[nMid]){
				max = dataArry[nMid];
			}
			if(dataArry[nMid]>dataArry[nRight] && dataArry[nMid]>dataArry[nLeft]){
				nRight--;
				nLeft++;
			}else if(dataArry[nMid]>dataArry[nLeft] && dataArry[nMid]<dataArry[nRight]){
				nLeft = nMid+1;
			}else if(dataArry[nMid]<dataArry[nLeft] && dataArry[nMid]>dataArry[nRight]){
				nRight = nMid-1;
			}else if(nLeft==nMid || nRight==nMid){
				return Math.max(dataArry[nLeft], dataArry[nRight]);
			}else{
				System.out.println(dataArry[nMid]);
				if(max<dataArry[nMid]){
					max = dataArry[nMid];
				}
				return max;
			}
			
		}
		
		
		return -1;
	}
	
	
	public int getMiddleOfIncreasingDescreasingSeries(int[] dataArry){
		int nLength = dataArry.length;
		int nLeft = 0;
		int nRight = nLength-1;
		while(nRight>nLeft){
			int nMid  = (nRight+nLeft)/2;
			if(dataArry[nMid]>dataArry[nMid-1] && dataArry[nMid]>dataArry[nMid+1]){
				return nMid;
			}else if(dataArry[nMid-1]>dataArry[nMid] && dataArry[nMid+1]<dataArry[nMid]){
				nLeft = nMid+1;
			}else if(dataArry[nMid-1]<dataArry[nMid] && dataArry[nMid+1]>dataArry[nMid]){
				nRight = nMid-1;
			}else if(dataArry[nMid]<dataArry[nMid-1] && dataArry[nMid]<dataArry[nMid+1]){
				return nMid+1;
			}
		}
		return -1;
	}
	
	
	public int getFirstOccuranceOfNumberInSortedArray(int[] dataArry,int nLength,int nNumber){ //duplicate entries are allowed
		if(nLength<=0){
			nLength =dataArry.length;
		}
		int nLeft = 0;
		int nRight = nLength - 1;
		while(nRight>nLeft){
			int nMid = (nLeft+nRight)/2;
			if(dataArry[nMid]==nNumber && (dataArry[nMid-1]<nNumber || nMid == nLeft )){
				return nMid;
			}else if(dataArry[nMid]>=nNumber){
				nRight = nMid-1;
			}else if(dataArry[nMid]<nNumber){
				nLeft = nMid+1;
			}
		}
		return -1;
	}
	
	public int findSecondSmallestNumber(int[] dataArry,int nLength){
		if(nLength<=0){
			nLength = dataArry.length;
		}
		int nMin = Integer.MAX_VALUE,nSecondMin = Integer.MAX_VALUE;
		for(int i=0;i<nLength;i++){
			if(dataArry[i]<nMin){
				nSecondMin = nMin;
				nMin = dataArry[i];
			}else if(dataArry[i]<nSecondMin){
				nSecondMin = dataArry[i];
			}
		}
		return nSecondMin;
	}
	
	public int getLastOccuranceOfNumberInSortedArray(int[] dataArry,int nLength,int nNumber){ //duplicate entries are allowed
		if(nLength<=0){
			nLength =dataArry.length;
		}
		int nLeft = 0;
		int nRight = nLength - 1;
		
		
		while(nRight>nLeft){
			int nMid = (nLeft+nRight)/2;
			if(dataArry[nMid]==nNumber && (dataArry[nMid+1]>nNumber || nMid == nRight )){
				return nMid;
			}else if(dataArry[nMid]>nNumber){
				nRight = nMid-1;
			}else if(dataArry[nMid]<=nNumber){
				nLeft = nMid+1;
			}
		}
		return -1;
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
		
		int[] dataMiddle = {-1,-2,-3,-4,-5,1,2,3,4,5,7,8,9};
		System.out.println("middle of the array is "+obj.getMiddleOfIncreasingDescreasingSeries(dataMiddle));
		
		int[] dataRotated = {5,6,7,8,9,10,11,12,13,0,1,2,3,4};
		System.out.println("11 is available in the array at position "+obj.findInRotatedArray1(dataRotated, 0, 13, 11));
		
		
		
		int[] dataIncDec = {8,9,10,11,12,13,14,16,17,18,19,20,15,7,6,5,4,3,2,1,0};
		System.out.println("Max in the increasing decreasing array is "+obj.findMaxInIncreasingDecreasingArray(dataIncDec, 0, 20));
		
		
		int[] data1StOcc = {-1,-2,-3,0,1,2,3,4,4,4,4,4,4,4,5};
		System.out.println("Fist occurance of 4 is "+obj.getFirstOccuranceOfNumberInSortedArray(data1StOcc, -1, 4));
		
		
		System.out.println("Second occurance of 4 is "+obj.getLastOccuranceOfNumberInSortedArray(data1StOcc, -1, 4));
		System.out.println("Second min int hte array is "+obj.findSecondSmallestNumber(data1StOcc, -1));
	}
}
