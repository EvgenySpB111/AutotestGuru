package data;

public class VisaCard extends Card{

    public VisaCard(String cardHolder, int balance, String cardNumber, PaymentSystem paymentSystem) {
        super(cardHolder, balance, cardNumber, PaymentSystem.VISA);
    }

    @Override
    public void payInCountry(Country country, int amount) {

    }
}
