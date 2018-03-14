package companies;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

import tree.BinaryTree;
import tree.BinaryTreeNode;

public class Oa_Practice {
	
	//#### Binary tree serialization and deserialization 
	public String serialization(BinaryTreeNode<Integer> root) {
		StringBuffer sbReturn  =  new StringBuffer();
		if(root!=null) {
			sbReturn.append("(");
			if(root.getData()!=Integer.MIN_VALUE) {
				sbReturn.append(root.getData());
				if(root.getLeft()!=null) {
					sbReturn.append(serialization(root.getLeft()));
				}
				if(root.getRight()!=null) {
					sbReturn.append(serialization(root.getRight()));
				}
			}
			
			sbReturn.append(")");
		}
		return sbReturn.toString();
	}
	
	
	public BinaryTreeNode<Integer> deserialization(String strInput){
		BinaryTreeNode<Integer> root = null;
		if(strInput!=null && strInput.trim().length()>2) {
			strInput =  strInput.trim();
			int nLength = strInput.length();
			root = new BinaryTreeNode<>();
			deserialization_Helper(strInput, root, 1, nLength);
		}
		return root;
	}
	
	public int deserialization_Helper(String strInput,BinaryTreeNode<Integer> root, int nCurrentIndex,int nLength){
		if(nLength == nCurrentIndex) {
			return nLength;
		}
		if(strInput.charAt(nCurrentIndex)!='(' && strInput.charAt(nCurrentIndex)!=')') {
			String strData =  String.valueOf(strInput.charAt(nCurrentIndex));
			root.setData(Integer.parseInt(strData));
			nCurrentIndex++;
		}
		if(strInput.charAt(nCurrentIndex)=='(') {
			BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>();
			nCurrentIndex = deserialization_Helper(strInput, newNode, nCurrentIndex+1,nLength);
			root.setLeft(newNode);
			newNode = new BinaryTreeNode<Integer>();// right child
			nCurrentIndex = deserialization_Helper(strInput, newNode, nCurrentIndex+1,nLength);
			root.setRight(newNode);
		}
		return nCurrentIndex+1;
	}
	//#### End
	
	
	//##Write a code to check whether the given tree is Binary Search Tree or not.  
	public boolean isBinaryTree(BinaryTreeNode<Integer> root) {
		if(root!=null) {
			isBinaryTree_Helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		return true;
	}
	
	public boolean isBinaryTree_Helper(BinaryTreeNode<Integer> root, int nMAx,int nMin) {
		if(root!=null) {
			return (
					root.getData()>nMin && 
					root.getData()< nMAx && 
					isBinaryTree_Helper(root.getLeft(), root.getData(), nMin) && 
					isBinaryTree_Helper(root.getRight(), nMAx, root.getData())
					); 
		}
		return true;
	}
	//## End
	
	
	
	
	
	
	//##End
	
	//##given an array and window size, pass the window all over the array and print the max element in the window in O(n)  
	public void printMaxInWindow(int[] nInputArry, int nWindowSize) {
		
		//length of input window
		int nLength =  nInputArry.length;
		
		//Variable used to track current index element
		int nCurrentIndex = 0;
		
		//checking for windows side is less the total length
		if(nWindowSize>nLength) {
			nWindowSize = nLength;
		}
		
		// a queue to store current window
		Deque<Integer> queueWindow =  new LinkedList<Integer>();
		
		//adding first window in queue
		while(nCurrentIndex<nWindowSize) {
			
			// For very element, the previous smaller elements are useless so
            // remove them from Qi
			while(!queueWindow.isEmpty() && nInputArry[nCurrentIndex]>= nInputArry[queueWindow.peekLast()]) {
				queueWindow.removeLast();
			}
			//adding current index in queue
			queueWindow.addLast(nCurrentIndex++);
		}
		
		
		//processing remaining elements
		while(nCurrentIndex<nLength) {
			
			//printing max for previous window
			System.out.println(nInputArry[queueWindow.peek()]);
			
			//removing elements out of the window
			while(!queueWindow.isEmpty() && queueWindow.peek() <= nCurrentIndex - nWindowSize) {
				queueWindow.remove();
			}
			
			//remove all elements which are smaller then the element being added
			while(!queueWindow.isEmpty() && nInputArry[nCurrentIndex]>= nInputArry[queueWindow.peekLast()]) {
				queueWindow.removeLast();
			}
			
			queueWindow.addLast(nCurrentIndex++);
		}
		
		// Print the maximum element of last window
        System.out.print(nInputArry[queueWindow.peek()]);
		
	}
	
	
	//##End
	
	
	//##find an subarray with size of n in an array, calculate the products of elements in the subarray, return the subarray whose products has most 0s  
	public int[] findSubArray(int[] nInputArry, int nWindowSize) {
		int[] nReturnArr = new int[nWindowSize];
		int nStart = 0;
		int nEnd =  nWindowSize;
		int nMaxZero = 0;
		int nLength = nInputArry.length;
		
		if(nLength<nWindowSize) {
			nWindowSize = nLength;
		}
		//putting first window in consideration
		int nCurrentIndex = 0;
		BigInteger nMulti =  new BigInteger("0");
		while(nCurrentIndex<nWindowSize) {
			nMulti = nMulti.multiply(new BigInteger(String.valueOf(nInputArry[nCurrentIndex])));
			nCurrentIndex++;
		}
		
		String strMulti =  nMulti.toString();
		int nCurrntZero = 0;
		while(nCurrentIndex<nLength) {
			nCurrntZero = strMulti.length() - strMulti.replace("0", "").length();
			if(nCurrntZero > nMaxZero) {
				nMaxZero = nCurrntZero;
				nEnd = nCurrentIndex-1;
				nStart =  nCurrentIndex-nWindowSize;
			}
			nMulti = nMulti.divide(new BigInteger(String.valueOf(nInputArry[nCurrentIndex-nWindowSize])));
			nMulti = nMulti.multiply(new BigInteger(String.valueOf(nInputArry[nCurrentIndex])));
			strMulti =  nMulti.toString();
			nCurrentIndex++;
		}
		
		while(nStart<=nEnd) {
			nReturnArr[nStart] = nInputArry[nStart];
			nStart++;
		}
		
		return nReturnArr;
	}
	//## End
	
	//##SubArray with Max Sum
	public int findMaxSubArrySum(int[] nInptArr) {
		int nMaxSum = 0;
		int nCurrentSum = 0;
		int nLength =  nInptArr.length;
		for(int i=0;i<nLength;i++) {
			nCurrentSum =  Math.max(nCurrentSum+nInptArr[i], nInptArr[i]);
			nMaxSum = Math.max(nCurrentSum, nMaxSum);
		}
		return nMaxSum;
	}
	
	//End
	
	//find the next higher number from given number digits
	public int findNextGreaterElement(int nInput) {
		String strInput =  String.valueOf(nInput);
		int nLength = strInput.length();
		
		//starting from right, find the 1st element which is smaller then element in the right of it
		int i=nLength-1;
		for(;i>0;i--) {
			if(strInput.charAt(i) > strInput.charAt(i-1)) {
				break;
			}
		}
		
		
		//if no such element is available then all digits are in descending order and we can not have greater value then itself
		if(i==0) {
			return -1;
		}
		
		
		//find the smallest element which is greater then element at i
		char cSwappingNumber = strInput.charAt(i-1);
		int nCurrentIndex = i;
		for(int j=i;j<nLength;j++) {
			if(strInput.charAt(j) > cSwappingNumber && strInput.charAt(j) < strInput.charAt(nCurrentIndex)) {
				nCurrentIndex = j;
			}
		}
		
		strInput = swapAndSort(strInput,nCurrentIndex,i-1,nLength);
		
		return Integer.parseInt(strInput);
	}
	private String swapAndSort(String strInput,int nCurrentIndex,int nSwapIndex,int nLength) {
		char[] data = strInput.toCharArray();
		char temp =  data[nCurrentIndex];
		data[nCurrentIndex] = data[nSwapIndex];
		data[nSwapIndex] = temp;
		Arrays.sort(data,nSwapIndex+1,nLength);
		StringBuilder sbOP =  new StringBuilder();
		for(int i=0;i<nLength;i++) {
			sbOP.append(data[i]);
		}
		return sbOP.toString();
	}
	
	//End
	
	//##Find the largest subarray with k sum
	public int findLargestSubArray(int[] nInputArry,int nK) {
		
		// Variable with output
		int nMaxLength = 0; 
		// length of input array
		int nLength =  nInputArry.length; 
		// Variable to get track of urrent Sum
		int nSum = 0;
		//Map to keep track of Sum on each level
		HashMap<Integer, Integer> mapSum =  new  HashMap<>();
		
		for(int i=0;i<nLength;i++) {
			//keep adding element in sum
			nSum+= nInputArry[i];
			
			// if we found the sum then change the length
			if(nSum == nK) { 
				nMaxLength = i+1;
			}else {
				//check if in past we get any sum which is nK less then current sum
				// which means the interval between those index generates sum nK
				Integer nPreviousIndex = mapSum.get(nSum - nK);
				//if we found the previous sum
				if(nPreviousIndex!=null) {
					//change the max length is necessary
					nMaxLength = Math.max(nMaxLength, i - nPreviousIndex);
				}
				if(!mapSum.containsKey(nSum)){
					// only put entry for the sum for 1st occurrence
					mapSum.put(nSum, i);
				}
			}
		}
		return nMaxLength;
	}
	//##End
	
	//##fibonacci series 4 ways
	public int fibonacci1(int nNumber) {
		HashMap<Integer, Integer> mapFibo =  new HashMap<>();
		return fibonacci1_helper(nNumber, mapFibo);
	}
	
	private int fibonacci1_helper(int nNumber,HashMap<Integer, Integer> mapFibo) {
		
		if(mapFibo.containsKey(nNumber)) {
			return mapFibo.get(nNumber);
		}
		if(nNumber==2) {
			return 1;
		}else if(nNumber==1 || nNumber == 0) {
			return nNumber;
		}
		int nK = (nNumber%2 == 0)?nNumber/2 : (nNumber+1)/2;
		int nFibo = 0;
		if(nNumber%2==1) {
			nFibo = fibonacci1_helper(nK,mapFibo) * fibonacci1_helper(nK,mapFibo) +  fibonacci1_helper(nK-1,mapFibo) * fibonacci1_helper(nK-1,mapFibo);
		}else {
			nFibo = fibonacci1_helper(nK,mapFibo)*(2*fibonacci1_helper(nK-1,mapFibo)+fibonacci1_helper(nK,mapFibo));
		}
		mapFibo.put(nNumber, nFibo);
		return nFibo;
	}
	
	public int fibonacci2(int nNumber) {
		int[] nFiboArr =  new int[nNumber];
		for(int i=0;i<nNumber;i++) {
			nFiboArr[i] = -1;
		}
		return fibonacci2_helper(nNumber-1, nFiboArr);
	}
	
	private int fibonacci2_helper(int nNumber,int[] nFiboArr) {
		
		if(nFiboArr[nNumber]>=0) {
			return nFiboArr[nNumber];
		}
		if(nNumber == 2) {
			return 1;
		}else if(nNumber==1 || nNumber==0) {
			return nNumber;
		}else {
			nFiboArr[nNumber] = fibonacci2_helper(nNumber-1, nFiboArr) + fibonacci2_helper(nNumber-2, nFiboArr);
			return nFiboArr[nNumber];
		}
	}
	
	public int fibonacci3(int nNumber) {
		int nNum1 = 0;
		int nNum2 = 1;
		for(int i=2;i<nNumber;i++) {
			nNum2 = nNum1+nNum2;
			nNum1 = nNum2 - nNum1;
		}
		return nNum2;
		
	}
	
	
	//##End
	
	public static void main(String str[]) {
		BinaryTree<Integer> bTree = new BinaryTree<Integer>();
		BinaryTreeNode<Integer> root = bTree.insert(null, 1);
		bTree.insert(root, 2);
		bTree.insert(root, 3);
		bTree.insert(root, 4);
		bTree.insert(root, 5);
		bTree.insert(root, 6);
		bTree.insert(root, 7);
		bTree.insert(root, 8);
		bTree.insert(root, 9);
	
		
		Oa_Practice obj = new Oa_Practice();
		String strSerialized =  obj.serialization(root);
		System.out.println("Tree before ");
		bTree.levelOrderTraversal(root);

		System.out.println(strSerialized);
		
		bTree.levelOrderTraversal(obj.deserialization(strSerialized));
		
		
		 int arr[]={12, 1, 78, 90, 57, 89, 56};
	     int k=3;
	     obj.printMaxInWindow(arr, k);
	     System.out.println();
	     
	     int arr1[] = {15, -2, 2, -8, 1, 7, 10, 23};
	     System.out.println(obj.findLargestSubArray(arr1, 0));
	     
	     
	     System.out.println("fibo is "+obj.fibonacci2(5));
	}
}
