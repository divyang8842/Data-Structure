package gfg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
https://practice.geeksforgeeks.org/problems/smallest-positive-missing-number/0
*/
public class SmallestPossibleMissing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nTestCases = sc.nextInt();
		while (nTestCases-- > 0) {
			List<Integer> list = new ArrayList<Integer>();

			int nMax = 0;
			int nNumberOfElements = sc.nextInt();
			while (nNumberOfElements-- > 0) {
				int nCurrent = sc.nextInt();
				if (nCurrent > 0) {
					if (nMax < nCurrent) {
						nMax = nCurrent;
					}
					list.add(nCurrent);
				}
			}
			int nReturn = 0;
			// if(nMax-nTotal >1 || nReturn<0){
			for (int i = 1; i < nMax; i++) {
				if (!list.contains(i)) {
					nReturn = i;
					break;
				}
			}
			// }

			System.out.println(nReturn);
		}
		sc.close();
	}

}
