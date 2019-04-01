package Map;

/**
 * @Author qqg
 * @Date 2019/3/3
 * @Description: PACKAGE_NAME
 */
public interface Map<K,V> {
    //添加键值对
    public void add(K key, V value);
    //删除键值对
    public V remove(K key);
    //是否包含某个键
    public boolean contains(K key);
    //查找键
    public V get(K key);
    //修改
    public void set(K key, V newValue);

    public int getSize();
    public boolean isEmpty();
}
