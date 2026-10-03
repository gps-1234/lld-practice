public class HasCardState implements ATMState{

@Override
public void insertCard(ATMSystem atmSystem,String cardno){
    System.out.println("Card inserted already");
    
}
@Override
public void enterPin(ATMSystem atmSystem,String pin){
   boolean authenticated=atmSystem.authenticate(pin);
if(authenticated){
    System.out.println("Authentication Succesful");
    atmSystem.changeState(new AuthenticatedState());
}
else{
    System.out.println("Authentication failed");
    ejectCard(atmSystem);
}
}
@Override
public void selectOperation(ATMSystem atmSystem,OperationType op,int...args){
    System.out.println("Error:Please enter pin first");
}
@Override
public void ejectCard(ATMSystem atmSystem){
    System.out.println("Card ejected");
    atmSystem.setCurrentCard(null);
    atmSystem.changeState(new IdleState());
}
}