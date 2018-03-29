package companies;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested
	// list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
    Stack<Iterator<NestedInteger>> stack = new Stack<Iterator<NestedInteger>>();
    Integer current;
 
    public NestedIterator(List<NestedInteger> nestedList) {
        if(nestedList==null)
            return;
 
        stack.push(nestedList.iterator());    
    }
 
    @Override
    public Integer next() {
    	if(current!=null ||  hasNext()) {
    		Integer result = current;
            current = null;
            return result;
    	}
        return null;
    }
 
    @Override
    public boolean hasNext() {
        while(!stack.isEmpty() && current==null){
            Iterator<NestedInteger> top = stack.peek();
            if(!top.hasNext()){
                stack.pop();
                continue;
            }
 
            NestedInteger n = top.next();
            if(n.isInteger()){
                current = n.getInteger();
                return true;
            }else{
                stack.push(n.getList().iterator());
            }
        }
 
        return false;
    }
}