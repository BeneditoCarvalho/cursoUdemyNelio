package cursoUdemyNelio.exerciciosFixacao.Interface02.services;

public interface PaymentService {

    double paymentFee(Double amount);

    double interest(double amount, int months);

}
