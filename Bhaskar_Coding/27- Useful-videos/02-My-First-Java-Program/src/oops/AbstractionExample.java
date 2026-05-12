package oops;

abstract  class ATM {
    abstract void withdrawnMoney();
    abstract  void depositMoney();
}

class  IciciBankATM extends  ATM{


    @Override
    void withdrawnMoney() {
        System.out.println("Icici Bank withdraw money");
    }


    @Override
    void depositMoney() {
        System.out.println("ICICI deposit money");
    }
}

public class AbstractionExample {
    public static void main(String[] args) {
        IciciBankATM icici=new IciciBankATM();
        icici.depositMoney();
        icici.withdrawnMoney();
    }
}
