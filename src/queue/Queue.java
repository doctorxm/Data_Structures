package queue;

/**
 * @Author qqg
 * @Date 2019/2/13
 * @Description: PACKAGE_NAME
 */
public interface Queue<E> {
    //入队
    public void enqueue(E e);
    //出队
    public E dequeue();
    //获取队首元素
    public E getFront();
    //队大小
    public int getSize();
    //判断队是否为空
    public boolean isEmpty();
}
