package LinkedList;

/**
 * @Author qqg
 * @Date 2019/2/14
 * @Description: PACKAGE_NAME
 */
public class LinkedList<E> {
    private class Node {
        private E e;//节点里面的元素
        private Node next;//指向下一个节点

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(Node next) {
            this(null, next);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private int size;
    private Node head;

    public LinkedList() {
        head = null;
        size = 0;
    }

    //获得链表中元素个数
    public int getSize() {
        return size;
    }

    //在链表头部添加元素
    public void addFirst(E e) {
        Node node = new Node(e);
        node.next = head;
        head = node;
        size++;
        //head=new Node(e,head);
    }
    //在链表中添加元素
    public void add(int index, E e) {
        Node pres = head;
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("The index is illegal!");
        }
        for (int i = 0; i < index - 1; i++) {
            pres = pres.next;
        }
        Node node = new Node(null, null);
        node.next = pres.next;
        pres.next = node;
        //pres.next=new Node(e,pres.next);
        size++;

    }
    @Override
    public String toString() {
         StringBuilder str=new StringBuilder();
         Node cur=head.next;
         while(cur!=null){
             str.append(cur+"->");
             cur=cur.next;
         }
         str.append("NULL");
        return str.toString();
    }
}
