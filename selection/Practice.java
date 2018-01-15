package selection;

public class Practice {
	public void findTheLArgestAndmallestElement(int[] dataArry, int nLength){
		if(nLength<=0){
			nLength = dataArry.length;
		}
		int nMin = Integer.MAX_VALUE;
		int nMax = Integer.MIN_VALUE;
		int i=0;
		while(i<nLength && (i+1)<nLength){
			
			if(dataArry[i]>dataArry[i+1]){
				if(dataArry[i]>nMax){
					nMax = dataArry[i];
				}
				if(dataArry[i+1]<nMin){
					nMin = dataArry[i+1];
				}
			}else{
				if(dataArry[i+1]>nMax){
					nMax = dataArry[i+1];
				}
				if(dataArry[i]<nMin){
					nMin = dataArry[i];
				}
			}
			i+=2;
		}
		if(i == nLength+1){ // length is odd
			i= nLength-1;
			if(dataArry[i]>nMax){
				nMax = dataArry[i];
			}
			if(dataArry[i]<nMin){
				nMin = dataArry[i+1];
			}
		}
		System.out.println("Min is "+nMin +" & Max is "+nMax);
	}
	
	
	public int findLargestElement(int[] dataArry,int nLength){
		if(nLength<=0){
			nLength = dataArry.length;
		}
		int nMax = Integer.MIN_VALUE;
		int i=0;
		while(i<nLength && i+1<nLength){
			nMax =  Math.max(nMax, Math.max(dataArry[i],dataArry[i+1]));
			i+=2;
		}
		if(nLength%2!=0){
			nMax = Math.max(nMax, dataArry[nLength-1]);
		}
		return nMax;
	}
	
	public void findNSmallestElementsInArray(int[] dataArry,int nStart,int nEnd,int n){
		int nPivot  = partitionHelper(dataArry, nStart, nEnd);
		if(nPivot==(n-1)){
			for(int i=0;i<n;i++){
				System.out.print(dataArry[i]);
			}
			System.out.println(" ");
		}else if(nPivot>(n-1)){
			findNSmallestElementsInArray(dataArry, nStart, nPivot-1, n);
		}else{
			findNSmallestElementsInArray(dataArry, nPivot+1,nEnd , n);
		}
	}
	
	private int partitionHelper(int[] dataArry, int nLeft, int nRight){
		int nPivot  = nLeft;
		int nPivotData = dataArry[nPivot];
		while(nRight>nLeft){
			while(nRight>nLeft && dataArry[nRight]>nPivotData){
				nRight--;
			}
			while(nRight>=nLeft && dataArry[nLeft]<nPivotData){
				nLeft++;
			}
			if(nLeft>nRight){
				dataArry[nPivot] = dataArry[nRight];
				dataArry[nRight] = nPivotData;
				nPivot = nRight;
			}else{
				swap(dataArry, nRight, nLeft);
			}
		}
		return nPivot;
	}
	
	
	private void swap(int[] dataArry,int nIndex1,int nIndex2){
		if(nIndex1!=nIndex2){
			dataArry[nIndex1] = dataArry[nIndex1] + dataArry[nIndex2];
			dataArry[nIndex2] = dataArry[nIndex1] - dataArry[nIndex2];
			dataArry[nIndex1] = dataArry[nIndex1] - dataArry[nIndex2];
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
		Practice obj = new Practice();
		
		int[] dataMinMax = {10,4,7,2,5,8,3,6,9,15,1};
		obj.findTheLArgestAndmallestElement(dataMinMax, -1);
		
		System.out.println("MAx in the array is "+obj.findLargestElement(dataMinMax, 0));
		obj.findNSmallestElementsInArray(dataMinMax,0, dataMinMax.length-1, 4);
		obj.printArry(dataMinMax);
	
	}
	
}
