package companies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode {

	// ##String to Integer (atoi)
	public int stringToInteger(String str) {

		// given string i null
		if (str == null) {
			return 0;
		}

		// given string is blank string
		str = str.trim();
		int nLength = str.length();
		if (nLength == 0) {
			return 0;
		}

		// string contains one character and its not digit
		char[] dataArr = str.toCharArray();
		if (nLength == 1 && !Character.isDigit(dataArr[0])) {
			return 0;
		}

		int nCurrentDigit = 0;
		int nSign = 1;
		Long nNumber = new Long(0);

		int i = 0;
		// first character is sign (+/-)
		if (dataArr[0] == '-' || dataArr[0] == '+') {
			if (dataArr[0] == '-') {
				nSign = -1;
			}
			i++;
		}

		int nMAX = Integer.MAX_VALUE;
		int nMIN = Integer.MIN_VALUE;
		for (; i < nLength; i++) {
			// if any character appears which is not digit
			if (!Character.isDigit(dataArr[i])) {
				return (nSign * nNumber.intValue());
			}
			nCurrentDigit = dataArr[i] - '0';
			// System.out.println(nNumber + " * "+nBase +" + "+nCurrentDigit );
			nNumber = nNumber * 10 + nCurrentDigit;
			if (nSign == 1 && (nSign * nNumber) > nMAX) {
				return nMAX;
			}

			if (nSign == -1 && (nSign * nNumber) < nMIN) {
				return nMIN;
			}

		}
		return (nSign * nNumber.intValue());

	}

	// ##End

	// ##IsValid Number

	public boolean isNumber(String strNumber) {
		// if input is null
		if (strNumber == null) {
			return false;
		}
		// removing extra spaces from the input
		strNumber = strNumber.trim();
		// getting length of the input
		int nLength = strNumber.length();
		// if input is empty string
		if (nLength == 0) {
			return false;
		}
		// if input has only one character and its not a digit
		if (nLength == 1 && !Character.isDigit(strNumber.charAt(0))) {
			return false;
		}

		// if first character of number is not a digit, '+', '-', '.'
		if (!Character.isDigit(strNumber.charAt(0)) && strNumber.charAt(0) != '+' && strNumber.charAt(0) != '-'
				&& strNumber.charAt(0) != '.') {
			return false;
		}

		// check if dot or e is coming for 1time and also . comes before e
		// boolean to check Dot
		boolean isDot = false;
		// boolean to check e
		boolean isE = false;

		int i = 1;
		if (strNumber.charAt(0) == '.') {
			i = 0;
		}
		for (; i < nLength; i++) {
			if (strNumber.charAt(i) == '.') {
				// valid number can not have dot for 2 times
				// also dot can not appear after e
				if (isDot || isE) {
					return false;
				} else {
					isDot = true;

					// 5.
					if (i == nLength - 1) {
						// -.
						if (i > 0 && !Character.isDigit(strNumber.charAt(i - 1))) {
							return false;
						}
						return true;
					}

					// .e1 , 5.e , 2.e
					if (i != 0 && strNumber.charAt(i + 1) == 'e') {
						continue;
					}
					i++;
					// number after : 5.q, 5.y
					if (!Character.isDigit(strNumber.charAt(i))) {
						return false;
					}

				}
			} else if (strNumber.charAt(i) == 'e') {
				// valid number can not have e two times
				if (isE) {
					return false;
				}

				// -e58
				if (strNumber.charAt(i - 1) == '+' || strNumber.charAt(i - 1) == '-') {
					return false;
				}

				// e can not be last character of number
				if (i == nLength - 1) {
					return false;
				}
				i++;
				// 5e+
				if (strNumber.charAt(i) == '+' || strNumber.charAt(i) == '-') {
					if (i == nLength - 1) {
						return false;
					}
				} else if (!Character.isDigit(strNumber.charAt(i))) {
					return false; // 5e., 5ee
				}
				isE = true;

			} else if (!Character.isDigit(strNumber.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	// ##Regex implementation with * and . support
	public static boolean isMatch(String s, String p) {

		char[] cArrS = s.toCharArray();
		char[] cArrP = p.toCharArray();

		int nPLength = cArrP.length;
		int nSLength = cArrS.length;

		int nP = 0;
		int nS = 0;
		char nPreviousChar = '0';
		char nPreviousUsedChar = '0';
		boolean bStar = false;
		while (nP < nPLength && nS < nSLength) {
			// Matches any single character so skip it
			if (cArrP[nP] == '.') {
				nPreviousChar = '.';
				nS++;
			} else if (cArrP[nP] == '*') {
				if (nP == 0) {
					return false;
				} else {
					if (nPreviousChar == '.') {
						nPreviousChar = cArrS[nS];
						nS++;
					}

					while (nS < nSLength && cArrS[nS] == nPreviousChar) {
						nS++;
						bStar = true;
						nPreviousUsedChar = nPreviousChar;
						if (nP + 1 < nPLength && cArrP[nP + 1] == nPreviousChar) {
							nP++;
						}
					}
				}
			} else if (cArrP[nP] == cArrS[nS]) {
				nPreviousChar = cArrP[nP];
				nPreviousUsedChar = nPreviousChar;
				bStar = false;
				nS++;
			} else {
				if (cArrP[nP] != cArrS[nS] && nP + 1 < nPLength && cArrP[nP + 1] != '*') {
					return false;
				} else {
					nPreviousChar = cArrP[nP];

				}
			}
			nP++;
		}

		while (nP < nPLength) {
			if (cArrP[nP] != '*' && (nP + 1 >= nPLength || (nP + 1 < nPLength && cArrP[nP + 1] != '*'))) {
				if (!bStar || cArrP[nP] != nPreviousUsedChar) {
					return false;
				} else if (cArrP[nP] != '*') {
					nPreviousUsedChar = cArrP[nP];
				}
			} /*
				 * else if(cArrP[nP] == '*') { bStar = true; }
				 */
			nP++;
		}

		if (nS < nSLength) {
			return false;
		}

		return true;

	}

	// ##End

	// ##Find all combinations that add upto given number
	// Given a positive number, find out all combinations of positive numbers that
	// adds upto that number. The program should print only combinations, not
	// permutations. For example, for input 3, either 1, 2 or 2, 1 should be
	// printed.

	public static void printAllCombinationOfNumber(int nNumber) {
		int[] nArr = new int[nNumber];
		printAllCombinationOfNumber_Utils(nArr, 0, nNumber, nNumber);
	}

	public static void printAllCombinationOfNumber_Utils(int[] nArr, int nIndex, int nNumber, int nReducedNum) {

		if (nReducedNum < 0 || nIndex >= nNumber) {
			return;
		}
		if (nReducedNum == 0) {
			System.out.println(Arrays.toString(nArr));
			return;
		}
		int nPrev = (nIndex == 0) ? 1 : nArr[nIndex - 1];
		for (int i = nPrev; i <= nNumber; i++) {
			nArr[nIndex] = i;
			printAllCombinationOfNumber_Utils(nArr, nIndex + 1, nNumber, nReducedNum - i);
		}

	}
	// ##End

	// ##Find all combinations of numbers in a given array that add up to a given
	// number.
	public static void printAllCombinationOfElementAddUpInN(int[] nArr, int nNumber) {
		int nLength = nArr.length;
		int[] nResultArr = new int[nLength];
		printAllCombinationOfElementAddUpInN_Utils(nArr, nNumber, nNumber, nResultArr, nLength, 0);
	}

	public static void printAllCombinationOfElementAddUpInN_Utils(int[] nArr, int nNumber, int nReducedNumber,
			int[] nResult, int nLength, int nIndex) {
		if (nReducedNumber < 0) {
			return;
		}

		if (nReducedNumber == 0) {
			System.out.println(Arrays.toString(nResult));
			return;
		}

		for (int i = nIndex; i < nLength; i++) {
			nResult[nIndex] = nArr[i];
			if (nReducedNumber - nArr[i] < 0) {
				nResult[nIndex] = 0;
				break;
			}
			printAllCombinationOfElementAddUpInN_Utils(nArr, nNumber, nReducedNumber - nArr[i], nResult, nLength,
					i + 1);

		}
	}

	// ##

	// ## print all substring for a string
	public static void printAllSubstrings(String strData) {
		char[] cData = strData.toCharArray();
		int nLength = strData.length();
		char[] cSubString = new char[nLength];
		printAllSubstrings_util(cData, 0, cSubString, nLength);
	}

	public static void printAllSubstrings_util(char[] cData, int nCurrentIndex, char[] nSubString, int nLength) {
		for (int i = nCurrentIndex; i < nLength; i++) {
			nSubString[i] = cData[i];
			char[] cNewSub = new char[nLength];
			cNewSub[i] = cData[i];
			System.out.println(Arrays.toString(nSubString));
			System.out.println(Arrays.toString(cNewSub));
			printAllSubstrings_util(cData, nCurrentIndex + 1, nSubString, nLength);
			printAllSubstrings_util(cData, nCurrentIndex + 1, cNewSub, nLength);
		}

	}
	// ##End

	// ##Zigzag conversion
	public String convert(String s, int nRows) {
		char[] cArr = s.toCharArray();
		int nLength = cArr.length;

		StringBuilder sbOP[] = new StringBuilder[nRows];

		for (int i = 0; i < nRows; i++) {
			sbOP[i] = new StringBuilder();
		}

		int i = 0;
		while (i < nLength) {
			for (int j = 0; j < nRows && i < nLength; j++) {
				sbOP[j].append(cArr[i++]);
			}
			for (int j = nRows - 2; j > 0 && i < nLength; j--) {
				sbOP[j].append(cArr[i++]);
			}
		}

		for (i = 1; i < nRows; i++) {
			sbOP[0].append(sbOP[i]);
		}

		return sbOP[0].toString();

	}

	// ##End

	// ##Reverse an integer
	public int reverse(int x) {
		int nBase = 10;
		Long newNum = 0L;
		boolean bNeg = x < 0;
		int nMax = Integer.MAX_VALUE;
		if (bNeg) {
			x *= -1;
		}
		while (x > 0) {
			newNum = newNum * nBase + x % 10;
			if (newNum > nMax) {
				return 0;
			}
			x = x / 10;
		}

		if (bNeg) {
			newNum *= -1;
		}
		return newNum.intValue();
	}
	// ##

	// ##Unique tupples with Sum 0 in array
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> lstOP = new ArrayList<List<Integer>>();
		int nLength = nums.length;
		Arrays.sort(nums);
		// System.out.println(Arrays.toString(nums));
		for (int i = 0; i < nLength; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int nLow = i + 1;
			int nHi = nLength - 1;
			while (nHi > nLow) {
				int nCurrent = nums[i] + nums[nHi] + nums[nLow];

				if (nCurrent == 0) {
					List<Integer> currentLst = new ArrayList<Integer>();
					currentLst.add(nums[i]);
					currentLst.add(nums[nLow]);
					currentLst.add(nums[nHi]);
					lstOP.add(currentLst);

					nHi--;
					while (nHi > nLow && nums[nHi] == nums[nHi + 1]) {
						nHi--;
					}

					nLow++;
					while (nHi > nLow && nums[nLow] == nums[nLow - 1]) {
						nLow++;
					}

					// System.out.println("-->nHi : "+nHi);
					// System.out.println("-->nLow : "+nLow);

				} else if (nCurrent > 0) {
					nHi--;
					while (nHi > nLow && nums[nHi] == nums[nHi + 1]) {
						nHi--;
					}
				} else {
					nLow++;
					while (nHi > nLow && nums[nLow] == nums[nLow - 1]) {
						nLow++;
					}
				}
				// System.out.println("After nHi : "+nHi);
				// System.out.println("After nLow : "+nLow);
			}
		}
		return lstOP;
	}
	// ##End

	// ## Container With Most Water
	// Given n non-negative integers a1, a2, ..., an, where each represents a point
	// at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
	// of line i is at (i, ai) and (i, 0). Find two lines, which together with
	// x-axis forms a container, such that the container contains the most water.

	public int maxArea(int[] height) {
		int nLength = height.length;
		int nLeft = 0;
		int nRight = nLength - 1;
		int nMaxArea = 0;

		while (nRight > nLeft) {

			nMaxArea = Math.max(nMaxArea, Math.min(height[nRight], height[nLeft]) * (nRight - nLeft));
			if (height[nRight] > height[nLeft]) {
				nLeft++;
			} else {
				nRight--;
			}
		}

		return nMaxArea;
	}
	// ##End

	// ##Write a function to find the longest common prefix string amongst an array
	// of strings.
	public String longestCommonPrefix(String[] strs) {
		if (strs == null) {
			return "";
		}

		int nLength = strs.length;
		if (nLength == 0) {
			return "";
		}
		String strPre = strs[0];
		for (int i = 1; i < nLength; i++) {
			while (!strs[i].startsWith(strPre)) {
				strPre = strPre.substring(0, strPre.length() - 1);
			}
		}

		return strPre;
	}
	// ##End

	// ##3Sum Closest
	// Given an array S of n integers, find three integers in S such that the sum is
	// closest to a given number, target. Return the sum of the three integers. You
	// may assume that each input would have exactly one solution.
	public int threeSumClosest(int[] nums, int target) {
		int nLength = nums.length;
		Arrays.sort(nums); // n Lon n
		int nOP = Integer.MAX_VALUE;
		for (int i = 0; i < nLength; i++) {
			int nLeft = i + 1;
			int nRight = nLength - 1;
			while (nRight > nLeft) {
				int nCurrentSum = nums[i] + nums[nLeft] + nums[nRight];

				if (Math.abs(nCurrentSum - target) < Math.abs(nOP)) {
					nOP = nCurrentSum - target;
				}

				if (nCurrentSum > target) {
					nRight--;
				} else {
					nLeft++;
				}
			}

		}
		return nOP + target;
	}
	// ##End

	// ##Remove Nth Node From End of List
	// Given a linked list, remove the nth node from the end of list and return its
	// head.

	/**
	 * Definition for singly-linked list.
	 **/
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}

		int nIndex = 0;
		ListNode current = head;
		ListNode endNode = head;
		while (endNode != null) {
			endNode = endNode.next;
			if (nIndex > n) {
				current = current.next;
			}
			nIndex++;
		}

		if (nIndex == n) {
			return head.next;
		} else if (nIndex > n) {
			ListNode temp = current.next;
			current.next = temp.next;
			temp.next = null;
			temp = null;

		}
		return head;
	}
	// ##End

	// ##Remove Duplicates from Sorted Array II
	public int removeDuplicates(int[] nums) {

		if (nums == null) {
			return 0;
		}
		boolean bTwice = false;
		int nLength = nums.length;
		if (nLength < 3) {
			return nLength;
		}
		int nNewLength = 1;
		int nCurrent = nums[0];
		for (int i = 1; i < nLength; i++) {
			if (nCurrent == nums[i]) {
				if (bTwice) {
					continue;
				} else {
					bTwice = true;
				}

			} else {
				nCurrent = nums[i];
				bTwice = false;
			}
			nums[nNewLength] = nCurrent;
			nNewLength++;
		}
		return nNewLength;
	}
	// ##End
	
	//##Generate Parentheses
	public List<String> generateParenthesis(int n) {
        List<String> lstOP =  new ArrayList<String>();
        generateParenthesis_util(lstOP,"",0,0,n); 
        return lstOP;
    }
    
    private void generateParenthesis_util(List<String> lstOP,String strOP,int nOpen, int nClose,int nMax){
        if(strOP.length() == nMax*2){
            lstOP.add(strOP);
            return;
        }
        
        if(nOpen < nMax){
            generateParenthesis_util(lstOP,strOP+"(",nOpen+1,nClose,nMax);
        }
        
        if(nClose<nOpen){
            generateParenthesis_util(lstOP,strOP+")",nOpen,nClose+1,nMax);
        }
        
    }
    //##End

	public static void main(String str[]) {
		/*
		 * if(isMatch("a", "ab*a") ) { System.out.println("True"); }else {
		 * System.out.println("False"); }
		 * 
		 */

		// printAllCombinationOfNumber(5);
		// int[] nArr = {1,1,2,3,4,5,6,7};
		// printAllCombinationOfElementAddUpInN(nArr, 5);
		String strData = "abcd";
		printAllSubstrings(strData);

	}
}
