package doublylinkedlist;

public class DoublyLinkedList<T> {
	DoublyLinkedListNode<T> head = null;
	
	public DoublyLinkedListNode<T> insert(T data){
		if(head==null){
			head = new DoublyLinkedListNode<T>();
			head.setData(data);
		}else{
			DoublyLinkedListNode<T> currentNode = head;
			while(currentNode.getNext()!=null){
				currentNode = currentNode.getNext();
			}
			DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>();
			newNode.setData(data);
			currentNode.setNext(newNode);
			newNode.setPrevious(currentNode);
		}
		return head;
	}
	
	public int getLength(){
		int nLength = 0;

		DoublyLinkedListNode<T> currentNode = head;
		while(currentNode!=null){
			nLength++;
			currentNode = currentNode.getNext();
		}
		return nLength;
	}
	
	public DoublyLinkedListNode<T> delete(int nIndex){
		
		DoublyLinkedListNode<T> currNode =  head;
		int length =  getLength();
		if(nIndex > length-1){
			nIndex = length-1;
		}
		if(nIndex==0){
			currNode =  head.getNext();
			currNode.setPrevious(null);
			head.setNext(null);
			head =  currNode;
		}else{
			
			int curIndex = 1;
			while(curIndex!=nIndex){
				currNode = currNode.getNext();
				curIndex++;
			}
			DoublyLinkedListNode<T> tempNode =  currNode.getNext();
			tempNode.setPrevious(null);
			tempNode.getNext().setPrevious(currNode);
			currNode.setNext(tempNode.getNext());
			tempNode.setNext(null);
		}
		return head;
	}
	
	public void printLL(){
		DoublyLinkedListNode<T> tempNode = head;
		while(tempNode!=null){
			System.out.println(tempNode.getData());
			tempNode =  tempNode.getNext();
		}
	}
	
	public static void main(String str[]){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.insert("hello");
		/*list.printLL();
		System.out.println("------------------");*/
		list.insert("1");
		list.insert("2");
		list.insert("3");
		list.insert("4");
		list.insert("5");
		list.insert("6");
		list.delete(1);
		list.printLL();
		System.out.println("------------------");
		/*list.delete(5);
		list.printLL();
		System.out.println("------------------");
		list.delete(0);
		list.printLL();
		System.out.println("------------------");*/
	}
}
