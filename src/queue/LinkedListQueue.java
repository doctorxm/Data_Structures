package queue;

/**
 * @Author qqg
 * @Date 2019/2/17
 * @Description: PACKAGE_NAME
 */
//用链表实现队列
public class LinkedListQueue<E>implements Queue<E> {
    public class Node{
        private E e;
        private Node next;
        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(Node next){
            this(null,next);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node head,tail;
    private int size;
    public LinkedListQueue(){
        head=null;
        tail=null;
        size=0;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void enqueue(E e){
        if(tail==null){
            tail=new Node(e,null);
            head=tail;
        }else{
            tail.next=new Node(e);
            tail=tail.next;
        }
        size++;
    }
    public E dequeue(){
        if(isEmpty()){
            throw new IllegalArgumentException("DEQUEUE IS FAILED!");
        }
        Node retNode=head;
         head=head.next;
        if(head==null){
            tail=null;
            size--;
        }
        return retNode.e;
    }
    public E getFront(){
        if(isEmpty()){
            throw new IllegalArgumentException("DEQUEUE IS FAILED!");
        }
        return head.e;
    }

    @Override
    public String toString() {
         StringBuilder str=new StringBuilder();
         str.append("Queue:front");
         Node cur=head;
         while(cur!=null){
             str.append(cur+"->");
             cur=cur.next;
         }
         str.append("tail");
         return str.toString();

    }
    public static void main(String[] args) {
        LinkedListQueue<Integer> linked= new LinkedListQueue<>();
        for (int i = 0; i <10;i++){
            linked.enqueue(i);
            System.out.println(linked);
            if (i % 3 == 2) {
                linked.dequeue();
                System.out.println(linked);
            }
        }

    }
}
