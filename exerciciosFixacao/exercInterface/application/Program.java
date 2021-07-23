package cursoUdemyNelio.exerciciosFixacao.exercInterface.application;

import cursoUdemyNelio.exerciciosFixacao.exercInterface.entities.CarRental;
import cursoUdemyNelio.exerciciosFixacao.exercInterface.entities.Vehicle;
import cursoUdemyNelio.exerciciosFixacao.exercInterface.services.BrazilTaxService;
import cursoUdemyNelio.exerciciosFixacao.exercInterface.services.RentalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter rental data");
        System.out.print("Car model: ");
        String carModel = scan.nextLine();
        System.out.print("Pickup (dd/MM/yyy hh:mm): ");
        Date pickupDate = sdf.parse(scan.nextLine());
        System.out.print("Return (dd/MM/yyy hh:mm): ");
        Date returnDate = sdf.parse(scan.nextLine());

        CarRental carRental = new CarRental(pickupDate, returnDate, new Vehicle(carModel));

        System.out.print("Enter price per hour: ");
        Double priceHour = scan.nextDouble();
        System.out.print("Enter price per day: ");
        Double priceDay = scan.nextDouble();

        RentalService rentalService = new RentalService(priceDay, priceHour, new BrazilTaxService());

        rentalService.processInvoice(carRental);

        System.out.println("INVOICE");
        System.out.printf("Basic payment: %.2f %n", carRental.getInvoice().getBasicPayment());
        System.out.printf("Tax: %.2f %n", carRental.getInvoice().getTax());
        System.out.printf("Total payment: %.2f", carRental.getInvoice().getTotalPayment());


        scan.close();
    }
}
