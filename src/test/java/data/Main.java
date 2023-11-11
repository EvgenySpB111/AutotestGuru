package data;

public class Main {
    public static void main(String[] args) {
        Card mirCard = new MirCard("Smorzevskij",150,"234846555",
                PaymentSystem.MIR);
        Card visaCard = new VisaCard("Frica",200,"76543737838",
                PaymentSystem.VISA);
        System.out.println(mirCard.getBalance());
        mirCard.buyCard(30);
        visaCard.buyCard(190);
        System.out.println(visaCard.getBalance());
        visaCard.buyCard(50);




    }
}
