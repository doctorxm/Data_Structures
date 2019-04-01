package stack;

import java.util.Random;

/**
 * @Author qqg
 * @Date 2019/2/17
 * @Description: PACKAGE_NAME
 */
public class LinkedListStack<E> implements Stack<E>{
    private LinkedList<E> list;
    public LinkedListStack(){
        list=new LinkedList();
    }
    public int getSize(){
        return list.getSize();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public void push(E e){
        list.addFirst(e);
    }
    public E pop(){
        return list.deleteFirst();
    }
    public E peek(){
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append("top");
        str.append(list);
        return list.toString();
    }
    public static void main(String[] args) {
        int ops = 1000000;
        ArrayStack<Integer> arr = new ArrayStack<>();
        double time1 = testStack(arr, ops);
        System.out.println("ArrayStack,time=:" + time1 + "s");
        LinkedListStack<Integer> loo = new LinkedListStack<>();
        double time2 = testStack(loo, ops);
        System.out.println("LinkedListStack,time=:" + time2 + "s");
    }
    public static double testStack(Stack e, int ops) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < ops; i++) {
            e.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < ops; i++) {
            e.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
