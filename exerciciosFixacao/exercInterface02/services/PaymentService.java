package cursoUdemyNelio.exerciciosFixacao.exercInterface02.services;

public interface PaymentService {

    double paymentFee(Double amount);

    double interest(double amount, int months);

}
