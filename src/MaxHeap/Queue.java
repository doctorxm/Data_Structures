package MaxHeap;

/**
 * @Author 厉害的小马fighting!
 * @Date 2019/4/1
 * @Description: MaxHeap
 */
public interface Queue<E> {
    public int getSize();
    public boolean isEmpty();
    public E getFront();
    public void enqueue(E e);
    public E dequeue();
}
