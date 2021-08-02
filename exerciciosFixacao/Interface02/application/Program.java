package cursoUdemyNelio.exerciciosFixacao.Interface02.application;

import cursoUdemyNelio.exerciciosFixacao.Interface02.entities.Contract;
import cursoUdemyNelio.exerciciosFixacao.Interface02.entities.Installment;
import cursoUdemyNelio.exerciciosFixacao.Interface02.services.ContractService;
import cursoUdemyNelio.exerciciosFixacao.Interface02.services.Paypal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter contract data");
        System.out.print("Numer: ");
        int contractNumber = scan.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        Date contractDate = sdf.parse(scan.next());
        System.out.print("Contract value: ");
        Double contractValue = scan.nextDouble();

        Contract contract = new Contract(contractNumber, contractDate, contractValue);

        System.out.print("Enter the number of installments: ");
        int installQty = scan.nextInt();

        ContractService contractService = new ContractService(new Paypal());

        contractService.contractProcess(contract, installQty);

        System.out.println("Installments: ");
        for (Installment it : contract.getInstallments()) {
            System.out.println(it);
        }

        scan.close();
    }
}
