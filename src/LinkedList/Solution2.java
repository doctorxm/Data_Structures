package LinkedList;

/**
 * @Author qqg
 * @Date 2019/2/17
 * @Description: PACKAGE_NAME
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
         ListNode dummyhead=new ListNode(-1);
         dummyhead.next=head;
         ListNode pres=dummyhead;
        while(pres.next!=null){
            if(pres.next.val==val){
               pres.next=pres.next.next;
            }else{
                pres=pres.next;
            }
        }
        return dummyhead.next;
    }
}
