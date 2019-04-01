package queue;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int ops = 100000;
        ArrayQueue<Integer> arr = new ArrayQueue<>();
        double time1 = testQueue(arr, ops);
        System.out.println("ArrayQueue,time=:" + time1 + "s");
        LoopQueue<Integer> loo = new LoopQueue<>();
        double time2 = testQueue(loo, ops);
        System.out.println("LoopQueue,time=:" + time2 + "s");
    }
    public static double testQueue(Queue e, int ops) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < ops; i++) {
            e.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < ops; i++) {
            e.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
    public static void testArrayQueue() {
        ArrayQueue<Integer> array = new ArrayQueue<>();
        for (int i = 0; i < 5; i++) {
            array.enqueue(i);
            System.out.println(array);
            if (i % 3 == 2) {
                array.dequeue();
                System.out.println(array);
            }
        }
    }
}
