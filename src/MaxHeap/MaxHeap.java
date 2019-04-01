package MaxHeap;

/**
 * @Author 小马
 * @Date 2019/3/11
 * @Description: PACKAGE_NAME
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> array;
    /*
    heapify操作：给你一个数组，转换成堆
    思路：1.在构造方法里初始化，给array赋值
         2.在Array方法里直接添加一个构造方法，赋值操作
         3.找到第一个不是叶子节点的节点依次往前遍历进行siftDown操作
     */
    //复制数组的值给array
    public MaxHeap(E arr[]){
        array =new Array(arr);
        for(int i=parentIdex(array.getSize()-1);i>=0;i--){
            siftDown(i);
        }
    }

    public MaxHeap(int capacity) {
        array = new Array(capacity);
    }

    public MaxHeap() {
        array = new Array();
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    //获得父亲节点的索引
    public int parentIdex(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("THE INDEX IS ROOT INDEX!");
        }
        return (index - 1) / 2;//数组下标从0开始，移一位
    }

    //获得左孩子的索引
    public int lefChildIndex(int index) {
        return 2 * index + 1;
    }

    //获得右孩子所在的索引
    public int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    //添加元素
    public void add(E e) {
        array.addLast(e);
        siftup(array.getSize() - 1);
    }

    //上浮操作
    public void siftup(int k) {
        while (k > 0 && array.get(k).compareTo(array.get(parentIdex(k))) > 0) {
            array.swap(k, parentIdex(k));
            k = parentIdex(k);
        }
    }

    //获取堆中最大元素
    public E findMax() {
        if (array.getSize() == 0) {
            throw new IllegalArgumentException("the heap is empty!");
        }
        return array.get(0);
    }

    //删除最大值并返回
    public E delete() {
        E ret = findMax();
        array.swap(0, array.getSize() - 1);
        array.removeLast();
        siftDown(0);
        return ret;
    }

    public void siftDown(int k) {
        //当该节点为叶子节点时，停止循环
        while (lefChildIndex(k) < array.getSize()) {
            //1.比较左孩子和右孩子的节点值大小
            int j = lefChildIndex(k);
            //如果右孩子存在且
            if ((j + 1) < array.getSize() && array.get(j + 1).compareTo(array.get(j)) > 0) {
                j = rightChildIndex(k);
            }
            //该节点与子节点比较，小的话下沉
            if (array.get(k).compareTo(array.get(j)) >= 0) {
                break;
            } else {
                //交换值，下一轮比较
                array.swap(k, j);
                k = j;
            }
        }
    }
    /*replace操作，取出最大元素，并且插入新的元素e
    实现方法1：先delete,然后再add，时间复杂度为O(nlogn)
    实现方法2：将顶部元素替换成新元素e,然后进行siftDown操作
     */
    public E  replace(E e){
        E ret=findMax();
        array.set(0,e);
        siftDown(0);
        return ret;
    }
}
