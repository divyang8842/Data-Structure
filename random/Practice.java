package random;

public class Practice {

	public double sumOfAllElementIn2DArray(int[][] dataArry,int x,int y){
		double sum = 0;
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j+=2){
				if(j==y-1){
					sum+=dataArry[i][j];
				}else{
					sum+=dataArry[i][j]+dataArry[i][j+1];
				}
				
			}
		}
		return sum;
	}
	
	public static void main(String str[]){
		Practice obj = new Practice();
		int[][]data = {{1,2,3,13},{4,5,6,14},{7,8,9,15},{10,11,12,16}};
		System.out.println(obj.sumOfAllElementIn2DArray(data, 4, 4));
	}
}
