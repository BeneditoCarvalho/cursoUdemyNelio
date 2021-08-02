package cursoUdemyNelio.exerciciosFixacao.Encaps.aplication;

import cursoUdemyNelio.exerciciosFixacao.Encaps.entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Account acc;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int number = scan.nextInt();

        System.out.print("Enter account holder: ");
        scan.nextLine();
        String holder = scan.nextLine();

        System.out.print("Is there an initial deposit (y/n)?");
        char choose = scan.next().charAt(0);

        if (choose == 'y') {
            System.out.print("Enter initial deposit value: ");
            double inicialDeposit = scan.nextDouble();
            acc = new Account(holder, number, inicialDeposit);

        } else {
            acc = new Account(holder, number);
        }

        System.out.println();
        System.out.println("Account data:");
        System.out.println(acc);

        System.out.println();
        System.out.print("Enter a deposit value: ");
        double value = scan.nextDouble();
        acc.deposit(value);
        System.out.println(acc);

        System.out.println();
        System.out.print("Enter a withdraw value: ");
        value = scan.nextDouble();
        acc.withdraw(value);
        System.out.println(acc);

        scan.close();
    }
}
