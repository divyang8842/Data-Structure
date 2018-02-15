package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Random {
	
	public static void main(String args[]){
		  Random mc = new Random();
			//int[][] testString = { { 5, 4, 4 }, { 4, 3, 4 }, { 3, 2, 4 },
				//	{ 2, 2, 2 }, { 3, 3, 4 }, { 1, 4, 4 }, { 4, 1, 1 } };
			//System.out.println(mc.solution(testString));
			
			System.out.println(mc.solution2("a0Ba"));  
	  }

	
	//This function is used to mark down the visited cells in every isolated country
	// it do recursive call to itself for every possible side of neighbor
	// Note : this function updates the Copy Array 
	//@Params : 
	// A : Original 2d array provided by code
	// nCopyArry :  Copy of original array which is being modified in this function
	// nCurrentRow : Row number of current area which we are checking
	// nCurrentCol : Column number of current area which we are checking
	// nRows : Total rows in whole map
	// nCols : Total Columns in whole map
	public void getOtherAreaOfCountry(int A[][], int nCopyArry[][], int nCurrentRow, int nCurrentCol, int nRows, int nCols) {

		// if current area is already visited then return without doing anything
		if (nCopyArry[nCurrentRow][nCurrentCol] == -1){
			return;
		}
		//mark area as visited
		nCopyArry[nCurrentRow][nCurrentCol] = -1;

		//check for north side area
		if (nCurrentRow - 1 >= 0 && A[nCurrentRow - 1][nCurrentCol] == A[nCurrentRow][nCurrentCol]){
			getOtherAreaOfCountry(A, nCopyArry, nCurrentRow - 1, nCurrentCol, nRows, nCols);
		}
		
		//check for south side area 
		if (nCurrentRow + 1 < nRows && A[nCurrentRow + 1][nCurrentCol] == A[nCurrentRow][nCurrentCol]){
			getOtherAreaOfCountry(A, nCopyArry, nCurrentRow + 1, nCurrentCol, nRows, nCols);
		}
		
		//check for west side area
		if (nCurrentCol + 1 < nCols && A[nCurrentRow][nCurrentCol + 1] == A[nCurrentRow][nCurrentCol]){
			getOtherAreaOfCountry(A, nCopyArry, nCurrentRow, nCurrentCol + 1, nRows, nCols);
		}
				
		//check for east side area
		if (nCurrentCol - 1 >= 0 && A[nCurrentRow][nCurrentCol - 1] == A[nCurrentRow][nCurrentCol]){
			getOtherAreaOfCountry(A, nCopyArry, nCurrentRow, nCurrentCol - 1, nRows, nCols);
		}
				
	}

	public int solution(int[][] A) {
		
		//check for null array
		if(A==null){
			return 0;
		}
		
		//country count
		int nCountryCount = 0;
		
		//number of rows in array
		int nRows = A.length;
		if(nRows<1){// return 0 if array is empty
			return 0;
		}
			
		
		int nCols = A[0].length; // number of columns
		if (nCols<1){//return 0 if array has no column
			return 0;
		}
			
		// generate a new Copy array to keep track of visited area of each isolated country
		int[][] copyArr = new int[nRows][nCols]; 
		for (int n = 0; n < nRows; n++) {
			for (int m = 0; m < nCols; m++){
				copyArr[n][m] = A[n][m];
			}
		}
		
		//iterate through the map and chec for every area
		for (int i = 0; i < nRows; i++){
			for (int j = 0; j < nCols; j++) {
				if (copyArr[i][j] >= 0) {//only allow to check other country area id current area is not part of any existing country
					getOtherAreaOfCountry(A, copyArr, i, j, nRows, nCols); // recursive call to new function to mark down all the area of country
					nCountryCount++;// increasing country count
				}
			}
		}
			
		return nCountryCount;
	}
	
	public int solution1(int[] A, int[] B, int M, int X, int Y) {

		long lTotalWeight = 0l;// total weight count of all persons in lift
		int nPersonCount = 0;  // total persons in the lift
		int nLiftStops = 0;   // total list stops
		
		Set<Integer> floorSet = new HashSet<Integer>(); //set will store distinct floor
		int nCurrentPerson = 0; // current person to be considered
		int nLength = A.length; // Total person in queue
		boolean isLiftFull = false;// variable to determine the lift is full or not
		while (nCurrentPerson < nLength) {
			//check if list is full either weight wise or number of person wise
			if ((lTotalWeight + A[nCurrentPerson]) <= Y && (nPersonCount + 1) <= X) {
				lTotalWeight += A[nCurrentPerson];//adding person's weight to total weight
				nPersonCount++;//increasing person count
				floorSet.add(B[nCurrentPerson]); // adding the floor for person in Set
				
				// If current person is last person then start the lift
				if (nCurrentPerson == nLength - 1){
					isLiftFull = true;
				}
				nCurrentPerson++;
			} else {
				isLiftFull = true;
			}

			if (isLiftFull) { // if list is full, go to each stop and count it
				nLiftStops += floorSet.size() + 1; // total stops plus one at ground floor : Here set is storing distinct floors and size will give us that
				floorSet.clear(); // need to clear the set for new tyurn
				nPersonCount = 0; // reinitializing person count to 0
				lTotalWeight = 0l; // reinitializing wiight to 0
				isLiftFull = false; // lift is empty
			}
		}

		return nLiftStops;
	}
	
	public int solution2(String S) {

		int nCurrent = 0;
		int nMaxPasswordLength = -1;
		int nUpperCount = 0;
		int nLength = S.length();
		
		for (int i=0;i <= nLength;i++) {
			if (i == nLength || Character.isDigit(S.charAt(i))) {
				if (nUpperCount>0 && i > nCurrent && i - nCurrent > nMaxPasswordLength) {
					nMaxPasswordLength = i - nCurrent;
				}
				nCurrent = i + 1;
				nUpperCount = 0;
			} else if (Character.isUpperCase(S.charAt(i))) {
				nUpperCount = 1;
			}
		}
		if (nMaxPasswordLength > 0)
			return nMaxPasswordLength;
		else
			return -1;
	}

	  

}
