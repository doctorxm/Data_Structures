package stack;

/**
 * @Author qqg
 * @Date 2019/2/12
 * @Description: PACKAGE_NAME
 */
public interface Stack<E> {
    //入栈
    public void push(E e);
    //出栈
    public E pop();
    //获取栈的大小
    public int getSize();
    //获取栈顶元素
    public E peek();
    //判断是否为空
    public boolean isEmpty();
}
