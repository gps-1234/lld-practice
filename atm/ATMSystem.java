public class ATMSystem{
    
    private static ATMSystem instance;
    private final CashDispenser cashDispenser;
    private final BankService bankService;
    private ATMState currentstate;
    private Card currentCard;

private ATMSystem(){
    this.currentState=new IdleState();
    this.bankService=new BankService();
    DispenseChain c1=new NoteDispenser50(10);
    DispenseChain c2=new NoteDispenser100(10);
    DispenseChain c3=new NoteDispenser200(10);
    c1.setNextChain(c2);
    c2.setNextChain(c3);
    this.cashDispenser=new CashDispenser(c1);

}
public static ATMSystem getInstance(){
    if(instance==null){
        instance=new ATMSystem();
    }
    return instance;
}
public void changeState(ATMState newState){
    this.currentState=newState;
}
public void insertCard(String cardNumber){
  currentState.insertCard(this,cardNumber);
}
public void enterPin(String pin){
    currentState.enterPin(this,pin);
}
public void selectOperation(OperationType op,int... args){
  currentState.selectOperation(this,op,args);
}
public boolean authenticate(String pin){
return bankService.authenticate(currentCard,pin);
}
public void withdrawCash(int amount){
if(!cashDispenser.canDispense(amount)){
     throw new IllegalStateException("Insufficient cash in ATM");
}
bankService.withdrawCash(currentCard,amount);
try{
    cashDispenser.dispenseCash(amount);
}
catch(Exception e){
        bankService.depositCash(currentCard,amount);
}

}
public void depositCash(int amount){
    bankService.depositCash(currentCard,amount);
}
public void checkBalance(){
    System.out.println("Balance is $%.2f%x",bankService.checkBalance(currentCard));
}
}


