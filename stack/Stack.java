package stack;

import singlylinkedlist.SinglyLinkedList;
import singlylinkedlist.SinglyLinkedListNode;

public class Stack<T> {
	
	private SinglyLinkedList<T> stackList = null;
	
	public Stack() {
		stackList = new SinglyLinkedList<T>();
	}
	
	public void push(T data){
		stackList.insertAtIndex(data,0);
	}
	
	public T getTop(){
		if(stackList.isEmpty()){
			return null;
		}else{
			return stackList.getNodeData(stackList.getLength()-1);
		}
	}
	
	public T pop(){
		if(stackList.isEmpty()){
			return null;
		}else{
			return stackList.delete(0);
		}
	}
	
	public boolean isEmpty(){
		return stackList.isEmpty();
	}
	
	public int size(){
		return stackList.getLength();
	}
	
	public void revertStack(Stack<T> stack){
		
		if(stack.isEmpty()){
			return;
		}
		T data = stack.pop();
		revertStack(stack);
		insertAtBottom(stack, data);
		
	}
	
	private void insertAtBottom(Stack<T> stack,T data){
		if(stack.isEmpty()){
			stack.push(data);
			return;
		}
		T temp = stack.pop();
		insertAtBottom(stack,data);
		stack.push(temp);
		
	}
	
	
	public static void main(String str[]){
		Stack<String> stack = new Stack<String>();
		stack.push("hello");
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		stack.push("5");
		stack.push("6");
		stack.push("7");
		stack.push("8");
		stack.push("9");
		
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
	
	
}
