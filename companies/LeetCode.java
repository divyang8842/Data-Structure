package companies;

import java.util.Arrays;

public class LeetCode {
	    
	//##String to Integer (atoi)
	public int stringToInteger(String str) {
	        
	        //given string i null
	        if(str==null){
	            return 0;
	        }
	        
	        //given string is blank string
	        str = str.trim();
	        int nLength = str.length();
	        if(nLength == 0){
	            return 0;
	        }
	        
	        //string contains one character and its not digit
	        char[] dataArr =  str.toCharArray();
	        if(nLength == 1 && !Character.isDigit(dataArr[0])){
	            return 0;
	        }
	        
	        int nCurrentDigit = 0;
	        int nSign = 1;
	        Long nNumber = new Long(0);
	        
	        int i=0;
	        //first character is sign (+/-)
	        if(dataArr[0] == '-' || dataArr[0] == '+'){
	            if(dataArr[0] == '-'){
	                nSign = -1;
	            }
	            i++;
	        }
	        
	        int nMAX =  Integer.MAX_VALUE;
	        int nMIN = Integer.MIN_VALUE;
	        for(;i<nLength;i++){
	            //if any character appears which is not digit
	            if(!Character.isDigit(dataArr[i])){
	                return (nSign * nNumber.intValue());
	            }
	            nCurrentDigit = dataArr[i]  - '0';
	            //System.out.println(nNumber + " * "+nBase +" + "+nCurrentDigit );
	            nNumber =  nNumber*10  + nCurrentDigit;
	            if(nSign == 1 && (nSign * nNumber) >  nMAX){
	                return nMAX;
	            }
	            
	            if(nSign == -1 && (nSign * nNumber) <  nMIN){
	                return nMIN;
	            }
	            
	        }
	        return (nSign * nNumber.intValue());
	        
	    }
	
	//##End
	
		//##IsValid Number
	
	    public boolean isNumber(String strNumber) {
	        //if input is null
			if(strNumber==null) {
				return false;
			}
			//removing extra spaces from the input
			strNumber =  strNumber.trim();
			//getting length of the input
			int nLength = strNumber.length();
			//if input is empty string
			if(nLength==0) {
				return false;
			}
			//if input has only one character and its not a digit
			if(nLength==1 && !Character.isDigit(strNumber.charAt(0))) {
				return false;
			}
			
			//if first character of number is not a digit, '+', '-', '.'
			if(!Character.isDigit(strNumber.charAt(0)) && strNumber.charAt(0)!='+' && strNumber.charAt(0)!='-' && strNumber.charAt(0)!='.'){
				return false;
			}
			
			//check if dot or e is coming for 1time and also . comes before e
			//boolean to check Dot
			boolean isDot = false;
			//boolean to check e
			boolean isE = false;
	        
	        int i=1;
	        if(strNumber.charAt(0)=='.'){
	            i=0;
	        }
			for(;i<nLength;i++) {
				if(strNumber.charAt(i)=='.') {
					//valid number can not have dot for 2 times
					// also dot can not appear after e
					if(isDot || isE) {
						return false;
					}else {
						isDot = true;
	                    
	                                         
	                    //5.
	                    if(i==nLength-1) {
	                        //-.
	                        if(i>0 && !Character.isDigit(strNumber.charAt(i-1))) {
		    				    return false;
			    		    }
	                        return true;
					    }
	                    
	                    //.e1 , 5.e , 2.e
	                    if(i!= 0 && strNumber.charAt(i+1) == 'e' ) {
						    continue;
					    }
	                    i++;
					    //number after : 5.q, 5.y 
					    if(!Character.isDigit(strNumber.charAt(i))) {
						    return false;
					    }
	                   
	                    
					}
				}else if(strNumber.charAt(i)=='e') {
					//valid number can not have e two times
					if(isE) {
						return false;
					}
	                
	                //-e58
					if(strNumber.charAt(i-1)=='+' || strNumber.charAt(i-1)=='-'){
	                    return false;
	                }
					
					//e can not be last character of number
					if(i==nLength-1) {
						return false;
					}
					i++;
					//5e+
					if(strNumber.charAt(i)=='+' || strNumber.charAt(i)=='-') {
						if(i==nLength-1) {
						    return false;
					    }
					}else if(!Character.isDigit(strNumber.charAt(i))){
	                    return false; //5e., 5ee
	                }
					isE = true;
					
				}else if(!Character.isDigit(strNumber.charAt(i))) {
					return false;
				}
			}
			return true;
	    }
	    
