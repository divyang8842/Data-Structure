package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AVLTree<T  extends Number> {
	
	
	
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
		root.setHeight(Math.max(getHeightOfTree(root.getLeft()),getHeightOfTree(root.getRight()))+1);
		left.setHeight(Math.max(getHeightOfTree(left.getLeft()), getHeightOfTree(left.getRight()))+1);
		
		return left;
		
	}
	
	public AVLBinaryTreeNode<T> SingleRightRotation(AVLBinaryTreeNode<T> root){
		AVLBinaryTreeNode<T> right = root.getRight();
		root.setRight(right.getLeft());
		right.setLeft(root);
		root.setHeight(Math.max(getHeightOfTree(root.getLeft()),getHeightOfTree(root.getRight()))+1);
		right.setHeight(Math.max(getHeightOfTree(right.getLeft()), getHeightOfTree(right.getRight()))+1);
		
		return right;
	} 
	
	public AVLBinaryTreeNode<T> RLRotation(AVLBinaryTreeNode<T> head){
		head.setLeft(SingleRightRotation(head.getLeft()));
		return SingleLeftRotation(head);
	}
	
	public AVLBinaryTreeNode<T> LRRotation(AVLBinaryTreeNode<T> head){
		head.setRight(SingleLeftRotation(head.getRight()));
		return SingleRightRotation(head);
	}
	
	
	public AVLBinaryTreeNode<T> insert(AVLBinaryTreeNode<T> head,T data){
		if(head==null){
			head =  new AVLBinaryTreeNode<T>();
			head.setData(data);
		}else{
			if(head.getData().doubleValue()>data.doubleValue()){
				head.setLeft(insert(head.getLeft(), data));
			}else if(head.getData().doubleValue()<data.doubleValue()){
				head.setRight(insert(head.getRight(), data));
			}
		}
		
		int differenceFactor = getHeightDifference(head);
		//System.out.println("With head "+head.getData()+" the difference is "+differenceFactor);;
		if(differenceFactor==2){ //left tree is having defect
			if(data.doubleValue() <head.getLeft().getData().doubleValue()){
				head = SingleLeftRotation(head);
			}else{
				head =  RLRotation(head);
			}
		}else if(differenceFactor==-2){//Right tree is having defect
			if(data.doubleValue() <head.getRight().getData().doubleValue()){
				head = SingleRightRotation(head);
			}else{
				head =  LRRotation(head);
			}
		}
		
		head.setHeight(Math.max(getHeightOfTree(head.getLeft()),getHeightOfTree(head.getRight()))+1);
		return head;
	}
	
	public void levelOrderReverseTraversal(AVLBinaryTreeNode<T> root){
		Queue<AVLBinaryTreeNode<T>> queue = new LinkedList<AVLBinaryTreeNode<T>>();
		Stack<AVLBinaryTreeNode<T>> stack =  new Stack<AVLBinaryTreeNode<T>>();
		if(root==null){
			System.out.println("Tree is empty...");
		}
		queue.offer(root);
		queue.offer(null);
		
		stack.push(null);
		int nLevelCount = 0;
		while(!queue.isEmpty()){
			AVLBinaryTreeNode<T> current = queue.poll();
			if(current==null){
				stack.push(null);
				if(nLevelCount == 0){
					nLevelCount++;
					queue.offer(null);
				}
				//System.out.println("");
				
			}else{
				nLevelCount = 0;
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
			AVLBinaryTreeNode<T> current =  stack.pop();
			if(current==null){
				System.out.println("");
			}else{
				System.out.print(current.getData()+" ");
			}
		}
	}
	
	
	
	public static void main(String str[]){
		AVLTree<Integer> tree = new AVLTree<Integer>();
		AVLBinaryTreeNode<Integer> head = null;
		head = tree.insert(head, 8);
		head = tree.insert(head, 7);
		tree.levelOrderReverseTraversal(head);
		head = tree.insert(head, 6);
		tree.levelOrderReverseTraversal(head);
		head = tree.insert(head, 5);
		tree.levelOrderReverseTraversal(head);
		head = tree.insert(head, 4);
		tree.levelOrderReverseTraversal(head);
		head = tree.insert(head, 3);
		tree.levelOrderReverseTraversal(head);
		head = tree.insert(head, 2);
		tree.levelOrderReverseTraversal(head);
		head = tree.insert(head, 1);
		tree.levelOrderReverseTraversal(head);
		head = tree.insert(head, 0);
		tree.levelOrderReverseTraversal(head);
	}
}
