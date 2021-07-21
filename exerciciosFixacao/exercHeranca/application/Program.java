package cursoUdemyNelio.exerciciosFixacao.exercHeranca.application;

import cursoUdemyNelio.exerciciosFixacao.exercHeranca.entities.Employee;
import cursoUdemyNelio.exerciciosFixacao.exercHeranca.entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {


    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int numberOfEmployees = scan.nextInt();

        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.printf("Employee #%d data: %n", i + 1);
            System.out.print("Outsourced (y/n)? ");
            String outsourced = scan.next();
            System.out.print("Name: ");
            scan.nextLine();
            String name = scan.next();
            System.out.print("Hours: ");
            int hours = scan.nextInt();
            System.out.print("Value per hour: ");
            double valueHour = scan.nextDouble();
            if (outsourced.equalsIgnoreCase("y")) {
                System.out.print("Additional charge: ");
                Double charge = scan.nextDouble();

                employees.add(new OutsourcedEmployee(name, hours, valueHour, charge));

            } else {

                employees.add(new Employee(name, hours, valueHour));

            }
        }

        System.out.println("PAYMENTS: ");
        System.out.println(employees);

        scan.close();
    }
}
