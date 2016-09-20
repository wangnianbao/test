/**
 * Created by wangnianbao on 2016/9/19.
 */
public class TryCatch {
    public static void main(String[] args) {
        TryCatch tc=new TryCatch();
        int result=tc.test();
        System.out.println("test（）方法执行完毕......."+result);
        System.out.println("表想我!!!!!!!!!!");
    }
    public  int test()
    {
        int divider=10;
        int result=100;
        try {
            while (divider > -1) {
                result = result + 100 / divider;
                divider--;
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("循环抛出异常了！！！！");
            return -1;
        }finally {
            System.out.println("这里是finally ....哈哈");
            System.out.println("我是最后结果result ="+result);
            return 999;
        }
    }
}
