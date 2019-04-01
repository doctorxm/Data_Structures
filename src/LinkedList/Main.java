package LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedListddummy<Integer> LinkedList=new LinkedListddummy<>();
        LinkedList.add(0,8);
        LinkedList.addLast(99);
       System.out.println(LinkedList);
       LinkedList.delete(0);
        System.out.println(LinkedList);
        System.out.println(LinkedList.getSize());
       /* for(int i=0;i<5;i++){
            LinkedList.addFirst(i);
            System.out.println(LinkedList);
        }
        LinkedList.set(3,666);
        System.out.println(LinkedList);*/
    }

}
