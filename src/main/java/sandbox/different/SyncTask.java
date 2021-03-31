package sandbox.different;

/**
 * Вопросы:
 * 1. Что будет выведено на печать
 * 2. Как исправить ситуацию
 * 3. поможет ли добавление volatile при объявлении counter.
 * 4. если расставлять synchronized, то в каких местах
 */
public class SyncTask {

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();

        Thread th = new Thread(test);

        th.start();
        for (int i = 0; i < 4; i++)
            test.dec();

        System.out.println(test.get());
    }

    static class Test implements Runnable {
        int counter;

        public void inc() {
            counter++;
        }

        public void dec() {
            counter--;
        }

        public int get() {
            return counter;
        }

        @Override
        public void run (){
            for (int i = 0; i < 4; i++)
                inc();
        }
    }
}

