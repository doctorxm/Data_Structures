package queue;

/**
 * @Author qqg
 * @Date 2019/2/13
 * @Description: PACKAGE_NAME
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] array;//定义泛型数组
    private int size;//元素个数
    private int capacity;//容量
    private int front;//指向队头索引
    private int tail;//指向队尾元素的下一个位置或者存放新元素的那个位置

    public LoopQueue(int capacity) {
        array = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    //队列元素个数
    public int getSize() {
        return size;
    }

    //队列容量
    public int getCapacity() {
        return array.length - 1;
    }

    //队列是否为空
    public boolean isEmpty() {
        return front == tail;
    }

    public boolean isFull() {
        return (tail + 1) % array.length == front;
    }

    //队列首部元素
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("THE QUEUE IS EMPTY!");
        }
        return array[front];
    }

    //入队
    public void enqueue(E e) {
        if (isFull()) {
            resize(2 * getCapacity());
        }
        array[tail] = e;
        tail = (tail + 1) % array.length;
        size++;
    }

    //出队
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("THE QUEUE IS EMPTY!");
        }
        E ret = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    //扩容
    public void resize(int newCapacity) {
        E newArray[] = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(i + front) % array.length];
        }
        array = newArray;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("size=" + getSize() + "\t capacity=" + getCapacity() + "\n");
        str.append("front[");
        for (int i = front; i!=tail;i=(i+1)%array.length){
            str.append(array[i]);
            if ((i+1)%array.length!=tail) {
                str.append(",");
            }
        }
        str.append("]tail");
        return str.toString();
    }
    public static void main(String[] args) {
        LoopQueue<Integer> array = new LoopQueue<>();
        for (int i = 0; i <10;i++){
            array.enqueue(i);
            System.out.println(array);
            if (i % 3 == 2) {
                array.dequeue();
                System.out.println(array);
            }
        }

    }
}
