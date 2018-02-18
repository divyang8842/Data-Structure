package gfg;

import java.util.Scanner;

public class NextLargestElement {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int nTestCases = sc.nextInt();
		while (nTestCases-- > 0) {
			int nLength = sc.nextInt();
			int[] nData = new int[nLength];
			
			for(int i=0;i<nLength;i++){
				nData[i] = sc.nextInt();
			}
			
			StringBuffer sbOP =  new StringBuffer();
			boolean bFound = false;
			for(int i=0;i<nLength;i++){
				bFound = false;
				for(int j=i+1;j<nLength;j++){
					if(nData[i] < nData[j]){
						sbOP.append(nData[j]+" ");
						bFound = true;
						break;
					}
				}
				if(!bFound){
					sbOP.append(-1+" ");
				}
			}
			System.out.println(sbOP.toString().trim());
		}
		sc.close();
	}
}
