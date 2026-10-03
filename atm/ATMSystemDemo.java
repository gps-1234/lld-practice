public class ATMSystemDemo{
    public static void main(String[] args){
        ATMSystem atmSystem = ATMSystem.getInstance();
        atmSystem.insertCard("1234-5678-0912");
        atmSystem.enterPin("1234");
        atmSystem.selectOperation(OperationType.CHECK_BALANCE);
    }
}