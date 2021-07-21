package cursoUdemyNelio.exerciciosFixacao.exercExcecoes.application;

import cursoUdemyNelio.exerciciosFixacao.exercExcecoes.model.entities.Reservation;
import cursoUdemyNelio.exerciciosFixacao.exercExcecoes.model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scan = new Scanner(System.in);

        try {

            System.out.print("Room number: ");
            int roomNumber = scan.nextInt();
            System.out.print("Check-in date (DD/MM/YYYY): ");
            Date checkin = sdf.parse(scan.next());
            System.out.print("Check-out date (DD/MM/YYYY): ");
            Date checkout = sdf.parse(scan.next());


            Reservation reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkin = sdf.parse(scan.next());
            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkout = sdf.parse(scan.next());

            reservation.updateDates(checkin, checkout);
            System.out.println(reservation);

        } catch (ParseException e) {
            System.out.println("Invalid date format");
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }

        scan.close();

    }
}
