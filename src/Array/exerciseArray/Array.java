package Array.exerciseArray;

/**
 * @Author qqg
 * @Date 2019/2/11
 * @Description: cn.xiaoma.home
 */
public class Array <E> {
    private int size;//元素个数/数组长度
    private E array[];//定义数组
    private int capacity;//数组容量

    public Array(int capacity){
        array=(E[])new Object[capacity];
        size=0;
    }
    public Array(){
        this(10);
    }
    //获得容量
    public int getCapacity(){
        return array.length;
    }
    //获得数组元素个数
    public int getSize(){
         return size;
    }
    //判断数组是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //插入元素
    public void insert(int index,E e){
        if(index<0||index>size){
            throw new IllegalArgumentException("Illegal index!");
        }
        if (size==array.length){
            resize(2*array.length);
        }
        for (int i=size;i>index;i--){
            array[i]=array[i-1];
        }
        array[index]=e;
        size++;
    }
    //首位插入元素
    public void insertFirst(E e){
         insert(0,e);
    }
    //末位插入元素
    public void insertLast(E e){
        insert(size,e);
    }
    //获取数组中的某个元素
    public E get(int index){
       if(index<0||index>size){
           throw new IllegalArgumentException("the index is illegal!");
       }
       return array[index];
    }
    //修改数组中某个位置的元素
    public void update(int index,E e){
        if(index<0||index>size){
            throw new IllegalArgumentException("Illegal index!");
        }
        array[index]=e;
    }
    //删除元素
    public void remove(int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("Illegal index!");
        }
        for(int i=index;i<size;i++){
            array[i]=array[i+1];
            }
            size--;
        if(size==array.length/4&&array.length/2!=0){
            resize(array.length/2);
        }
        }

        //删除首位
    public void removeFirst(){
        remove(0);
    }
    //删除末位
    public void removeLast(){
        remove(size-1);
    }
    //删除某个元素
    public int removeElement(E e){
        int  index = find(e);
        if(index<0||index>size){
            throw new IllegalArgumentException("no this element!");
        }
        remove(index);
        return index;
    }
    //查找数组中某个元素，返回下标，没有返回-1
    public int find(E e) {
        for(int i=0;i<size;i++){
            if(array[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    //数组中是否包含某个元素,返回下标
    public boolean contains(int e){
        for(int i=0;i<size;i++){
            if(array[i].equals(e)){
                return true;
            };
        }
        return false;
    }
    public String toString() {
         StringBuilder str=new StringBuilder();
         str.append("size:"+size+"\t capacity="+array.length+"\n");
         for(int i=0;i<size;i++){
             str.append(array[i]+" ");
         }
         return str.toString();
    }
    //扩容
    public void resize(int newCapacity){
        E newArray[]=(E[]) new Object[newCapacity];
        for (int i=0;i<size;i++){
            newArray[i]=array[i];
        }
        array=newArray;
    }
}
