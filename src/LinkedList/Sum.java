package LinkedList;

/**
 * @Author qqg
 * @Date 2019/2/18
 * @Description: PACKAGE_NAME
 */
public class Sum {

    public static int sum(int arr[],int l){
        if(l==arr.length){
            return 0;
        }
        return arr[l]+sum(arr,l+1);
    }
    public static int Sum(int[]arr){
        return  sum(arr,0);
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8};
        System.out.println(Sum(arr));
    }

}
