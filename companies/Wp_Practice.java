package companies;

import java.util.LinkedList;
import java.util.Queue;

public class Wp_Practice {

	//## write a function which tells whether G is bipartite or not
	public boolean isBipartite(int[][] nGraphArry) {
		int nVertexes = nGraphArry.length;
		int[] nColorArry =  new int[nVertexes];
		
		for(int i=0;i<nVertexes;i++) {
			nColorArry[i] = -1;
		}
		for(int i=0;i<nVertexes;i++) {
			if(nColorArry[i] == -1) {
				if(!isBipartite_Helper(nGraphArry, nColorArry, nVertexes, i)) {
					return false;
				}
			}
		}
		return true;
	}
	public boolean isBipartite_Helper(int[][] nGraphArry,int[] nColorArry,int nLength,int nU){
		Queue<Integer> queue =  new LinkedList<Integer>();
		queue.offer(nU);
		nColorArry[nU] = 1; 
		
		while(!queue.isEmpty()) {
			int u =  queue.poll();
			
			//self loop
			if(nGraphArry[u][u] == 1) { 
				return false;
			}
			for(int v=0;v<nLength;v++) {
				if(nGraphArry[u][v]==1 && nColorArry[v] == -1) {
					nColorArry[v] = 1 - nColorArry[u];
					queue.offer(v);
				}else if(nGraphArry[u][v]==1 && nColorArry[v] == nColorArry[u]) {
					return false;
				}
			}
		}
		
		return true;
	}
	//## End
	
	//## check if string is valid number or not
	public boolean isValidNumber(String strNumber) {
		
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
		for(int i=1;i<nLength;i++) {
			if(strNumber.charAt(i)=='.') {
				//valid number can not have dot for 2 times
				// also dot can not appear after e
				if(isDot || isE) {
					return false;
				}else {
					isDot = true;
				}
			}else if(strNumber.charAt(i)=='e') {
				//valid number can not have e two times
				if(isE) {
					return false;
				}
				i++;
				
				//e can not be last character of number
				if(i==nLength) {
					return false;
				}
				
				//number after 
				if(strNumber.charAt(i)!='+' && strNumber.charAt(i)!='-' && !Character.isDigit(strNumber.charAt(i))) {
					return false;
				}
				isE = true;
				
			}else if(!Character.isDigit(strNumber.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	//## End
	
	
	public static void main(String[] str) {
		
		 int G[][] = {
				 	 {0, 1, 0, 1},
				 	 {1, 0, 1, 0},
				 	 {0, 1, 0, 1},
				 	 {1, 0, 1, 0}
				 	 };
		 Wp_Practice obj = new Wp_Practice();
		 if(obj.isBipartite(G)) {
			 System.out.println("True");
		 }else {
			 System.out.println("False");
		 }
		 
		 if(obj.isValidNumber("1.0e5e9")) {
			 System.out.println("Valid Number.");
		 }else {
			 System.out.println("Invalid Number.");
		 }
	}
}
