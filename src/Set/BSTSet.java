package Set;

/**
 * @Author qqg
 * @Date 2019/3/3
 * @Description: PACKAGE_NAME
 */
public class BSTSet <E extends Comparable<E>>implements Set<E>{
    private BST<E> bst;
    public BSTSet(){
        bst=new BST<E>();
    }
    public int getSize(){
        return bst.getSize();
    }
    public boolean isEmpty(){
        return bst.isEmpty();
    }
    public boolean contains(E e){
        return bst.contains(e);
    }
    public void add(E e){
        bst.add(e);
    }
    public void remove(E e){
        bst.removeElement(e);
    }
}
