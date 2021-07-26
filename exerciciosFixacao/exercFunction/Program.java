package cursoUdemyNelio.exerciciosFixacao.exercFunction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();
        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        double min = 100;

        list.forEach(p -> p.setPrice(p.getPrice() + min));// -> forEach(consumer)

        list.removeIf(p -> p.getPrice() <= 150); // -> removeIf(predicate)

        list.stream()
                .map(p -> p.getName().toUpperCase()) // -> map(function)
                .forEach(System.out::println);

        System.out.println("_____________________________________________________");

//        list.sort((p1,p2) -> p1.getPrice().compareTo(p2.getPrice())); -> lambda expression ou arrow function

        list.sort(Comparator.comparing(Product::getPrice)); // method reference

        list.forEach(System.out::println);

        System.out.println("____________________________________________");


        list.stream()
                .filter(p -> p.getName().charAt(0) == 'T') // -> filter(predicate)
                .forEach(System.out::println);

        System.out.println("_____________________________________________");

        ProductService productService = new ProductService(); // função product service chama outra função

        Double sum = productService.filteredSum(list, p -> p.getName().charAt(0) == 'T');

        System.out.println(sum);

    }


}
