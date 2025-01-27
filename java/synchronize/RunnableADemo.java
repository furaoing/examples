package syncexample;


/**
 * Created by roy on 2016/5/5.
 */

class SumArray {
    private int sum;

    synchronized int sumArray(int[] nums) {
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
            System.out.println("Running total for " +
                    Thread.currentThread().getName() + " is " + sum);
        }

        return sum;
    }
}

public class RunnableADemo implements Runnable {
    private Thread t;
    private String threadName;
    static SumArray sa = new SumArray();
    int a[];
    int answer;

    RunnableADemo(String name){
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        answer = sa.sumArray(a);
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start(int[] nums) {
        a = nums;
        System.out.println("Starting " + threadName);
        if(t == null)
        {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public void join() {
        try {
            t.join();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
