package cursoUdemyNelio.exerciciosFixacao.exerc02.aplication;

import cursoUdemyNelio.exerciciosFixacao.exerc02.entities.Employee;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Employee e1 = new Employee();

        System.out.print("Name: ");
        e1.name = scan.nextLine();
        System.out.print("Gross Salary: ");
        e1.grossSalary = scan.nextDouble();
        System.out.print("Tax: ");
        e1.tax = scan.nextDouble();

        System.out.println();
        System.out.println("Employee: " + e1);
        System.out.println();
        System.out.print("Wich percentage to increase salary?");
        double percentage = scan.nextDouble();
        e1.increaseSalary(percentage);

        System.out.println();
        System.out.println("Update data: " + e1);
        scan.close();

    }
}
