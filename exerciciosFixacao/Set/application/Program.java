package cursoUdemyNelio.exerciciosFixacao.Set.application;

import cursoUdemyNelio.exerciciosFixacao.Set.entities.Student;

import java.util.*;

public class Program {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Student> studentListA = new ArrayList<>();
        List<Student> studentListB = new ArrayList<>();
        List<Student> studentListC = new ArrayList<>();

        System.out.print("How many students for course A? ");
        int numberOfStudentsA = scan.nextInt();
        for (int i = 0; i < numberOfStudentsA; i++) {
            studentListA.add(new Student(scan.nextInt()));
        }

        System.out.print("How many students for course B? ");
        int numberOfStudentsB = scan.nextInt();
        for (int i = 0; i < numberOfStudentsB; i++) {
            studentListB.add(new Student(scan.nextInt()));
        }

        System.out.print("How many students for course C? ");
        int numberOfStudentsC = scan.nextInt();
        for (int i = 0; i < numberOfStudentsC; i++) {
            studentListC.add(new Student(scan.nextInt()));
        }

        Set<Student> totalStudents = new HashSet<>(studentListA);
        totalStudents.addAll(studentListB);
        totalStudents.addAll(studentListC);

        System.out.println("Total students: " + totalStudents.size());

        scan.close();

    }
}
