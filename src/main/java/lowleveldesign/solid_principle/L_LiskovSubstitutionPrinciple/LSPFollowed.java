package lowleveldesign.solid_principle.L_LiskovSubstitutionPrinciple;

import java.util.ArrayList;
import java.util.List;

interface DepositAccount{
    void deposit(double amount);
}
interface WithdrawlAccount extends DepositAccount{
    void withdrawl(double amount);
}
class savingsAcc implements WithdrawlAccount{
    private double balance;
    public savingsAcc(){
        this.balance=0.0;
    }
    @Override
    public void withdrawl(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Savings Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Savings Account!");
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Savings Account. New Balance: " + balance);
    }
}
class currentAccount implements WithdrawlAccount{

    private double balance;
    public currentAccount(){
        this.balance=0.0;
    }
    @Override
    public void withdrawl(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Current Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Current Account!");
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Current Account. New Balance: " + balance);
    }
}
class FixedTermDeposit implements DepositAccount{
    private double balance;
    public FixedTermDeposit(){
        this.balance=0.0;
    }
    @Override
    public void deposit(double amount) {
        balance+=amount;
        System.out.println("Deposited: "+ amount+" in FixedTermDeposit Account. New Balance: "+balance);
    }
}
class bankClient {
    List<WithdrawlAccount> withdrawlAccountList;
    List<DepositAccount> depositAccountList;

    public bankClient(List<WithdrawlAccount> withdrawlAccountList, List<DepositAccount> depositAccountList) {
        this.withdrawlAccountList = withdrawlAccountList;
        this.depositAccountList = depositAccountList;
    }

    void processTransactions() {
        for (WithdrawlAccount acc : withdrawlAccountList) {
            acc.deposit(1000);
            acc.withdrawl(500);
        }
        for (DepositAccount acc : depositAccountList) {
            acc.deposit(1000);
        }
    }
}

public class LSPFollowed {
        public static void main(String args[]) {
            List<WithdrawlAccount> withdrawlAccountList = new ArrayList<>();
            List<DepositAccount> depositAccountList = new ArrayList<>();

            withdrawlAccountList.add(new savingsAcc());
            withdrawlAccountList.add(new currentAccount());
            depositAccountList.add(new FixedTermDeposit());

            bankClient client=new bankClient(withdrawlAccountList,depositAccountList);
            client.processTransactions();
        }
}
