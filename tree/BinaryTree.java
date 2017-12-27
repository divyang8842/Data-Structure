package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*public class BinaryTree<T extends Number & Comparable<? super Number>> {*/
	
public class BinaryTree<T extends Number> {
	public void inOrderTraversal(BinaryTreeNode<T> root){
		if(root!=null){
			inOrderTraversal(root.getLeft());
			System.out.print(root.getData()+" ");
			inOrderTraversal(root.getRight());
		}
	}
	
	public void preOrderTraversal(BinaryTreeNode<T> root){
		if(root!=null){
			System.out.print(root.getData()+" ");
			inOrderTraversal(root.getLeft());
			inOrderTraversal(root.getRight());
		}
	}
	
	public void postOrderTraversal(BinaryTreeNode<T> root){
		if(root!=null){
			inOrderTraversal(root.getLeft());
			inOrderTraversal(root.getRight());
			System.out.print(root.getData()+" ");
		}
	}
	
	public void levelOrderTraversal(BinaryTreeNode<T> root){
		Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
		if(root==null){
			System.out.println("Tree is empty...");
		}
		queue.offer(root);
		queue.offer(null);
		int nLevelCount = 0;
		while(!queue.isEmpty()){
			BinaryTreeNode<T> current = queue.poll();
			if(current==null){
				System.out.println("");
				if(nLevelCount==0){
					nLevelCount++;
					queue.offer(null);	
				}
				
			}else{
				nLevelCount = 0;
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
				double dMax =  max.doubleValue();
				double data = current.getData().doubleValue();
				if (data>dMax) {
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
		int nLevelCount = 0;
		while(!queue.isEmpty()){
			BinaryTreeNode<T> current = queue.poll();
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
			BinaryTreeNode<T> current =  stack.pop();
			if(current==null){
				System.out.println("");
			}else{
				System.out.print(current.getData()+" ");
			}
		}
	}
	
	public int minDepth(BinaryTreeNode<T> root){
		int depth = 0;
		if(root!=null){
			depth = 1;
		}
		if(root.getLeft()!=null && root.getRight()!=null){
			depth = 1+Math.min(minDepth(root.getLeft()), minDepth(root.getRight()));
		}
		return depth;
	}
	
	public BinaryTreeNode<T> insert(BinaryTreeNode<T> root,T data){
		if(root==null){
			root =  new BinaryTreeNode<T>();
			root.setData(data);
		}else{
			Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
			queue.offer(root);
			boolean done =  false;
			BinaryTreeNode<T> newNode =  new BinaryTreeNode<T>();
			newNode.setData(data);
			
			while (!done) {
				BinaryTreeNode<T> current = queue.poll();
				
				if (current.getLeft() != null) {
					queue.offer(current.getLeft());
				}else{
					current.setLeft(newNode);
					done = true;
				}
				if (current.getRight() != null) {
					queue.offer(current.getRight());
				}else if(!done){
					current.setRight(newNode);
					done = true;
				}
			}
		}
		
		return root;
	}
	
	public static void main(String srgs[]){
		
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
		bTree.insert(root, 10);
		bTree.insert(root, 11);
		bTree.insert(root, 12);
		bTree.insert(root, 13);
		bTree.insert(root, 14);
		bTree.insert(root, 15);
		bTree.insert(root, 16);
		
		bTree.levelOrderTraversal(root);
		System.out.println("MAx depth is "+bTree.depth(root));
		System.out.println("Min depth is "+bTree.minDepth(root));
		bTree.levelOrderReverseTraversal(root);
		System.out.println("size of tree is "+bTree.size(root));
		System.out.println("Max record in tree is "+bTree.findMax(root));
		System.out.println("Max record using recursiove in tree is "+bTree.findMaxRec(root));
	}
}
