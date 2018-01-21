package random;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Problems {
	public void sortRoyalNames(String nameAry[]){
		Arrays.sort(nameAry,compare);
	}
	
	Comparator<String> compare=  new Comparator<String>() {

		@Override
		public int compare(String str1, String str2) {
			String name1[] =  str1.split(" ");
			String name2[] =  str2.split(" ");
			if(name1[0].compareTo(name2[0])==0){
				if(name1.length>1 && name2.length>1){
					return romanToDecimal(name1[1]) - romanToDecimal(name2[1]);
				}else if(name1.length==1){
					return 1;
				}else{
					return -1;
				}
			}
			return name1[0].compareTo(name2[0]);
		}
	};
	
    int romanToDecimal(String str)
    {
        int res = 0;
 
        for (int i=0; i<str.length(); i++)
        {
            int s1 = value(str.charAt(i));
 
            if (i+1 <str.length())
            {
                int s2 = value(str.charAt(i+1));
 
                if (s1 >= s2)
                {
                    res = res + s1;
                }
                else
                {
                    res = res + s2 - s1;
                    i++; 
                }
            }
            else
            {
                res = res + s1;
                i++;
            }
        }
 
        return res;
    }
    
    int value(char r)
    {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }
    
    public void printArry(String[] dataArry){
		int nLength =  dataArry.length;
		for(int i=0;i<nLength;i++){
			System.out.print(dataArry[i]+" ");
		}
		System.out.println(" ");
	}
    
    public void printArry(int[] dataArry){
		int nLength =  dataArry.length;
		for(int i=0;i<nLength;i++){
			System.out.print(dataArry[i]+" ");
		}
		System.out.println(" ");
	}
    
    public void printLL(LinkedList dataLL){
		int nLength =  dataLL.size();
		for(int i=0;i<nLength;i++){
			System.out.print(dataLL.get(i)+" ");
		}
		System.out.println(" ");
	}
    
    
	public void AddLinkedList(LinkedList<Integer> AddedLinkedList,LinkedList<Integer> LL1,int nPos1,LinkedList<Integer> LL2,int nPos2,int nCarry){
		if(nPos1<0 && nPos2<0){
			nPos1 = LL1.size()-1;
			nPos2 = LL2.size()-1;
		}
		if(AddedLinkedList == null){
			AddedLinkedList = new LinkedList<Integer>();
		}
		int nData = 0;
		int nSum = 0;
		
		if(nPos1>=0 && nPos2>=0){
			nSum = LL1.get(nPos1)+LL2.get(nPos2)+nCarry;
			nCarry = nSum/10;
			nData = nSum%10;
			nPos1--;
			nPos2--;
		}else if(nPos1>=0){
			nSum = LL1.get(nPos1)+nCarry;
			nCarry = nSum/10;
			nData  = nSum%10;
			nPos1--;
		}else if(nPos2>=0){
			nSum = LL1.get(nPos2)+nCarry;
			nCarry = nSum/10;
			nData  = nSum%10;
			nPos2--;
		}else{
			return;
		}
		
		if(nPos1 >=0 || nPos2>=0){
			AddLinkedList(AddedLinkedList, LL1, nPos1, LL2, nPos2, nCarry);
		}else if(nCarry>0){
			AddedLinkedList.add(nCarry);
		}
		
		AddedLinkedList.add(nData);
	}
	
	/*//1=a,....,26 = z
	public int getPossibleNumberOfWordsFromNumberString(String strData){
		
	}*/
	
	private final String[] strNumberPad = {"", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};
	
	private String getPossibleCharString(int number){
		if(number>=0 && number<=9) 
			return strNumberPad[number];
		else
			return "";
	}
	
	public void findAllPossibleNumberFromTelephoneNumberPad(int[] dataArry,int nPos,int nLength,String strData){
		if(nPos<0){
			nPos = 0;
		}
		if(nLength<=0){
			nLength = dataArry.length;
		}
		
		if(nLength == nPos){
			System.out.println(strData);
			return;
		}
		char[] strChars = getPossibleCharString(dataArry[nPos]).toCharArray();
		int nChars = strChars.length;
		nPos++;
		while(nChars-->0){
			findAllPossibleNumberFromTelephoneNumberPad(dataArry, nPos, nLength, strData+strChars[nChars]);
		}
	}
	
	public int[] mergeKSortedArrays(int[][] dataArry){
		 PriorityQueue<Integer> queue =  new PriorityQueue<Integer>();
		 int nLength = dataArry.length;
		 int nArrayLength =  dataArry[0].length;
		 int n = nLength*nArrayLength;
		 
		 for(int i=0;i<n;i++){
			 queue.add(dataArry[i/nArrayLength][i%nArrayLength]);
		 }
		 int[] mergedArry =  new int[n];
		 for(int i=0;i<n;i++){
			 mergedArry[i] = queue.poll();
		 }
		 return mergedArry;
	}
	
	/* 	 	 1
		    11
		    21
		  1211
		111221
		312211
	  13112221
	1113213211 */
	public String findNextNumberInSeq(String strData){
		int nLength = strData.length();
		int i = 0;
		int nCount = 0;
		char current = ' ';
		StringBuffer sbOP = new StringBuffer();
		while(i<nLength){
			if(current == strData.charAt(i)){
				nCount++;
			}else{
				if(nCount>0){
					sbOP.append(nCount).append(current);
				}
				nCount = 1;
				current = strData.charAt(i);
			}
			i++;
		}
		if(nCount>0){
			sbOP.append(nCount).append(current);
		}
		System.out.println(sbOP);
		return sbOP.toString();
	}
	
	
	
	public boolean isStringBalanced(HashMap<Character,Character> balance, String strData){
		int nLength = strData.length();
		int nIndex = 0;
		int nListLengh = 0;
		List<Character> bracesList =  new LinkedList<Character>();
		while(nIndex<nLength){
			if(balance.containsKey(strData.charAt(nIndex))){
				bracesList.add(strData.charAt(nIndex));
				nListLengh++;
			}else if(balance.containsValue(strData.charAt(nIndex))){
				if(balance.get(bracesList.get(nListLengh-1)) == strData.charAt(nIndex)){
					bracesList.remove(--nListLengh);
				}else{
					return false;
				}
			}
			nIndex++;
		}
		return bracesList.size()==0;
	}
	
	public int MaximumTipCalculator(int N,int X,int Y,int[] A,int[] B){
		int nLengthA = A.length;
		int nLengthB = B.length;
		int nAMinus = 0;
		int nBMinus = 0;
		int nSum = 0;
		for(int i=0;i<N;i++){
			if(nAMinus <= nLengthA && A[i] >= B[i]){
				nSum+= A[i];
				nAMinus++;
			}else if(nBMinus <= nLengthB){
				nSum+= B[i];
				nBMinus++;
			}else if(nBMinus == nLengthB && nAMinus == nLengthA){
				break;
			}
		}
		
		return nSum;
	}
	
	public int getNumberOfDigitswithPrimeBinarySet(int nMin, int nMax){
		int nCount = 0;
		for(int i=nMin;i<=nMax;i++){
			String strBinary =  Integer.toBinaryString(i);
			int nSetBits = strBinary.length() - strBinary.replace("1", "").length();
			if(isPrimeNumber(nSetBits)){
				nCount++;
			}
		}
		
		return nCount;
	}
	

	private boolean isPrimeNumber(int nData){
		
		if(nData<2){
			return false;
		}
		if(nData==2){
			return true;
		}
		
		if(nData%2==0){
			return false;
		}
		for(int i=3;i*i<=nData;i+=2){
			if(nData%i==0){
				return false;
			}
		}
		return true;
	}
	
	
	public char getKthCharAfterNIteration(int nData,int N,int K){
		String strData =  Integer.toBinaryString(nData);
		StringBuilder sbData = new StringBuilder(strData);
		int nLength = strData.length();
		for(int i=0;i<N;i++){
			
			
			for(int j=0;j<nLength;j++){
				if(strData.charAt(j)=='0'){
					sbData.append("01");
				}else{
					sbData.append("10");
				}
			}
			strData = sbData.toString();
			nLength = strData.length();
			sbData.delete(0, nLength-1);

		}
		return strData.charAt(K);
	}
	
	public void printMatrixAfterKLeftRotations(String strData,int M,int N,int K){
		String[] strArry =  strData.split(" ");
		StringBuffer sbData =  new StringBuffer();
		
		for(int i=0;i< M;i++){
			int k = K;
			for(int j=0;j<N;j++){
				sbData.append(strArry[i*N + (k%N)]).append(" ");
				k++;
			}
		}
		/*int i=0;
		int k = K;
		for(int j=0;i<M;j++){
			if(j== N  ){
				k=K;
				j=0
				i++;
			}
			if(i<M){
				sbData.append(strArry[i*N + (k%N)]).append(" ");
				k++;
			}
		}*/
		System.out.println(sbData.toString().trim());
	}
	
	public void findStarAndSuperStarFromString(String strData,int nLength){
		String[] arrData = strData.split(" ");
		int nSupreStar = Integer.parseInt(arrData[0]);
		int nStarIndex = 0;
		
		for(int i=1;i<nLength;i++){
			if(Integer.parseInt(arrData[i]) >nSupreStar){
				nSupreStar = Integer.parseInt(arrData[i]); 
			}
			if(Integer.parseInt(arrData[nStarIndex]) < Integer.parseInt(arrData[i])){
				nStarIndex = i;
			}
		}
		for(int i=nStarIndex;i<nLength;i++){
			System.out.print(arrData[i]+" ");
		}
		System.out.println("");
		System.out.println(nSupreStar);
		
	}
	
	public void rotateMatrixBy90Degree(int[][] dataArry){
		int nX = dataArry.length;
		for(int i=0;i<nX;i++){
			for(int j=i;j<nX-i-1;j++){
				int temp = dataArry[i][j];
				dataArry[i][j] = dataArry[j][nX-1-i];
				dataArry[j][nX-1-i] = dataArry[nX-1-i][nX-1-j];
				dataArry[nX-1-i][nX-1-j] = dataArry[nX-1-j][i];
				dataArry[nX-1-j][i] = temp;
			}
		}
	}
	
	public void print2DArray(int[][] dataArry){
		int nX = dataArry.length;
		int nY = dataArry[0].length;
		for(int i=0;i<nX;i++){
			for(int j=0;j<nY;j++){
				System.out.print(dataArry[i][j]);
			}
			System.out.println("");
		}
	}
	
	public int isStringsHaveCommonSubString(String str1,String str2){
		Set<Character> data = new HashSet<Character>();
		int nLength = str1.length();
		for(int i=0;i<nLength;i++){
			data.add(str1.charAt(i));
		}
		for(int i=0;i<nLength;i++){
			if(data.contains(str2.charAt(i))){
				return 1;
			}
		}		
		return 0;
	}
	
	public int[] setPositiveElementFollowingNegativeElement(int[] dataArry,int nLength){
		int nPos = 0;
		int nNeg = 1;
		int[] formattedArry = new int[nLength];
		for(int i=0;i<nLength;i++){
			if(dataArry[i]>0){
				formattedArry[nPos+=2] = dataArry[i];
			}
			if(dataArry[i]<0){
				formattedArry[nNeg+=2] = dataArry[i];
			}
		}
		
		return formattedArry;
	}
	
	public int chocolateStationProblem(int[] dataArry,int nLength,int nPrice){
		int nSum = dataArry[0];
		int nCurrent = 0;
		for(int i=1;i<nLength;i++){
			if(dataArry[i]>(dataArry[i-1]+nCurrent)){
				nSum+=dataArry[i]-(dataArry[i-1]+nCurrent);
				nCurrent=0;
			}else{
				nCurrent+=dataArry[i-1] - dataArry[i];
			}
		}
		//System.out.println(nSum*nPrice);
		return nSum*nPrice;
	}
	
	public void getFirstAndLastInstanceOfNumberInArray(int[] dataArry,int nLength,int nNumber){
		int nLeft = 0;
		int nRight = nLength-1;	
		int firstOccurance = -1;
		int lastOccurance = -1;
		while(nRight>=nLeft){
			int nMid = (nRight+nLeft)/2;
			if(dataArry[nMid] == nNumber && (nMid == nLeft || dataArry[nMid-1]<nNumber)){
				firstOccurance = nMid;
			}
			
			if(dataArry[nMid]>=nNumber){
				nRight = nMid-1;
			}else{
				nLeft = nMid+1;
			}
		}
		if(firstOccurance>0){
			for(int i = firstOccurance;i<nLength;i+=2){
				if(dataArry[i]!=nNumber){
					if(dataArry[i-1] == nNumber){
						lastOccurance = i-1;
					}else
					{
						lastOccurance = i-2;
					}
					break;
				}else{
					lastOccurance = i;
				}
				
			}
			
			System.out.println(firstOccurance+" "+lastOccurance);
		}else{
			System.out.println("-1");
		}
	}
	
	public int getLengthOFNonOverlappingSubArrays(int[] dataArry,int nLength,int nNumberToFind){
		int nLengthSum = 0;
		int nSum = 0;
		boolean bKAvailable = false;
		for(int i=0;i<nLength;i++){
			if(dataArry[i]<=nNumberToFind){
				if(dataArry[i]==nNumberToFind){
					bKAvailable = true;
				}
				nLengthSum++;
			}else {
				if(bKAvailable){
					nSum+=nLengthSum;
					bKAvailable = false;
				}
				nLengthSum = 0;
			}
		}
		if(bKAvailable){
			nSum+=nLengthSum;
		}
		
		return nSum;
	}
	
	public int findPeakElemetInIncDecArray(int[] dataArry,int nLength){
		int nLeft = 0;
		int nRight = nLength - 1;
		while(nRight>=nLeft){
			int nMid = (nRight+nLeft)/2;
			if(dataArry[nMid]>dataArry[nMid-1] && dataArry[nMid]>dataArry[nMid+1]){
				return dataArry[nMid];
			}else if(dataArry[nMid]>dataArry[nMid-1]){
				nLeft = nMid+1;
			}else{
				nRight = nMid-1;
			}
		}
		return -1;
	} 

    public static void main(String str[]){
    	Problems obj = new Problems();
    	/*String names[]={"Richard V","Henry VI","Edward II","Richard XXV","Henry IX","Edward LII"};
    	obj.sortRoyalNames(names);
    	obj.printArry(names);
    	*/
    	/*LinkedList<Integer> LL1 = new LinkedList<Integer>();
    	LL1.add(1);
    	LL1.add(9);
    	
    	LinkedList<Integer> LL2 = new LinkedList<Integer>();
    	LL2.add(1);
    	LL2.add(9);
    	LL2.add(1);
    	
    	LinkedList<Integer> LLAdd = new LinkedList<Integer>();
    	obj.AddLinkedList(LLAdd, LL1, -1, LL2, -1, 0);
    	obj.printLL(LLAdd);*/
    	/* 
    	int[] ndata = {2};
    	obj.findAllPossibleNumberFromTelephoneNumberPad(ndata, 0, -1, "");
    	*/
    	
    	/* 
    	int[][] dataArry = {{1,4,7,10},{2,5,8,11},{3,6,9,12}};
    	int[] result = obj.mergeKSortedArrays(dataArry);
    	obj.printArry(result);*/
    	
    	//obj.findNextNumberInSeq("13112221");
    	HashMap<Character, Character> map =  new HashMap<Character, Character>();
    	map.put('(', ')');
    	map.put('{', '}');
    	map.put('[', ']');
    	
    	System.out.println("123(45{67}89) is balanced "+obj.isStringBalanced(map, "123(45{67}89)"));
    	int[] A = {1,4,3,2,7,5,9,6};
    	int[] B = {1,2,3,6,5,4,9,8};
    	System.out.println("Max tip is "+obj.MaximumTipCalculator(8, 4, 4, A, B));
    	System.out.println(obj.getKthCharAfterNIteration(11, 6, 4));
    	
    	
    	obj.printMatrixAfterKLeftRotations("1 2 3 4", 2, 2, 1);
    	
    	obj.findStarAndSuperStarFromString("4 2 5 7 2 1", 6);
    	
    	int[][] dataArry = {{1,4,7},{2,5,8},{3,6,9}};
    	obj.print2DArray(dataArry);
    	obj.rotateMatrixBy90Degree(dataArry);
    	obj.print2DArray(dataArry);
    	
    	
    	int[] dataChkltPrblm = {10,6,11,4,7,1};
    	obj.chocolateStationProblem(dataChkltPrblm, 6, 5);
    	
    	
    	int[] data = {5,10,12,12,13,20,23,28,30,32,35,37,43,43,44,59,60,61,63,68,70,72,82,83,85,85,85,88,91,92,95,96,98,98,108,118,122,124,125,125,128,129,132,136,140,143,144,150,151,156,164,168,171,173,173,179,180,184,191,191,194,198,199,200,206,207,210,211,212,220,223,225,227,228,229,229,229,230,236,238,246,256,256,259,270,271,274,276,277,281,282,283,287,293,299,300,300,302,302,306,306,307,312,314,316,318,321,322,325,325,328,336,337,337,337,341,341,341,343,344,349,349,351,354,356,363,365,366,368,369,369,369,370,371,373,374,377,379,380,380,380,386,387,394,396,397,400,404,405,408,413,414,417,419,422,422,423,423,427,429,430,433,435,435,438,441,442,444,445,445,446,452,453,457,465,466,467,468,469,471,475,482,489,491,492,493,493,498,500,501,504,506,506,508,523,525,527,529,530,531,538,539,540,541,543,543,546,551,552,556,568,568,569,571,580,582,583,585,587,587,588,591,591,600,601,602,606,607,612,614,619,620,622,623,625,625,626,627,631,638,641,645,650,652,653,659,660,661,662,668,669,670,673,676,677,684,685,689,690,691,706,709,709,710,714,714,716,722,724,726,730,730,731,733,733,737,737,740,744,744,747,751,755,757,757,764,764,765,765,770,772,773,774,777,777,778,783,785,787,789,794,794,796,797,802,803,805,809,811,812,814,815,819,819,820,820,829,830,841,842,847,847,851,851,857,857,858,859,860,861,863,863,866,872,874,879,882,885,887,888,895,896,899,900,900,903,905,905,915,916,918,918,920,921,922,925,926,927,927,928,929,930,931,933,934,937,937,940,941,955,957,960,966,973,974,981,982,985,988,994,995,997,997,997};
    	obj.getFirstAndLastInstanceOfNumberInArray(data, 384 , 238);
    	
    	
    	int[] nData = {2,1,4,9,2,3,8,3,4};
    	System.out.println("Length is "+obj.getLengthOFNonOverlappingSubArrays(nData, 9, 4));
    }
	
}
