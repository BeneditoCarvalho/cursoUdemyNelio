package cursoUdemyNelio.exerciciosFixacao.Map.application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Map<String, Integer> votes = new HashMap<>();

        System.out.print("Enter file full path: ");
        String path = scan.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {

                String[] fields = line.split(",");
                String name = fields[0];
                Integer qty = Integer.parseInt(fields[1]);

                if (votes.containsKey(name)) {
                    int votesQty = votes.get(name);
                    votes.put(name, qty + votesQty);
                } else {
                    votes.put(name, qty);
                }

                line = br.readLine();
            }

            for (String key : votes.keySet()) {
                System.out.println(key + ": " + votes.get(key));
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }


    }
}
