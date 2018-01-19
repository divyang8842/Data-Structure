package stringOperations;

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
}
