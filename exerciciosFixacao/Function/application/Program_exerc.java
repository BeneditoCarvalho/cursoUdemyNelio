package cursoUdemyNelio.exerciciosFixacao.Function.application;

import cursoUdemyNelio.exerciciosFixacao.Function.entities.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Program_exerc {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();

        System.out.print("Enter full file path: ");
        String path = scan.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {

                String[] fields = line.split(",");
                String name = fields[0];
                Double price = Double.parseDouble(fields[1]);

                productList.add(new Product(name, price));
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        double avg = productList.stream()
                .map(Product::getPrice)
                .reduce(0.0, (x, y) -> x + y) / productList.size();

        System.out.println(avg);

        System.out.println("------------------");

        productList.stream()
                .filter(p -> p.getPrice() < avg) // predicate
                .map(Product::getName) // function + method reference
                .sorted(Comparator.comparing(String::toUpperCase)) //comparator method reference
                .forEach(System.out::println);                     //

        scan.close();
    }
}
