package stringOperations.trie;

public class Trie {
	private TrieNode head;
	public Trie(){
		head =  new TrieNode(' ');
	}
	public void insertInTrie(String strData){
		if(strData==null || strData.length()==0){
			head.setIs_end_of_string(true);
		}else{
			char[] dataArry = strData.toCharArray();
			
			int nLength = dataArry.length;
			int i=0;
			
			if(head.getData()==' '){
				head.setData(dataArry[i++]);
			}else{
				TrieNode current = head;
				while(i<nLength){
					TrieNode child = current.getSubNode(dataArry[i]);
					if(child==null){
						child =  new TrieNode(dataArry[i]);
						current.addChild(child);
					}else{
						current = child;
					}
					i++;
				}
				current.setIs_end_of_string(true);
			}
		}
		
		
	}
	public boolean SearchInTrie(String strData){
		TrieNode current =  head;
		char[] data = strData.toCharArray();
		int i=0;
		int nLength = data.length;
		if(head.getData() == data[i++]){
			while(i<nLength){
				TrieNode child = current.getSubNode(data[i]);
				if(child!=null){
					current = child;
				}else{
					return false;
				}
			}
			
			return current.isIs_end_of_string();
		}
		return false;
	}
}
