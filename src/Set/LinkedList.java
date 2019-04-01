package Set;

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
    private Node dummyhead;
    public LinkedList(){
        dummyhead=new Node(null,null);
        size=0;
    }
    //获得链表中元素个数
    public int getSize() {
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    //在链表中添加元素
    public void add(int index, E e) {
        Node pres = dummyhead;//等于size时，在末尾添加元素
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("The index is illegal!");
        }
        for (int i = 0; i < index; i++) {
            pres = pres.next;
        }
        /*Node node = new Node(e, null);
        node.next = pres.next;
        pres.next = node;*/
        pres.next=new Node(e,pres.next);
        size++;
    }
    //在链表首位添加元素
    public void addFirst(E e){
        add(0,e);
    }
    //在链表末尾添加元素
    public void addLast(E e){
        add(size,e);
    }
    //在链表中查找元素
    public E find(int index){
        Node cur=dummyhead.next;
        if (index < 0 || index >=size) {//等于size时，为空，一共有size个元素，最后一个元素是size-1,从零开始
            throw new IllegalArgumentException("The index is illegal!");
        }
        for (int i = 0; i < index; i++) {
            cur=cur.next;
        }
        return cur.e;
    }
    //在链表中获取元素
    public E get(int index){
        Node cur= dummyhead.next;
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("The index is illegal!");
        }
        for (int i = 0; i < index; i++) {
            cur=cur.next;
        }
        return cur.e;
    }
    //在链表中修改元素
    public void set(int index,E e){
        Node cur= dummyhead.next;
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("The index is illegal!");
        }
        for (int i = 0; i < index; i++) {
             cur=cur.next;
        }
             cur.e=e;
    }
    //链表中是否包含某元素
    public boolean contains(E e){
        Node cur=dummyhead.next;
        while(cur!=null){
            if(cur.e.equals(e)){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //在链表中删除元素,返回被删除的元素
    public E delete(int index) {
        Node pres = dummyhead;//等于size时，在末尾添加元素
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("The index is illegal!");
        }
        for (int i = 0; i < index; i++) {
            pres = pres.next;
        }
        Node ret=pres.next;
        pres.next=ret.next;
        ret.next=null;
        size--;
        return ret.e;
    }
    public void removeElement(E e){
        Node pres=dummyhead;
        while(pres.next!=null){
            if(pres.next.e.equals(e)){
                break;
            }
            pres=pres.next;
        }
        if(pres.next!=null){
            Node delNode=pres.next;
            pres.next=delNode.next;
            delNode.next=null;
            size--;
        }
    }
    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        Node cur=dummyhead.next;
        while(cur!=null){
            str.append(cur+"->");
            cur=cur.next;
        }
       // for(cur=dummyhead.next;cur!null;cur=cur.next);
        str.append("NULL");
        return str.toString();
    }
}
