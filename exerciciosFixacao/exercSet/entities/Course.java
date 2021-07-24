package cursoUdemyNelio.exerciciosFixacao.exercSet.entities;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private List<Student> students = new ArrayList<>();

    public Course(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
