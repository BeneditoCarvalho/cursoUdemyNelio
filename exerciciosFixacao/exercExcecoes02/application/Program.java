package cursoUdemyNelio.exerciciosFixacao.exercExcecoes02.application;

import cursoUdemyNelio.exerciciosFixacao.exercExcecoes02.model.entities.Account;
import cursoUdemyNelio.exerciciosFixacao.exercExcecoes02.model.exceptions.BalanceException;
import cursoUdemyNelio.exerciciosFixacao.exercExcecoes02.model.exceptions.WithDrawLimitException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        try {

            System.out.println("Enter account data");
            System.out.print("Number: ");
            int accNumber = scan.nextInt();
            System.out.print("Holder: ");
            String accHolder = scan.next();
            System.out.print("Initial balance: ");
            scan.nextLine();
            Double initBalance = scan.nextDouble();
            System.out.print("Withdraw limit: ");
            Double withDrawLimit = scan.nextDouble();

            Account acc = new Account(accNumber, accHolder, initBalance, withDrawLimit);

            System.out.println();
            System.out.print("Enter amoutn for withdraw: ");
            acc.withdraw(scan.nextDouble());
            System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));

        } catch (WithDrawLimitException | BalanceException exception) {
            System.out.println(exception.getMessage());
        }

        scan.close();
    }
}
