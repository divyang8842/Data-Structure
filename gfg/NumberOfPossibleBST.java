package gfg;

import java.util.Scanner;

public class NumberOfPossibleBST {
	public static void main (String[] args) {
		Scanner sc =  new Scanner(System.in);
		int nTestCases =  sc.nextInt();
		while(nTestCases-->0){
			int nNodes =  sc.nextInt();
			int[] nDP = new int[nNodes+1];
			if(nNodes>1){
				nDP[2] = 2;
			}
			if(nNodes>=0){
				nDP[0] = nDP[1] = 1;
			}
			System.out.println(getPossibleBST(nNodes,nDP));
		}
		sc.close();
	}
	
	public static int getPossibleBST(int nNodes,int[] nDP){
		setBST(nNodes, nDP);
		return nDP[nNodes];
	}
	
	public static int setBST(int nStart,int[] nDP){
		
		
		if(nDP[nStart]==0){
			int nLeft = 0;
			int nRight = nStart-1;
			while(nRight>=0){
				nDP[nStart]+=(setBST(nLeft++, nDP)*setBST(nRight--, nDP));
			}
		}
		return nDP[nStart];
	}
}
