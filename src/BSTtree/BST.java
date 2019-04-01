package BSTtree;

/**
 * @Author qqg
 * @Date 2019/2/20
 * @Description: PACKAGE_NAME
 */
public class BST<E extends Comparable<E>> {
    public class Node {
        private E e;
        private Node left;
        private Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node root;
    private int size;

    public BST() {
        root=null;
        size = 0;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    //添加元素
    public void add(E e){
        if(root==null){
            root=new Node(e);
        }else{
            add(root,e);
        }
    }
    //向以node为根节点的二分搜索树插入元素e,递归算法
    public void add(Node node,E e) {
        if (node.e.equals(e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if(e.compareTo(node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size++;
            return;
        }
        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {//e.compareTo(node.e)>0
            add(node.right, e);
        }
    }
}
