package stringOperations;

import java.util.LinkedList;

public class Problems {
	//O(n)
	public String reverseString(String strData){
		int i=0;
		int j = strData.length()-1;
		StringBuilder sbRev =  new StringBuilder(strData);
		while(j>i){
			sbRev.setCharAt(i, (char) (sbRev.charAt(i)^sbRev.charAt(j)));
			sbRev.setCharAt(j, (char) (sbRev.charAt(j)^sbRev.charAt(i)));
			sbRev.setCharAt(i, (char) (sbRev.charAt(i)^sbRev.charAt(j)));
		}
		return strData;
	}
	

	public boolean findIfStringsAreAnagram(String str1,String str2){
		int nLength1 = str1.length();
		int nLength2 = str2.length();
		int xoredNumber = 0;
		if(nLength1==nLength2){
			while(nLength1>0){
				nLength1--;
				
				xoredNumber^=   ((int)str1.charAt(nLength1) ^ (int)str2.charAt(nLength1));
				System.out.println(xoredNumber);
			}
			return xoredNumber==0;
		}
		return false;
	}
	
	public static void main(String[] str){
		Problems obj = new Problems();
		System.out.println("123456789 & 147258369 are anagram : "+obj.findIfStringsAreAnagram("123456789", "142258369"));
	}
	
	



}
