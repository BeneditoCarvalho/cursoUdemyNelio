package cursoUdemyNelio.exerciciosFixacao.exercSummary.application;

import cursoUdemyNelio.exerciciosFixacao.exercSummary.entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        List<Product> productList = new ArrayList<>();
        List<Product> productListRead = new ArrayList<>();
        productList.add(new Product("TV LED", 1290.99, 1));
        productList.add(new Product("Video Game", 350.50, 3));
        productList.add(new Product("Iphone", 900.00, 2));
        productList.add(new Product("Samsung Galaxy 9", 850.00, 2));

        Function<Product, String> productToString = new Function<Product, String>() {
            @Override
            public String apply(Product product) {
                return product.getProductName() + "," + String.format("%.2f", product.getProductPrice())
                        + "," + product.getProductQty().toString();
            }
        };

        File path01 = new File("C:\\Users\\bjcnu\\Desktop\\Workspace\\AprendendoJava.csv");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path01))) {
            for (Product p : productList) {
                bw.write(productToString.apply(p));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(path01))) {

            String fileCsv = br.readLine();
            while (fileCsv != null) {

                String[] fields = fileCsv.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);
                productListRead.add(new Product(name, price, quantity));
                fileCsv = br.readLine();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.getMessage();
        }

        boolean success = new File("C:\\Users\\bjcnu\\Desktop\\Workspace\\Out").mkdir();

        File path02 = new File("C:\\Users\\bjcnu\\Desktop\\Workspace\\Out\\Summary.csv");

        try (BufferedWriter bw02 = new BufferedWriter(new FileWriter(path02))) {

            for (Product p : productListRead) {
                bw02.write(p.getProductName() + ", " + String.format("%.2f", p.total()));
                bw02.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
