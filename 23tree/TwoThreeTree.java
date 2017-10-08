class Node 
{
	private int keyCount;
	private Node parent;
	public static final int defaultValue = Integer.MIN_VALUE;
	private Node arryChilds[] = new Node[4];
	private int keyArray[] = {defaultValue, defaultValue, defaultValue };

	public boolean isFourthNodeAvail() {
		return (arryChilds[3] != null);
	}
	
	public Node getParentNode()
	{
		return parent;
	}

	public boolean isLeafNode()
	{
		return (arryChilds[0] == null && arryChilds[1] == null && arryChilds[2] == null ) ? true : false;
	}

	public int getkeyCount()
	{
		return keyCount;
	}

	public int getKey(int index) 
	{
		return keyArray[index];
	}

	public void addChild(int index, Node child)
	{
		if(index<0 || index>3)
			return;
		
		arryChilds[index] = child;
		if (child != null)
			child.parent = this;
	}

	public Node removeChild(int index) {
		if(index<0 || index>3)
			return null;
		
		Node tempNode = arryChilds[index];
		arryChilds[index] = null;
		return tempNode;
	}

	public Node getChildNode(int index) 
	{
		if(index<0 || index>2)
			return null;
		return arryChilds[index];
	}

	public boolean isNodeFull()
	{
		return (keyCount >=2);
	}

	public String printKeys()
	{
		String strKeys = "";
		for (int j = 0; j < 3; j++) {
			if (keyArray[j] == defaultValue)
				break;
			else
				strKeys+=keyArray[j]+" ";
		}
		return strKeys.trim(); //deletes space first and last
	}

	public int findKey(int key)
	{
		for (int j = 0; j < 2; j++)
		{
			if (keyArray[j] == key)
				return j;
		}
		return defaultValue;
	} 

	public int addKey(int newKey,boolean isThirdKey) 
	{
		if((isThirdKey && getkeyCount()==3 ) || (!isThirdKey &&isNodeFull()))  //returns default value when node is full
			return defaultValue;
		
		int currentIndex = findKey(newKey); //prevents duplicate keys
		if(currentIndex>=0)
			return currentIndex;
		keyCount++;
		
		int keyIndexTostart = 1; //initialize to 1
		if(isThirdKey)
			keyIndexTostart = 2; //if thirdkey true start at 2

		for(int j=keyIndexTostart; j>=0; j--)        
			if(keyArray[j] != defaultValue)                                      
			{                            
				int itsKey = keyArray[j];
				if(newKey < itsKey)           
					keyArray[j+1] = keyArray[j]; 
				else
				{
					keyArray[j+1] = newKey;   
					return j+1;                
				}                          
			}
		keyArray[0] = newKey;             
		return 0;
	}

	public int removeHighestKey() 
	{
		if(keyCount==0) {
			return defaultValue;
		}
		int temp = keyArray[keyCount - 1];
		keyArray[keyCount - 1] = defaultValue;
		keyCount--;
		return temp;
	}

	public void removeKey(int index)
	{
		if(index==(keyCount-1))
			removeHighestKey();
		else 
		{
			for(int i =index+1; i<3; i++)
			{
				keyArray[i-1] = keyArray[i];
			}
			
			keyArray[2] = defaultValue;
		}
	}

}

public class TwoThreeTree
{
	private Node root;


	public TwoThreeTree()
	{
		root = new Node(); 
	}

	public String search(int key)
	{
		Node currentNode = root;
		Node parent = root;
		while(currentNode!=null)
		{
			if(currentNode.findKey(key) != Node.defaultValue )
				return currentNode.printKeys();              
			else if( currentNode.isLeafNode() )
				return currentNode.printKeys();              
			else                                
			{
				parent = currentNode;
				currentNode = getNextChild(currentNode, key);
			}
		}
		
		return  (currentNode!=null ?  currentNode.printKeys(): parent.printKeys());
	}

