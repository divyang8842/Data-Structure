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
	
	public static void main(String str[]){
		Practice obj = new Practice();
		
		int[] dataMinMax = {1,4,7,2,5,8,3,6,9,15,10};
		obj.findTheLArgestAndmallestElement(dataMinMax, -1);
	}
	
}
