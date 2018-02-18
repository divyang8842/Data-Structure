package gfg;

import java.util.HashMap;
import java.util.Scanner;
/*
https://practice.geeksforgeeks.org/problems/triplet-sum-in-array/0/?ref=self
*/
public class Find3WithSumK {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nTestCases = sc.nextInt();
		while (nTestCases-- > 0) {
			int nLength = sc.nextInt();
			int nK = sc.nextInt();
			int[] nData = new int[nLength];
			HashMap<Integer, Integer> givenData = new HashMap<Integer, Integer>();
			for (int i = 0; i < nLength; i++) {
				nData[i] = sc.nextInt();
				givenData.put(nData[i], givenData.getOrDefault(nData[i], 0) + 1);
			}
			boolean bFound = false;
			for (int i = 0; i < nLength; i++) {
				if (bFound) {
					break;
				}
				givenData.put(nData[i], givenData.getOrDefault(nData[i], 0) - 1);
				for (int j = 0; j < nLength; j++) {
					if (givenData.get(nData[j]) > 0) {
						givenData.put(nData[j],
								givenData.getOrDefault(nData[j], 0) - 1);
						if (givenData.containsKey(nK - nData[i] - nData[j])
								&& givenData.get(nK - nData[i] - nData[j]) > 0) {
							bFound = true;
							break;
						}
						givenData.put(nData[j],
								givenData.getOrDefault(nData[j], 0) + 1);
					}
				}
				givenData
						.put(nData[i], givenData.getOrDefault(nData[i], 0) + 1);
			}
			System.out.println(bFound ? 1 : 0);
		}
		sc.close();
	}

}
