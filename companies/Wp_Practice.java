package companies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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
				if(i==nLength-1) {
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
	
	
	//##Check is number is power number or not
	public boolean isPowerNumber(int nInput) {
		double nSqrRoot =  Math.sqrt(nInput);
		for(int i=2;i<nSqrRoot;i++) {
			int nCurrent = i;
			while(nCurrent<=nInput) {
				nCurrent*=i;
				if(nCurrent == nInput) {
					return true;
				}
			}
			
		}
		return false;
	}
	//##End
	
	//## Work LEdder Problem
	
	class WordNode{
	    String word;
	    int numSteps;
	    WordNode pre;
	 
	    public WordNode(String word, int numSteps, WordNode pre){
	        this.word = word;
	        this.numSteps = numSteps;
	        this.pre = pre;
	    }
	}
	 
	public class Solution {
	    public List<List<String>> findLadders(String start, String end, Set
	    		<String> dict) {
	        List<List<String>> result = new ArrayList<List<String>>();
	 
	        LinkedList<WordNode> queue = new LinkedList<WordNode>();
	        queue.add(new WordNode(start, 1, null));
	 
	        dict.add(end);
	 
	        int minStep = 0;
	 
	        HashSet<String> visited = new HashSet<String>();  
	        HashSet<String> unvisited = new HashSet<String>();  
	        unvisited.addAll(dict);
	 
	        int preNumSteps = 0;
	 
	        while(!queue.isEmpty()){
	            WordNode top = queue.remove();
	            String word = top.word;
	            int currNumSteps = top.numSteps;
	 
	            if(word.equals(end)){
	                if(minStep == 0){
	                    minStep = top.numSteps;
	                }
	 
	                if(top.numSteps == minStep && minStep !=0){
	                    //nothing
	                    ArrayList<String> t = new ArrayList<String>();
	                    t.add(top.word);
	                    while(top.pre !=null){
	                        t.add(0, top.pre.word);
	                        top = top.pre;
	                    }
	                    result.add(t);
	                    continue;
	                }
	 
	            }
	 
	            if(preNumSteps < currNumSteps){
	                unvisited.removeAll(visited);
	            }
	 
	            preNumSteps = currNumSteps;
	 
	            char[] arr = word.toCharArray();
	            for(int i=0; i<arr.length; i++){
	                for(char c='a'; c<='z'; c++){
	                    char temp = arr[i];
	                    if(arr[i]!=c){
	                        arr[i]=c;
	                    }
	 
	                    String newWord = new String(arr);
	                    if(unvisited.contains(newWord)){
	                        queue.add(new WordNode(newWord, top.numSteps+1, top));
	                        visited.add(newWord);
	                    }
	 
	                    arr[i]=temp;
	                }
	            }
	 
	 
	        }
	 
	        return result;
	    }
	}
	
	
	//## End
	
	//##fibonacci series 3 ways
	public int fibonacci1(int nNumber) {
		HashMap<Integer, Integer> mapFibo =  new HashMap<>();
		return fibonacci1_helper(nNumber, mapFibo);
	}
	
	private int fibonacci1_helper(int nNumber,HashMap<Integer, Integer> mapFibo) {
		
		if(mapFibo.containsKey(nNumber)) {
			return mapFibo.get(nNumber);
		}
		if(nNumber==2) {
			return 1;
		}else if(nNumber==1 || nNumber == 0) {
			return nNumber;
		}
		int nK = (nNumber%2 == 0)?nNumber/2 : (nNumber+1)/2;
		int nFibo = 0;
		if(nNumber%2==1) {
			nFibo = fibonacci1_helper(nK,mapFibo) * fibonacci1_helper(nK,mapFibo) +  fibonacci1_helper(nK-1,mapFibo) * fibonacci1_helper(nK-1,mapFibo);
		}else {
			nFibo = fibonacci1_helper(nK,mapFibo)*(2*fibonacci1_helper(nK-1,mapFibo)+fibonacci1_helper(nK,mapFibo));
		}
		mapFibo.put(nNumber, nFibo);
		return nFibo;
	}
	
	public int fibonacci2(int nNumber) {
		int[] nFiboArr =  new int[nNumber];
		for(int i=0;i<nNumber;i++) {
			nFiboArr[i] = -1;
		}
		return fibonacci2_helper(nNumber-1, nFiboArr);
	}
	
	private int fibonacci2_helper(int nNumber,int[] nFiboArr) {
		
		if(nFiboArr[nNumber]>=0) {
			return nFiboArr[nNumber];
		}
		if(nNumber == 2) {
			return 1;
		}else if(nNumber==1 || nNumber==0) {
			return nNumber;
		}else {
			nFiboArr[nNumber] = fibonacci2_helper(nNumber-1, nFiboArr) + fibonacci2_helper(nNumber-2, nFiboArr);
			return nFiboArr[nNumber];
		}
	}
	
	public int fibonacci3(int nNumber) {
		int nNum1 = 0;
		int nNum2 = 1;
		for(int i=2;i<nNumber;i++) {
			nNum2 = nNum1+nNum2;
			nNum1 = nNum2 - nNum1;
		}
		return nNum2;
		
	}
	//##End
	
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
