package com;

public class ThreadLocalLearn {


    public static void main(String args[]) {

       // IntHolder intHolder = new IntHolder();
        ThreadLocal<IntHolder> tl = new ThreadLocal<IntHolder>() {
            @Override
            protected IntHolder initialValue() {
                //System.out.println("调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值！");
                return IntHolder.getInstance();
            }
        };
        //System.out.println(Thread.currentThread().getName() + " " + tl.get().increAndGet());
        for (int i = 0; i <30000; i++) {
            Thread th = new Thread(new ThreadTest(tl, i));
            th.start();
        }
    }
}

class ThreadTest implements Runnable {

    ThreadLocal<IntHolder> tl; //threadlocal变量
    int i;  //线程局部变量 （ThreadTest的成员变量）
    int a = 3; //线程局部变量（ThreadTest的成员变量） 

    public ThreadTest(ThreadLocal<IntHolder> tl, int i) {
        super();
        this.tl = tl;
        this.i = i;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        //tl.get().increAndGet();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        tl.get().increAndGet();
        System.out.println(tl.get().getA());
    }
}

class IntHolder {
    private static IntHolder intHolder;

    private IntHolder() {

    }

    public static synchronized IntHolder getInstance() {
        try {
            if (null == intHolder) {
                // 模拟在创建对象之前做一些准备工作
                intHolder = new IntHolder();
            }
        } finally {

        }
        return intHolder;
    }

    int a = 1;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int increAndGet() {
        return ++a;
    }
}
