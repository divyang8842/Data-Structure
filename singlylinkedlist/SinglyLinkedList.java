package singlylinkedlist;

import java.util.Stack;

public class SinglyLinkedList<T> {
	SinglyLinkedListNode<T> head = null;
	
	public SinglyLinkedListNode<T> getHead(){
		return head;
	}
	
	public SinglyLinkedListNode<T> insert(T data){
		SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>();
		newNode.setData(data);
		return insert(newNode);
	}
	
	public SinglyLinkedListNode<T> insert(SinglyLinkedListNode<T> newNode){
		if(head==null){
			head = newNode;
		}else{
			SinglyLinkedListNode<T> currentNode = head;
			while(currentNode.getNext()!=null){
				currentNode = currentNode.getNext();
			}
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
		return getLength(head);
	}
	
	public int getLength(SinglyLinkedListNode<T> head){
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
		while(next!=null && next.getNext()!=null){
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
	
	/*
	 * Given a singly linked list containing n nodes. Modify the value of first
	 * half nodes such that 1st node’s new value is equal to the last node’s
	 * value minus first node’s current value, 2nd node’s new value is equal to
	 * the second last node’s value minus 2nd node’s current value, likewise for
	 * first half nodes. If n is odd then the value of the middle node remains
	 * unchanged.
	 */
	public void updateLinkedList(SinglyLinkedListNode<Integer> root){
		if(root == null){
			root = ((SinglyLinkedListNode<Integer>)head);
		}
		SinglyLinkedListNode<Integer> current =  root;
		Stack<Integer> stack =  new  Stack<Integer>();
		SinglyLinkedListNode<Integer> nextPointer =  root;
		
		//stack.add(current.getData());
		while(nextPointer!=null && nextPointer.getNext()!=null){
			
			current = current.getNext();
			//stack.add(current.getData());
			nextPointer = nextPointer.getNext().getNext();
		}
		if(nextPointer !=null){ // odd number of nodes
			current= current.getNext().getNext();
		}
		//stack.add(current.getData());
		while(current!=null){
			stack.add(current.getData());
			current = current.getNext();
			
		}
		
		current =  root;
		while(!stack.isEmpty()){
			current.setData(stack.pop() - current.getData());
			current = current.getNext();
		}
		
	}
	
	public SinglyLinkedListNode<Integer> sortSinglyLinkedList(SinglyLinkedListNode<Integer> head){
		if(head==null || head.getNext()==null){
			return head;
		}
		SinglyLinkedListNode<Integer> middle = getMiddleOfLL(head);
		SinglyLinkedListNode<Integer> middleNext = middle.getNext();
		middle.setNext(null);
		SinglyLinkedListNode<Integer> left =  sortSinglyLinkedList(head);
		SinglyLinkedListNode<Integer> right = sortSinglyLinkedList(middleNext);
		
		SinglyLinkedListNode<Integer> sortedList = mergeList(left, right);
		
		
		return sortedList;
	}
	
	public SinglyLinkedListNode<Integer> mergeList(SinglyLinkedListNode<Integer> left, SinglyLinkedListNode<Integer> right){
		SinglyLinkedListNode<Integer> result = null;
		if(left==null){
			return right;
		}else if(right==null){
			return left;
		}
		
		if(left.getData()>right.getData()){
			result = left;
			result.setNext(mergeList(result.getNext(), right));
		}else{
			result = right;
			result.setNext(mergeList(left, result.getNext()));
		}
		
		return result;
	}
	
	public SinglyLinkedListNode<Integer> getMiddleOfLL(SinglyLinkedListNode<Integer> head){
		
		if(head==null){
			return null;
		}
		SinglyLinkedListNode<Integer> fastPtr = head.getNext();
		SinglyLinkedListNode<Integer> slowPtr = head;
		
		while(fastPtr!=null){
			fastPtr = fastPtr.getNext();
			if(fastPtr != null){
				fastPtr = fastPtr.getNext();
				slowPtr = slowPtr.getNext();
			}
			
		}
		
		return slowPtr;
	}
	
	public SinglyLinkedListNode<T> findIntersectionOf2LinkedList(SinglyLinkedListNode<T> head1, SinglyLinkedListNode<T> head2){
		int nLength1 =  getLength(head1);
		int nLength2 =  getLength(head2);
		if(nLength1>nLength2){
			while(nLength1-nLength2>0){
				head1 = head1.getNext();
				nLength1--;
			}
		}else if(nLength1<nLength2){
			while(nLength2-nLength1>0){
				head2 = head2.getNext();
				nLength2--;
			}
		}
		
		while(head1!=null){
			if(head1.getData() == head2.getData()){
				System.out.println("intersection is "+head1.getData());
				return head1;
			}else{
				head1 = head1.getNext();
				head2 = head2.getNext();
			}
		}
		System.out.println("intersection not found. ");
		return null;
	}
	
	public static void main(String str[]){
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
		
		list1.insert(7);
		list1.insert(8);
		list1.insert(9);
		list1.insert(10);
		list1.insert(11);
		list1.insert(12);
		list1.insert(13);
		list1.insert(list.head);
		
		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
		
		list2.insert(15);
		list2.insert(16);
		list2.insert(17);
		list2.insert(18);
		
		list2.insert(list.head);
		
		list.findIntersectionOf2LinkedList(list1.head, list2.head);
		
		list.reverseSecondHalfOfLL();
		list.printLL();
		System.out.println("------------------");
		list.updateLinkedList(null);
		list.printLL();
		System.out.println("------------------");
		list.updateLinkedList(null);
		list.printLL();
		System.out.println("------------------");
		SinglyLinkedListNode<Integer> head =  list.getHead();
		head = list.sortSinglyLinkedList(head);
		list.head = head;
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
