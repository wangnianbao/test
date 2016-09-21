import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by wangnianbao on 2016/9/21.
 */
public class MapTest {
    /*
    * 用来承装学社类型对象*/
    public Map<String,Student> students;
    /*
    * 在够着其中初始化students属性
    * */

    public MapTest(){
        this.students=new HashMap<String, Student>();

    }
    /*
    * 测试添加方法：输入学生ID，判断是否被占用
    * 若未被占用，则输入姓名，创建学生对象，并且
    * 添加到student中*/

    public  void testPut(){
        Scanner console=new Scanner(System.in);
        int i=0;
        while (i<3){
            System.out.println("请输入学生ID");
            String ID=console.next();
            //判断该ID是否被占用
            Student st= students.get(ID);
            if(st==null){
                //输入学生姓名
                System.out.println("请输入学生姓名：");
                String name=console.next();
                //创建新的学生对象
                Student newStudent =new Student(ID,name);
                //通过调用studens 的put方法，添加学生的ID映射
                students.put(ID,newStudent);
                System.out.println("成功添加学生："+students.get(ID).name);
                i++;
            }else {
                System.out.println("该学生ID已被占用！");
                continue;
            }
        }
    }
    public  void testKeySet(){
        Set<String> keySet=students.keySet();
        //取得students的容器
        System.out.println("总共有："+students.size()+"学生！");
        //遍历keySet，取得每一个键，再调用get方法取得每个键对应的value

        for(String stuId:keySet)
    {
        Student st=students.get(stuId);
        if(st!=null)
        {
            System.out.println("学生："+st.name);
        }
    }
    }

    public static void main(String[] args) {
        MapTest mt=new MapTest();
        mt.testPut();
        mt.testKeySet();
    }
  }
