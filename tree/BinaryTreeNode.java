package tree;

public class BinaryTreeNode<T> {
	private T data;
	private BinaryTreeNode<T> left,right,sibling;
	
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BinaryTreeNode<T> getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}
	public BinaryTreeNode<T> getRight() {
		return right;
	}
	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}
	public BinaryTreeNode<T> getSibling() {
		return sibling;
	}
	public void setSibling(BinaryTreeNode<T> sibling) {
		this.sibling = sibling;
	}
	
	
}
