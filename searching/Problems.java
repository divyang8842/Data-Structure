package searching;


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
	
	
	public static void main(String str[]){
		Problems obj = new Problems();
		int[] data = {1,1,1,1,1,2,3,4,5,6,7,8,9,10,11,11,11,11,11,11,11,11,11,11,11,11};
		System.out.println("Max repeated number is "+obj.checkMaxepeatedNumber(data)); 
		
		int[] data1 = {0,1,2,3,4,5,6,7,8,9,10,5};
		System.out.println("Array contains repeated number :"+obj.checkIfArrayHasRepeatedNumber(data1));
		
	}
}
