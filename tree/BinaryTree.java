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
	
	public void mirrorTree(BinaryTreeNode<T> root){
		Queue<BinaryTreeNode<T>> queue =  new LinkedList<BinaryTreeNode<T>>();
		if(root!=null){
			queue.offer(root);
			BinaryTreeNode<T> current = root;
			while(!queue.isEmpty()){
				current = queue.poll();
				if(current!=null){
					BinaryTreeNode<T> temp = current.getLeft();
					current.setLeft(current.getRight());
					current.setRight(temp);
					queue.offer(current.getLeft());
					queue.offer(current.getRight());
				}
			}
		}
	}
	
	
	public void printPossiblePath(BinaryTreeNode<T> root,String strPath){
		if(root!=null){
			strPath+="-> "+root.getData();
			if(root.getLeft()==null && root.getRight()==null){
				System.out.println(strPath);
			}else{
				printPossiblePath(root.getLeft(), strPath);
				printPossiblePath(root.getRight(), strPath);
			}
		}
	}
	
	public BinaryTreeNode<T> makeSpecialTreeFromString(char[] data,int curPos){
		if(data==null || data.length==curPos){
			return null;
		}
		
		T tData = extracted(curPos);
		BinaryTreeNode<T> newNode = new BinaryTreeNode<T>();
		newNode.setData(tData);
		newNode.setLeft(null);
		newNode.setRight(null);
		if(data[curPos]=='L'){
			return newNode;
		}
		
		newNode.setLeft(makeSpecialTreeFromString(data, ++curPos));
		newNode.setRight(makeSpecialTreeFromString(data, ++curPos));
		
		
		return newNode;
		
	}

	private T extracted(int curPos) {
		return (T)(Number)curPos;
	}
	
	public void setSiblings(BinaryTreeNode<T> root){
		Queue<BinaryTreeNode<T>> queue =  new LinkedList<BinaryTreeNode<T>>();
		if(root!=null){
			queue.offer(root);
			queue.offer(null);
			BinaryTreeNode<T> current;
			while(!queue.isEmpty()){
				current = queue.poll();
				
				if(current==null){
					queue.offer(null);
				}else{
					current.setSibling(queue.peek());
					
					if(current.getLeft()!=null){
						queue.offer(current.getLeft());
					}
					if(current.getRight()!=null){
						queue.offer(current.getRight());
					}
				}
				
			}
		}
	}
	//(n + 1) * (n + 2) * ··· * 2n / (n + 1)!
	public int findNumberOfUniqueBinaryTree(int nNumbers){
		 long result = 1;
	      for(int i = nNumbers + 1; i <= 2 * nNumbers; i ++) {
	          result *= i;
	          result /= (i - nNumbers);
	      }
	      result /= nNumbers + 1;
	      return (int)result;
	}
	
	public BinaryTreeNode<Integer> findLeastCommonAncestor(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> data1,BinaryTreeNode<Integer> data2){
		if(root != null){
			if(root.getData() == data1.getData() || root.getData() ==  data2.getData()){
				return root;
			}else if(root.getData() > Math.max(data1.getData(), data2.getData())){
				root = root.getLeft();
			}else if(root.getData() < Math.min(data1.getData(), data2.getData())){
				root = root.getRight();
			}
		}
		return root;
	}
	
	public BinaryTreeNode<Integer> generateBinaryTree(int[] pre, char[] preLN){
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();
		generateTreeHelper(root, pre, preLN, 0,pre.length-1);
		
		
		return root;
	}
	
	private int generateTreeHelper(BinaryTreeNode<Integer> root,int[] pre, char[] preLN,int nPos,int nLength){
		
		root.setData(pre[nPos]);
		if(preLN[nPos] == 'N'){
			int nLeft = ++nPos;
			if(nLeft<= nLength){
				BinaryTreeNode<Integer> bLeft = new BinaryTreeNode<Integer>();
				root.setLeft(bLeft);
				nPos = generateTreeHelper(bLeft, pre, preLN, nLeft, nLength);
			}
			int nRight = ++nPos;
			if(nRight<= nLength){
				BinaryTreeNode<Integer> bRight = new BinaryTreeNode<Integer>();
				root.setRight(bRight);
				generateTreeHelper(bRight, pre, preLN, nRight, nLength);
			}
		}
		return nPos;
	}
	
	public boolean isIsomorphic(BinaryTreeNode<Integer> root1,BinaryTreeNode<Integer> root2)
    {
		if(root1==null && root2 == null){
			return true;
		}else if(root1==null || root2 == null){
			return false;
		}else if( getNodeData(root1.getLeft()) == getNodeData(root2.getLeft()) && getNodeData(root1.getRight()) == getNodeData(root2.getRight())){
			return  ( isIsomorphic(root1.getLeft(), root2.getLeft()) && isIsomorphic(root1.getRight(), root2.getRight()) );
		}else if (getNodeData(root1.getLeft()) == getNodeData(root2.getRight()) && getNodeData(root1.getRight()) == getNodeData(root2.getLeft())){
			return  ( isIsomorphic(root1.getLeft(), root2.getRight()) && isIsomorphic(root1.getRight(), root2.getLeft()) );
		}
		return false;
	}
	
	private Integer getNodeData(BinaryTreeNode<Integer> node){
		if(node!=null){
			return node.getData();
		}else{
			return Integer.MIN_VALUE;
		}
	}
	
	
	public void printLEftMostAndRightMostNodesAtEachLevel(BinaryTreeNode<Integer> root){
		if(root!=null){
			BinaryTreeNode<Integer> current = root;
			//System.out.println(root.getData());
			Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
			queue.offer(root);
			queue.offer(null);
			boolean bPrint = false;
			while(!queue.isEmpty()){
				
				if(queue.peek()==null){
					if(current==null){
						break;
					}
					System.out.println(" "+current.getData());
					//
				} if(current==null){
					bPrint = true;
				}
				
				current =  queue.poll();
				if(current!=null){
					if(current.getLeft()!=null)
					queue.offer(current.getLeft());
					
					if(current.getRight()!=null)
					queue.offer(current.getRight());
					
				}else{
					queue.offer(null);
				}
				if(bPrint){
					System.out.print(current.getData());
					bPrint = false;
				}
			}
		}
	}
	
	int nCount = 0;
	public void printNumberOfPathHavingKAsNodeSum(BinaryTreeNode<Integer> head,int k,int sum){
		if(head!=null){
			if(sum+head.getData()==k){
				nCount++;
			}else{
				if(head.getLeft()!=null){
					printNumberOfPathHavingKAsNodeSum(head.getLeft(), k, sum);
					printNumberOfPathHavingKAsNodeSum(head.getLeft(), k, 0);
				}
				
				if(head.getRight()!=null){
					printNumberOfPathHavingKAsNodeSum(head.getRight(), k, sum);
					printNumberOfPathHavingKAsNodeSum(head.getRight(), k, 0);
				}
			}
		}
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
		bTree.mirrorTree(root);
		System.out.println("After mirroring the tree is ");
		bTree.levelOrderTraversal(root);
		bTree.printPossiblePath(root, "Start ");
		char[] data = {'I','L','I','L','L'};
		BinaryTreeNode<Integer> newRoot = bTree.makeSpecialTreeFromString(data, 0);
		bTree.levelOrderTraversal(newRoot);
		
		
		int pre[] = {10, 30, 20, 5, 15};
		char preLN[] = {'N', 'N', 'L', 'L', 'L'};
		BinaryTreeNode<Integer> newTree =  bTree.generateBinaryTree(pre, preLN);
		bTree.levelOrderTraversal(newTree);
		
		bTree.printLEftMostAndRightMostNodesAtEachLevel(newTree);
		
	}
}
