package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T extends Number & Comparable<? super Number>> {
	
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
	
	public void levelOrderTraversal(BinaryTreeNode<T> root){
		Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
		if(root==null){
			System.out.println("Tree is empty...");
		}
		queue.offer(root);
		queue.offer(null);
		while(!queue.isEmpty()){
			BinaryTreeNode<T> current = queue.poll();
			if(current==null){
				System.out.println("");
				queue.offer(null);
			}else{
				System.out.print(current.getData()+" ");
				if(current.getLeft()!=null){
					queue.offer(current.getLeft());
				}
				if(current.getRight()!=null){
					queue.offer(current.getRight());
				}
			}
		}
	}
	
	
	public T findMax(BinaryTreeNode<T> root){
		Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
		if(root==null){
			System.out.println("Tree is empty...");
		}
			queue.offer(root);
			T max;
			max =  root.getData();
			while (!queue.isEmpty()) {
				BinaryTreeNode<T> current = queue.poll();
				if (current.getLeft() != null) {
					queue.offer(current.getLeft());
				}
				if (current.getRight() != null) {
					queue.offer(current.getRight());
				}
				if (max.compareTo(current.getData()) < 0) {
					max = current.getData();
					
				}
			}
		return max;
	}
	
	public Number findMaxRec(BinaryTreeNode<T> root){
		Number max = 0;
		if(root!=null){
			T leftMax =  extractedT( findMaxRec(root.getLeft()));
			T rightMax =  extractedT(findMaxRec(root.getRight()));
			max = root.getData();
			
			if(extracted(max).compareTo(leftMax)<0){
				max = leftMax;
			}
			
			if(extracted(max).compareTo(rightMax)<0){
				max = rightMax;
			}
		}
		return max;
	}

	private Comparable<? super Number> extracted(Number max) {
		return (Comparable<? super Number>) max;
	}
	private T extractedT(Number max) {
		return (T) max;
	}
	
	
	public int size(BinaryTreeNode<T> root){
		int size = 0;
		if(root!=null){
			size = 1+size(root.getLeft()) + size(root.getRight());
		}
		return size;
	}
	
	public int depth(BinaryTreeNode<T> root){
		int height = 0;
		if(root!=null){
			height = 1+Math.max(depth(root.getLeft()) , depth(root.getRight())) ;
		}
		return height;
	}
	
	public void levelOrderReverseTraversal(BinaryTreeNode<T> root){
		Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
		Stack<BinaryTreeNode<T>> stack =  new Stack<BinaryTreeNode<T>>();
		if(root==null){
			System.out.println("Tree is empty...");
		}
		queue.offer(root);
		queue.offer(null);
		stack.push(null);
		stack.push(root);
		stack.push(null);
		while(!queue.isEmpty()){
			BinaryTreeNode<T> current = queue.poll();
			if(current==null){
				stack.push(null);
				//System.out.println("");
				queue.offer(null);
			}else{
				//System.out.print(current.getData()+" ");
				stack.push(current);
				if(current.getLeft()!=null){
					queue.offer(current.getLeft());
				}
				if(current.getRight()!=null){
					queue.offer(current.getRight());
				}
			}
		}
		
		while(!stack.isEmpty()){
			BinaryTreeNode<T> current =  stack.pop();
			StringBuilder sbLevel =  new StringBuilder();
			if(current==null){
				System.out.println(sbLevel.toString());
				sbLevel =  new StringBuilder();
			}else{
				sbLevel = new StringBuilder(String.valueOf(current.getData()) + sbLevel);
				//System.out.print(current.getData()+" ");
			}
		}
	}
	
	
	
}
