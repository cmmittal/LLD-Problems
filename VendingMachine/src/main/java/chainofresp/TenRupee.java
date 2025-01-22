package main.java.chainofresp;

import main.java.entity.NoteType;
import main.java.repository.MoneyRepository;

public class TenRupee extends ProcessMoney{

    public void getMoney(int amount){
        int needed = 0;
        if (amount > 10) {
            needed = amount / 10;
            System.out.println("Dispensed " + needed + " Ten Rupee Notes.");
            MoneyRepository.noteMap.put(NoteType.TEN, MoneyRepository.noteMap.get(NoteType.TEN) - needed);
        }
        else if (amount == 10) {
            needed = 1;
            System.out.println("Dispensed 1 Ten Rupee Note");
            MoneyRepository.noteMap.put(NoteType.TEN, MoneyRepository.noteMap.get(NoteType.TEN) - 1);
        }

        processNext(amount - (needed * 10));
    }
}
