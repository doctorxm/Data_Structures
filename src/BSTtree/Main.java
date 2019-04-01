package BSTtree;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BST1<Integer> bs = new BST1<Integer>();
        /*int[] nums = {5, 3, 2, 4, 6, 8};
        for (int num : nums) {
            bs.add(num);
        }
        bs.preOrder();
        System.out.println("*******************先序非递归写法*********************");
        bs.preOrderNRln("*******************层序遍历*********************");
        bs.levelOrder();();
        System.out.print
        System.out.println("********************中序******************");
        // System.out.println(bs);
        bs.inOrder();
        System.out.println("*******************后序*********************");
        bs.postOrder();*/
      /*  Random random=new Random();
        int n=1000;
        for(int i=0;i<n;i++){
            bs.add(random.nextInt(10000));
        }
        System.out.println(bs);
        ArrayList<Integer> nums=new ArrayList<Integer>();

        while(!bs.isEmpty()){
            System.out.println("888888888888888888");
            nums.add(bs.removeMax());
        }
        for(int i=1;i<nums.size();i++){
            if(nums.get(i-1)<nums.get(i)){
                throw new IllegalArgumentException("Remove is failed!");
            }
        }
        System.out.println("the progress is success!");*/
      for(int i=0;i<10;i++){
          bs.add(i);
          System.out.println(bs);
      }
      bs.removeElement(1);
        System.out.println(bs);
    }
}
