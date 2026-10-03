public interface ATMState{
    void insertCard(ATMSystem atmSystem,String cardno);
    void enterPin(ATMSystem atmSystem,String pin);
    void selectOperation(ATMSystem atmSystem,OperationType op,int... args);
    void ejectCard(ATMSystem atmSystem);
}