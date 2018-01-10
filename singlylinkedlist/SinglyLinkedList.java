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
	
	
	public SinglyLinkedListNode<T> insertAtIndex(T data,int nIndex){
		if(head==null){
			head = new SinglyLinkedListNode<T>();
			head.setData(data);
		}else if(nIndex==0){
			SinglyLinkedListNode<T>  newNode = new SinglyLinkedListNode<T>();
			newNode.setData(data);
			newNode.setNext(head);
			head =  newNode;
		}else{
			int length =  getLength();
			if(nIndex > length-1){
				nIndex = length-1;
			}
			
			SinglyLinkedListNode<T> currentNode = head;
			int curIndex =1; 
			while(currentNode.getNext()!=null && curIndex!=nIndex){
				currentNode = currentNode.getNext();
				curIndex++;
			}
			SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>();
			newNode.setData(data);
			newNode.setNext(currentNode.getNext());
			currentNode.setNext(newNode);
		}
		return head;
	}
	
	public boolean isEmpty(){
		return head==null;
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
	
	public T delete(int nIndex){
		
		int length =  getLength();
		SinglyLinkedListNode<T> tempNode = new SinglyLinkedListNode<T>();
		if(nIndex > length-1){
			nIndex = length-1;
		}
		if(nIndex==0){
			tempNode = head;
			head =  head.getNext();
		}else{
			int curIndex = 1;
			SinglyLinkedListNode<T> currNode =  head;
			while(curIndex!=nIndex){
				currNode = currNode.getNext();
				curIndex++;
			}
			tempNode =  currNode.getNext();
			currNode.setNext(tempNode.getNext());
			tempNode.setNext(null);
		}
		return tempNode.getData();
	}
	
	
	public T getNodeData(int nIndex){
		
		int length =  getLength();
		SinglyLinkedListNode<T> tempNode = new SinglyLinkedListNode<T>();
		if(nIndex > length-1){
			nIndex = length-1;
		}
		if(nIndex==0){
			return head.getData();
		}else{
			int curIndex = 1;
			SinglyLinkedListNode<T> currNode =  head;
			while(curIndex!=nIndex){
				currNode = currNode.getNext();
				curIndex++;
			}
			tempNode =  currNode.getNext();
		}
		return tempNode.getData();
	}
	
	public void printLL(){
		SinglyLinkedListNode<T> tempNode = head;
		while(tempNode!=null){
			System.out.println(tempNode.getData());
			tempNode =  tempNode.getNext();
		}
	}
	
	public void reverseLL(){
		SinglyLinkedListNode<T> prev = null;
		SinglyLinkedListNode<T> current =  head;
		
		while(current!=null){
			
			SinglyLinkedListNode<T> next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		head = prev;
	}
	
	public void reverseSecondHalfOfLL(){
		SinglyLinkedListNode<T> prev = null;
		SinglyLinkedListNode<T> current =  head;
		SinglyLinkedListNode<T> next = head;
		SinglyLinkedListNode<T> middle = head;
		
		//finding middle of LL
		while(next.getNext()!=null){
			next=next.getNext().getNext();
			middle = middle.getNext();
		}
		
		prev = null;
		current = middle.getNext();
		next = null;
		while(current!=null){
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		
		middle.setNext(prev);
		
		
	}
	
	
	public void reverseInPAir(){
		SinglyLinkedListNode<T> prev = head;
		SinglyLinkedListNode<T> current =  head;
		SinglyLinkedListNode<T> temp = null;
		while(prev!=null && prev.getNext() != null){
			current =  prev.getNext();
			//if(current==null)
			temp = current.getNext();
			prev.setNext(temp);
			current.setNext(prev);
			prev = temp;
		}
		head = head.getNext();
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
		list.reverseSecondHalfOfLL();
		list.printLL();
		/*list.delete(1);*/
		/*list.reverseInPAir();
		list.printLL();
		
		System.out.println("------------------");
		list.delete(5);
		list.printLL();
		System.out.println("------------------");
		list.delete(0);
		list.printLL();
		System.out.println("------------------");*/
	}
}
