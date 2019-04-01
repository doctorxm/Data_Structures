package Set;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @Author qqg
 * @Date 2019/3/10
 * @Description: PACKAGE_NAME
 */
public class leetcode {
    public static int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer,Integer>tm=new TreeMap<>();
            for(int i=0;i<nums1.length;i++){
                if(tm.containsKey(nums1[i])){
                    tm.put(nums1[i],tm.get(nums1[i])+1);
                }
                else{
                    tm.put(nums1[i],1);
                }
            }
        ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<nums2.length;i++) {
                if (tm.containsKey(nums2[i])) {
                    list.add(nums2[i]);
                    tm.put(nums2[i], tm.get(nums2[i]) - 1);
                    if (tm.get(nums2[i]) == 0) {
                        tm.remove(nums2[i]);
                    }
                }
            }
        int []res=new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
    public static int[] intersect1(int[] nums1, int[] nums2) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums1){
            if(!map.containsKey(num))
                map.put(num, 1);
            else
                map.put(num, map.get(num) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int num: nums2){
            if(map.containsKey(num)){
                res.add(num);
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0)
                    map.remove(num);
            }
        }

        int[] ret = new int[res.size()];
        for(int i = 0 ; i < res.size() ; i ++)
            ret[i] = res.get(i);

        return ret;
    }
    public static void main(String[] args) {
        int a[]={1,2,3,2};
        int b[]={2,2,3,5};
        int[]  res = intersect(a, b);
        for(Integer nus:res){
            System.out.println(nus);
        }
      /*  int h=4;
        int p=3;
        if((h-p)&&(p=p-5)||(h=p)){
            --h;
        }
        System.out.println(h++);*/
    }
}
