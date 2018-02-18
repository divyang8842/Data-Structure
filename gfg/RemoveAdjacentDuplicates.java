
package gfg;

import java.util.Scanner;
/*
https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates/0
*/
public class RemoveAdjacentDuplicates {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int nTestCases = sc.nextInt();
		while(nTestCases-->0){
		    StringBuffer sbOP =  new StringBuffer();
		    String strInput =  sc.next();
		    char cCurrentChar =  ' ';
		    int nCount = 0;
		    int nLength =  Integer.MAX_VALUE;
		    while(nLength != strInput.length()){
		        sbOP =  new StringBuffer();
		        nLength =  strInput.length();
		        cCurrentChar =  ' ';
		        nCount = 0;
		        for(int i=0;i<nLength;i++){
		            if(strInput.charAt(i) != cCurrentChar){
		                if(nCount==1){
		                    sbOP.append(cCurrentChar);    
		                }
		                cCurrentChar =  strInput.charAt(i);
		                nCount=0;
		            }
		            nCount++;
		        }
		        if(nCount==1){
		            sbOP.append(cCurrentChar);    
		        }
		        strInput = sbOP.toString();
		        
		    }
		    
		    System.out.println(sbOP.toString());
		}
		sc.close();
	}
}
