package stringOperations;

public class KMPAlgo {
	private int[] prefix_Table(char[] p,int m){
		int[] f = new int[m];
		int i=1,j=0;
		while(i<m){
			if(p[i]==p[j]){
				f[i] = j+1;
				i++;
				j++;
			}else if(j>0){
				j= f[j-1];
			}else{
				f[i] = 0;
				i++;
			}
		}
		return f;
	}
	
	private int KMP(char T[],int n,char P[],int m){
		int i=0;
		int j=0;
		int[] F = prefix_Table(P, m);
		while(i<n){
			if(T[i]==P[j]){
				if(j==m-1){
					return i-j;
				}else{
					i++;
					j++;
				}
			}else if(j>0){
				j= F[j-1];
			}else{
				i++;
			}
		}
		
		return -1;
	}
}
