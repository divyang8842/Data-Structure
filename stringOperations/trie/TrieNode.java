package stringOperations.trie;

import java.util.Collection;
import java.util.LinkedList;

public class TrieNode {
	private char cData;
	private boolean is_end_of_string;
	private Collection<TrieNode> child;
	
	public TrieNode(char cData){
		this.cData = cData;
		this.is_end_of_string = false;
		child =  new LinkedList<TrieNode>();
	}
	
	public TrieNode getSubNode(char cData){
		if(child != null){
			for(TrieNode objChild :  child){
				if(objChild.getData()==cData){
					return objChild;
				}
			}
		}
		return null;
	}
	
	public void addChild(TrieNode child){
		this.child.add(child);
	}

	public char getData() {
		return cData;
	}
	public void setData(char cData) {
		this.cData = cData;
	}
	public boolean isIs_end_of_string() {
		return is_end_of_string;
	}
	public void setIs_end_of_string(boolean is_end_of_string) {
		this.is_end_of_string = is_end_of_string;
	}
	public Collection<TrieNode> getChild() {
		return child;
	}
	public void setChild(Collection<TrieNode> child) {
		this.child = child;
	}
}
