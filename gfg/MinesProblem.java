package gfg;

public class MinesProblem {
	public static void main(String[] args){
		char[][] data =  {{'.','m','.','.'},{'.','.','.','.'},{'.','.','.','m'},{'m','.','.','.'}};
		minesIproblem(data);
		
		
	}
	
	public static int[][] minesIproblem(char[][] data){
		
		int nRows =  data.length;
		int nCols = data[0].length;
		int[][] nReturnData =  new int[nRows][nCols];
		int[] nRowMines =  new int[nRows];
		for(int i=0;i<nRows;i++){
			for(int j=0;j<nCols;j++){
				if(data[i][j] == 'm'){
					
					nRowMines[i]++;
					
					nReturnData[i][j] = -1;
					
					if(i>0){
						if(nReturnData[i-1][j]==0){
							nReturnData[i-1][j] = 1;
						}
						if(j>0 && nReturnData[i-1][j-1]==0){
							nReturnData[i-1][j-1] = 1;
						}
						if(j+1<nCols && nReturnData[i-1][j+1]==0){
							nReturnData[i-1][j+1] = 1;
						}
					}
					
					if(i+1<nRows){
						if(nReturnData[i+1][j]==0){
							nReturnData[i+1][j] = 2;
						}
						if(j>0 && nReturnData[i+1][j-1]==0){
							nReturnData[i+1][j-1] = 1;
						}
						if(j+1<nCols && nReturnData[i+1][j+1]==0){
							nReturnData[i+1][j+1] = 1;
						}
					}
					
					if(j>0 && nReturnData[i][j-1]!=-1){
						nReturnData[i][j-1] = 1;
					}
					
					if(j+1<nCols && nReturnData[i][j+1]!=-1){
						nReturnData[i][j+1] = -2;
					}
				}
			}
		}
		
		for(int i=0;i<nRows;i++){
			for(int j=0;j<nCols;j++){
				if(i%2==1 && nReturnData[i][j]>0 && nRowMines[i]>0){
					nReturnData[i][j]*=3;
				}
				int nPass = 0;
				if(i>0 && j>0 && nReturnData[i-1][j-1] == -1){
					nPass++;
				}
				if(i+1<nRows && j>0 && nReturnData[i+1][j-1] == -1){
					nPass++;
				}
				if(j+1<nCols && i>0 && nReturnData[i-1][j+1]==-1){
					nPass++;
				}
				
				if(j+1<nCols && i+1<nRows && nReturnData[i+1][j+1]==-1){
					nPass++;
				}
				
				if(nPass>0 && nReturnData[i][j]>0){
					nReturnData[i][j]*=(2*nPass);
				}
				if(nReturnData[i][j]==-2){
					nReturnData[i][j]=0;
				}
				System.out.print(nReturnData[i][j]);
			}
			System.out.println();
		}
		return nReturnData;
	}
}
