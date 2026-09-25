package lowleveldesign.solid_principle.L_LiskovSubstitutionPrinciple;

import java.util.ArrayList;
import java.util.List;

interface Account{
    void deposit(double amount);
    void withdrawl(double amount);
}
class SavingsAccount implements Account{

    private double balance;

    public SavingsAccount() {
        balance = 0;
    }
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Savings Account. New Balance: " + balance);
    }
    @Override
    public void withdrawl(double amount) {
            if(balance>=amount){
                balance-=amount;
                System.out.println("Debited: "+amount+" in Savings Account. New Balance: "+balance);
            }else {
                System.out.println("Insufficient funds in Savings Account!");
            }
    }
}
class CurrentAccount implements  Account{

    private double balance;

    public CurrentAccount() {
        balance = 0;
    }
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Current Account. New Balance: " + balance);
    }

    @Override
    public void withdrawl(double amount) {
        if(balance>=amount){
            balance-=amount;
            System.out.println("Debited: "+amount+" in Current Account. New Balance: "+balance);
        }else {
            System.out.println("Insufficient funds in Current Account!");
        }
    }
}
class FixedTermAccount implements Account{
    private double balance;

    public FixedTermAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Fixed Term Account. New Balance: " + balance);
    }

    @Override
    public void withdrawl(double amount) {
        throw new UnsupportedOperationException("Withdrawal not allowed in Fixed Term Account!");
    }
}
class BankClient{
    private List<Account> accounts;
    public BankClient(List<Account> acc){
        this.accounts=acc;
    }
    void processTransactions(){
        for(Account acc:accounts){
            //Assuming all accounts allow deposit
            acc.deposit(1000);
            try{
                //Assuming all bank allow withdrawl
                acc.withdrawl(5000);
            }catch(UnsupportedOperationException e){
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}

public class LSPViolated {
    public static void main(String args[]){
        List<Account> list=new ArrayList<>();
        Account savings=new SavingsAccount();
        Account current=new CurrentAccount();
        Account fixedTermDeposit=new FixedTermAccount();
        list.add(savings);
        list.add(current);
        list.add(fixedTermDeposit);

        BankClient client=new BankClient(list);
        client.processTransactions();
    }

}
