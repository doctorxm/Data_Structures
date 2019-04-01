package Set;

/**
 * @Author qqg
 * @Date 2019/3/3
 * @Description: PACKAGE_NAME
 */
public class LinkedListSet<E extends Comparable<E>>implements Set<E> {
    private LinkedList<E>linkedList;
    public LinkedListSet(){
        linkedList=new LinkedList<>();
    }
    public int getSize(){
        return linkedList.getSize();
    }
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }
    public boolean contains(E e){
        return linkedList.contains(e);
    }
    public void add(E e){
        if(!contains(e)){
            linkedList.addFirst(e);
        }
    }
    public void remove(E e){
        linkedList.removeElement(e);
    }
}
