package cursoUdemyNelio.exerciciosFixacao.exercStatic;

public class CurrencyConverter {

    public static double IOF = 0.06;

    public static double totalAmount(double amount, double priceDollar) {
        return amount * priceDollar * (1.0 + IOF);
    }
}
