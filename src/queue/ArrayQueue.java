package queue;

/**
 * @Author qqg
 * @Date 2019/2/13
 * @Description: PACKAGE_NAME
 */
public class ArrayQueue<E> implements Queue<E> {
    private Arrayss<E>array;
    //有参构造，定义队列容量
    public ArrayQueue(int capacity){
        array=new Arrayss<E>(capacity);
    }
    //无参 默认数组给的容量
    public ArrayQueue(){
        array=new Arrayss<>();
    }
    //获得队列元素个数
    public int getSize(){
        return array.getSize();
    }
    //获取容量
    public int getCapacity(){
        return array.getCapacity();
    }
    //判断队是否为空
    public boolean isEmpty(){
        return array.isEmpty();
    }
    //入队
    public void enqueue(E e){
        array.addLast(e);
    }
    //出队
    public E dequeue(){
        return array.removeFirst();
    }
    //获取队首元素
    public E getFront(){
        return array.get(0);
    }

    @Override
    public String toString() {
         StringBuilder str=new StringBuilder();
         str.append("front[");
         for (int i=0;i<array.getSize();i++){
             str.append(array.get(i));
             if(i!=array.getSize()-1){
                 str.append(",");
             }
         }
         str.append("]tail");
         return str.toString();
    }
}

