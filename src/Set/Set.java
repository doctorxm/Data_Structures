package Set;

/**
 * @Author qqg
 * @Date 2019/3/3
 * @Description: PACKAGE_NAME
 */
public interface Set <E>{
    public int getSize();
    public boolean isEmpty();
    public boolean contains(E e);
    public void add(E e);
    public void remove(E e);
}
