package leetcode;

public class SumOfLL {
	
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	 
	class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode op =  null;
	        ListNode current = null;
	        //ListNode finalOP = op;
	        int nAdd = 0;
	        while(l1!=null && l2!=null){
	            int sum =  l1.val + l2.val + nAdd;
	            nAdd = sum/10;
	            sum =  sum%10;
	            
	            ListNode newNode =  new ListNode(sum);
	            if(op==null){
	                op =  newNode;
	            }
	            if(current==null){
	                current =  newNode;
	            }else{
	                current.next = newNode;
	                current = newNode;
	            }
	            
	            l1 = l1.next;
	            l2 = l2.next;
	        }
	        
	        while(l1!=null){
	             int sum =  l1.val + nAdd;
	            nAdd = sum/10;
	            sum =  sum%10;
	            
	            ListNode newNode =  new ListNode(sum);
	            if(op==null){
	                op =  newNode;
	            }
	            if(current==null){
	                current =  newNode;
	            }else{
	                current.next = newNode;
	                current = newNode;
	            }
	             l1 = l1.next;
	        }
	        
	        while(l2!=null){
	             int sum =   l2.val + nAdd;
	            nAdd = sum/10;
	            sum =  sum%10;
	            
	            ListNode newNode =  new ListNode(sum);
	            if(op==null){
	                op =  newNode;
	            }
	            if(current==null){
	                current =  newNode;
	            }else{
	                current.next = newNode;
	                current = newNode;
	            }
	            l2 = l2.next;
	        }
	        
	        if(nAdd>0){
	            ListNode newNode =  new ListNode(nAdd);
	           
	                current.next = newNode;
	                //current = newNode;
	            
	        }
	        
	        return op;
	    }
	}

}
