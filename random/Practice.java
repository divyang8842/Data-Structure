package random;

import sortings.HeapSort;

public class Practice {

	public double sumOfAllElementIn2DArray(int[][] dataArry,int x,int y){
		double sum = 0;
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j+=2){
				if(j==y-1){
					sum+=dataArry[i][j];
				}else{
					sum+=dataArry[i][j]+dataArry[i][j+1];
				}
				
			}
		}
		return sum;
	}
	
	
	public boolean foundIfRepeatedNumber(int[] dataArry){
		 HeapSort.sort(dataArry);// this can be changed to any algo
		 for(int i=1;i<dataArry.length;i++){
			 if(dataArry[i]==dataArry[i-1]){
				 return true;
			 }
		 }
		return false;
	}
	
	public boolean isSumAvailableInSortedArray(int[] arry,int sum){
			int nLeft = 0;
			int nRight = arry.length-1;
			while(nRight>nLeft){
				int currentSum =  arry[nLeft] + arry[nRight];
				if(currentSum == sum ){
					return true;
				}else if(currentSum>sum){
					nRight--;
				}else{
					nLeft++;
				}
			}
		return false;
	}
	
	public static void main(String str[]){
		Practice obj = new Practice();
		int[][]data = {{1,2,3,13},{4,5,6,14},{7,8,9,15},{10,11,12,16}};
		System.out.println(obj.sumOfAllElementIn2DArray(data, 4, 4));
		
		
		int data0[] = {3,7,4,6,8,5,3,5,79,5,3,5,7,9,1,3,8,0};
		System.out.println(obj.foundIfRepeatedNumber(data0));
		
		int data1[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		System.out.println(obj.foundIfRepeatedNumber(data1));
		
		
		System.out.println(obj.isSumAvailableInSortedArray(data1, 5000));
		
		System.out.println(obj.isSumAvailableInSortedArray(data1, 10));
	}
}
