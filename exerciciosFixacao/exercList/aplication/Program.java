package cursoUdemyNelio.exerciciosFixacao.exercList.aplication;

import cursoUdemyNelio.exerciciosFixacao.exercList.entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int numberOfEmployees = scan.nextInt();

        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.printf("Employee #%d%n", i + 1);
            System.out.print("Id: ");
            int id = scan.nextInt();
            System.out.print("Name: ");
            scan.nextLine();
            String name = scan.nextLine();
            System.out.print("Salary: ");
            Double salary = scan.nextDouble();

            employees.add(new Employee(id, name, salary));
        }

        System.out.println();
        System.out.print("Enter the employee ID that will have salary increase: ");
        int id = scan.nextInt();

        Employee bestEmployee = employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);

//    public static int hasId(List<Employee> list, int id) {
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getId() == id) {
//                return i;
//            }
//        }
//        return -1;
//    }

        if (bestEmployee == null) {
            System.out.println("This id does not exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percentage = scan.nextDouble();
            bestEmployee.increaseSalary(percentage);
        }

        System.out.println();
        System.out.println("List of employees: ");
        employees.forEach(System.out::println);

        scan.close();
    }

}