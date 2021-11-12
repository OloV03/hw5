package com.company;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {
    public static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Scanner in = new Scanner(System.in);
            String[] names = new String[]{"Смотрящий", "Главарь", "Батя", "Сестричка", "Братик", null};
            Worker[] workers;
            int res;
            int count = ThreadLocalRandom.current().nextInt(-5, 5);
            try{
                workers = new Worker[count];
            } catch (NegativeArraySizeException ex){
                // обработка ошибки NegativeArraySizeException (5 задание)
                count += 10;
                workers = new Worker[count];
                System.out.println("Вышла небольшая ошибка, кол-во работников ушло в  минус, " +
                                    "но сейчас все в норме, продолжайте");
            }

            // заполнение массива работяг
            for (int i = 0; i < count; i++){
                workers[i] = new Worker(names[ThreadLocalRandom.current().nextInt(1, names.length)]);
            }

            System.out.println("1 - отправить гребцов на работу  /  2 - имя работяги");
            try {
                res = in.nextInt();
            } catch (Exception ex) {
                // отлов ошибки IO Exception (2 задание)
                System.out.println("Ты или цифру пиши, или читать учись!");
                continue;
            }

            if (res == 1) {
                System.out.println("Да начнется работенка, гребцы в бой!\n");
                for (var item : workers)
                    item.Work();
            } else if (res == 2) {
                System.out.print("Какой работяга интересует? ");
                try {
                    System.out.println(workers[in.nextInt()].getName());
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //обработка исключения ArrayIndexOutOfBoundsException (1 задание)
                    System.out.println("Такого работника нет!");
                }
            } else {
                System.out.println("Конец программы");
                break;
            }

            TimeUnit.SECONDS.sleep(2);
            System.out.println("\n\n");
        }
    }
}
