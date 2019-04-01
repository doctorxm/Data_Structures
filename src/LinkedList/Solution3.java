package LinkedList;

/**
 * @Author qqg
 * @Date 2019/2/18
 * @Description: PACKAGE_NAME
 */
//运用递归删除链表中值为val的元素
public class Solution3 {
    public static ListNode removeElements(ListNode head, int val) {
        //基本问题（最短时的情况）链表为空
        if(head==null){
            return null;
        }
        //ListNode res=removeElements(head.next,val);//删除头结点以外值为val的元素
         head.next=removeElements(head.next,val);//删除头结点以外值为val的元素
       /* //判断head的值，如果等于val,返回res,否则返回head+res
        if(head.val==val){
            return res;
        }else{
            head.next=res;
            return head;
        }*/
       return head.val==val ? head.next:head;
    }
    public static void main(String[] args) {
        int []nums={1,2,3,4,6,5,7,6,8};
        ListNode head=new ListNode(nums);
        ListNode  list = removeElements(head, 6);
        System.out.println(list);
    }
}
