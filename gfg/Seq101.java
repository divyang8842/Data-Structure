package gfg;

import java.util.Scanner;

/*
https://practice.geeksforgeeks.org/problems/101-pattern-count/0
*/
public class Seq101 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int nTestCases =  sc.nextInt();
		//sc.next();//to capture \n
		while(nTestCases-->0){
		    String strInput =  sc.next();
		    int nLength = strInput.length();
		    int nCount = 0;
		    int nZeroCount = 0;
		    boolean bSeq = false;
		    for(int i=0;i<nLength;i++){
		        char cCurrent =  strInput.charAt(i);
		        if(cCurrent=='1'){
		            if(bSeq && nZeroCount>0){
		                bSeq = true;
		                nZeroCount=0;
		                nCount++;    
		            }else{
		                bSeq = true;
		                nZeroCount=0;
		            }
		        }else if(cCurrent=='0' && bSeq){
		            nZeroCount++;
		        }else{
		            bSeq = false;
		            nZeroCount=0;
		        }
		        
		    }
		    System.out.println(nCount);
		}
	}
}
