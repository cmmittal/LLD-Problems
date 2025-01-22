package main.java.service;

import java.util.Arrays;
import java.util.List;

import main.java.chainofresp.FiveRupee;
import main.java.chainofresp.ProcessMoney;
import main.java.chainofresp.TenRupee;
import main.java.entity.Note;
import main.java.entity.NoteType;
import main.java.entity.Product;
import main.java.entity.ProductType;
import main.java.repository.MoneyRepository;
import main.java.repository.ProductRepository;

public class VendingService {

    public static void main(String[] args) {
        Product p1 = new Product(ProductType.APPLE, 5, 10);

        ProductRepository.products.add(p1);

        MoneyRepository.noteMap.put(NoteType.TEN, 10);
        MoneyRepository.noteMap.put(NoteType.FIVE, 10);

        Note note1 = new Note(NoteType.TWENTY);
        Note note2 = new Note(NoteType.TEN);
        Note note3 = new Note(NoteType.TEN);

        dispense(ProductType.APPLE, 5, Arrays.asList(note1, note2, note3));
        System.out.println("Updated amount of products : " + p1.quantity);
    }

    public static void dispense(ProductType productType, int quantity, List<Note> notes){

        for (var p : ProductRepository.products) {
            if (p.type.equals(productType) && p.quantity >= quantity) {
                upDateInventory(productType, quantity);
                calculate(p.price * quantity, notes);
                return ;
            }
        }
    }

    public static void calculate(int price, List<Note> notes){

        int totalAmount = 0;

        for (Note note : notes) {
            totalAmount += note.value;
            MoneyRepository.noteMap.put(note.type, MoneyRepository.noteMap.getOrDefault(note.type, 0) + 1);
        }

        int amountToReturn = totalAmount - price;

        ProcessMoney processMoney = ProcessMoney.link(
            new TenRupee(),
            new FiveRupee()
        );

        processMoney.getMoney(amountToReturn);
    }

    public static void upDateInventory(ProductType type, int quantity){
        for (Product product : ProductRepository.products) {
            if (product.type.equals(type)) {
                product.quantity -= quantity;
                break;
            }
        }
        System.out.println("Updated product repository");
    }
}
