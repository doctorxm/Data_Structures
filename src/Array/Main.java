package Array;

public class Main {

    public static void main(String[] args) {
        Arrayss<Integer> arr = new <Integer>Arrayss();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        arr.addFirst(100);
        arr.set(1,500);
        System.out.println(arr);
        System.out.println("aarrar"+arr.get(1));
        arr.remove(0);
        System.out.println(arr);
        arr.removeElement(2);
        System.out.println(arr);
        int i = arr.find(500);
        System.out.println("$$$$$$$$$"+i);
    }

}
