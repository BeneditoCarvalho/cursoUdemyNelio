package cursoUdemyNelio.exerciciosFixacao.Abstract.application;

import cursoUdemyNelio.exerciciosFixacao.Abstract.entities.TaxPayer;
import cursoUdemyNelio.exerciciosFixacao.Abstract.entities.Individual;
import cursoUdemyNelio.exerciciosFixacao.Abstract.entities.Company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        List<TaxPayer> list = new ArrayList<>();
//        Function<List<Contribuinte>, Double> totalTaxes = new Function<List<Contribuinte>, Double>() {
//            @Override
//            public Double apply(List<Contribuinte> contribuintes) {
//                Double contribuinte1 = 0.0;
//                for (int i = 0; i < list.size(); i++) {
//                    contribuinte1 += list.get(i).impostoPago();
//                }
//                return contribuinte1;
//
//            }
//        };

        System.out.print("Enter the number of tax payers: ");
        int numberOfPayers = scan.nextInt();

        for (int i = 0; i < numberOfPayers; i++) {
            System.out.printf("Tax payer #%d data: %n", i + 1);
            System.out.print("Individual or company (i/c)? ");
            char type = scan.next().charAt(0);
            System.out.print("Name: ");
            scan.nextLine();
            String name = scan.nextLine();
            System.out.print("Annual income: ");
            Double income = scan.nextDouble();
            if (type == 'i') {
                System.out.print("Health expenditures: ");
                Double healthExpend = scan.nextDouble();
                list.add(new Individual(name, income, healthExpend));
            } else if (type == 'c') {
                System.out.print("Number of employees: ");
                int numberEmployees = scan.nextInt();
                list.add(new Company(name, income, numberEmployees));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID:");
        list.forEach(System.out::println);
        System.out.println();
//        System.out.println(totalTaxes.apply(list));
        Double total = 0.0;
        for (TaxPayer c : list) {
            total += c.tax();
        }
        System.out.printf("TOTAL TAXES: $ %.2f", total);

        scan.close();
    }
}
