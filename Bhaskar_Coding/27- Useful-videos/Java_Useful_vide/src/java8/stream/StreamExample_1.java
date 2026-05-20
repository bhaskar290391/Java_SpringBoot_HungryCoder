package java8.stream;

import java.util.Arrays;
import java.util.List;

class Transaction{
    private String category;
    private double amount;

    public Transaction(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

public class StreamExample_1 {
    static void main() {

        List<Transaction> data= Arrays.asList(
                new Transaction("groceries",500),
                new Transaction("Entertainment",200),
                new Transaction("Electronic",1000),
                new Transaction("groceries",2000),
                new Transaction("Entertainment",6000),
                new Transaction("Electronic",2564)
        );

        System.out.println(  data.stream().filter(trans-> trans.getCategory().equals("groceries"))
                .mapToDouble(Transaction::getAmount)
                .sum());

        System.out.println(
        data.stream().mapToDouble(Transaction::getAmount).average().orElse(0.0));
    }
}
