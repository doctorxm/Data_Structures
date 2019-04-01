package Array.exerciseArray;
public class Main {

    public static void main(String[] args) {
        Array arr=new Array();
        for(int i=0;i<10;i++){
            arr.insertLast(i);
        }
        arr.insertFirst(100);
        arr.insertLast(89);
        System.out.println(arr);
        arr.remove(0);
        arr.remove(1);
        arr.remove(2);
        arr.remove(3);
        arr.remove(5);
        arr.remove(6);
        arr.remove(5);
        System.out.println(arr);

    }
}
