package Set;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Pride and Prehudice");
        ArrayList<String>words1=new ArrayList<String>();
        FileOperation.readFile("pride-and-prejudice.txt",words1);
        //BSTSet<String>bst=new BSTSet<String>();
        LinkedListSet<String>bst=new LinkedListSet<>();
        System.out.println("总字数为："+words1.size());
        for(String str:words1){
            bst.add(str);
        }
        System.out.println("不重复的单词为："+bst.getSize());
        System.out.println("a-tale-of-two-cities.txt");
        ArrayList<String>words2=new ArrayList<String>();
        FileOperation.readFile("a-tale-of-two-cities.txt",words2);
        LinkedListSet<String>bst1=new LinkedListSet<String>();
        System.out.println("总字数为："+words2.size());
        for(String str:words2){
            bst1.add(str);
        }
        System.out.println("不重复的单词为："+bst1.getSize());
    }
}
