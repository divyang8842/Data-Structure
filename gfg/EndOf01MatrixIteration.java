package gfg;

import java.util.Scanner;

/*
https://practice.geeksforgeeks.org/problems/exit-point-in-a-matrix/0
*/
public class EndOf01MatrixIteration {
	public static void main (String[] args) {
    	Scanner sc = new Scanner(System.in);
		int nTestCases = sc.nextInt();
		while (nTestCases-- > 0) {
			int nRows =  sc.nextInt();
			int nCols = sc.nextInt();
			int[][] data =  new int[nRows][nCols];
			for(int i=0;i<nRows;i++){
				for(int j=0;j<nCols;j++){
					data[i][j] = sc.nextInt();
				}
			}
			int nDirection = 0;//left to right
			/*0 : left to right
			1 : top to down
			2 : right to left
			3 : bottom to up*/
			int i=0,j=0;
			while(i>=0 && i<nRows && j>=0 && j<nCols){
				if(data[i][j] == 1){
					nDirection++;
					nDirection =  nDirection%4;
					data[i][j] = 0;
				}else{
					if(nDirection==0){
						j++;
					}else if(nDirection == 1){
						i++;
					}else if(nDirection == 2){
						j--;
					}else{
						i--;
					}
				}
				
			}
			if(i==nRows){
				i--;
			}
			if(j==nCols){
				j--;
			}
			if(i<0){
			    i=0;
			}
			if(j<0){
			    j=0;
			}
			System.out.println(i+" "+j);
		}
	}
}
