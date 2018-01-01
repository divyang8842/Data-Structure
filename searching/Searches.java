package searching;

public class Searches {
	public int searchInNonSortedArray(int[] dataArry,int elementToSearch){
		int nLength = dataArry.length;
		for(int i=0;i<nLength;i++){
			if(dataArry[i]==elementToSearch){
				return i;
			}
		}
		return -1;
	}
	public int searchInSortedArray(int[] dataArry,int elementToSearch){
		int nLength = dataArry.length;
		if(elementToSearch<=dataArry[nLength-1]){
			for(int i=0;i<nLength;i++){
				if(dataArry[i]==elementToSearch){
					return i;
				}else if(dataArry[i]>elementToSearch){
					return -1;
				}
			}

		}
		return -1;
	}
	
	public int binarySearch(int[] dataArry,int elementToSearch, boolean bRecursive){
		int nLeft = 0;
		int nRight = dataArry.length-1;
		if(bRecursive){
			return binarySearchRecusrive(dataArry, elementToSearch, nLeft, nRight);
		}else{
			return binarySearchNonRecusrive(dataArry, elementToSearch, nLeft, nRight);
		}
			
		
	}
	
	private int binarySearchNonRecusrive(int[] dataArry, int elementToSearch,int nLeft, int nRight){
		while(nLeft<=nRight){
			int nMid = (nRight+nLeft)/2;
			/*if(nMid>nLength || nMid<0){
				return -1;
			}*/
			if(dataArry[nMid]==elementToSearch){
				return nMid;
			}else if(dataArry[nMid]>elementToSearch){
				nRight = nMid-1;
			}else{
				nLeft = nMid+1;
			}
		}
		
		return -1;
	}
	
	private int binarySearchRecusrive(int[] dataArry, int elementToSearch,int nLeft, int nRight){
		
		if(nRight>nLeft){
			int nMiddle = (nRight+nLeft)/2;
			int nDiff = dataArry[nMiddle] - elementToSearch;
			
			if(nDiff==0){
				return nMiddle;
			}else if(nDiff>0){
				return binarySearchRecusrive(dataArry, elementToSearch, nLeft, nMiddle-1);
			}else if(nDiff<0){
				return binarySearchRecusrive(dataArry, elementToSearch, nMiddle+1, nRight);
			}
		
		}
		return -1;	
	}
	
	
	public static void main(String sytr[]){
		Searches obj =  new Searches();
		int[] data =  {8,5,2,9,6,3,7,4,1,0};
		System.out.println("Non Sorted array : ");
		System.out.println("3 is available in the array at index"+obj.searchInNonSortedArray(data, 3));
		System.out.println("10 is available in the array at index"+obj.searchInNonSortedArray(data, 10));
		
		int[] data1 = {0,1,2,3,4,5,6,7,8,9,10};
		System.out.println("Sorted array : ");
		System.out.println("3 is available in the array at index"+obj.searchInSortedArray(data1, 3));
		System.out.println("10 is available in the array at index"+obj.searchInSortedArray(data1, 15));
		
		System.out.println("binary search with sorted array");
		System.out.println("Recursive : ");
		System.out.println("3 is available in the array at index"+obj.binarySearch(data1, 3,true));
		System.out.println("10 is available in the array at index"+obj.binarySearch(data1, 15,true));
		
		System.out.println("Non Recursive : ");
		System.out.println("3 is available in the array at index"+obj.binarySearch(data1, 3,false));
		System.out.println("10 is available in the array at index"+obj.binarySearch(data1, 15,false));
		
	}
}
