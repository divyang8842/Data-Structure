package companies;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NArrayLevelOrderTraveersal {
	class NArray{
		int nData;
		List<NArray> childs;
	}
	
	
	public void levelOrderTraversal(NArray root) {
		if(root == null) {
			return;
		}
		Queue<NArray> queue =  new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			NArray currentNode  =  queue.poll();
			if(currentNode!=null) {
				System.out.print(currentNode.nData+" ");
				List<NArray> childs = currentNode.childs;
				for (NArray nArray : childs) {
					if(nArray!=null) {
						queue.add(nArray);
					}
				}
			}else if(!queue.isEmpty()) {
				System.out.println();
				queue.add(null);
			}
		}
	}
}
