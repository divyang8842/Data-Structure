package gfg;

import java.util.Scanner;
/*
https://practice.geeksforgeeks.org/problems/shortest-source-to-destination-path/0
*/
class GFG {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
		int nTestCases = sc.nextInt();
		while(nTestCases-->0){
		    int nRows = sc.nextInt();
		    int nCols = sc.nextInt();
		    int[][] data =  new int[nRows][nCols];
		    for(int i=0;i<nRows;i++){
		        for(int j=0;j<nCols;j++){
		            data[i][j] = sc.nextInt();
		        }
		    }
		    int nSourceRow = 0;
		    int nSourceCol = 0;
		    int nDestRow = sc.nextInt();
		    int nDestCol = sc.nextInt();
		    if(nDestRow>=nRows || nDestCol>=nCols){
		        System.out.println(-1);		        
		    }else{
                getMinDistance(nSourceRow,nSourceCol,nDestRow,nDestCol,data,nRows,nCols,2);
		        System.out.println(data[nDestRow][nDestCol]<2?-1:data[nDestRow][nDestCol]-2);		        
		    }

		}
		sc.close();
	}
    public static void getMinDistance(int nSourceRow,int nSourceCol,int nDestRow,int nDestCol,int[][] data,int nRows,int nCols,int nDist){
		if(nSourceRow< 0 || nSourceRow == nRows || nSourceCol == nCols || nSourceCol < 0){
		    return;
		}
		if(data[nSourceRow][nSourceCol] == 0){
		    data[nSourceRow][nSourceCol] = -1;
		}
		if(data[nSourceRow][nSourceCol]>nDist || data[nSourceRow][nSourceCol]==1){
		    data[nSourceRow][nSourceCol] = nDist;    
		}else{
		    return;
		}
		
	    if(nSourceRow!=nDestRow || nSourceCol!=nDestCol){
	        nDist++;
		    getMinDistance(nSourceRow-1,nSourceCol,nDestRow,nDestCol,data,nRows,nCols,nDist);
		    getMinDistance(nSourceRow+1,nSourceCol,nDestRow,nDestCol,data,nRows,nCols,nDist);
		    getMinDistance(nSourceRow,nSourceCol-1,nDestRow,nDestCol,data,nRows,nCols,nDist);
		    getMinDistance(nSourceRow,nSourceCol+1,nDestRow,nDestCol,data,nRows,nCols,nDist);
	    }else{
	        return;
	    }
	}
}