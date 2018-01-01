package tree;

public class AVLTree<T> extends BinarySearchTree<Number>{
	
	
	
	public int getHeightOfTree(AVLBinaryTreeNode<T> head){
		
		if(head==null){
			return -1;
		}else{
			return head.getHeight();
		}
	}
	
	public int getHeightDifference(AVLBinaryTreeNode<T> head){
		int left =  0;
		int right = 0;
		if(head.getLeft()!=null){
			left =  head.getLeft().getHeight();
		}
		if(head.getRight()!=null){
			right =  head.getRight().getHeight();
		}
		return left-right;
	}
}
