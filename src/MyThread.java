public class MyThread implements Runnable {

    Main main;
    @Override
    public void run() {
        // 打印出当前线程的名字
        synchronized (main) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
