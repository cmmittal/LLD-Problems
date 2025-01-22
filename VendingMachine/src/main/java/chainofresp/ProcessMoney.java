package main.java.chainofresp;

public abstract class ProcessMoney {
    public ProcessMoney next;

    public static ProcessMoney link(ProcessMoney start, ProcessMoney... list){
        ProcessMoney head = start;

        for (ProcessMoney processMoney : list) {
            head.next = processMoney;
            head = head.next;
        }

        return start;
    }

    public abstract void getMoney(int amount);

    public void processNext(int amount){
        if (next == null) {
            return;
        }

        next.getMoney(amount);
    }
}
