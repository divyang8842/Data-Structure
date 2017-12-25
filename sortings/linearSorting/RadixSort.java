package sortings.linearSorting;

public class RadixSort {
	public void doSort(int[] dataArry,int range){
		int nDivisor = 1;
		while(range/nDivisor >=1){
			countingSort(dataArry, nDivisor);
			nDivisor*=10;
		}
	}
	
	public void countingSort(int[] dataArry, int nDivisor){
		int[] countArry = new int[10];
		int nLength =  dataArry.length;
		int[] temp =  new int[nLength];
		for(int i=0;i<nLength;i++){
			countArry[(dataArry[i]/nDivisor)%10]++;
		}
		
		for(int i=1;i<10;i++){
			countArry[i] = countArry[i]+ countArry[i-1];
		}
		
		for(int i=9;i>0;i--){
			countArry[i] = countArry[i-1];
		}
		countArry[0]= 0;
		
		for(int i=0;i<nLength;i++){
			temp[countArry[(dataArry[i]/nDivisor)%10]] = dataArry[i];
			countArry[(dataArry[i]/nDivisor)%10]++;
		}
		
		
		for(int i=0;i<nLength;i++){
			 dataArry[i] = temp[i];
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
		RadixSort objSort =  new RadixSort();
		int[] data = {0,1,2,3,4,5,6,7,8,9,9,10};
		objSort.doSort(data,10);
		objSort.printArry(data);
		
		System.out.println("  ------   ");
		int[] data1 = {10,9,9,8,7,6,5,4,3,2,1,0};
		 objSort.doSort(data1,10);
		objSort.printArry(data1);
	}
}
