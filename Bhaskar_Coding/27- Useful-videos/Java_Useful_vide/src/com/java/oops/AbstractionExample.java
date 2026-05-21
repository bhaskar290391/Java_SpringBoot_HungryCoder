package com.java.oops;

abstract  class ATM{
    abstract  void withdrawnMoney();
    abstract  void depositMoney();
}

class  IciciBank extends  ATM{

    @Override
    void withdrawnMoney() {
        System.out.println("Money withdrawn from ICICI bank");
    }

    @Override
    void depositMoney() {
        System.out.println("Money deposit in ICICI bank ATM");
    }
}
public class AbstractionExample {
    public static void main() {
        IciciBank icici=new IciciBank();
        icici.depositMoney();
        icici.withdrawnMoney();
    }
}
