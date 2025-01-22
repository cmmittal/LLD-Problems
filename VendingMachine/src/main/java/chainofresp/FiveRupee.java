package main.java.chainofresp;

import main.java.entity.NoteType;
import main.java.repository.MoneyRepository;

public class FiveRupee extends ProcessMoney{

    public void getMoney(int amount){
        int needed = 0;
        if (amount > 5) {
            needed = amount / 5;
            System.out.println("Dispensed " + needed + " Five Rupee notes");
            MoneyRepository.noteMap.put(NoteType.FIVE, MoneyRepository.noteMap.get(NoteType.FIVE) - needed);
        }
        else if (amount == 5) {
            needed = 1;
            System.out.println("Dispensed 1 Five Rupee Note");
            MoneyRepository.noteMap.put(NoteType.FIVE, MoneyRepository.noteMap.get(NoteType.FIVE) - 1);
            return;
        }
        else{
            return;
        }

        processNext(amount - (5 * needed));
    }
}
