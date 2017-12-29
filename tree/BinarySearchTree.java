package tree;

public class BinarySearchTree<T extends Number> extends BinaryTree<T>{

	public BinaryTreeNode<T> insert(BinaryTreeNode<T> root,T data){
		if(root==null){
			root =  new BinaryTreeNode<T>();
			root.setData(data);
			return root;
		}
		if(root.getData().doubleValue()>data.doubleValue()){
			root.setLeft(insert(root.getLeft(),data));
		}else{
			root.setRight(insert(root.getRight(),data));
		}
		return root;
	}
	
	public BinaryTreeNode<T> findMaxNode(BinaryTreeNode<T> root){
		if(root!=null){
			while(root.getRight()!=null){
				root = root.getRight();
			}
		}	
		return root;
	}
	
	public BinaryTreeNode<T> findMinNode(BinaryTreeNode<T> root){
		if(root!=null){
			while(root.getLeft()!=null){
				root = root.getLeft();
			}
		}	
		return root;
	}
	
	public BinaryTreeNode<T> findNode(BinaryTreeNode<T> root,T data){
		BinaryTreeNode<T> node = null;
		if(root!=null){
			if(data.doubleValue()==root.getData().doubleValue()){
				node = root;
			}else if(data.doubleValue()<root.getData().doubleValue()){
				node = findNode(root.getLeft(), data);
			}else{
				node = findNode(root.getRight(), data);
			}
			
		}	
		return node;
	}
	
	public BinaryTreeNode<T> delete(BinaryTreeNode<T> root,T data){
		if(root==null){
			return null;
		}else if(root.getData().doubleValue()>data.doubleValue()){
			root.setLeft(delete(root.getLeft(), data));
		}else if(root.getData().doubleValue()<data.doubleValue()){
			root.setRight(delete(root.getRight(), data));
		}else{
			if(root.getLeft()!=null && root.getRight()!=null){
				BinaryTreeNode<T> successor = findMaxNode(root.getLeft());
				root.setData(successor.getData());
				root.setLeft(delete(successor, data));
			}else{
				if(root.getLeft()!=null){
					root = root.getLeft();
				}else{
					root = root.getRight();
				}
			}
		}
		
		return root;
	}
	
	public BinaryTreeNode<T> findLCA(BinaryTreeNode<T> root,T nodeData1,T nodeData2){
		if(root==null){
			return null;
		}
		double rootData = root.getData().doubleValue();
		if(rootData==nodeData1.doubleValue() || rootData==nodeData2.doubleValue()){
			return root;
		}
		
		if(rootData> Math.max(nodeData1.doubleValue(), nodeData2.doubleValue())){
			return findLCA(root.getLeft(),nodeData1,nodeData2);
		}
		if(rootData< Math.min(nodeData1.doubleValue(), nodeData2.doubleValue())){
			return findLCA(root.getRight(),nodeData1,nodeData2);
		}
		
		return root;
	}
	
	
	public static void main(String str[]){
		BinarySearchTree<Integer> bsTree = new BinarySearchTree<Integer>();
		BinaryTreeNode<Integer> root =  bsTree.insert(null, 3);
		bsTree.insert(root, 1);
		bsTree.insert(root, 5);
		bsTree.insert(root, 2);
		bsTree.insert(root, 4);
		bsTree.insert(root, 6);
		bsTree.insert(root, 0);
		
		bsTree.levelOrderTraversal(root);	
		System.out.println("Min value is " +bsTree.findMinNode(root).getData());
		System.out.println("Max value is " +bsTree.findMaxNode(root).getData());
		System.out.println("6 is available in tree "+(bsTree.findNode(root, 6)!=null));
		System.out.println("7 is available in tree "+(bsTree.findNode(root, 7)!=null));
		bsTree.delete(root, 4);
		bsTree.levelOrderTraversal(root);
		
		System.out.println("LCA of 2 and 6 is "+bsTree.findLCA(root, 2, 6).getData().intValue());
	}
}
