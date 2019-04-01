package stack;

/**
 * @Author qqg
 * @Date 2019/2/12
 * @Description:  数组栈
 */
public class ArrayStack<E> implements Stack<E>{
    Arrayss<E>array;
    //有参构造
    public ArrayStack(int capacity){
       array= new Arrayss<>(capacity);
    }
    //无参构造
    public ArrayStack(){
        array= new Arrayss<>();
    }
    @Override
    //入栈
    public void push(E e) {
        array.addLast(e);
    }
    @Override
    //出栈
    public E pop() {
        return array.removeLast();
    }
    @Override
    public int getSize() {
        return array.getSize();
    }
    public int getCapacity(){
        return array.getCapacity();
    }
    @Override
    //取栈顶元素
    public E peek() {
        return array.get(array.getSize()-1);
    }
    @Override
    //判断是否为空
    public boolean isEmpty() {
        return array.getSize()==0;
    }
    @Override
    public String toString() {
        StringBuilder str=new StringBuilder("栈元素个数："+array.getSize()+"\n");
        for (int i=0;i<array.getSize();i++){
            str.append(array.get(i));
            if(i!=array.getSize()-1){
                str.append(",");
            }
        }
        str.append("top");
        return str.toString();
    }
}
