package LinkedList;

/**
 * @Author qqg
 * @Date 2019/2/17
 * @Description: PACKAGE_NAME
 */
public class Solution {
    public static  ListNode removeElements(ListNode head, int val) {
        while(head!=null&&head.val==val){
           /* ListNode delNode=head;
            head=head.next;
            delNode.next=null;*/
            head=head.next;
        }
        if(head==null){
            return null;
        }
        ListNode pres=head;
        while(pres.next!=null){
            if(pres.next.val==val){
               /* ListNode del=pres.next;
                pres.next=del.next;
                del.next=null;*/
               pres.next=pres.next.next;
            }else{
                pres=pres.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int []nums={1,2,3,4,6,5,7};
        ListNode head=new ListNode(nums);
        ListNode  list = removeElements(head, 6);
        System.out.println(list);
    }
}
