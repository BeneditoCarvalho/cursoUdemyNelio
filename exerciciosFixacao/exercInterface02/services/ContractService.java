package cursoUdemyNelio.exerciciosFixacao.exercInterface02.services;

import cursoUdemyNelio.exerciciosFixacao.exercInterface02.entities.Contract;
import cursoUdemyNelio.exerciciosFixacao.exercInterface02.entities.Installment;

import java.util.Calendar;
import java.util.Date;

public class ContractService {

    private PaymentService paymentService;

    public ContractService(PaymentService paymentService) { //Injeção de dependencia pelo construtor
        this.paymentService = paymentService;
    }

    public void contractProcess(Contract contract, int months) {

        Double contractValue = contract.getTotalValue() / months;
        for (int i = 1; i <= months; i++) {
            Date date = addMonths(contract.getDate(), i);
            double updatedQuota = contractValue + paymentService.interest(contractValue, i);
            double fullQuota = updatedQuota + paymentService.paymentFee(updatedQuota);
            contract.addInstallment(new Installment(date, fullQuota));
        }

    }

    private Date addMonths(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();

    }

}
