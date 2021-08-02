package cursoUdemyNelio.exerciciosFixacao.Heranca02.application;

import cursoUdemyNelio.exerciciosFixacao.Heranca02.entities.ImportedProduct;
import cursoUdemyNelio.exerciciosFixacao.Heranca02.entities.Product;
import cursoUdemyNelio.exerciciosFixacao.Heranca02.entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scan = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int numberProducts = scan.nextInt();
        for (int i = 0; i < numberProducts; i++) {
            System.out.printf("Product #%d data: %n", i + 1);
            System.out.print("Common, used or imported (c/u/i)? ");
            char productType = scan.next().charAt(0);
            System.out.print("Name: ");
            scan.nextLine();
            String name = scan.nextLine();
            System.out.print("Price: ");
            double price = scan.nextDouble();
            if (productType == 'c') {
                productList.add(new Product(name, price));
            } else if (productType == 'u') {
                System.out.print("Manufacture Date (DD/MM/YY): ");
                Date date = sdf.parse(scan.next());
                productList.add(new UsedProduct(name, price, date));
            } else if (productType == 'i') {
                System.out.print("Customs fee: ");
                double fee = scan.nextDouble();
                productList.add(new ImportedProduct(name, price, fee));
            }
        }
        System.out.println();
        System.out.println("PRICE TAGS:");
        productList.forEach(System.out::print);

    }
}
