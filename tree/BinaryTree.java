package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
	
	public void inOrderTraversal(BinaryTreeNode<T> root){
		if(root!=null){
			inOrderTraversal(root.getLeft());
			System.out.println(root.getData());
			inOrderTraversal(root.getRight());
		}
	}
	
	public void preOrderTraversal(BinaryTreeNode<T> root){
		if(root!=null){
			System.out.println(root.getData());
			inOrderTraversal(root.getLeft());
			inOrderTraversal(root.getRight());
		}
	}
	
	public void postOrderTraversal(BinaryTreeNode<T> root){
		if(root!=null){
			inOrderTraversal(root.getLeft());
			inOrderTraversal(root.getRight());
			System.out.println(root.getData());
		}
	}
	
/*	public void levelOrderTraversal(BinaryTreeNode<T> root){
		Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
		
		
	}*/
}
