package companies;

import java.util.Deque;
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
			while(!queueWindow.isEmpty() && nInputArry[nCurrentIndex]> queueWindow.peekLast()) {
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
			while(!queueWindow.isEmpty() && nInputArry[nCurrentIndex]> queueWindow.peekLast()) {
				queueWindow.removeLast();
			}
			
			queueWindow.addLast(nCurrentIndex++);
		}
		
		// Print the maximum element of last window
        System.out.print(nInputArry[queueWindow.peek()]);
		
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
		
	}
}
