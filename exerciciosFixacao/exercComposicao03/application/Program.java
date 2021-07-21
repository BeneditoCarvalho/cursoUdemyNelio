package cursoUdemyNelio.exerciciosFixacao.exercComposicao03.application;

import cursoUdemyNelio.exerciciosFixacao.exercComposicao03.entities.Client;
import cursoUdemyNelio.exerciciosFixacao.exercComposicao03.entities.Order;
import cursoUdemyNelio.exerciciosFixacao.exercComposicao03.entities.OrderItem;
import cursoUdemyNelio.exerciciosFixacao.exercComposicao03.entities.Product;
import cursoUdemyNelio.exerciciosFixacao.exercComposicao03.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdfBirth = new SimpleDateFormat("dd/MM/yyyy");

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("Email: ");
        String email = scan.nextLine();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        Date birthDate = sdfBirth.parse(scan.next());
        System.out.println("Enter Order Data:");
        System.out.print("Status: ");
        String status = scan.next();

        Client c1 = new Client(name, email, birthDate);
        Order order = new Order(Date.from(Instant.now()), OrderStatus.valueOf(status.toUpperCase()), c1);

        System.out.print("How many items to this order? ");
        int numberOfItems = scan.nextInt();

        for (int i = 0; i < numberOfItems; i++) {
            System.out.printf("Enter #%d item data:%n", i + 1);
            System.out.print("Product name: ");
            scan.nextLine();
            String productName = scan.nextLine();
            System.out.print("Product Price: ");
            Double productPrice = scan.nextDouble();
            System.out.print("Quantity: ");
            Integer productQtd = scan.nextInt();

            OrderItem orderItem = new OrderItem(productQtd, productPrice, new Product(productName, productPrice));

            order.addItem(orderItem);


        }

        System.out.println();
        System.out.println(order);


    }
}
