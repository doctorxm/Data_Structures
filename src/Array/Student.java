package Array;

/**
 * @Author qqg
 * @Date 2019/2/10
 * @Description: com.company
 */
public class Student {
    String name;
    String score;
    public Student(String name,String score){
        this.name=name;
        this.score=score;
    }
    @Override
    public String toString() {
        return "[name="+name+",score="+score+"]" ;
    }
    public static void main(String args[]){
       Student sq=new Student("xiaowu","88");
       Student sq1=new Student("xiaoma","65");
       Arrayss <Student>stu=new Arrayss<Student>();
       stu.add(0,sq);
       stu.addLast(sq1);
        System.out.println(stu);
        System.out.println(stu.find(sq1));
    }
}
