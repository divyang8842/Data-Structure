package companies;

import java.util.LinkedList;
import java.util.Queue;

public class Wp_Practice {

	//## write a function which tells whether G is bipartite or not
	public boolean isBipartite(int[][] nGraphArry) {
		int nVertexes = nGraphArry.length;
		int[] nColorArry =  new int[nVertexes];
		
		for(int i=0;i<nVertexes;i++) {
			nColorArry[i] = -1;
		}
		for(int i=0;i<nVertexes;i++) {
			if(nColorArry[i] == -1) {
				if(!isBipartite_Helper(nGraphArry, nColorArry, nVertexes, i)) {
					return false;
				}
			}
		}
		return true;
	}
	public boolean isBipartite_Helper(int[][] nGraphArry,int[] nColorArry,int nLength,int nU){
		Queue<Integer> queue =  new LinkedList<Integer>();
		queue.offer(nU);
		nColorArry[nU] = 1; 
		
		while(!queue.isEmpty()) {
			int u =  queue.poll();
			
			//self loop
			if(nGraphArry[u][u] == 1) { 
				return false;
			}
			for(int v=0;v<nLength;v++) {
				if(nGraphArry[u][v]==1 && nColorArry[v] == -1) {
					nColorArry[v] = 1 - nColorArry[u];
					queue.offer(v);
				}else if(nGraphArry[u][v]==1 && nColorArry[v] == nColorArry[u]) {
					return false;
				}
			}
		}
		
		return true;
	}
	//## End
	
	
	public static void main(String[] str) {
		
		 int G[][] = {{0, 1, 0, 1},
                 {1, 0, 1, 0},
                 {0, 1, 0, 1},
                 {1, 0, 1, 0}};
		 Wp_Practice obj = new Wp_Practice();
		 if(obj.isBipartite(G)) {
			 System.out.println("True");
		 }else {
			 System.out.println("False");
		 }
		 
	}
}
