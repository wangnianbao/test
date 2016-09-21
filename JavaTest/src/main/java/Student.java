import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangnianbao on 2016/9/20.
 */
public class Student {
    public String id;
    public  String name;

    public Set<Course> courses;
    public  Student(String id,String name ){
       this.id=id;
        this.name=name;
       this.courses=new HashSet<Course>();
        }
}
