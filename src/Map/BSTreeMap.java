package Map;

import java.util.ArrayList;

/**
 * @Author qqg
 * @Date 2019/3/8
 * @Description: PACKAGE_NAME
 */
public class BSTreeMap<K extends Comparable<K>, V>implements Map<K,V>{

     public class Node{
         K key;
         V value;
         Node  left,right;
         public Node(K key,V value){
             this.key=key;
             this.value=value;
              left=null;
              right=null;
         }
         public Node(){
             this(null,null);
         }
     }
     private Node root;
     private int size;
     public BSTreeMap(){
         root=null;
         size=0;
     }
     //获取容量的大小
    public int getSize(){
        return size;
    }
    //判断是否为空
    public boolean isEmpty(){
         return size==0;
    }
    //添加键值对
    public void add(K key,V value){
      root=add(root,key,value);
    }
    //向以Node为根节点的二叉树添加键值对
    public Node add(Node node,K key,V value){
         if(node==null){
             size++;
             return new Node(key,value);
         }
         if(key.compareTo(node.key)<0){
            node.left= add(node.left,key,value);
         }
         else if(key.compareTo(node.key)>0){
           node.right=add(node.right,key,value);
         }
         else{//键已经存在，更新值
             node.value=value;
         }
         return node;
    }
    //返回以node为根的二叉搜索树中key所在的节点
    public Node getNode(Node node,K key){
        if(node == null)
            return null;

        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }
    //判断是否包含某个元素
    public boolean contains(K key){
      return getNode(root,key)!=null;
    }
    //通过键获取值
    public V get(K key){
         Node node=getNode(root,key);
         return node==null ? null:node.value;
    }
    //修改键所对应的的值
    public void set(K key,V newvalue){
         Node node=getNode(root,key);
         if(node==null){
             throw new IllegalArgumentException("the key is not extistance!");
         }
         node.value=newvalue;
    }
    //寻找以node为根最小值所在的节点
    public Node getMin(Node node){
         if(node.left==null){
              return node;
         }
         return getMin(node.left);
    }
    //删除以node为根的二分搜索树的最小节点，返回删除节点后新的二分搜索树的根
    public Node removeMin(Node node){
         if(node.left==null){
             Node rightNode=node.right;
             node.right=null;
             size--;
             return rightNode;
         }
         node.left=removeMin(node.left);
         return node;
    }
    //删除键值对返回值
    public V remove(K key){
         Node node=getNode(root,key);
         if(node!=null){
          root=remove(root, key);
          return node.value;
         }
         return  null;
    }
    public Node remove(Node node,K key){
         if(node==null){
             return null;
         }
         if(key.compareTo(node.key)>0){
          node.right=remove(node.right,key);
          return node;
         }
         else if(key.compareTo(node.key)<0){
             node.left=remove(node.left,key);
             return node;
         }
         else{//key.compareTo(node.key)=0
             if(node.left==null){
                 Node rightNode=node.right;
                 node.right=null;
                 size--;
                 return rightNode;
             }
             if(node.right==null){
                 Node leftNode=node.left;
                 node.left=null;
                 size--;
                 return leftNode;
             }
             Node successor=getMin(node.right);
             successor.right=removeMin(node.right);
             //多删加size size++
             successor.left=node.left;
             node.left=node.right=null;
             //size--
             return successor;
         }
    }
    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            BSTreeMap<String, Integer> map = new BSTreeMap<String, Integer>();
            map.add("nishi",3);
            for (String word : words) {
                if (map.contains(word)){
                    map.set(word, map.get(word) + 1);}
                else{
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }
        System.out.println();
    }

}
