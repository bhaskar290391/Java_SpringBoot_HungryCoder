package java8.stream;

import java.util.ArrayList;
import java.util.List;

class Transaction{

    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

public class Stream_Eaxmple1 {
    static void main() {
        List<Transaction> data=new ArrayList<>();
        data.add(new Transaction("groceries",1000));
        data.add(new Transaction("Entertainment",500));
        data.add(new Transaction("Others",400));
        data.add(new Transaction("groceries",5000));
        data.add(new Transaction("Entertainment",100));
        data.add(new Transaction("Others",300));

        double groceries = data.stream().filter(tras -> tras.getType().equals("groceries")).mapToDouble(Transaction::getAmount).sum();
        System.out.println("The total invested in the groceries ==>" +groceries);

        double average=data.stream().mapToDouble(Transaction::getAmount).average().orElse(0.0);
        System.out.println("The average data is ==> "+average);
    }}
