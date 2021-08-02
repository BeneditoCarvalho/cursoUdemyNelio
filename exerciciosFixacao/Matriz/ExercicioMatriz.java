package cursoUdemyNelio.exerciciosFixacao.Matriz;

import java.util.Scanner;

public class ExercicioMatriz {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Insert number M: ");
        int m = scan.nextInt();
        System.out.print("Insert number N: ");
        int n = scan.nextInt();

        Integer[][] matriz = new Integer[m][n];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println(matriz[i][j]);
            }
        }

    }
}