	    //##Regex implementation with * and . support
	    public static boolean isMatch(String s, String p) {
	    	

	        char[] cArrS =  s.toCharArray();
	        char[] cArrP =  p.toCharArray();
	        
	        int nPLength =  cArrP.length;
	        int nSLength =  cArrS.length;
	        
	        int nP = 0;
	        int nS = 0;
	        char nPreviousChar = '0';
	        char nPreviousUsedChar = '0';
	        boolean bStar	 = false;
	        while(nP<nPLength && nS<nSLength){
	            //Matches any single character so skip it
	            if(cArrP[nP] == '.'){
                    nPreviousChar = '.';
	                nS++;
	            }else if(cArrP[nP] == '*'){
	                if(nP==0){
	                    return false;    
	                }else{
                        if(nPreviousChar == '.'){
                            nPreviousChar = cArrS[nS];
                            nS++;
                        }
                        
	                    while(nS<nSLength && cArrS[nS] == nPreviousChar){
		                        nS++;   
		                        bStar = true;
		                        nPreviousUsedChar = nPreviousChar;
		                        if(nP+1<nPLength && cArrP[nP+1] == nPreviousChar) {
		                        	nP++;
		                        }
		                }
	                }
	            }else if(cArrP[nP] == cArrS[nS]){
	            	nPreviousChar = cArrP[nP];
	            	nPreviousUsedChar = nPreviousChar;
	            	bStar = false;
	                nS++;
	            }else{
	                if(cArrP[nP] != cArrS[nS] && nP+1<nPLength  && cArrP[nP+1] !='*'){
                        return false;
	                }else{
	                   nPreviousChar = cArrP[nP];
	                   
	                }
	            }     
	            nP++;
	        }
	        
	        while(nP < nPLength){
	            if(cArrP[nP] != '*' && (nP+1>=nPLength || (nP+1<nPLength && cArrP[nP+1] !='*'))){
                        if(!bStar || cArrP[nP] != nPreviousUsedChar){
                            return false;
                        }else if(cArrP[nP] != '*'){
                        	nPreviousUsedChar = cArrP[nP];
                        }
	            }/*else if(cArrP[nP] == '*') {
	            	bStar = true;
	            }*/
                nP++;
	        }
	        
	        
	        if(nS < nSLength){
	            return false;
	        }
	        
	        return true;
	    
	    	
	    }
	    
	    //##End
	    
	    //##Find all combinations that add upto given number
	    //Given a positive number, find out all combinations of positive numbers that adds upto that number. The program should print only combinations, not permutations. For example, for input 3, either 1, 2 or 2, 1 should be printed.
	    
	    public static void printAllCombinationOfNumber(int nNumber) {
	    	int[] nArr = new int[nNumber];
	    	printAllCombinationOfNumber_Utils(nArr, 0, nNumber, nNumber);
	    }
	    
	    public static void printAllCombinationOfNumber_Utils(int[] nArr,int nIndex, int nNumber,int nReducedNum) {
	    	
	    	if(nReducedNum < 0 ||  nIndex>=nNumber) {
	    		return;
	    	}
	    	if(nReducedNum == 0) {
	    		System.out.println(Arrays.toString(nArr));
	    		return;
	    	}
	    	int nPrev = (nIndex == 0)?1:nArr[nIndex-1];
	    	for(int i=nPrev;i<=nNumber;i++) {
	    		nArr[nIndex] = i;
	    		printAllCombinationOfNumber_Utils(nArr, nIndex+1, nNumber, nReducedNum - i);
	    	}
	    	
	    }
	    //##End
	    
	    
	    //##Find all combinations of numbers in a given array that add up to a given number.
	    
	    
	    
	    
	    
	    public static void main(String str[]) {
	    	/*if(isMatch("a", "ab*a") ) {
	    		System.out.println("True");	
	    	}else {
	    		System.out.println("False");
	    	}
	    	
	    	 */
	    	
	    	printAllCombinationOfNumber(5);
	    	
	    }
}
