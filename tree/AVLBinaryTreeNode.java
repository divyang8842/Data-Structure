package tree;

public class AVLBinaryTreeNode<T> {

	private int height;
	private T data;
	private AVLBinaryTreeNode<T> left,right,sibling;
	
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public AVLBinaryTreeNode<T> getLeft() {
		return left;
	}
	public void setLeft(AVLBinaryTreeNode<T> left) {
		this.left = left;
	}
	public AVLBinaryTreeNode<T> getRight() {
		return right;
	}
	public void setRight(AVLBinaryTreeNode<T> right) {
		this.right = right;
	}
	public AVLBinaryTreeNode<T> getSibling() {
		return sibling;
	}
	public void setSibling(AVLBinaryTreeNode<T> sibling) {
		this.sibling = sibling;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
