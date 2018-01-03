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
	
	public AVLBinaryTreeNode<T> SingleLeftRotation(AVLBinaryTreeNode<T> root){
		AVLBinaryTreeNode<T> left = root.getLeft();
		root.setLeft(left.getRight());
		left.setRight(root);
		root.setHeight(Math.max(root.getLeft().getHeight(),root.getRight().getHeight())+1);
		left.setHeight(Math.max(left.getLeft().getHeight(), left.getRight().getHeight())+1);
		
		return left;
		
	}
	
	public AVLBinaryTreeNode<T> SingleRightRotation(AVLBinaryTreeNode<T> root){
		AVLBinaryTreeNode<T> right = root.getRight();
		root.setRight(right.getLeft());
		right.setLeft(root);
		root.setHeight(Math.max(root.getLeft().getHeight(),root.getRight().getHeight())+1);
		right.setHeight(Math.max(right.getLeft().getHeight(), right.getRight().getHeight())+1);
		
		return right;
	} 
	
	public AVLBinaryTreeNode<T> RLRotation(AVLBinaryTreeNode<T> head){
		head.setLeft(SingleRightRotation(head.getLeft()));
		return SingleLeftRotation(head);
	}
}
