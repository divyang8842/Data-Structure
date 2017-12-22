package singlylinkedlist;

public class SinglyLinkedList<T> {
	SinglyLinkedListNode<T> head = null;
	
	public SinglyLinkedListNode<T> insert(T data){
		if(head==null){
			head = new SinglyLinkedListNode<T>();
			head.setData(data);
		}else{
			SinglyLinkedListNode<T> currentNode = head;
			while(currentNode.getNext()!=null){
				currentNode = currentNode.getNext();
			}
			SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>();
			newNode.setData(data);
			currentNode.setNext(newNode);
		}
		return head;
	}
	
	public int getLength(){
		int nLength = 0;

		SinglyLinkedListNode<T> currentNode = head;
		while(currentNode!=null){
			nLength++;
			currentNode = currentNode.getNext();
		}
		return nLength;
	}
	
	public SinglyLinkedListNode<T> delete(int nIndex){
		
		int length =  getLength();
		if(nIndex > length-1){
			nIndex = length-1;
		}
		if(nIndex==0){
			head =  head.getNext();
		}else{
			int curIndex = 1;
			SinglyLinkedListNode<T> currNode =  head;
			while(curIndex!=nIndex){
				currNode = currNode.getNext();
				curIndex++;
			}
			SinglyLinkedListNode<T> tempNode =  currNode.getNext();
			currNode.setNext(tempNode.getNext());
			tempNode.setNext(null);
		}
		return head;
	}
	
	public void printLL(){
		SinglyLinkedListNode<T> tempNode = head;
		while(tempNode!=null){
			System.out.println(tempNode.getData());
			tempNode =  tempNode.getNext();
		}
	}
	
	public static void main(String str[]){
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.insert("hello");
		list.printLL();
		System.out.println("------------------");
		list.insert("1");
		list.insert("2");
		list.insert("3");
		list.insert("4");
		list.insert("5");
		list.insert("6");
		list.delete(1);
		list.printLL();
		System.out.println("------------------");
		list.delete(5);
		list.printLL();
		System.out.println("------------------");
		list.delete(0);
		list.printLL();
		System.out.println("------------------");
	}
}
