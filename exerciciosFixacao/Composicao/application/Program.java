package cursoUdemyNelio.exerciciosFixacao.Composicao.application;

import cursoUdemyNelio.exerciciosFixacao.Composicao.entities.Department;
import cursoUdemyNelio.exerciciosFixacao.Composicao.entities.HourContract;
import cursoUdemyNelio.exerciciosFixacao.Composicao.entities.Worker;
import cursoUdemyNelio.exerciciosFixacao.Composicao.entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = scan.nextLine();
        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("Level: ");
        String insertLevel = scan.next();
        WorkerLevel level = WorkerLevel.valueOf(insertLevel.toUpperCase());
        System.out.print("Base Salary: ");
        double salary = scan.nextDouble();

        Worker w1 = new Worker(name, level, salary, new Department(departmentName));

        System.out.print("How many contracts to this worker? ");
        int numberOfContracts = scan.nextInt();
        List<HourContract> contracts = new ArrayList<>();

        for (int i = 0; i < numberOfContracts; i++) {
            System.out.printf("Enter contract #%d data: %n", i + 1);
            System.out.print("Date (DD/MM/YYYY): ");
            Date date = sdf.parse(scan.next());
            System.out.print("Value per hour: ");
            Double valueHour = scan.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = scan.nextInt();

            contracts.add(new HourContract(date, valueHour, hours));
            w1.addContract(contracts.get(i));

        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String contractDate = scan.next();
        int month = Integer.parseInt(contractDate.substring(0, 2));
        int year = Integer.parseInt(contractDate.substring(3));
        System.out.printf("Name: %s%n", w1.getName());
        System.out.printf("Department: %s%n", w1.getDepartment().getName());
        System.out.printf("Income for %d/%d : %.2f", month, year, w1.income(year, month));

        scan.close();

    }

}
