package tree;

public class GenericTreeNode<T> {

	T data;
	GenericTreeNode<T> firstChild;
	GenericTreeNode<T> nextSibling;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public GenericTreeNode<T> getFirstChild() {
		return firstChild;
	}
	public void setFirstChild(GenericTreeNode<T> firstChild) {
		this.firstChild = firstChild;
	}
	public GenericTreeNode<T> getNextSibling() {
		return nextSibling;
	}
	public void setNextSibling(GenericTreeNode<T> nextSibling) {
		this.nextSibling = nextSibling;
	}	
}
