package leetcode;
public class MaxLengthPalindrome {

	    public String longestPalindrome(String s) {
	        
	        int nLength= s.length();
	        int nLeft = 0;
	        int nRight = 0;
	        int nStart = 0;
	        int nMax = 0;
	        for(int i=0;i<nLength;i++){
	            
	            nLeft = i-1;
	            nRight = i+1;;
	            int nMaxLength = 1;
	            while(nLeft>=0 && nRight<nLength && (s.charAt(nLeft) == s.charAt(nRight))){
	                nLeft--;
	                nRight++;
	                nMaxLength+=2;
	            }
	            if(nMaxLength>nMax){
	                nMax = nMaxLength;
	                nStart = nLeft+1;
	            }
	            
	            
	            nLeft = i;
	            nRight = i+1;;
	            nMaxLength = 0;
	            while(nLeft>=0 && nRight<nLength && (s.charAt(nLeft) == s.charAt(nRight))){
	                nLeft--;
	                nRight++;
	                nMaxLength+=2;
	            }
	            if(nMaxLength>nMax){
	                nMax = nMaxLength;
	                nStart = nLeft+1;
	            }
	        }
	            
	        return s.substring(nStart,nStart+nMax);
	    }
}
