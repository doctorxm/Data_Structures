package MaxHeap;

/**
 * @Author 厉害的小马fighting!
 * @Date 2019/4/1
 * @Description: MaxHeap
 */
public class PriorityQueue<E extends Comparable<E>>implements Queue<E> {
    private MaxHeap<E>maxHeap;
    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.delete();
    }
}
