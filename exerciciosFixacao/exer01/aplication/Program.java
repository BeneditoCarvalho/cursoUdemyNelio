package cursoUdemyNelio.exerciciosFixacao.exer01.aplication;

import cursoUdemyNelio.exerciciosFixacao.exer01.entities.Rectangle;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        Rectangle r1 = new Rectangle();

        System.out.println("Enter rectangle width and height:");
        r1.width = scan.nextDouble();
        r1.height = scan.nextDouble();

        System.out.printf("AREA = %.2f\n", r1.Area());
        System.out.printf("PERIMETER = %.2f\n", r1.Perimeter());
        System.out.printf("DIAGONAL = %.2f\n", r1.Diagonal());

    }
}
