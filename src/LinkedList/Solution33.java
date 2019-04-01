package LinkedList;

/**
 * @Author qqg
 * @Date 2019/2/18
 * @Description: PACKAGE_NAME
 */
//运用递归删除链表中值为val的元素
public class Solution33 {
    public static ListNode removeElements(ListNode head, int val,int depth) {
        String depthString=generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("call:remove前"+val+"in"+head);
        //基本问题（最短时的情况）链表为空
        if(head==null){
            System.out.print(depthString);
            System.out.println("head空Return: "+head);
            return null;
        }
         ListNode res=removeElements(head.next,val,depth+1);//删除头结点以外值为val的元素
         System.out.print(depthString);
         System.out.println("After:remove后"+val+"\t"+res);
       //判断head的值，如果等于val,返回res,否则返回head+res
        ListNode ret;
        if(head.val==val){
            ret=res;
        }else{
            head.next=res;
            res=head;
            ret=res;
        }
        System.out.print(depthString);
        System.out.println("结果Return:"+ret);
        return ret;
       //return head.val==val ? head.next:head;
    }
    public static String generateDepthString(int depth){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<depth;i++){
            str.append("--");
        }
        return str.toString();
    }
    public static void main(String[] args) {
        int []nums={1,2,3,4,6,5,7,6,8};
        ListNode head=new ListNode(nums);
        ListNode  list = removeElements(head, 6,0);
        System.out.println(list);
    }
}
