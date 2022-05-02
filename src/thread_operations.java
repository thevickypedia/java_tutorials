import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

class Random {
    public int get_random_number(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}

class Thread_1 extends Thread {
    private final int seconds;

    public Thread_1(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        long t1 = System.nanoTime();
        try {
            System.out.printf("Thread 1 start time: %s\n", LocalDateTime.now());
            TimeUnit.SECONDS.sleep(seconds);
            System.out.printf("Thread 1 end time: %s\n", LocalDateTime.now());
        } catch (InterruptedException error) {
            error.printStackTrace();
        }
        long t2 = System.nanoTime();
        long elapsedTimeInSeconds = (t2 - t1) / 1000000000;
        System.out.println("First thread has completed in: " + elapsedTimeInSeconds + "s");
    }
}

class Thread_2 extends Thread {
    private final int seconds;

    public Thread_2(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        long t1 = System.nanoTime();
        try {
            System.out.printf("Thread 2 start time: %s\n", LocalDateTime.now());
            TimeUnit.SECONDS.sleep(seconds);
            System.out.printf("Thread 2 end time: %s\n", LocalDateTime.now());
        } catch (InterruptedException error) {
            error.printStackTrace();
        }
        long t2 = System.nanoTime();
        long elapsedTimeInSeconds = (t2 - t1) / 1000000000;
        System.out.println("Second thread has completed in: " + elapsedTimeInSeconds + "s");
    }
}

class MultiThreading {
    public static void main(String[] args) {
        Random rand = new Random();
        int rand_1 = rand.get_random_number(1, 10);
        int rand_2 = rand.get_random_number(11, 20);
        Thread_1 thread1 = new Thread_1(rand_1);
        Thread_2 thread2 = new Thread_2(rand_2);
        thread1.start();
        thread2.start();
    }
}
