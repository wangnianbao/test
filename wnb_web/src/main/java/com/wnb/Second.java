package com.wnb;

/**
 * Created by wangnianbao on 2016/7/14.
 */
public class Second {
    public static void merge(int a[],int b[],int c[])
    { int i,j,k=0,flag;
        for(i=0;i<a.length;i++)
        {
            c[i]=a[i];
        }
        flag=a.length;
        for(i=0;i<b.length;i++)
        {
            for(j=0;j<a.length;j++)
            {
                if(b[i]==c[j])
                  k=1;

                //else {
                 //   c[flag] = b[i];
                  //  flag++;
                }
            if(k!=1)
            {
                c[flag] = b[i];
                k=0;
                flag++;
            }

        }
    }
    public static void main(String[] args) {
        System.out.println("我是王年宝");
        System.out.println("我是王金生");
        System.out.println("我是王金生");
        System.out.println("我是王金生");
        System.out.println("我是王年宝");
        System.out.println("我是王老二");
        System.out.println("我在北京");
        System.out.println("我在北京");
        System.out.println("可恶的英语，我恨死你啦");
        System.out.println("可恶的英语，我恨死你啦");
  int []a=new int[4];
        int []b=new int[5];
        int c[]=new int[9];
        for(int i=0;i<a.length;i++)
        {
            a[i]=i;
        }
        for(int i=0;i<b.length;i++)
        {
            b[i]=10-i;
        }

        merge(a,b, c);
        System.out.println("输出集合b：");
        for(int i=0;i<c.length;i++)
        {
            System.out.println(c[i]);
        }
        System.out.println("输出集合a：");
        for(int i=0;i<b.length;i++)
        {
            System.out.println(b[i]);

        }
        System.out.println("输出集合c：");
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
    }
}
