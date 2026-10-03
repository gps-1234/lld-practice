public class BankService{
     private Map<String,Account>  accounts;
     private Map<String,Card>cards;
     private Map<Card,Account>cardaccountmap;
    public BankService(){
   this.acccounts=new ConcurrentHashMap<>();
   this.cards=new ConcurrentHashMap<>();
   this.cardaccountmap=new ConcurrentHashMap<>();
    }
    public Card createCard(String cardNumber,String pin){
       Card card=new Card(cardNumber,pin);
         cards.put(cardNumber,pin);
         return card;
    }
    public Account creatAccount(String accountno,String pin){
       //similar for account
    }
public linkCardToaccount(Card card,Account account){
  account.getCards().put(card.getCardNumber,card);
  cardaccountmap.put(card,account);
}
public depositCash(Card card,double amount){
cardaccountmap.get(card).deposit(amount);
}
public withdrawCash(Card card,double amount){
    cardaccountmap.get(card).withdraw(ammount);
}
public double checkBalance(Card card){
  return cardaccountmap.get(card).getBalance();
}

}