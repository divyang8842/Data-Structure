package singlylinkedlist;

public class SinglyLinkedListNode<T> {
	private T Data;
	private SinglyLinkedListNode<T> nextNode;
	public T getData() {
		return Data;
	}
	public void setData(T Data) {
		this.Data = Data;
	}
	public SinglyLinkedListNode<T> getNext() {
		return nextNode;
	}
	public void setNext(SinglyLinkedListNode<T> objNode) {
		this.nextNode = objNode;
	}
	
	
}
