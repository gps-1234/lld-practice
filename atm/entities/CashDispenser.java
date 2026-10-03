public class CashDispenser{
    private final DispenseChain chain;
    public CashDispenser(DispenseChain chain){
        this.chain=chain;
    }
    public synchronized void dispenseCash(double amount){
        chain.dispenseCash(amount);
    }
    public synchronized boolean canDispenseAmount(int amount){
        if(amount%10!=0)
        return false;
        return chain.canDispense(amount);
    }

}