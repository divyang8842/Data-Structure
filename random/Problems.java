package random;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

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
				j=0;
				i++;
			}
			if(i<M){
				sbData.append(strArry[i*N + (k%N)]).append(" ");
				k++;
			}
		}*/
		System.out.println(sbData.toString().trim());
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
    }
	
}
