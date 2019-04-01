package LinkedList;

/**
 * @Author qqg
 * @Date 2019/2/17
 * @Description: PACKAGE_NAME
 */
public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x; }

  public ListNode(int[] arr){
    if(arr==null||arr.length==0){
        throw new IllegalArgumentException("the arrray is null");
    }
     this.val=arr[0];
    ListNode cur=this;
    for(int i=1;i<arr.length;i++){
        cur.next=new ListNode(arr[i]);
        cur=cur.next;
    }
  }
    @Override
    public String toString() {
         StringBuilder str=new StringBuilder();
         str.append("front:  ");
         ListNode cur=this;
         while(cur!=null){
             str.append(cur.val+"->");
             cur=cur.next;
         }
         str.append("NULL");
         return str.toString();
    }
}
