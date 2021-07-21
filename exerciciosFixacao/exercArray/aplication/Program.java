package cursoUdemyNelio.exerciciosFixacao.exercArray.aplication;

import cursoUdemyNelio.exerciciosFixacao.exercArray.entities.Client;

import java.util.Arrays;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Client[] clients = new Client[10];
        boolean sair = true;

        while (sair) {
            System.out.print("How many rooms will be rented? ");
            int roomsNumber = scan.nextInt();
            if (roomsNumber < 1 || roomsNumber > 10) {
                System.out.println("Max 10 rooms!");
            } else {
                for (int i = 0; i < roomsNumber; i++) {
                    System.out.printf("Rent #%d%n", i + 1);
                    System.out.print("Name: ");
                    scan.nextLine();
                    String name = scan.nextLine();
                    System.out.print("E-mail: ");
                    String email = scan.nextLine();
                    System.out.print("Room: ");
                    int room = scan.nextInt();
                    if (room < 0 || room > 9) {
                        System.out.println("Choose 0 to 9");
                    } else {
                        clients[room] = new Client(name, email, room);
                        sair = false;
                    }
                }
            }
        }
        System.out.println();
        System.out.println("Busy rooms:");
        Arrays.stream(clients)
                .filter(c -> c != null)
                .forEach(System.out::println);
    }
}
