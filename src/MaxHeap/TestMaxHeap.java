package MaxHeap;

import java.util.Random;

/**
 * @Author 厉害的小马fighting!
 * @Date 2019/4/1
 * @Description: MaxHeap
 */
public class TestMaxHeap {
    public static void main(String[] args) {
        Random random=new Random();
        Integer arr[]=new Integer[1000000];
        for(int i=0;i<1000000;i++){
           arr[i]=random.nextInt(Integer.MAX_VALUE);
        }
        double time1=testHeap(arr,false);
        System.out.println("without heapify:"+time1+"s");
        double time2=testHeap(arr,false);
        System.out.println("with heapify:"+time2+"s");
    }
    public static double testHeap(Integer[]arr, boolean isHeapify){
        long startTime=System.nanoTime();
        MaxHeap<Integer>maxheap;
        if(isHeapify){
             maxheap=new MaxHeap<Integer>(arr);
        }else{
            maxheap=new MaxHeap<Integer>();
            for(int num:arr){
                maxheap.add(num);
            }
        }
        int arrs[]=new int[1000000];
        for(int i=0;i<arr.length;i++){
            arr[i]=maxheap.delete();
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]<arr[i]){
                System.out.println("failure!");
            }
        }
        long endTime=System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
}
