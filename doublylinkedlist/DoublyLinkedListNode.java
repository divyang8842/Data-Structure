package doublylinkedlist;

public class DoublyLinkedListNode<T> {
	private T Data;
	private DoublyLinkedListNode<T> nextNode;
	private DoublyLinkedListNode<T> previousNode;
	
	public T getData() {
		return Data;
	}
	public void setData(T Data) {
		this.Data = Data;
	}
	public DoublyLinkedListNode<T> getNext() {
		return nextNode;
	}
	public void setNext(DoublyLinkedListNode<T> objNode) {
		this.nextNode = objNode;
	}
	public DoublyLinkedListNode<T> getPrevious() {
		return previousNode;
	}
	public void setPrevious(DoublyLinkedListNode<T> previousNode) {
		this.previousNode = previousNode;
	}
	
	
}
