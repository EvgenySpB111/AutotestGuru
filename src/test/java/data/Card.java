package data;

import java.util.ArrayList;

public abstract class Card {

  protected String cardHolder;
   protected int balance;
   protected String cardNumber;

   // String []paySystem  = {"Visa","masterCard","Mir"};
   // String payCard = paySystem[2];
    protected PaymentSystem paymentSystem;

    public Card(String cardHolder, int balance, String cardNumber, PaymentSystem paymentSystem) {
        this.cardHolder = cardHolder;
        this.balance = balance;
        this.cardNumber = cardNumber;
        this.paymentSystem = paymentSystem;
    }

    protected abstract void payInCountry (Country country, int amount);
    protected void buyCard(int amountCash) {
        if(balance < amountCash) {
            System.out.println("not enough money!");
            return;
        }
        if(balance > amountCash) {
             balance = balance - amountCash;
            System.out.println("success! Balance card: " + balance);
        }
    }

    protected PaymentSystem paymentSystem() {
        return paymentSystem;
    }
  // seters
    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setPaymentSystem(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }
    // geters

    public String getCardHolder() {
        return cardHolder;
    }

    public int getBalance() {
        return balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public PaymentSystem getPaymentSystem() {
        return paymentSystem;
    }

}
