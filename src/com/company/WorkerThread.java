package com.company;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class WorkerThread implements Runnable {
    Worker worker;

    // цветной вывод
    public static final String PURPLE = "\u001B[35m";
    public static final String RESET = "\u001B[0m";

    public WorkerThread(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void run() {

        for (int i = 0; i < 7; i++) {
            int salary = ThreadLocalRandom.current().nextInt(10, 50);
            worker.setMoney(salary);
            System.out.println("Работяга " + worker.getName() + " заработал " + PURPLE + salary + RESET + " монет за час");

            try {
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 6));
            } catch (InterruptedException e) {
                // обработка исключения InterruptedException (3 задание)
                System.out.println("Обработка исключения 'InterruptedException'");
            }
        }

        worker.getResult();
    }
}
