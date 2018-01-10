package sortings.linearSorting;


public class CountingSort {
	
	public void doSort(int[] dataArry,int range){
		int[] countArry= new int[range];
		int nLength = dataArry.length;
		int[] sortedArry = new int[nLength];		
		
		for(int i=0;i<nLength;i++){
			countArry[dataArry[i]]++;
		}
		
		for(int i=1;i<range;i++){
			countArry[i]+=countArry[i-1];
		}
		//printArry(countArry);

		for(int i=range-1;i>0;i--){
			countArry[i] = countArry[i-1];
		}
		
		countArry[0] = 0;
		//printArry(countArry);
	
		
		for(int i=0;i<nLength;i++){
			sortedArry[countArry[dataArry[i]]] = dataArry[i];
			countArry[dataArry[i]]++;
		}
		
		for(int i=0;i<nLength;i++){
			dataArry[i]= sortedArry[i]; 
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
		CountingSort objSort =  new CountingSort();
		int[] data = {0,1,2,3,4,5,6,7,8,9,9};
		objSort.doSort(data,10);
		objSort.printArry(data);
		
		
		int[] data1 = {9,9,8,7,6,5,4,3,2,1,0};
		 objSort.doSort(data1,10);
		objSort.printArry(data1);
	}
}
