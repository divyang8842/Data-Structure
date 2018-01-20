package stack;

public class SpecialStack {
	private int[] stackData;
	private int[] minStackData;
	private int[] maxStackData;
	private int top = -1;
	private int nMax;
	public SpecialStack() {
		this(50);
	}
	
	public SpecialStack(int nLength) {
		stackData = new int[nLength];
		minStackData = new int[nLength];
		maxStackData = new int[nLength];
		nMax = nLength;
	}
	
	
	public void push(int nData){
		top++;
		if(top == 0){
			stackData[top] = nData;
			minStackData[top] = nData;
			maxStackData[top] = nData;
		}else if(top == nMax){
			top--;
			System.err.println("Stack is full");
		}else{
			stackData[top] = nData;
			maxStackData[top] = Math.max(nData,maxStackData[top-1]);
			minStackData[top] = Math.min(nData,minStackData[top-1]);
		}
		
	}
	public int pop(){
		if(top==-1){
			System.err.println("Stack is empty ");
			return Integer.MIN_VALUE;
		}else{
			return stackData[top--];
		}
	}
	
	public int getMin(){
		return minStackData[top];
	}
	
	public int getMax(){
		return maxStackData[top];
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	
	public static void main(String[] str){
		SpecialStack stack = new SpecialStack();
		stack.push(1);
		stack.push(2);
		stack.push(4);
		stack.push(3);
		stack.push(5);
		while(!stack.isEmpty()){
			System.out.println("Min is "+stack.getMin());
			System.out.println("Max is "+stack.getMax());
			System.out.println("Pop is "+stack.pop());
		}
	}
}
