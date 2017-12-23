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
}