	public void insert(int newKey)
	{
		
		
		Node currentNode = root;
		while(!currentNode.isLeafNode() && currentNode.findKey(newKey)==Node.defaultValue)
		{	
			currentNode = getNextChild(currentNode, newKey);
			if(currentNode==null)
				currentNode = new Node();// go insert
			// node is not full, not a leaf; so go to lower level
		}  
		if (currentNode.findKey(newKey) == Node.defaultValue) {
			if (currentNode.isNodeFull()) {
				currentNode.addKey(newKey, true);
				split(currentNode);
				currentNode = currentNode.getParentNode();

				currentNode = getNextChild(currentNode, newKey);
			} // end if(node is full)
			else
				currentNode.addKey(newKey, false); // insert new DataItem
		}  
	}
	
	
	public void splitWithForthNode(Node currentNode) {
		Node parent, child3,child2;
		int  key1,key2, itemIndex;
		boolean bSplitParent = false;
		
		child2 = currentNode.removeChild(2);
		child3 = currentNode.removeChild(3);
		
		Node newRight = new Node();       
		if(currentNode==root)                // if this is the root,
		{
			root = new Node();                // make new root
			parent = root;                    // root is our parent
			root.addChild(0, currentNode);   // connect to parent
		}
		else                              // this node not the root
			parent = currentNode.getParentNode();    // get parent

		key2 = currentNode.removeHighestKey();    
		key1 = currentNode.removeHighestKey();
		
		//currentNode.addKey(key2, false);

				itemIndex = parent.addKey(key1,false);
				if(itemIndex==Node.defaultValue) {
					bSplitParent = true;
					itemIndex = parent.addKey(key1,true);
				}
		
				//System.out.println(itemIndex);
				int n = parent.getkeyCount();
				
				for(int j=n-1; j>itemIndex; j--)          
				{                                      
					Node temp = parent.removeChild(j);
					parent.addChild(j+1, temp);        
				}
				
				if(bSplitParent) {
					
				}
				parent.addChild(itemIndex+1, newRight);

				newRight.addKey(key2,false);       
				newRight.addChild(0, child2);
				newRight.addChild(1, child3); 
				
				
				//displayTree();
				if(bSplitParent)
					split(parent);
				
	}

	public void split(Node currentNode)     
	{
		
		if(currentNode.isFourthNodeAvail()) {
			splitWithForthNode(currentNode);
		}else {
		Node parent, child2, child1;
		int  key1,key2, itemIndex;
		boolean bSplitParent = false;

		child1 = currentNode.removeChild(1); 
		child2 = currentNode.removeChild(2);

		Node newRight = new Node();       
		if(currentNode==root)                // if this is the root,
		{
			root = new Node();                // make new root
			parent = root;                    // root is our parent
			root.addChild(0, currentNode);   // connect to parent
		}
		else                              // this node not the root
			parent = currentNode.getParentNode();    // get parent


		//currentNode.addKey(newValueToInsert, true);

		key2 = currentNode.removeHighestKey();    
		key1 = currentNode.removeHighestKey();
		//currentNode.addKey(key2, false);

		itemIndex = parent.addKey(key1,false);
		if(itemIndex==Node.defaultValue) {
			bSplitParent = true;
			itemIndex = parent.addKey(key1,true);
		}
		
			
			
		
		//System.out.println(itemIndex);
		int n = parent.getkeyCount();
		
		for(int j=n-1; j>itemIndex; j--)          
		{                                      
			Node temp = parent.removeChild(j);
			parent.addChild(j+1, temp);        
		}
		
		
		parent.addChild(itemIndex+1, newRight);

		newRight.addKey(key2,false);       
		newRight.addChild(0, child1);
		newRight.addChild(1, child2); 
		
		
		//displayTree();
		if(bSplitParent)
			split(parent);
		
		}
	}  
	
	public Node getNextChild(Node theNode, double theValue)
	{
		int keyCount = theNode.getkeyCount();
		int i = 0;
		for(i =0; i<keyCount; i++)          
		{                               
			if( theValue < theNode.getKey(i) )
				return theNode.getChildNode(i);  
		}                    
		return theNode.getChildNode(i);       
	}
	
	
	
}