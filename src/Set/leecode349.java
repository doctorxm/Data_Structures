package Set;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @Author qqg
 * @Date 2019/3/10
 * @Description: PACKAGE_NAME
 */
public class leecode349 {
    public static  int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> ts=new TreeSet<>();
           for(int i=0;i<nums1.length;i++){
                ts.add(nums1[i]);
                }
        ArrayList<Integer>list=new ArrayList<>();
                for(int i=0;i<nums2.length;i++){
                    if(ts.contains(nums2[i])){
                        list.add(nums2[i]);
                        ts.remove(nums2[i]);
                    }
           }
           int []res=new int[list.size()];
                for(int i=0;i<list.size();i++){
                    res[i]=list.get(i);
                }
                return res;
    }
    public static void main(String[] args) {
        int a[]={1,2,3,2};
        int b[]={2,2,3,5};
        int[]  res = intersection(a, b);
        for(Integer nus:res){
            System.out.println(nus);
        }
}}
