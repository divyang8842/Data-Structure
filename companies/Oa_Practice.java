package companies;

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
