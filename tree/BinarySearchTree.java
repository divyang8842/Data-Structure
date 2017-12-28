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
	}
}
