public class Account{
    private final String accountno;
    private double balance;
    private Map<String,Card>cards;

    public Account(String accountno,double balance){
       this.accountno=accountno;
       this.balance=balance;
       this.cards=new HashMap<>();
    }
    public String getAccountNo(){
        return accountno;
    }
    //getter for balance,cards
    public deposit(double amount){
        return balance=balance+amounnt;
    }
    public withdraw(double amount){
        if(balance>=amount){
           balance=balance-amount;
           return true;
        }
        return false;
    }
}