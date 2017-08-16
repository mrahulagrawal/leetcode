class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
public class AddTwoNumbers{
   public static void main(String...args){
	   ListNode l1=createList(111);
	   ListNode l2=createList(9991);
	   printList(l1);
	   printList(l2);
	   Solution s=new Solution();
	   ListNode l3=s.addTwoNumbers(l1, l2);
	   printList(l3);
   }
   public static ListNode createList(int n){
	   ListNode current=new ListNode(n%10);
	   ListNode start = current;
	   int temp=(int)n/10;
	   while(temp>0){
		   current.next=new ListNode(temp%10);
		   current=current.next;
		   temp=(int)temp/10;
	   }
	   return start;
   }
   public static void printList(ListNode l){
	   while(l != null){
		   if(l.next !=null)
			   System.out.print(l.val+"->");
		   else
			   System.out.println(l.val);
		   l=l.next;
	   }
   }
}
 class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current=new ListNode(0);
        ListNode l3=current;
        ListNode temp1=l1;
        ListNode temp2=l2;
        int tenth=0;
        while(temp1 !=null || temp2 != null){
            if(temp1 !=null && temp2 != null){
                int add=temp1.val+temp2.val+tenth;
                tenth=add>9?1:0;
                current.next=new ListNode(add%10);
                temp1=temp1.next;
                temp2=temp2.next;    
            }
            else if(temp1 ==null){
                int add=temp2.val+tenth;
                tenth=add>9?1:0;
                current.next=new ListNode(add%10);
                temp2=temp2.next;
            }
            else if(temp2 ==null){
                int add=temp1.val+tenth;
                tenth=add>9?1:0;
                current.next=new ListNode(add%10);
                temp1=temp1.next;
            }
            current=current.next;
        }
        if(tenth>0){
            current.next=new ListNode(tenth);
        }
        return l3.next;
    }
}
