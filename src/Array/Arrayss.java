package Array;

/**
 * @Author qqg
 * @Date 2019/1/6
 * @Description: com.company
 */
public class Arrayss<E> {
    private E array[];
    private int size;

    public Arrayss(int capacity) {
        array = (E[]) new Object[capacity];
        size = 0;
    }

    //无参数的构造方法，默认数组的容量为10
    public Arrayss() {
        this(10);
    }

    //获得数组中元素个数
    public int getSize() {
        return size;
    }

    //获得数组的容量
    public int getCapacity() {
        return array.length;
    }

    //返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在所有元素末尾添加元素
    public void addLast(E e) {
        add(size, e);
    }

    //在所有元素前面添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    //获得数组中的某个元素
    E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("GET FAILEED!!!");
        }
        return array[index];
    }

    void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("SET IS FAILED! INDEX IS ILLEGAL!");
        }
        array[index] = e;
    }

    //向指定位置添加元素
    public void add(int index, E e) {
        //如果下标＜0或者大于元素个数（导致元素排列不连续）
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add is failed,the  index is illegal");
        }
        if (size == array.length) {
             resize(2*array.length);
        }

        //最后一个元素依次往后挪一个
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = e;
        size++;
    }

    //判断数组是否包含某个元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
    //查找元素e在数组中的索引，如果没有返回-1
    public int find(E e){
        for(int i=0;i<size;i++){
            if(array[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
    //删除数组中的指定位置元素
    public E remove(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove is failed,the  index is illegal");
        }
        E ret=array[index];
        for(int i=index+1;i<size;i++){
            array[i-1]=array[i];
        }
        size--;
        if(size==array.length/4&&array.length/2!=0){
            resize(array.length/2);
        }
        return ret;
    }
    //从数组中删除第一个元素，返回被删除的元素
    public E removeFirst(){
       return remove(0);
    }
    //从数组中删除最后一个元素，返回被删除的元素
    public E removeLast(){
        return remove(size-1);
    }
    //从数组中删除元素e
    public void removeElement(E e){
        int index=find(e);
        if(index!=-1){
            remove(index);
        }
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Arrayss :size=%d,capacity=%d\n", size, array.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(array[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
    private void resize(int newCapacity){
        E newArray[]= (E[]) new Object[newCapacity];
        for (int i=0;i<size;i++){
            newArray[i]=array[i];
        }
        array=newArray;
    }
}


