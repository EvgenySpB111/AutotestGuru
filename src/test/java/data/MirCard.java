package data;

public class MirCard extends Card{


    public MirCard(String cardHolder, int balance, String cardNumber,PaymentSystem paymentSystem) {
        super(cardHolder, balance, cardNumber, PaymentSystem.MIR);
    }

    @Override
    public void payInCountry(Country country, int amount) {

    }
}
