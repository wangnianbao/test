import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wangnianbao on 2016/9/20.
 */
public class ListTest {
public List cToS;

    public  ListTest(){
        this.cToS=new ArrayList();
    }
    public  void testAdd(){
        //创建一个课程对象,并通过调用add方法，添加到备选课程List中
        Course cr1=new Course("1","数据结构");
        cToS.add(cr1);
        Course temp=(Course)cToS.get(0);
        System.out.println("添加了课程："+temp.id+temp.name);
        Course cr2=new Course("2","C语言");
        cToS.add(0,cr2);
        Course temp2=(Course)cToS.get(0);
        System.out.println("添加了课程："+temp2.id+temp2.name);
    /*    Course cr3=new Course("3","test");
        cToS.add(4,cr3);*/
        Course[] course={new Course("3","离散数学"),new Course("4","汇编语言")};
        cToS.addAll(Arrays.asList(course));
        Course temp3=(Course)cToS.get(2);
        Course temp4=(Course)cToS.get(3);
        System.out.println("添加了两门课程："+temp3.id+":"
                +temp3.name+";"+temp4.id+":"+temp4.name);
        Course[] course2={new Course("5","高等数学"),new Course("6","大学英语")};
        cToS.addAll(2,Arrays.asList(course2));
        Course temp5=(Course)cToS.get(2);
        Course temp6=(Course)cToS.get(3);
        System.out.println("添加了两门课程："+temp5.id+":"
                +temp5.name+";"+temp6.id+":"+temp6.name);
    }
/*
* 取得List中的元素的方法
*
*
* */
    public  void testGet() {
        System.out.println("有如下课程待选：");
    int size =cToS.size();
        for (int i=0;i<size;i++) {
            Course cr=(Course)cToS.get(i);
            System.out.println("课程："+cr.id
            +":"+cr.name);
        }
    }
    public void testIterator(){
        //同过集合的iterator方法，取得迭代器的实例
        Iterator it= cToS.iterator();
        System.out.println("有如下课程待选：(通过迭代器访问)");
        while (it.hasNext())
        {
            Course cr=(Course)it.next();
            System.out.println("课程："+cr.id+":"+cr.name);
        }
    }
    public  void testForEach(){
        System.out.println("有如下课程待选：(通过for each访问)");
        for (Object obj: cToS) {
            Course cr = (Course) obj;
            System.out.println("课程：" + cr.id + ":" + cr.name);
        }
    }
    public void testModify() {
        cToS.set(4,new Course("7","毛概"));
    }
    public  void testRemove(){
       // Course cr=(Course)cToS.get(4);
      //  System.out.println("我是课程:"+cr.id+":"+cr.name);
       // cToS.remove(cr);
        System.out.println("课程成功删除");

        Course[] cr1={(Course)cToS.get(4),(Course)cToS.get(5)};
        cToS.removeAll( Arrays.asList(cr1));
        testForEach();
    }
    public void testType(){
        System.out.println("能否在List中添加一些奇怪的东西呢？");
        cToS.add("我不是课程，我只是无辜的字符串");
    }
     public static void main(String[] args) {
   ListTest lt=new ListTest();
        lt.testAdd();
        lt.testGet();
         lt.testIterator();
         lt.testForEach();
         lt.testModify();
         lt.testForEach();
         lt.testRemove();
        /* lt.testType();
         lt.testForEach();*/
    }
}
