package cursoUdemyNelio.exerciciosFixacao.exercSet.entities;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends User {

    private List<Course> courses = new ArrayList<>();

    public Instructor(int id, List<Course> courses) {
        super(id);
        this.courses = courses;
    }

}
