package leetcode;

import java.util.HashMap;

public class LargestSubstringWithoutRepeatation {
	    public int lengthOfLongestSubstring(String s) {
	        HashMap<Character, Integer> charMap =  new HashMap<Character, Integer>();
	        int nMaxDiff = 0;
	        int nLength =  s.length();
	        int i=0;
	        int nStart = 0;
	        if(nLength <2){
	            return nLength;
	        }
	        while(i<nLength){
	            char currentChar = s.charAt(i);
	            // System.out.println(i+" "+currentChar);
	            if(charMap.containsKey(currentChar)){
	                if(i-nStart > nMaxDiff){
	                    nMaxDiff = i-nStart; 
	                 //  System.out.println(i+" "+nStart);
	                }
	                if(nStart <=  charMap.get(currentChar)){
	                    nStart = charMap.get(currentChar)+1;    
	                }
	                
	               // System.out.println("nStart is "+charMap.get(currentChar) + " + "+1);
	            }
	            charMap.put(currentChar,i);
	            i++;
	        }
	        
	        if(nStart!=i){
	            if(i-nStart > nMaxDiff){
	              // System.out.println(i+" "+nStart);
	                    nMaxDiff = i-nStart; 
	                }
	        }
	        return nMaxDiff;
	    }
}
