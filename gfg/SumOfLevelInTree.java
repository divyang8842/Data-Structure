package gfg;

import java.util.Scanner;

/*
https://practice.geeksforgeeks.org/problems/binary-tree-k-level-sum/0/?ref=self
*/
public class SumOfLevelInTree {
	public static void main (String[] args) {
	    Scanner sc =  new Scanner(System.in);
	    
	    int nTestCases = sc.nextInt();
	    //sc.next();
	    while(nTestCases-->0){
	        int nLevel =  Integer.parseInt(sc.next());
	        int nCurrentLevel = -1;
	        String strTree = sc.next();
	       // System.out.println(strTree);
	        int nSum = 0;
	        int nLength = strTree.length();
	        for(int i=0;i<nLength;i++){
	            if(strTree.charAt(i)=='('){
	                nCurrentLevel++;
	            }else if(strTree.charAt(i)==')'){
	                nCurrentLevel--;
	            }else if(nCurrentLevel == nLevel){
	                int nCurrent = 0;
	                while(Character.isDigit(strTree.charAt(i))){
	                    nCurrent*=10;
	                    nCurrent+=Character.getNumericValue(strTree.charAt(i));
	                    i++;
	                }
	                i--;
	                nSum+=nCurrent;
	            }
	            
	        }
	        System.out.println(nSum);
	    }
	}
}
