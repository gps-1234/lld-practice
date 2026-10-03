public class AuthenticatedState implements ATMState{

@Override
public void insertCard(ATMSystem atmSystem,String cardno){
    System.out.println("Error:Card inserted already");
    
}
@Override
public void enterPin(ATMSystem atmSystem,String pin){
    System.out.println("Error:Pin already entered and authenticated");
}
@Override
public void selectOperation(ATMSystem atmSystem,OperationType op,int...args){
    switch(op){
        case CHECK_BALANCE:
            atmSystem.checkBalance();
            break;
        case WITHDRAW_CASH:
            if(args.length==0||args[0]<=0){
                System.out.println("Error:Invalid withdrawal amount!");
                break;
            }
            int amount=args[0];
            double accountBalance=atmSystem.getBankService().checkBalance(atmSystem.getCurrentCard());
            if(amount>accountBalance){
                System.out.println("Error:Insufficient balance");
                break;
            }
            System.out.println("Processing withdrawal for $"+amount);
            atmSystem.withdrawCash(amount);
            break;
        case DEPOSIT_CASH:
          if(args.length==0||args[0]<=0){
                System.out.println("Error:Invalid withdrawal amount!");
                break;
            }
            int amount=args[0];
            System.out.println("Processing deposit for $"+amount);
            atmSystem.depositCash(amount);
            break;
        default:
          System.out.println("Error:invalid operation selected");
          break;
    }
    System.out.println("Transaction complete");
    ejectCard(atmSystem);
}
@Override
public void ejectCard(ATMSystem atmSystem){
    System.out.println("Card ejected");
    atmSystem.setCurrentCard(null);
    atmSystem.changeState(new IdleState());
}
}