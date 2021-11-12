package com.company;

public class Worker {
    private String name;
    private int money;

    // цветной вывод
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public WorkerThread workerThread = new WorkerThread(this);

    public Worker(String name) {
        // обработка исключения NullPointerException (4 задание)
        if (name == null){
            this.name = "Лефрут";
        }
         else{
             this.name = name;
        }
    }

    public void getResult(){
        System.out.println(RED +  "По итогу смены " + name + " заработал " + money + " монет!" + RESET);
    }

    public String getName() { return GREEN+name+RESET; }

    public int getMoney() { return money; }

    public void setMoney(int money) { this.money += money; }

    public void Work(){ Main.executor.execute(workerThread); }
}
